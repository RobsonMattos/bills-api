package br.com.bills.lancamento;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bills.fatura.Fatura;
import br.com.bills.fatura.FaturaRepository;

@RestController
@RequestMapping("/lancamentos")
@CrossOrigin
public class LancamentoController {
 
	@Autowired
    private LancamentoService service;
 
	@Autowired
	private FaturaRepository faturaRepository;
	
	@RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<LancamentoDTO>> findAll() {
		List<Lancamento> list = service.findAll();
		List<LancamentoDTO> lancamentos = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lancamentos);
//		return new ResponseEntity<List<LancamentoDTO>>(lancamentos, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Lancamento> find(@PathVariable Long id) {
		Optional<Lancamento> obj = service.findById(id);
		
		if(obj.isPresent()) {			
			return ResponseEntity.ok().body(obj.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value="/fatura/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<LancamentoDTO>> findByFatura(@PathVariable Long id) {
		List<Lancamento> list = service.findByFaturaId(id);
		List<LancamentoDTO> lancamentos = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lancamentos);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LancamentoDTO objDto) {
		Lancamento entity = service.fromDTO(objDto);
		service.repository.save(entity);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(entity.getFatura().getDataVencimento());
		
		Fatura fatura;
		Lancamento lancamento;
		Integer parcela = entity.getParcela();
		
		for (Integer i = 1; i <= entity.getQuantidadeParcelas() - entity.getParcela(); i++) {
			cal.add(Calendar.MONTH, 1);

			String mes = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("pt", "BR"));
			Integer ano = cal.get(Calendar.YEAR);
			
//			verifica se a fatura já existe
			fatura = faturaRepository.findByDataVencimento(cal.getTime()).get();
			if (fatura == null) {
				fatura = new Fatura();
				fatura.setDataVencimento(cal.getTime());
//				fatura.setMes(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("pt", "BR")));
				fatura.setMes(mes.concat("/").concat(ano.toString()));
				faturaRepository.save(fatura);
			}
			
			lancamento = new Lancamento();
			lancamento.setEstabelecimento(entity.getEstabelecimento()); 
			lancamento.setData(entity.getData()); 
			lancamento.setValor(entity.getValor()); 
			lancamento.setCategoria(entity.getCategoria());
			lancamento.setFatura(fatura);
			lancamento.setParcela(++parcela);
			lancamento.setQuantidadeParcelas(entity.getQuantidadeParcelas());
			lancamento.setResponsavel(entity.getResponsavel());
			lancamento.setObservacao(entity.getObservacao());
			
			service.repository.save(lancamento);
			
			BigDecimal valorTotalDaFatura = new BigDecimal(0);
			List<Lancamento> lancamentos = service.findByFaturaId(fatura.getId());
			
			for(Lancamento l : lancamentos) {
				valorTotalDaFatura = valorTotalDaFatura.add(l.getValor());
			}
			fatura.setValor(valorTotalDaFatura);
			faturaRepository.save(fatura);
		}
		
		cal.add(Calendar.MONTH, -(entity.getQuantidadeParcelas() - entity.getParcela()));
		parcela = entity.getParcela();
		for (Integer i = 1; i <= entity.getParcela() - 1; i++) {
			cal.add(Calendar.MONTH, -1);

			String mes = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("pt", "BR"));
			Integer ano = cal.get(Calendar.YEAR);
			
//			verifica se a fatura já existe
			fatura = faturaRepository.findByDataVencimento(cal.getTime()).get();
			if (fatura == null) {
				fatura = new Fatura();
				fatura.setDataVencimento(cal.getTime());
				fatura.setMes(mes.concat("/").concat(ano.toString()));
				faturaRepository.save(fatura);
			}
			
			lancamento = new Lancamento();
			lancamento.setEstabelecimento(entity.getEstabelecimento()); 
			lancamento.setData(entity.getData()); 
			lancamento.setValor(entity.getValor()); 
			lancamento.setCategoria(entity.getCategoria());
			lancamento.setFatura(fatura);
			lancamento.setParcela(--parcela);
			lancamento.setQuantidadeParcelas(entity.getQuantidadeParcelas());
			lancamento.setResponsavel(entity.getResponsavel());
			lancamento.setObservacao(entity.getObservacao());
			
			service.repository.save(lancamento);
			
			BigDecimal valorTotalDaFatura = new BigDecimal(0);
			List<Lancamento> lancamentos = service.findByFaturaId(fatura.getId());	
			for(Lancamento l : lancamentos) {
				valorTotalDaFatura = valorTotalDaFatura.add(l.getValor());
			}
			fatura.setValor(valorTotalDaFatura);
			faturaRepository.save(fatura);
		}		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LancamentoDTO objDto, @PathVariable Long id) {
		Lancamento obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.repository.save(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}

package br.com.bills.fatura;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/faturas")
@CrossOrigin
public class FaturaController {

	@Autowired
	private FaturaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FaturaDTO>> findAll() {
//		List<Fatura> list = service.repository.findAll(Sort.by(Sort.Direction.DESC, "dataVencimento"));
		List<Fatura> list = service.repository.buscarTodos().get();
		List<FaturaDTO> faturas = list.stream().map(obj -> new FaturaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(faturas);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Fatura> find(@PathVariable Long id) {
		Optional<Fatura> obj = service.repository.buscarPorId(id);
		
		if(obj.isPresent()) {
//			obj.get().setValor(service.repository.getValorTotalDaFatura(obj.get()));
			return ResponseEntity.ok().body(obj.get());
		}
		
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FaturaDTO objDto) {
		Fatura entity = service.repository.save(service.fromDTO(objDto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FaturaDTO objDto, @PathVariable Long id) {
		Fatura obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.repository.save(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

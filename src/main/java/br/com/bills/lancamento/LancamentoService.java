package br.com.bills.lancamento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bills.categoria.Categoria;
import br.com.bills.categoria.CategoriaRepository;
import br.com.bills.fatura.Fatura;
import br.com.bills.fatura.FaturaRepository;

@Service
public class LancamentoService {
	
	@Autowired
	public LancamentoRepository repository;
	
	@Autowired
	public FaturaRepository faturaRepository;
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	public List<Lancamento> findAll() {
		return repository.findAll();
	}
	
	public Optional<Lancamento> findById(Long id) {
		Optional<Lancamento> obj = repository.findById(id);
		return obj;
	}
	
	public List<Lancamento> findByFaturaId(Long id) {
		Optional<Fatura> fatura = faturaRepository.findById(id);
		return repository.findByFatura(fatura.get());
	}

	public Lancamento fromDTO(LancamentoDTO objDto) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(objDto.getCategoria());
		Optional<Fatura> fatura = faturaRepository.findById(objDto.getFatura());
		
		return new Lancamento(objDto.getId(), 
				objDto.getEstabelecimento(), 
				objDto.getData(), 
				objDto.getValor(), 
				categoria.get(),
				fatura.get(),
				objDto.getParcela(),
				objDto.getQuantidadeParcelas(),
				objDto.getObservacao(),
				objDto.getResponsavel());
	}
}

package br.com.bills.responsavel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bills.categoria.Categoria;
import br.com.bills.categoria.CategoriaRepository;
import br.com.bills.fatura.Fatura;
import br.com.bills.fatura.FaturaRepository;

@Service
public class ResponsavelService {
	
	@Autowired
	public ResponsavelRepository repository;
	
	@Autowired
	public FaturaRepository faturaRepository;
	
	public Optional<List<Responsavel>> obterPorFatura(Long idFatura) {
		Optional<List<Responsavel>> responsaveis = repository.obterPorFatura(idFatura);
		return responsaveis;
	}

	public Responsavel fromDTO(ResponsavelDTO objDto) {
		
		return new Responsavel(
				objDto.getId(), 
				objDto.getNome(), 
				objDto.getValor(),
				objDto.getEmail());
	}
}

package br.com.bills.fatura;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaturaService {
	
	@Autowired
	public FaturaRepository repository;
	
	public Fatura fromDTO(FaturaDTO objDto) {
		return new Fatura(
				objDto.getId(), 
				objDto.getDataVencimento(), 
				objDto.getMes(),
				objDto.getDataPagamento(), 
				objDto.getValor()
//				objDto.getLancamentos()
				);
	}
	
	public Optional<Fatura> findByDataVencimento(Date data) {
		Optional<Fatura> obj = repository.findByDataVencimento(data);
		return obj;
	}
	
//	public Optional<Fatura> buscar(Long id) {
//		Optional<Fatura> obj = repository.findById(id);
//		return obj;
//	}
}

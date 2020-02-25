package br.com.bills.responsavel;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responsaveis")
@CrossOrigin
public class ResponsavelController {
 
	@Autowired
    private ResponsavelService service;
 	
	@RequestMapping(value="/fatura/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<ResponsavelDTO>> obterPorFatura(@PathVariable Long id) {
		List<Responsavel> list = service.obterPorFatura(id).get();
		List<ResponsavelDTO> responsaveis = list.stream().map(obj -> new ResponsavelDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(responsaveis);
	}
}

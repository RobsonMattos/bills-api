package br.com.bills.responsavel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository  extends JpaRepository<Responsavel, Long> {

	@Query(value = "select row_number() OVER (PARTITION by 0) as id, responsavel as nome, sum(valor) as valor, null as email\n" + 
			"from \n" + 
			"  lancamento\n" + 
			"where\n" + 
			"  fatura_id = ?1\n" + 
			"group by responsavel", nativeQuery = true)
	Optional<List<Responsavel>> obterPorFatura(@Param("fatura_id")Long idFatura);
}

package br.com.bills.fatura;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

	Optional<Fatura> findByDataVencimento(Date data);
	
	@Query("select sum(l.valor) from Lancamento l where l.fatura = :fatura")
	BigDecimal getValorTotalDaFatura (@Param("fatura") Fatura fatura);
	
	@Query(value = "select \n" + 
			"  fatura.id, fatura.data_pagamento, fatura.data_vencimento, fatura.mes, \n" + 
			"  (select sum(l.valor) valor from lancamento l where l.fatura_id = fatura.id) valor\n" + 
			"from \n" + 
			"  fatura fatura order by data_vencimento desc", nativeQuery = true)
	Optional<List<Fatura>> buscarTodos();
	
	@Query(value = "select \n" + 
			"  fatura.id, fatura.data_pagamento, fatura.data_vencimento, fatura.mes, \n" + 
			"  (select sum(l.valor) valor from lancamento l where l.fatura_id = fatura.id) valor\n" + 
			"from \n" + 
			"  fatura fatura where id = ?1", nativeQuery = true)
	Optional<Fatura> buscarPorId(@Param("id") Long id);
	
}

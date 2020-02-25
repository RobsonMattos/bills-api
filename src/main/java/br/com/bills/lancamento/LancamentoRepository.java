package br.com.bills.lancamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.bills.fatura.Fatura;

@CrossOrigin
public interface LancamentoRepository  extends JpaRepository<Lancamento, Long> {

	List<Lancamento> findByFatura(Fatura fatura);
}

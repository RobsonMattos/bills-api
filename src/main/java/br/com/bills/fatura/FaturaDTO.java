package br.com.bills.fatura;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bills.lancamento.Lancamento;

public class FaturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	private String mes;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	private BigDecimal valor;
//    private List<Lancamento> lancamentos;

	public FaturaDTO() {
	}

	public FaturaDTO(Fatura fatura) {
		this.id = fatura.getId();
		this.dataVencimento = fatura.getDataVencimento();
		this.dataPagamento = fatura.getDataPagamento();
		this.mes = fatura.getMes();
		this.valor = fatura.getValor();
//		this.lancamentos = fatura.getLancamentos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

//	public List<Lancamento> getLancamentos() {
//		return lancamentos;
//	}
//
//	public void setLancamentos(List<Lancamento> lancamentos) {
//		this.lancamentos = lancamentos;
//	}
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaturaDTO other = (FaturaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

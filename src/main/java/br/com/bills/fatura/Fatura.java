package br.com.bills.fatura;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bills.lancamento.Lancamento;

@Entity
@Table(name = "fatura")
public class Fatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Long id;
	
	@Column(name = "mes", nullable = false)
	private String mes;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "data_vencimento", nullable = false)
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
    @Column(name = "valor", nullable = true)
	private BigDecimal valor;
    
    @JsonIgnore
    @OneToMany(mappedBy = "fatura")
    private List<Lancamento> lancamentos;
    
	public Fatura() {;
	}

	public Fatura(Long id, Date dataVencimento, String mes, Date dataPagamento, BigDecimal valor) {
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.mes = mes;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
//		this.lancamentos = lancamentos;
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
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
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

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
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
		Fatura other = (Fatura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

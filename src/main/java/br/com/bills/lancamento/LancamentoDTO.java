package br.com.bills.lancamento;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LancamentoDTO {

	private Long id;
	private String estabelecimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	private BigDecimal valor;
	private Long categoria;
	private Long fatura;
	private Integer parcela;
	private Integer quantidadeParcelas;
	private String responsavel;
	private String observacao;
		
	public LancamentoDTO() {
	}

	public LancamentoDTO(Lancamento lancamento) {
		this.id = lancamento.getId();
		this.estabelecimento = lancamento.getEstabelecimento();
		this.data = lancamento.getData();
		this.valor = lancamento.getValor();
		this.categoria = lancamento.getCategoria().getId();
		this.fatura = lancamento.getFatura().getId();
		this.responsavel = lancamento.getResponsavel();
		this.quantidadeParcelas = lancamento.getQuantidadeParcelas();
		this.parcela = lancamento.getParcela();
		this.observacao = lancamento.getObservacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Long getFatura() {
		return fatura;
	}

	public void setFatura(Long fatura) {
		this.fatura = fatura;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}

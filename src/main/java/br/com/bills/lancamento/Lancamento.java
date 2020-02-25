package br.com.bills.lancamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bills.categoria.Categoria;
import br.com.bills.fatura.Fatura;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Long id;
	
	@Column(name = "estabelecimento", nullable = false)
	private String estabelecimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "FK_CATEGORIA_LANCAMENTO"))
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "fatura_id", foreignKey = @ForeignKey(name = "FK_FATURA_LANCAMENTO"))
	private Fatura fatura;
	
	@Column(name = "parcela", nullable = false)
	private Integer parcela;
	
	@Column(name = "quantidade_parcelas", nullable = false)
	private Integer quantidadeParcelas;
	
	@Column(name = "observacao", nullable = true)
	private String observacao;
	
	@Column(name = "responsavel", nullable = false)
	private String responsavel;
	
	public Lancamento() {
		super();
	}

	public Lancamento(Long id, String estabelecimento, Date data, BigDecimal valor, Categoria categoria, Fatura fatura,
			Integer parcela, Integer quantidadeParcelas, String observacao, String responsavel) {
		this.id = id;
		this.estabelecimento = estabelecimento;
		this.data = data;
		this.valor = valor;
		this.categoria = categoria;
		this.fatura = fatura;
		this.parcela = parcela;
		this.quantidadeParcelas = quantidadeParcelas;
		this.observacao = observacao;
		this.responsavel = responsavel;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

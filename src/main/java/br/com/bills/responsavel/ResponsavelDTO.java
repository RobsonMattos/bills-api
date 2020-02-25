package br.com.bills.responsavel;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResponsavelDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private BigDecimal valor;
	private String email;
	
	public ResponsavelDTO() {
	}

	public ResponsavelDTO(Responsavel responsavel) {
		this.id = responsavel.getId();
		this.nome = responsavel.getNome();
		this.valor = responsavel.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}

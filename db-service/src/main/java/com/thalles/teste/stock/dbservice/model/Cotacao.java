package com.thalles.teste.stock.dbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cotacoes", catalog="teste")
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "cotacao")
	private String cotacao;

	
	public Cotacao(Integer id, String usuario, String cotacao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.cotacao = cotacao;
	}

	public Cotacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Cotacao(String usuario, String cotacao) {
		super();
		this.usuario = usuario;
		this.cotacao = cotacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCotacao() {
		return cotacao;
	}

	public void setCotacao(String cotacao) {
		this.cotacao = cotacao;
	}
	
	
	
}

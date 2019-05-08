package com.thalles.teste.stock.dbservice.model;

import java.util.List;

public class Cotacoes {

	private String usuario;
	private List<String> cotacoes;
	
	public Cotacoes(String usuario, List<String> cotacoes) {
		super();
		this.usuario = usuario;
		this.cotacoes = cotacoes;
	}
	public Cotacoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public List<String> getCotacoes() {
		return cotacoes;
	}
	public void setCotacoes(List<String> cotacoes) {
		this.cotacoes = cotacoes;
	}
	
	
	
}

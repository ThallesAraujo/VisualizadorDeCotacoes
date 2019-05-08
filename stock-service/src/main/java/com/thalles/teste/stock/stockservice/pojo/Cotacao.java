package com.thalles.teste.stock.stockservice.pojo;

import java.math.BigDecimal;

public class Cotacao {
	
	private String cotacao;
	private BigDecimal preco;
	
	public Cotacao(String cotacao, BigDecimal preco) {
		super();
		this.cotacao = cotacao;
		this.preco = preco;
	}

	public String getCotacao() {
		return cotacao;
	}

	public void setCotacao(String cotacao) {
		this.cotacao = cotacao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


}

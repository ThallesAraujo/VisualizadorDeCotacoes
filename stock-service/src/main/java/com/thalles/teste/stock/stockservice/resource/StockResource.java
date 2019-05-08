package com.thalles.teste.stock.stockservice.resource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thalles.teste.stock.stockservice.pojo.Cotacao;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.*;

@RestController
@RequestMapping("/api/cotacao")
public class StockResource {
	
	@Autowired
	private RestTemplate restTemplate;
	

	@GetMapping("/{usuario}")
	public List<Cotacao> getCotacao(@PathVariable("usuario") final String usuario){
		
		ResponseEntity<List<String>> cotacaoResponse = restTemplate.exchange("http://db-service/api/db/"+usuario, 
				HttpMethod.GET,null, new ParameterizedTypeReference<List<String>>() {});
		
		List<String> cotacoes = cotacaoResponse.getBody();
		return cotacoes.stream()
				.map(cotacao -> {
					Stock stock = getPrecoCotacao(cotacao);
					return new Cotacao(cotacao, stock.getQuote().getPrice());
				})
				.collect(Collectors.toList());
		
	}

	private Stock getPrecoCotacao(String cotacao) {
		try {
			return YahooFinance.get(cotacao);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Stock(cotacao);
		}
	}
	
}

package com.thalles.teste.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thalles.teste.stock.dbservice.model.Cotacao;
import com.thalles.teste.stock.dbservice.model.Cotacoes;
import com.thalles.teste.stock.dbservice.repository.CotacoesRepository;

@RestController
@RequestMapping("/db")
public class DbServiceResource {
	
	@Autowired
	private CotacoesRepository cotacoesRepository;

	
	@GetMapping("/cotacao/{usuario}")
	public List<String> getCotacoes(@PathVariable("usuario") final String usuario){
		
		return getCotacoesPorUsuario(usuario);
	}

	private List<String> getCotacoesPorUsuario(final String usuario) {
		return cotacoesRepository.getByUsuario(usuario)
			.stream()
			.map(Cotacao::getCotacao)
			.collect(Collectors.toList());
	}
	
	@PostMapping("/cotacao/adicionar")
	public List<String> adicionarCotacao(@RequestBody final Cotacoes cotacoes){
		
		cotacoes.getCotacoes()
			.stream()
			.map(cotacao -> new Cotacao(cotacoes.getUsuario(), cotacao))
			.forEach(cotacao -> cotacoesRepository.save(cotacao));
		
		return getCotacoesPorUsuario(cotacoes.getUsuario());
	}
	
	@DeleteMapping("/cotacao/remover/{usuario}")
	public List<String> removerCotacoes(@PathVariable("usuario") final String usuario){
		List<Cotacao> cotacoes = cotacoesRepository.getByUsuario(usuario);
		cotacoesRepository.deleteAll(cotacoes);
		return cotacoes.stream()
				.map(Cotacao::getCotacao)
				.collect(Collectors.toList());
		
	}

}

package com.thalles.teste.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thalles.teste.stock.dbservice.model.Cotacao;

public interface CotacoesRepository  extends JpaRepository<Cotacao, Integer>{

	List<Cotacao> getByUsuario(String usuario);

}

package br.com.cateno.cotacao.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cateno.cotacao.model.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao, Integer>{
	
	@Query(name="select c from Cotacao c ")
	Cotacao findByDataCotacao(Date dataCotacao);

}

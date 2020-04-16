package br.com.cateno.cotacao.controller;


import java.text.ParseException;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cateno.cotacao.exception.CotacaoException;
import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.parse.DateParser;
import br.com.cateno.cotacao.response.CotacaoResponse;
import br.com.cateno.cotacao.service.CotacaoService;
import br.com.cateno.cotacao.validator.CotacaoRequestValidator;


@RestController()
public class CotacaoController {
	
	
	CotacaoService cotacaoService; 
	
	public CotacaoController(CotacaoService cotacaoService) {
		this.cotacaoService = cotacaoService; 
	}

	@GetMapping("/v1/cotacoes")
	public ResponseEntity<CotacaoResponse> obter(@RequestParam String dataCotacao) {
		CotacaoResponse response;
		try {
			Date data = DateParser.toDate(dataCotacao,"dd/MM/yyyy");
			CotacaoRequestValidator.seDataMaiorQueDataAtual(data); 
			response = this.cotacaoService.obterCotacaoPorDataCotacao(data );
			return ResponseEntity.ok().body(response);
		} catch (ParseException e) {
			return ResponseEntity.badRequest().build();
		} catch (IntegracaoBacenException  | IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (CotacaoException e) {
			return ResponseEntity.badRequest().build();
		} 
	}

}

package br.com.cateno.cotacao.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.cateno.cotacao.model.Cotacao;
import br.com.cateno.cotacao.parse.DateParser;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class CotacaoResponse {

	public CotacaoResponse() {
	}

	public CotacaoResponse(Cotacao cotacao) {
		if (cotacao == null) {
			throw new IllegalArgumentException("cotação está nulo"); 
		}
		this.cotacaoCompra = cotacao.getCotacaoCompra(); 
		this.cotacaoVenda = cotacao.getCotacaoVenda(); 
		this.dataHoraCotacao =DateParser.toString("yyyy-MM-dd HH:mm:ss.SSS ",  cotacao.getDataHoraCotacao()) ; 
	}

	private Double cotacaoCompra; 
	private Double cotacaoVenda;
	private String dataHoraCotacao;
}

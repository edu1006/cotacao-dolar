package br.com.cateno.cotacao.converter;

import java.text.ParseException;

import br.com.cateno.cotacao.model.Cotacao;
import br.com.cateno.cotacao.parse.DateParser;
import br.com.cateno.cotacao.response.CotacaoResponse;

public class CotacaoConverter {
	
	private CotacaoConverter() throws IllegalAccessException { 
		throw new IllegalAccessException("utility class"); 
	}
	
	public final static String COTACAO_REPONSE_PATTERN = "yyyy-MM-dd hh:mm:ss.SSS" ; 
	
	public static Cotacao responseToModel(CotacaoResponse cotResponse) throws ParseException { 
		Cotacao cotacao = new Cotacao();
		cotacao.setCotacaoCompra(cotResponse.getCotacaoCompra());
		cotacao.setCotacaoVenda(cotResponse.getCotacaoVenda());
		cotacao.setDataHoraCotacao(DateParser.toDate(cotResponse.getDataHoraCotacao() , COTACAO_REPONSE_PATTERN ));
		
		return cotacao ; 
	}
}

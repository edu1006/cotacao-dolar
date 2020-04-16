package br.com.cateno.cotacao.service;

import java.text.ParseException;
import java.util.Date;

import br.com.cateno.cotacao.exception.CotacaoException;
import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.response.CotacaoResponse;

public interface CotacaoService {

	CotacaoResponse obterCotacaoPorDataCotacao(Date dataCotacao) throws CotacaoException;

}

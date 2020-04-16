package br.com.cateno.cotacao.adaptador;

import java.util.Date;

import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.response.CotacaoResponse;

public interface CotacaoIntegracaoBacen {

	CotacaoResponse obterCotacaoPorDataCotacao(Date dataCotacao) throws IntegracaoBacenException;

}

package br.com.cateno.cotacao.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cateno.cotacao.adaptador.CotacaoIntegracaoBacen;
import br.com.cateno.cotacao.converter.CotacaoConverter;
import br.com.cateno.cotacao.exception.CotacaoException;
import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.model.Cotacao;
import br.com.cateno.cotacao.repository.CotacaoRepository;
import br.com.cateno.cotacao.response.CotacaoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CotacaoServiceImpl implements CotacaoService {

	@Autowired
	CotacaoRepository cotacaoRepository;

	@Autowired
	CotacaoIntegracaoBacen cotacaoIntegracaoBacen;

	private final static Logger LOG = LoggerFactory.getLogger(CotacaoServiceImpl.class);

	/**
	 * 
	 */
	@Override
	public CotacaoResponse obterCotacaoPorDataCotacao(Date dataCotacao) throws CotacaoException {
		return buscarCotacaoEmRepositorios(dataCotacao);
	}

	/**
	 * 
	 * @param dataCotacao
	 * @return
	 * @throws CotacaoException
	 */
	private CotacaoResponse buscarCotacaoEmRepositorios(Date dataCotacao) throws CotacaoException {
		Cotacao cotacao = this.cotacaoRepository.findByDataCotacao(dataCotacao);
		if (cotacao != null) {
			return new CotacaoResponse(cotacao);
		} else {
			CotacaoResponse cotacaoResponse = this.cotacaoIntegracaoBacen.obterCotacaoPorDataCotacao(dataCotacao);
			salvarCotacao(cotacaoResponse, dataCotacao);
			return cotacaoResponse;
		}

	}

	/**
	 * 
	 * @param cotacaoResponse
	 * @param dataCotacao
	 * @throws CotacaoException
	 */
	private void salvarCotacao(CotacaoResponse cotacaoResponse, Date dataCotacao)throws  CotacaoException {
		try {

			Cotacao cotacao = CotacaoConverter.responseToModel(cotacaoResponse);
			cotacao.setDataCotacao(dataCotacao);
			cotacao.setDataHoraRequisicao(Calendar.getInstance().getTime());
			this.cotacaoRepository.save(cotacao);

		} catch (ParseException e) {
			LOG.error(e.getMessage());
			throw new CotacaoException(e); 
		}

	}

}

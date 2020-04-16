package br.com.cateno.cotacao.adaptador;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cateno.cotacao.dto.IntegracaoBacenRetornoDTO;
import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.parse.DateParser;
import br.com.cateno.cotacao.response.CotacaoResponse;

@Service
public class CotacaoIntegracaoBacenImpl implements CotacaoIntegracaoBacen {

	private static final String PATTERN_BACEN = "MM-dd-YYYY";
	final String URL_COTACAO_DATA_COTACAO = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='?1'&$format=json";

	@Override
	public CotacaoResponse obterCotacaoPorDataCotacao(Date dataCotacao) throws IntegracaoBacenException {
		RestTemplate restTemplate = new RestTemplate();
		String urlFormatada = substituirParametro(dataCotacao);
		IntegracaoBacenRetornoDTO result = restTemplate.getForObject(urlFormatada, IntegracaoBacenRetornoDTO.class);
		if (result == null || result.getValue() == null || result.getValue().isEmpty()) {
			throw new IntegracaoBacenException("Nenhum registro encontrado!");
		}
		return result.getValue().get(0);
	}

	private String substituirParametro(Date dataCotacao) {
		return URL_COTACAO_DATA_COTACAO.replace("?1", DateParser.toString(PATTERN_BACEN, dataCotacao));
	}

}

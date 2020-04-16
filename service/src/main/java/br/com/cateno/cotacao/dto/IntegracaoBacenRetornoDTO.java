package br.com.cateno.cotacao.dto;

import java.util.ArrayList;

import br.com.cateno.cotacao.response.CotacaoResponse;
import lombok.Data;

public @Data class IntegracaoBacenRetornoDTO {

	ArrayList<CotacaoResponse> value = new ArrayList<CotacaoResponse>();

}

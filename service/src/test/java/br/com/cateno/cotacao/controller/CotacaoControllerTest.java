package br.com.cateno.cotacao.controller;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.response.CotacaoResponse; 
public class CotacaoControllerTest extends AbstractControllerTest {

	
	@Test
	public void obterCotacoesTest() throws Exception {
		when(service.obterCotacaoPorDataCotacao(any())).thenReturn(new CotacaoResponse()); 
		mockMvc.perform(get("/v1/cotacoes?dataCotacao=14/04/2020")).andExpect(status().isOk());

	}

	
	@Test
	public void obterCotacoesComDataInvalidaTest() throws Exception {
		when(service.obterCotacaoPorDataCotacao(any())).thenReturn(new CotacaoResponse()); 
		mockMvc.perform(get("/v1/cotacoes?dataCotacao=14")).andExpect(status().isBadRequest());

	}

	@Test
	public void obterCotacoesDataMaiorQueDataAtualTest() throws Exception {
		when(service.obterCotacaoPorDataCotacao(any())).thenReturn(new CotacaoResponse()); 
		mockMvc.perform(get("/v1/cotacoes?dataCotacao=14/04/2021")).andExpect(status().isNotFound());

	}
			
	
}

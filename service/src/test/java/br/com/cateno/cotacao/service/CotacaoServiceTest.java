package br.com.cateno.cotacao.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cateno.cotacao.exception.CotacaoException;
import br.com.cateno.cotacao.exception.IntegracaoBacenException;
import br.com.cateno.cotacao.response.CotacaoResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CotacaoServiceTest {

	@Autowired
	CotacaoService service;

	@Test
	public void obterCotacoesPorDataCotacaoRemote() throws CotacaoException {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, -1);
		CotacaoResponse cotacao;
		cotacao = service.obterCotacaoPorDataCotacao(c.getTime());
		assertNotNull(cotacao);
		;
	}

	@Test
	public void obterCotacoesPorDataCotacaoLocal() throws CotacaoException {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, -1);
		CotacaoResponse cotacao = service.obterCotacaoPorDataCotacao(c.getTime());
		assertNotNull(cotacao);
	}

	@Test
	public void obterCotacoesPorDataCotacaoComDataMaiorQueDataAtual() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, +1);
		try {
			service.obterCotacaoPorDataCotacao(c.getTime());
			fail(); 
		} catch (CotacaoException e) {
			assertEquals(e.getMessage(), "Nenhum registro encontrado!");
		}
	}
}

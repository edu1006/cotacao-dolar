package br.com.cateno.cotacao.exception;

import java.text.ParseException;

public class CotacaoException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CotacaoException() {
		
	}

	public CotacaoException(String message) {
		super(message); 
	}

	public CotacaoException(ParseException e) {
		super(e);
	}

}

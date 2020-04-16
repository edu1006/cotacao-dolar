package br.com.cateno.cotacao.validator;

import java.util.Calendar;
import java.util.Date;

public class CotacaoRequestValidator {
	private CotacaoRequestValidator() {
		throw new IllegalArgumentException("utility class! ");
	}
	/**
	 * 
	 * valida se a data passada como parametro é maior que hoje. 
	 * Se for, lança exceção.
	 * @throws
	 * 	IllegalArgumentException("Data maior que data corrente"); 
	 
	 * 
	 * 
	 * @param data
	 * @return boolean
	 */
	public static boolean seDataMaiorQueDataAtual(Date data) {
		Calendar dataCorrente = Calendar.getInstance();
		Calendar dataParam = Calendar.getInstance();
		dataParam.setTime(data);
		if ( dataParam.get(Calendar.DATE) <= dataCorrente.get(Calendar.DATE) 
				&&  dataParam.get(Calendar.MONTH)<= dataCorrente.get(Calendar.MONTH)
				&& dataParam.get(Calendar.YEAR)<= dataCorrente.get(Calendar.YEAR)  

		) {
			return Boolean.TRUE;
		}
		throw new IllegalArgumentException("Data maior que data corrente"); 
	}
	
}

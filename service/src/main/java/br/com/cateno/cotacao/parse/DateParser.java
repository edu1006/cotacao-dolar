package br.com.cateno.cotacao.parse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	private DateParser() throws IllegalAccessException {
		throw new IllegalAccessException("utility class"); 
	}

	
	public static String toString(String pattern, Date date) { 
		DateFormat df = new SimpleDateFormat(pattern); 
		return df.format(date);  
	}


	public static Date toDate(String data, String pattern) throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern ); 
		return df.parse(data);  
	}
}


package br.com.cateno.cotacao.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
public @Data class Cotacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id; 
	private Date dataHoraRequisicao;
	@Column(unique =  true)
	@Temporal(TemporalType.DATE)
	private Date dataCotacao; 
	private Double cotacaoCompra; 
	private Double cotacaoVenda; 
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraCotacao;

	
	
}

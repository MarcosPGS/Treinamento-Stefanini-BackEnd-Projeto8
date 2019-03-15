package com.stefanini.treinamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="capa")
public class Capa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_idcapa", sequenceName = "SQ_idcapa", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SQ_idcapa")
	@Column(name="idcapa", length=5)
	private  Long idCapa;
	
	@NotNull
	@Column(name="nome", length=20)
	private String descricao;
	
	@Column(name = "idcelular")
   private Long idcelular;

	public Capa() {
		super();
	}

	
	public Capa(Long idCapa, @NotNull String descricao) {
		super();
		this.idCapa = idCapa;
		this.descricao = descricao;
	}




	public Long getIdCapa() {
		return idCapa;
	}


	public void setIdCapa(Long idCapa) {
		this.idCapa = idCapa;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Long getIdcelular() {
		return idcelular;
	}


	public void setIdcelular(Long idcelular) {
		this.idcelular = idcelular;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCapa == null) ? 0 : idCapa.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capa other = (Capa) obj;
		if (idCapa == null) {
			if (other.idCapa != null)
				return false;
		} else if (!idCapa.equals(other.idCapa))
			return false;
		return true;
	}


	
	
	
	
}

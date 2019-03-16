package com.stefanini.treinamento.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="celular")
public class Celular implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SQ_idcelular", sequenceName = "SQ_idcelular", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SQ_idcelular")
	@Column(name="idcelular")
	private Long idCelular;
	
	@NotNull
	@Column(name="nome", length=20)
	private String nome;
   
	@Size(min=1, max=5)
	@OneToMany(mappedBy = "idcelular",fetch = FetchType.LAZY,
	cascade= {CascadeType.ALL},orphanRemoval=true)
	private List<Capa> capas;
	
	public Celular() {
		super();
	}



	public Celular(Long idCelular, @NotNull String nome) {
		super();
		this.idCelular = idCelular;
		this.nome = nome;
	}



	

	public Long getIdCelular() {
		return idCelular;
	}



	public void setIdCelular(Long idCelular) {
		this.idCelular = idCelular;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<Capa> getCapas() {
		return capas;
	}



	public void setCapas(List<Capa> capas) {
		this.capas = capas;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCelular == null) ? 0 : idCelular.hashCode());
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
		Celular other = (Celular) obj;
		if (idCelular == null) {
			if (other.idCelular != null)
				return false;
		} else if (!idCelular.equals(other.idCelular))
			return false;
		return true;
	}
	
	
	
	

}

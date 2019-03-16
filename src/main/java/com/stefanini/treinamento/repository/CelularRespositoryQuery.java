package com.stefanini.treinamento.repository;

import java.util.List;

import com.stefanini.treinamento.entity.Celular;

public interface CelularRespositoryQuery {

	public List<Celular> searchByName(String nome);
	public Celular buscarPorNomeUnico(String nome);
	
}

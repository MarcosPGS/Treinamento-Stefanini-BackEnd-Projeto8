package com.stefanini.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.treinamento.entity.Celular;

public interface CelularRepository extends JpaRepository<Celular, Long>, CelularRespositoryQuery{

}

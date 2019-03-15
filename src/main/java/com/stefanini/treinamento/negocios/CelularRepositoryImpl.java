package com.stefanini.treinamento.negocios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.stefanini.treinamento.entity.Celular;
import com.stefanini.treinamento.repository.CelularRespositoryQuery;

@Repository
public class CelularRepositoryImpl implements CelularRespositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	@Override
	public List<Celular> buscarPorNome(String nome) {
		List<Celular> celularEncontrado = null;
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Celular> criteriaQuery = builder.createQuery(Celular.class);
			Root<Celular>root =criteriaQuery.from(Celular.class);
			Predicate[] predicates =criearRestricao(nome,builder,root);
			criteriaQuery.where(predicates);
			
			TypedQuery<Celular>typedQuery = manager.createQuery(criteriaQuery);
			celularEncontrado = typedQuery.getResultList();
			
			return celularEncontrado;
		} catch (Exception e) {
			return celularEncontrado;
		}
	}

	private Predicate[] criearRestricao(String nome, CriteriaBuilder builder, Root<Celular> root) {
		List<Predicate> predicates  = new ArrayList<>();
		if(!StringUtils.isEmpty(nome)) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%"+(nome.toLowerCase())+"%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	@Override
	public Celular buscarPorNomeUnico(String nome) {
		Celular celularEncontrado = null;
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Celular> criteriaQuery = builder.createQuery(Celular.class);
			Root<Celular>root =criteriaQuery.from(Celular.class);
			Predicate[] predicates =criearRestricao2(nome,builder,root);
			criteriaQuery.where(predicates);
			
			TypedQuery<Celular>typedQuery = manager.createQuery(criteriaQuery);
			celularEncontrado = typedQuery.getSingleResult();
			
			return celularEncontrado;
		} catch (Exception e) {
			return celularEncontrado;
		}
	}

	private Predicate[] criearRestricao2(String nome, CriteriaBuilder builder, Root<Celular> root) {
		List<Predicate> predicates  = new ArrayList<>();
		if(!StringUtils.isEmpty(nome)) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%"+(nome.toLowerCase())+"%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}

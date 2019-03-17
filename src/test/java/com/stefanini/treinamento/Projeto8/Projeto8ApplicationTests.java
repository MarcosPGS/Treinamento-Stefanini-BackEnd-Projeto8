package com.stefanini.treinamento.Projeto8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stefanini.treinamento.entity.Capa;
import com.stefanini.treinamento.entity.Celular;
import com.stefanini.treinamento.exceptions.CelularDuplicadoException;
import com.stefanini.treinamento.service.CelularService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Projeto8ApplicationTests {
	
	@Autowired CelularService cs;

	@Test
	public void contextLoads() {
		testaIncluiarCelular();
		testaConsultarCelular();
		testaEditarCelular();
		testaExclusaoCelular();
	}
	
	void testaExclusaoCelular() {
		List<Celular> listaCelular =  cs.searchByName("Meu 10");
		Celular encontrado = listaCelular.get(0);
		cs.delete(encontrado.getIdCelular());
	
	}
	void testaIncluiarCelular() {
		Celular c = new Celular();
		c.setIdCelular(new Long(1));
		c.setNome("Meu 10");
		Capa capa  = new Capa();
		Capa capa2  = new Capa();
		
		capa.setIdCapa(new Long(1));
		capa.setDescricao("Minha Capa Teste 1");
		capa2.setIdCapa(new Long(2));
		capa2.setDescricao("Minha Capa Teste 2");
		
		List<Capa> listaCapas = new ArrayList<Capa>();
		listaCapas.add(capa);
		listaCapas.add(capa2);
		
		c.setCapas(listaCapas);
		
		try {
			cs.create(c);
		} catch (CelularDuplicadoException e) {
			e.printStackTrace();
		}
	
	}
	
	void testaConsultarCelular() {
		List<Celular> listaCelular =  cs.searchByName("Meu 10");
		listaCelular.get(0);
	}
	
	void testaEditarCelular() {
		List<Celular> listaCelular =  cs.searchByName("Meu 10");
		Celular encontrado = listaCelular.get(0);
		encontrado.setNome("Celular Alterado");
		
		Capa capa  = new Capa();
		Capa capa2  = new Capa();
		
		capa.setIdCapa(new Long(1));
		capa.setDescricao("Minha Capa Teste 1");
		capa2.setIdCapa(new Long(2));
		capa2.setDescricao("Minha Capa Teste 2");
		
		List<Capa> listaCapas = new ArrayList<Capa>();
		listaCapas.add(capa);
		listaCapas.add(capa2);
		encontrado.setCapas(listaCapas);
		
		try {
			cs.update(encontrado);
		} catch (CelularDuplicadoException e) {
			
			e.printStackTrace();
		}  

		
	}
	

}

package com.stefanini.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.treinamento.entity.Capa;
import com.stefanini.treinamento.entity.Celular;
import com.stefanini.treinamento.exceptions.CelularDuplicadoException;
import com.stefanini.treinamento.repository.CelularRepository;

@Service
public class CelularService {

	@Autowired
	private CelularRepository celularRepository;
	
	//EndPoint list all
	public List<Celular> findAll(){
		return celularRepository.findAll();
	}
	
	
	//EndPoint searchName
		public List<Celular> searchByName(String nome){
			return celularRepository.searchByName(nome);
		}
		
	//EndPoint create
	public Celular create(Celular celular) throws CelularDuplicadoException {
		Celular celularEncontrado =celularRepository.buscarPorNomeUnico(celular.getNome());
		if(celularEncontrado!= null) {
			throw new CelularDuplicadoException("Celular Duplicado! ID: " + celularEncontrado.getIdCelular() + "  Nome: "+
					celularEncontrado.getNome());
		}
		 Celular celularSalvo = celularRepository.save(celular);
	        
	      
	       if(celular.getCapas() != null) {
		       celular.getCapas().forEach(capa->{
		    	   capa.setIdcelular(celularSalvo.getIdCelular());
		        	
		        });
	       }
	       
	       
	      celularRepository.save(celular);  
	      
	    return celularSalvo;
	    }
	
	
	//EndPoint update
	public Celular update(Celular celular) {
   		for (Capa c: celular.getCapas()) {	
   			if (c.getIdCapa() == null) {
   				c.setIdcelular(celular.getIdCelular());
   			}
   			
		}
	return celularRepository.save(celular);
		
	}
	
	//EndPoint delete
	public void delete(Long  idCelular) {
	celularRepository.deleteById(idCelular);
}
	
}

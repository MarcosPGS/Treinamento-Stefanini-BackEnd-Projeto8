package com.stefanini.treinamento.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.treinamento.entity.Celular;
import com.stefanini.treinamento.exceptions.CelularDuplicadoException;
import com.stefanini.treinamento.service.CelularService;

@CrossOrigin
@RestController
@RequestMapping(value="/celular")
public class CelularResource {

	@Autowired
	private CelularService celularService;
	
	//EndPoint list all
	@GetMapping
	public List<Celular> findAll(){
		return celularService.findAll();
	}
	
	//EndPoint searchName
	@GetMapping("/{nome}")
	public ResponseEntity<List<Celular>> searchName(@PathVariable String nome){
		List<Celular> celularEncontrado= celularService.searchName(nome);
		if(celularEncontrado == null) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(celularEncontrado);
	}
	//EndPoint create
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Celular celular){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(celularService.create(celular));
		} catch (CelularDuplicadoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	//EndPoint update
	@PutMapping
	public ResponseEntity<Celular> update(@Valid @RequestBody Celular celular){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(celularService.update(celular));
	}
	
	//EndPoint delete
	@DeleteMapping("/{idCelular}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idCelular) {
		celularService.delete(idCelular);
	}
}

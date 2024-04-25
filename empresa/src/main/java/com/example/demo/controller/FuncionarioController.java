package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Funcionario;
import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	@Autowired
	FuncionarioService funcionarioService;
	
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAll(){
		List<Funcionario> funcionarios = funcionarioService.getAll();
		if (!funcionarios.isEmpty()) {
			return new ResponseEntity<>(funcionarios, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Integer id){
		Funcionario funcionario = funcionarioService.getById(id);
		if (funcionario != null) {
			return new ResponseEntity<>(funcionario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<>(funcionarioService.saveFuncionario(funcionario), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario){
		Funcionario funcionarioAtualizada = funcionarioService.updateFuncionario(id, funcionario);
		if (funcionarioAtualizada != null) 
			return new ResponseEntity<>(funcionarioAtualizada, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteFuncionario(@PathVariable Integer id){
		if (funcionarioService.deleteFuncionario(id)) 
			return new ResponseEntity<>(true, HttpStatus.OK);
		 else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		
	}
}

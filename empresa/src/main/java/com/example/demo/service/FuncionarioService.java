package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Funcionario;
import com.example.demo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getAll(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario getById(Integer id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario updateFuncionario(Integer id, Funcionario funcionario) {
		Funcionario funcionarioAtualizado = funcionarioRepository.findById(id).orElse(null);
		if (funcionarioAtualizado != null) {
			funcionarioAtualizado.setFuncionarioNome(funcionario.getFuncionarioNome());
			return funcionarioRepository.save(funcionarioAtualizado);
		} else {
			return null;
		}
	}
	
	public Boolean deleteFuncionario(Integer id) {
		Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
		if (funcionario != null) {
			funcionarioRepository.delete(funcionario);
			return true;
		} else {
			return false;
		}
	}
}

package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "funcionario")

public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Integer funcionarioId;
	
	@Column(name = "funcionario_matricula")
	private Integer funcionarioMatricula;
	
	@Column(name = "funcionario_nome")
	private String funcionarioNome;

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getFuncionarioMatricula() {
		return funcionarioMatricula;
	}

	public void setFuncionarioMatricula(Integer funcionarioMatricula) {
		this.funcionarioMatricula = funcionarioMatricula;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}
	
	
}


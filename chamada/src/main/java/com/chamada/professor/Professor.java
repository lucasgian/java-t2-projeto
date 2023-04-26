package com.chamada.professor;

import java.util.Set;

import com.chamada.turma.Turma;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "professores")
@Entity
public class Professor {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String nome;

	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Turma> turmas;

	// private String disciplina;
	// private String turno;
    // private int cargaHoraria;
	//private boolean ensinoSuperior;
	
	// Construtor vazio, usado na listagem
	public Professor() {
		
	}
	
	// Construtor completo, usado na criação
	public Professor(DadosCadastroProfessor dados) {
		this.nome = dados.nome();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
/* O que estiver comentado podem deletar Comentario 
	public Set<Turma> getTurma() {
		return turmas;
	}
	*/
}

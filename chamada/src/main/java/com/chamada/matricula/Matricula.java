package com.chamada.matricula;

import com.chamada.aluno.Aluno;
import com.chamada.turma.Turma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity()
@Table(name = "matriculas")
public class Matricula {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String aluno_id;
	private String turma_id;
	
	@ManyToOne()
	@MapsId("alunoId")
	private Aluno aluno;
	
	@ManyToOne()
	@MapsId("turmaId")
	private Turma turma;
	
	public Aluno getAluno() {
		return this.aluno;
	}
	
	public Turma getTurma() {
		return this.turma;
	}
	
}

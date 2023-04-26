package com.chamada.aluno;

public record DadosListagemAluno(String id, String nome) {

	public DadosListagemAluno(Aluno aluno) {
		this(aluno.getId(), aluno.getNome());
	}
}

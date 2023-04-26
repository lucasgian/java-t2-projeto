package com.chamada.turma;

public record DadosCadastroTurma(String id, String modulo) {
	public DadosCadastroTurma(Turma turma) {
		this(turma.getId(), turma.getModulo());
	}
}
package com.chamada.professor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record DadosAtualizadoProfessor(
		@NotBlank @NotEmpty(message = "Precisa ter o id") String id,
		@Min(3) @NotBlank @NotEmpty(message = "Precisa ter o nome") String nome) {

}

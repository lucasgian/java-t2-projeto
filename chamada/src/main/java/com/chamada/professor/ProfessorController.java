package com.chamada.professor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository repository;

	@GetMapping
	public List<Professor> listar() {
		return repository.findAll();
	}

	// Quando estamos falando de DTO usamos record como definição
	@PostMapping
	public void criar(@RequestBody DadosCadastroProfessor dados) {
		// Estamos salvando um novo professor e inserindo os dados pelo Construtor
		repository.save(new Professor(dados));
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable String id) {
		System.out.println(id);
		repository.deleteById(id);
	}

	@PutMapping
	public void atualizar(@RequestBody @Valid DadosAtualizadoProfessor dados) {
		try {
			if (dados.nome().length() < 4) {
				throw new Exception("Erro nome deve ser maior que 4");
			}

			// Precisamos usar o Optional para não termos erro com um retorno NULL
			Optional<Professor> professorOptinal = repository.findById(dados.id());
	
			if (professorOptinal.isPresent()) {
				Professor professor = professorOptinal.get();
				professor.setNome(dados.nome());
	
				repository.save(professor);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

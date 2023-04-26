package com.chamada.turma;

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


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	private TurmaRepository repository;

	@GetMapping
	public List<Turma> listar() {
		return repository.findAll();
	}

	@PostMapping
	@Transactional
	public void criar(@RequestBody @Valid DadosCadastroTurma dados) {
		repository.save(new Turma(dados));
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable String id) {
		repository.deleteById(id);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody DadosCadastroTurma dados) {
		try {
			Optional<Turma> turmaOptional = repository.findById(dados.id());
			if (turmaOptional.isPresent()) {
				Turma turma = turmaOptional.get();
				turma.setModulo(dados.modulo());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

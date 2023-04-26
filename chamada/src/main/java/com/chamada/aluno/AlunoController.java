package com.chamada.aluno;

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
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;

	@GetMapping
	public List<DadosListagemAluno> listar() {
		return repository.findAll().stream().map(DadosListagemAluno::new).toList();
	}

	@PostMapping
	@Transactional
	public void criar(@RequestBody @Valid DadosCadastroAluno dados) {
		repository.save(new Aluno(dados));
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable String id) {
		repository.deleteById(id);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody DadosCadastroAluno dados) {
		try {
			Optional<Aluno> alunoOptional = repository.findById(dados.id());
			if (alunoOptional.isPresent()) {
				Aluno aluno = alunoOptional.get();
				aluno.setNome(dados.nome());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

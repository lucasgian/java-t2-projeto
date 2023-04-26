package com.chamada.matricula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/matriculas")
@RestController()
public class MatriculaController {
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@GetMapping()
	public List<Matricula> listagem() {
		return matriculaRepository.findAll();
	}
}

package com.tropical.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.tropical.model.PacoteDeViagem;
import com.tropical.model.Reserva;
import com.tropical.repository.PacoteRepository;
import com.tropical.repository.ReservaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PacoteController {

	@Autowired
	PacoteRepository pacoteRepository;

	@Autowired
	ReservaRepository reservaRepository;
	
	@GetMapping("/pacotes")
	public List<PacoteDeViagem> findAll() {
		return pacoteRepository.findAll();
	}

	@PostMapping("/pacotes")
	public PacoteDeViagem create(@RequestBody PacoteDeViagem pacote) {
		return pacoteRepository.save(pacote);
	}

	@GetMapping("/pacotes/{id}")
	public PacoteDeViagem findById(@PathVariable Long id) {
		return pacoteRepository.findById(id).get();
	}

	@PutMapping("/pacotes/{id}")
	public PacoteDeViagem update(@PathVariable Long id, @RequestBody PacoteDeViagem pacoteedit) {
		PacoteDeViagem pacote = pacoteRepository.findById(id).get();
		pacote.setDestino(pacoteedit.getDestino());
		pacote.setDescricao(pacoteedit.getDescricao());
		pacote.setDuracaoEmDias(pacoteedit.getDuracaoEmDias());
		pacote.setPreco(pacoteedit.getPreco());
		return pacoteRepository.save(pacote);
	}

	@DeleteMapping("/pacotes/{id}")
	public void delete(@PathVariable Long id) {

		for (Reserva reserva :reservaRepository.findAll() ) {
			
			if (reserva.getPacoteDeViagem().getId()==id) {
				reservaRepository.delete(reserva);
			}
		}
		pacoteRepository.deleteById(id);
	}
}

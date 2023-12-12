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

import com.tropical.model.Cliente;
import com.tropical.model.Contato;
import com.tropical.repository.ClienteRepository;
import com.tropical.repository.ContatoRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/contatos")
	public List<Contato> getAll(){
		return contatoRepository.findAll();
	}
	@GetMapping("/contatos/{id}")
	public Contato getById(@PathVariable Long id) {
		return contatoRepository.findById(id).get();
	}
	@PostMapping("/contatos/{id}")
	public Contato create(@PathVariable Long id,@RequestBody Contato contato) {
		Cliente cliente=clienteRepository.findById(id).get();
		contato.setCliente(cliente);
		return contatoRepository.save(contato);
	}
	
	@PutMapping("/contatos/{id}/{ClienteId}")
	public Contato update(@PathVariable Long id,@PathVariable Long ClienteId ,@RequestBody Contato contatoDetails) {
		Contato contato= contatoRepository.findById(id).get();
		
		Cliente cliente= clienteRepository.findById(ClienteId).get();
		System.out.println("ID do cliente");
		contato.setAssunto(contatoDetails.getAssunto());
		contato.setMensagem(contatoDetails.getMensagem());
		contato.setCliente(cliente);
		//contato.setCliente(cliente);
		return contatoRepository.save(contato);
		
	}
	@DeleteMapping("/contatos/{id}")
	public void delete(@PathVariable Long id) {
		contatoRepository.deleteById(id);
	}
}

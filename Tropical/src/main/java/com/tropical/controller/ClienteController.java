package com.tropical.controller;

import java.util.Iterator;
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
import com.tropical.model.Reserva;
import com.tropical.repository.ClienteRepository;
import com.tropical.repository.ContatoRepository;
import com.tropical.repository.ReservaRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> getAll(){
		
		return  clienteRepository.findAll();
	}
	@GetMapping("/clientes/{id}")
	public Cliente getClientByid(@PathVariable Long id) {
		return  clienteRepository.findById(id).get();
	}
	
	@PostMapping("/clientes")
	public Cliente create(@RequestBody Cliente cliente) {
		System.out.println(cliente.getNome());
		return clienteRepository.save(cliente);
	}
	@PutMapping("/clientes/{id}")
	public Cliente updateClient(@PathVariable Long id,@RequestBody Cliente clientDetails) {
		Cliente cliente =clienteRepository.findById(id).get();
		cliente.setNome(clientDetails.getNome());
		cliente.setCep(clientDetails.getCep());
		cliente.setDataNascimento(clientDetails.getDataNascimento());
		cliente.setEmail(clientDetails.getEmail());
		cliente.setSenha(clientDetails.getSenha());
		cliente.setTelefone(clientDetails.getTelefone());
		
		return clienteRepository.save(cliente);
		
	}
	@DeleteMapping("/clientes/{id}")
	public void deleteById(@PathVariable Long id) {
		 
		 for (Contato contato : contatoRepository.findAll()) {
			 if(contato.getCliente().getId() == id) {
				 contatoRepository.delete(contato);
			 }
		}
		 for(Reserva reserva :reservaRepository.findAll()) {
			 if(reserva.getCliente().getId()==id) {
				 reservaRepository.delete(reserva);
			 }
		 }
		clienteRepository.deleteById(id);
	}
	
}

package com.tropical.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.tropical.model.PacoteDeViagem;
import com.tropical.model.Reserva;
import com.tropical.repository.ClienteRepository;
import com.tropical.repository.PacoteRepository;
import com.tropical.repository.ReservaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReservaController {

	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PacoteRepository pacoteRepository;
	
	@GetMapping("/reservas")
	public List<Reserva> getAll(){
		return reservaRepository.findAll();
	}
	@GetMapping("/reservas/{id}")// obs : o nome do parâmetro deve ser igual ao nome passado na rota
	public Reserva getById(@PathVariable Long id) { 
		return reservaRepository.findById(id).get();
	}
	@PostMapping("/reservas/{idCliente}/{idPacote}")
	public Reserva create(@PathVariable Long idCliente,@PathVariable Long idPacote, @RequestBody Reserva reserva) {
		
		LocalDateTime dataReserva=LocalDateTime.now();
		
		System.out.println(idPacote);
		Cliente cliente = clienteRepository.findById(idCliente).get();
		PacoteDeViagem pacote= pacoteRepository.findById(idPacote).get();
		reserva.setCliente(cliente);
		reserva.setPacoteDeViagem(pacote);
		reserva.setDataReserva(dataReserva);
		return reservaRepository.save(reserva);
	}
	@PutMapping("reservas/{id}")
	public Reserva update(@PathVariable Long id , @RequestBody Reserva reservaDetails) {
			Reserva reserva=reservaRepository.findById(id).get();
			PacoteDeViagem pacote=pacoteRepository.findById(reservaDetails.getPacoteDeViagem().getId()).get();
			Cliente cliente=clienteRepository.findById(reservaDetails.getCliente().getId()).get();
			reserva.setDataReserva(reservaDetails.getDataReserva());
			reserva.setDataViagem(reservaDetails.getDataViagem());
			reserva.setCliente(cliente);
			reserva.setPacoteDeViagem(pacote);
		return reservaRepository.save(reserva);
				
	}
	@DeleteMapping("reservas/{id}")
	public void delete(@PathVariable Long id ) {
		
		reservaRepository.deleteById(id);
	}
}

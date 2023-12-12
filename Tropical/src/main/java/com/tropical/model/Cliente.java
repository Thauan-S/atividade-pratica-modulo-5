package com.tropical.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="clientes")
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long id;
	@Column(length = 50 ,nullable = false)
	private String nome;
	@Column(length = 50 ,nullable = false,unique = true)
	private String email;
	@Column(length = 50 ,nullable = false)
	private String senha;
	@Column(length = 50 ,nullable = false)
	private String telefone;
	@Column(length = 50 ,nullable = false)
	private String cep;
	@Column(name="data_nascimento",length = 50 ,nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	/*
	 * @OneToMany(mappedBy = "clientes",fetch = FetchType.LAZY) private
	 * List<Contato> contato;
	 */
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone="
				+ telefone + ", cep=" + cep + ", dataNascimento=" + dataNascimento + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	/*
	 * public List<Contato> getContato() { return contato; }
	 * 
	 * 
	 * public void setContato(List<Contato> contato) { this.contato = contato; }
	 */

}

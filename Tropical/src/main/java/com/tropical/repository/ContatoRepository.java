package com.tropical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tropical.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

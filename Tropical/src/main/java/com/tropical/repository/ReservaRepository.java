package com.tropical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tropical.model.Reserva;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}

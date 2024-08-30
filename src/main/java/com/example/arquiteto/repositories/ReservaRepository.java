package com.example.arquiteto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.arquiteto.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    
} 
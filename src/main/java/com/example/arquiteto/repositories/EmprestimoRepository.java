package com.example.arquiteto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arquiteto.domain.Emprestimo;

public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> { 
    
}

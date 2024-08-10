package com.example.arquiteto.repositories;

import com.example.arquiteto.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

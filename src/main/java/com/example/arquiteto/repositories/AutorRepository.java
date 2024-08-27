package com.example.arquiteto.repositories;

import com.example.arquiteto.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}

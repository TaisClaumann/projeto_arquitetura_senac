package com.example.arquiteto.repositories;

import com.example.arquiteto.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findAllByNomeContainingAndCategoriasNomeContainingAndAutoresNomeContaining(String nome, String categoria, String autor);
}

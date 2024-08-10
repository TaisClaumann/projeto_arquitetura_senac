package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.LivroDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    private Long id;
    private String nome;
    private Autor autor;
    private Categoria categoria;
    private String editora;
    private Integer quantidade;

    public Livro(LivroDto livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.autor = new Autor(livro.getAutor());
        this.categoria = new Categoria(livro.getCategoria());
        this.editora = livro.getEditora();
        this.quantidade = livro.getQuantidade();
    }
}

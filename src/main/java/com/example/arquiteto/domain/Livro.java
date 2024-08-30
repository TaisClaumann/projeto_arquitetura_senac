package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.LivroDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "livro_categoria", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @JsonIgnore
    @OneToMany(mappedBy = "livroEmprestimo")
    private List<Emprestimo> emprestimos;
    
    private String editora;
    private Integer quantidade;

    public Livro(LivroDto livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.autores = livro.getAutores().stream().map(Autor::new).toList();
        this.categorias = livro.getCategorias().stream().map(Categoria::new).toList();
        this.editora = livro.getEditora();
        this.quantidade = livro.getQuantidade();
    }
}

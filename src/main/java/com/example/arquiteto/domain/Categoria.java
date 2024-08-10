package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.CategoriaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<Livro> livros;

    public Categoria(CategoriaDto categoriaDto) {
        this.id = categoriaDto.getId();
        this.nome = categoriaDto.getNome();
    }
}

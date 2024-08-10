package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.CategoriaDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

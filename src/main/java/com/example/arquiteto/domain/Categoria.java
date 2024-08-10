package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.CategoriaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    private Long id;
    private String nome;

    public Categoria(CategoriaDto categoriaDto) {
        this.id = categoriaDto.getId();
        this.nome = categoriaDto.getNome();
    }
}

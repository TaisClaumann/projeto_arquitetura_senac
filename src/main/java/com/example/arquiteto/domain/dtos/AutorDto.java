package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.domain.Autor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDto {

    private Long id;
    private String nome;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
    }
}

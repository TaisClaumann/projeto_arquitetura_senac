package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.AutorDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor {

    private Long id;
    private String nome;

    public Autor(AutorDto autorDto) {
        this.id = autorDto.getId();
        this.nome = autorDto.getNome();
    }
}

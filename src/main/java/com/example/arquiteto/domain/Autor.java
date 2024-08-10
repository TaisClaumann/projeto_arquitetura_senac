package com.example.arquiteto.domain;

import com.example.arquiteto.domain.dtos.AutorDto;
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
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;

    public Autor(AutorDto autorDto) {
        this.id = autorDto.getId();
        this.nome = autorDto.getNome();
    }
}

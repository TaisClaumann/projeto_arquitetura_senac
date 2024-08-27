package com.example.arquiteto.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataSaida;
    private LocalDate dataVencimento;
    private boolean status;

    @ManyToOne(cascade= CascadeType.REFRESH)
    public Usuario usuarioEmprestimo;

    @ManyToOne(cascade= CascadeType.REFRESH)
    public Livro livroEmprestimo;
}
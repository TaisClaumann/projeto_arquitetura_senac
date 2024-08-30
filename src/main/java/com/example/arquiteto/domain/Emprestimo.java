package com.example.arquiteto.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataSaida;
    private String dataVencimento;
    private boolean status;

    @ManyToOne(cascade= CascadeType.REFRESH)
    public Usuario usuario_emprestimo;


    @ManyToOne(cascade= CascadeType.REFRESH)
    public Livro livro_emprestimo;

    public Emprestimo(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataSaida = emprestimo.getDataSaida();
        this.dataVencimento = emprestimo.getDataVencimento();
        this.status = emprestimo.isStatus();
        this.usuario_emprestimo = emprestimo.getUsuario_emprestimo();
        this.livro_emprestimo = emprestimo.getLivro_emprestimo();
    }
}
package com.example.arquiteto.domain;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

    @Entity
public class Emprestimo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Usuario usuario;
    //private Livro livro;
    private LocalDate dataSaida;
    private LocalDate dataVencimento;
    private boolean status;

    @ManyToOne(cascade= CascadeType.REFRESH)
    public Usuario usuario_emprestimo;


    @ManyToOne(cascade= CascadeType.REFRESH)
    public Livro livro_emprestimo;

    public Emprestimo(Long id, LocalDate dataSaida, LocalDate dataVencimento, boolean status,
            Usuario usuario_emprestimo, Livro livro_emprestimo) {
        this.id = id;
        this.dataSaida = dataSaida;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.usuario_emprestimo = usuario_emprestimo;
        this.livro_emprestimo = livro_emprestimo;
    }

    public Emprestimo() {
    }    


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDataSaida() {
        return dataSaida;
    }


    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }


    public LocalDate getDataVencimento() {
        return dataVencimento;
    }


    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }


    public boolean isStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    public Usuario getUsuario_emprestimo() {
        return usuario_emprestimo;
    }


    public void setUsuario_emprestimo(Usuario usuario_emprestimo) {
        this.usuario_emprestimo = usuario_emprestimo;
    }


    public Livro getLivro_emprestimo() {
        return livro_emprestimo;
    }


    public void setLivro_emprestimo(Livro livro_emprestimo) {
        this.livro_emprestimo = livro_emprestimo;
    }

    
}
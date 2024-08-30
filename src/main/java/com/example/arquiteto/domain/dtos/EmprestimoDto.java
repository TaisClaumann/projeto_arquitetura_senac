package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.domain.Livro;
import com.example.arquiteto.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmprestimoDto {

    private Long id;
    private Usuario usuario;
    private Livro livro;
    private String dataSaida;
    private String dataVencimento;
    private boolean status;

    public EmprestimoDto(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.usuario = emprestimo.getUsuarioEmprestimo();
        this.livro = emprestimo.getLivroEmprestimo();
        this.dataSaida = emprestimo.getDataSaida();
        this.dataVencimento = emprestimo.getDataVencimento();
        this.status = emprestimo.isStatus();
    }
}

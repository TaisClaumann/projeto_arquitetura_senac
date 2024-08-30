package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.Utils.DataUtils;
import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.domain.Livro;
import com.example.arquiteto.domain.Usuario;
import com.example.arquiteto.enums.StatusEnum;
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
    private Usuario usuarioEmprestimo;
    private Livro livroEmprestimo;
    private String dataSaida;
    private String dataVencimento;
    private StatusEnum status;

    public EmprestimoDto(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.usuarioEmprestimo = emprestimo.getUsuarioEmprestimo();
        this.livroEmprestimo = emprestimo.getLivroEmprestimo();
        this.dataSaida = DataUtils.localDateToString(emprestimo.getDataSaida());
        this.dataVencimento = DataUtils.localDateToString(emprestimo.getDataVencimento());
        this.status = emprestimo.getStatus();
    }
}

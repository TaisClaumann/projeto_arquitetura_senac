package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.Utils.DataUtils;
import com.example.arquiteto.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private boolean ativo;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.dataNascimento = DataUtils.localDateToString(usuario.getDataNascimento());
        this.ativo = usuario.isAtivo();
    }
}

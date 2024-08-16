package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.domain.Categoria;
import com.example.arquiteto.domain.Livro;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDto {

    private Long id;
    private String nome;
    private List<AutorDto> autores;
    private List<CategoriaDto> categorias;
    private String editora;
    private Integer quantidade;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.autores = livro.getAutores().stream().map(AutorDto::new).toList();
        this.categorias = livro.getCategorias().stream().map(CategoriaDto::new).toList();
        this.editora = livro.getEditora();
        this.quantidade = livro.getQuantidade();
    }
}

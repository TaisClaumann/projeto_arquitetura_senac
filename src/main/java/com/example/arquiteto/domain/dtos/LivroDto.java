package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.domain.Categoria;
import com.example.arquiteto.domain.Livro;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDto {

    private Long id;
    private String nome;
    private AutorDto autor;
    private CategoriaDto categoria;
    private String editora;
    private Integer quantidade;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.autor = new AutorDto(livro.getAutor());
        this.categoria = new CategoriaDto(livro.getCategoria());
        this.editora = livro.getEditora();
        this.quantidade = livro.getQuantidade();
    }
}

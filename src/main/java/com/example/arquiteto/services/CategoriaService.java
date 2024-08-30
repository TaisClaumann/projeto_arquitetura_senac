package com.example.arquiteto.services;

import com.example.arquiteto.domain.Autor;
import com.example.arquiteto.domain.Categoria;
import com.example.arquiteto.domain.dtos.AutorDto;
import com.example.arquiteto.domain.dtos.CategoriaDto;
import com.example.arquiteto.repositories.AutorRepository;
import com.example.arquiteto.repositories.CategoriaRepository;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaDto salvar(CategoriaDto categoriaDto) {
        return new CategoriaDto(repository.save(new Categoria(categoriaDto)));
    }

    public CategoriaDto buscarPorId(Long id) {
        return new CategoriaDto(repository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Autor não encontrado! ID: " + id)));
    }

    public CategoriaDto atualizar(Long id, CategoriaDto categoriaDto) {
        buscarPorId(id);
        categoriaDto.setId(id);
        return new CategoriaDto(repository.save(new Categoria(categoriaDto)));
    }

    public List<CategoriaDto> listar() {
        return repository.findAll().stream().map(CategoriaDto::new).toList();
    }
}

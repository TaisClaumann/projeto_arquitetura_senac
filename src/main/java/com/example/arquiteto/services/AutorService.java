package com.example.arquiteto.services;

import com.example.arquiteto.domain.Autor;
import com.example.arquiteto.domain.dtos.AutorDto;
import com.example.arquiteto.repositories.AutorRepository;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public AutorDto salvar(AutorDto autorDto) {
        return new AutorDto(repository.save(new Autor(autorDto)));
    }

    public AutorDto buscarPorId(Long id) {
        return new AutorDto(repository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Autor não encontrado! ID: " + id)));
    }

    public AutorDto atualizar(Long id, AutorDto autorDto) {
        buscarPorId(id);
        autorDto.setId(id);
        return new AutorDto(repository.save(new Autor(autorDto)));
    }

    public List<AutorDto> listar() {
        return repository.findAll().stream().map(AutorDto::new).toList();
    }
}

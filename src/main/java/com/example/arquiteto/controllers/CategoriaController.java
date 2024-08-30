package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.dtos.CategoriaDto;
import com.example.arquiteto.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public CategoriaDto salvar(@RequestBody CategoriaDto categoriaDto) {
        return categoriaService.salvar(categoriaDto);
    }

    @PutMapping("/{id}")
    public CategoriaDto atualizar(@PathVariable("id") Long id, @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.atualizar(id, categoriaDto);
    }

    @GetMapping("/{id}")
    public CategoriaDto buscarPorId(@PathVariable("id") Long id) {
        return categoriaService.buscarPorId(id);
    }

    @GetMapping
    public List<CategoriaDto> listar() {
        return categoriaService.listar();
    }
}

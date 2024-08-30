package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.dtos.AutorDto;
import com.example.arquiteto.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public AutorDto salvar(@RequestBody AutorDto autorDto) {
        return autorService.salvar(autorDto);
    }

    @PutMapping("/{id}")
    public AutorDto atualizar(@PathVariable("id") Long id, @RequestBody AutorDto autorDto) {
        return autorService.atualizar(id, autorDto);
    }

    @GetMapping("/{id}")
    public AutorDto buscarPorId(@PathVariable("id") Long id) {
        return autorService.buscarPorId(id);
    }


    @GetMapping
    public List<AutorDto> listar() {
        return autorService.listar();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        autorService.excluir(id);
    }
}

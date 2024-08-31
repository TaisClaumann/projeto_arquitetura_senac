package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.Usuario;
import com.example.arquiteto.domain.dtos.LivroDto;
import com.example.arquiteto.domain.dtos.UsuarioDto;
import com.example.arquiteto.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public LivroDto salvar(@RequestBody LivroDto livroDto) {
        return livroService.salvar(livroDto);
    }

    @PutMapping("/{id}")
    public LivroDto atualizar(@PathVariable("id") Long id, @RequestBody LivroDto livroDto) {
        return livroService.atualizar(id, livroDto);
    }

    @GetMapping("/{id}")
    public LivroDto buscarPorId(@PathVariable("id") Long id) {
        return livroService.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<LivroDto> buscarPorNome(@RequestParam("nome") String nome) {
        return livroService.buscarPorNome(nome);
    }

    @GetMapping
    public List<LivroDto> listar() {
        return livroService.listar();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        livroService.excluir(id);
    }
}

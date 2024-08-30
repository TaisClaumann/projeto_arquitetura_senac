package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.dtos.LivroDto;
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
    public List<LivroDto> buscarPorNomeCategoriaEAutor(@RequestParam("nome") String nome,
                                                       @RequestParam("categoria") String categoria,
                                                       @RequestParam("autor") String autor) {
        return livroService.buscarPorNomeCategoriaEAutor(nome, categoria, autor);
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

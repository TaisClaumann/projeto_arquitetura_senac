package com.example.arquiteto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.domain.dtos.EmprestimoDto;
import com.example.arquiteto.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    
    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoDto salvar(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.salvar(emprestimo);
    }

    @PutMapping("/{id}")
    public EmprestimoDto atualizar(@PathVariable("id") Long id, @RequestBody Emprestimo emprestimo) {
        return emprestimoService.atualizar(id, emprestimo);
    }

    @GetMapping("/{id}")
    public EmprestimoDto buscarPorId(@PathVariable("id") Long id) {
        return emprestimoService.buscarPorId(id);
    }

    @GetMapping
    public List<EmprestimoDto> buscarTodos() {
        return emprestimoService.buscarTodos();
    }
}

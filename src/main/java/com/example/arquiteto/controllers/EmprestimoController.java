package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.domain.dtos.EmprestimoDto;
import com.example.arquiteto.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
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

    @GetMapping("/usuario/{usuarioId}")
    public List<EmprestimoDto> buscarPorUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return emprestimoService.buscarPorUsuario(usuarioId);
    }
}

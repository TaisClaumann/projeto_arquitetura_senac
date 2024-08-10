package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.Usuario;
import com.example.arquiteto.domain.dtos.UsuarioDto;
import com.example.arquiteto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDto salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioDto atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario);
    }

    @GetMapping("/{id}")
    public UsuarioDto buscarPorId(@PathVariable("id") Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping
    public List<UsuarioDto> buscarTodos() {
        return usuarioService.buscarTodos();
    }
}

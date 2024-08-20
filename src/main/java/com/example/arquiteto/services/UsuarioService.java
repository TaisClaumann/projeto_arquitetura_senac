package com.example.arquiteto.services;

import com.example.arquiteto.domain.Usuario;
import com.example.arquiteto.domain.dtos.LoginDto;
import com.example.arquiteto.domain.dtos.UsuarioDto;
import com.example.arquiteto.repositories.UsuarioRepository;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto salvar(Usuario usuario) {
        usuario.setAtivo(true);
        return new UsuarioDto(usuarioRepository.save(usuario));
    }

    public void logar(LoginDto login) {
        usuarioRepository.findByEmailAndSenha(login.getEmail(), login.getSenha())
                .orElseThrow(() -> new RegistroNaoEncontradoException("Usuário ou senha incorretos"));
    }

    public UsuarioDto buscarPorId(Long id) {
        return new UsuarioDto(usuarioRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Usuário não encontrado! ID: " + id)));
    }

    public UsuarioDto atualizar(Long id, Usuario usuario) {
        buscarPorId(id);
        usuario.setId(id);
        return new UsuarioDto(usuarioRepository.save(usuario));
    }

    public List<UsuarioDto> buscarTodos() {
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).toList();
    }
}

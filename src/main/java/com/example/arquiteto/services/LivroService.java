package com.example.arquiteto.services;

import com.example.arquiteto.domain.Livro;
import com.example.arquiteto.domain.dtos.LivroDto;
import com.example.arquiteto.repositories.LivroRepository;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroDto salvar(LivroDto livro) {
        return new LivroDto(livroRepository.save(new Livro(livro)));
    }

    public LivroDto atualizar(Long id, LivroDto livroDto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado"));
        livroDto.setId(livro.getId());
        return new LivroDto(livroRepository.save(new Livro(livroDto)));
    }

    public LivroDto buscarPorId(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado"));
        return new LivroDto(livro);
    }

    public List<LivroDto> listar() {
        return livroRepository.findAll().stream()
                .map(LivroDto::new)
                .toList();
    }

    public List<LivroDto> buscarPorNome(String nome) {
        return livroRepository.findAllByNomeContainingIgnoreCase(nome).stream()
                .map(LivroDto::new)
                .toList();
    }

    public void excluir(Long id) {
        if (livroRepository.existsById(id)) livroRepository.deleteById(id);
    }
}

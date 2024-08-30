package com.example.arquiteto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.domain.dtos.EmprestimoDto;
import com.example.arquiteto.repositories.EmprestimoRepository;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;

@Service
public class EmprestimoService {
    
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoDto salvar(Emprestimo emprestimo) {
        return new EmprestimoDto(emprestimoRepository.save(emprestimo));
    }

    public EmprestimoDto buscarPorId(Long livro) {
        return new EmprestimoDto(emprestimoRepository.findById(livro)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado! ID: " + livro)));
    }

    public EmprestimoDto atualizar(Long id, Emprestimo emprestimo) {
        buscarPorId(id);
        emprestimo.setId(id);
        return new EmprestimoDto(emprestimoRepository.save(emprestimo));
    }

    public List<EmprestimoDto> buscarTodos() {
        return emprestimoRepository.findAll().stream().map(EmprestimoDto::new).toList();
    }
}

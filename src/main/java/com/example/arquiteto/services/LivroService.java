package com.example.arquiteto.services;

import com.example.arquiteto.domain.Livro;
import com.example.arquiteto.domain.dtos.LivroDto;
import com.example.arquiteto.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

//    public Livro salvar(LivroDto livro) {
//        return livroRepository.save(new Livro(livro));
//    }

}

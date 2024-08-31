package com.example.arquiteto.repositories;

import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByUsuarioEmprestimoId(Long usuarioEmprestimoId);
    List<Emprestimo> findByLivroEmprestimoIdAndStatus(Long livroEmprestimoId, StatusEnum status);
}

package com.example.arquiteto.services;

import com.example.arquiteto.domain.Emprestimo;
import com.example.arquiteto.domain.dtos.EmprestimoDto;
import com.example.arquiteto.domain.dtos.LivroDto;
import com.example.arquiteto.enums.StatusEnum;
import com.example.arquiteto.repositories.EmprestimoRepository;
import com.example.arquiteto.services.exceptions.LivroIndisponivelException;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmprestimoService {
    
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    public EmprestimoDto salvar(Emprestimo emprestimo) {
        Objects.requireNonNull(emprestimo.livroEmprestimo);
        Objects.requireNonNull(emprestimo.usuarioEmprestimo);
        hasLivroDisponivel(emprestimo.livroEmprestimo.getId());

        if (Objects.nonNull(emprestimo.getId())) emprestimo.setStatus(StatusEnum.ABERTO);
        return new EmprestimoDto(emprestimoRepository.save(emprestimo));
    }

    public EmprestimoDto buscarPorId(Long livro) {
        return new EmprestimoDto(emprestimoRepository.findById(livro)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado! ID: " + livro)));
    }

    public EmprestimoDto atualizar(Long id, Emprestimo emprestimo) {
        EmprestimoDto emprestimoSalvo = buscarPorId(id);

        Objects.requireNonNull(emprestimo.livroEmprestimo);
        Objects.requireNonNull(emprestimo.usuarioEmprestimo);
        if (emprestimoSalvo.getLivroEmprestimo().getId().compareTo(emprestimo.getLivroEmprestimo().getId()) != 0) {
            hasLivroDisponivel(emprestimo.getLivroEmprestimo().getId());
        }

        emprestimo.setId(id);
        return new EmprestimoDto(emprestimoRepository.save(emprestimo));
    }

    public List<EmprestimoDto> buscarTodos() {
        return emprestimoRepository.findAll().stream().map(EmprestimoDto::new).toList();
    }

    public void excluir(Long id) {
        if (emprestimoRepository.existsById(id)) emprestimoRepository.deleteById(id);
    }

    public List<EmprestimoDto> buscarPorUsuario(Long usuarioId) {
        usuarioService.buscarPorId(usuarioId);
        return emprestimoRepository.findByUsuarioEmprestimoId(usuarioId).stream()
                .map(EmprestimoDto::new)
                .toList();
    }

    private void hasLivroDisponivel(Long livroId) {
        LivroDto livro = livroService.buscarPorId(livroId);
        int qtdEmprestimosEmAberto = buscarEmprestimosEmAbertoPorLivro(livroId).size();

        if (qtdEmprestimosEmAberto == livro.getQuantidade()) {
            throw new LivroIndisponivelException("O livro " + livro.getNome() + " esta indisponível para empréstimo");
        }
    }

    public List<EmprestimoDto> buscarEmprestimosEmAbertoPorLivro(Long livroId) {
        return emprestimoRepository.findByLivroEmprestimoIdAndStatus(livroId, StatusEnum.ABERTO).stream()
                .map(EmprestimoDto::new)
                .toList();
    }
}

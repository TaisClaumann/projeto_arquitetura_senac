package com.example.arquiteto.services;


import com.example.arquiteto.domain.Reserva;
import com.example.arquiteto.domain.dtos.ReservaDto;
import com.example.arquiteto.repositories.ReservaRepository;
import com.example.arquiteto.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private LivroService livroService;

    public ReservaDto salvar(Reserva reserva) {
        usuarioService.buscarPorId(reserva.getUsuarioReserva().getId());
        livroService.buscarPorId(reserva.getLivroReserva().getId());
        return new ReservaDto(reservaRepository.save(reserva));
    }

    public List<ReservaDto> listar() {
        return reservaRepository.findAll().stream().map(ReservaDto::new).toList();
    }

    public void excluir(Long id) {
        buscarPorId(id);
        reservaRepository.deleteById(id);
    }

    public ReservaDto buscarPorId(Long id) {
        return new ReservaDto(reservaRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Reserva não encontrada! ID: " + id)));
    }

    public ReservaDto atualizar(Long id, Reserva reserva) {
        buscarPorId(id);
        reserva.setId(id);
        return salvar(reserva);
    }

    public List<ReservaDto> buscarReservasPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioReservaId(usuarioId).stream().map(ReservaDto::new).toList();
    }
}

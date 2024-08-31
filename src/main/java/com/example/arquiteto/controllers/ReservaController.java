package com.example.arquiteto.controllers;

import com.example.arquiteto.domain.Reserva;
import com.example.arquiteto.domain.dtos.ReservaDto;
import com.example.arquiteto.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ReservaDto salvar(Reserva reserva) {
        return reservaService.salvar(reserva);
    }

    @GetMapping
    public List<ReservaDto> listar() {
        return reservaService.listar();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        reservaService.excluir(id);
    }

    @GetMapping("/{id}")
    public ReservaDto buscarPorId(@PathVariable("id") Long id){
        return reservaService.buscarPorId(id);
    }
}

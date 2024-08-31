package com.example.arquiteto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquiteto.domain.Reserva;
import com.example.arquiteto.services.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService service;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(Reserva reserva) {

        return new ResponseEntity<>(service.cadastro(reserva), HttpStatus.OK);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<Reserva>> listar() {

        return new ResponseEntity<>(service.listar(), HttpStatus.OK);

    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") int id) {
        String resposta = service.excluir(id);
        if (resposta.equals("Reserva excluída")) {
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Reserva> listar(@PathVariable("id") int id){
        return service.listaReservas(id);
    }
}

package com.example.arquiteto.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.arquiteto.domain.Reserva;
import com.example.arquiteto.repositories.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    ReservaRepository repository;

    public String cadastro(Reserva reserva){

        repository.save(reserva);

        return "RESERVADO!";
    }

    public List<Reserva> listar(){

        List<Reserva> lista = repository.findAll();

        return lista;
        
    }

    public String excluir(int id){  
        Reserva reserva = repository.findById(id).orElse(null);

        if (reserva != null) {
            repository.delete(reserva);
            return "Reserva excluída";
        }

        return "Reserva não encontrada";
    }

     public ResponseEntity<Reserva> listaReservas(int id){
        Reserva reservas = repository.findById(id).orElse(null);

        if (reservas != null){
            return new ResponseEntity<>(reservas, HttpStatus.OK);
        }

            return new ResponseEntity<>(reservas, HttpStatus.NOT_FOUND);

    }

}

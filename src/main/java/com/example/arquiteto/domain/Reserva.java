package com.example.arquiteto.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuarioReserva;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Livro livroReserva;
    

    
    




   
    

}

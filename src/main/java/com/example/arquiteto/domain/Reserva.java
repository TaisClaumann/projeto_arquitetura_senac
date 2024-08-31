package com.example.arquiteto.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int prioridade;


    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario_reserva;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Livro livro_reserva;
    

    
    




   
    

}

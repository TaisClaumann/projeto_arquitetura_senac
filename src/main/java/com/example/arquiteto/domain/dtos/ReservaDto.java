package com.example.arquiteto.domain.dtos;

import com.example.arquiteto.domain.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaDto {

    private Long id;
    private UsuarioDto usuarioReserva;
    private LivroDto livroReserva;
    private LocalDate data;

    public ReservaDto(Reserva reserva) {
        this.id = reserva.getId();
        this.usuarioReserva = new UsuarioDto(reserva.getUsuarioReserva());
        this.livroReserva = new LivroDto(reserva.getLivroReserva());
        this.data = reserva.getData();

    }
}

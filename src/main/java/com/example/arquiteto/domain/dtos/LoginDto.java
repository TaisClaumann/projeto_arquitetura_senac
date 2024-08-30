package com.example.arquiteto.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginDto {

    private String email;
    private String senha;
}

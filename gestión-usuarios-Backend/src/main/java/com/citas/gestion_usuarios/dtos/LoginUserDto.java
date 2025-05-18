package com.citas.gestion_usuarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginUserDto {

    public String username;
    public String password;

}

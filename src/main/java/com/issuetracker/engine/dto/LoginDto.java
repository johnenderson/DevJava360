package com.issuetracker.engine.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = "atributo obrigatorio")
    private String username;

    @NotBlank(message = "atributo obrigatorio")
    private String password;

}
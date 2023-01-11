package com.capflix.capflixbackend.dto.entradaDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserEntradaDTO {

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String name;

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String password;

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String email;
}

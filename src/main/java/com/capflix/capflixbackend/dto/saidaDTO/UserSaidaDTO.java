package com.capflix.capflixbackend.dto.saidaDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserSaidaDTO {

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String name;

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String password;

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String email;

    public UserSaidaDTO(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

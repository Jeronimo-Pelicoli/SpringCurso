package com.capflix.capflixbackend.rest.dto.movieDto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Data
public class MovieExitDto {

    @NotEmpty(message="not null")
    @Size(max=50, message="máximo de trinta caracteres")
    private String name;

    @NotEmpty(message="not null")
    @Size(max=100, message="máximo de cem caracteres")
    private String gender;

    @NotEmpty(message="not null")
    @Size(max=200, message="máximo de duzentos caracteres")
    private String url;

    @NotEmpty(message="not null")
    @Size(max=1000, message="máximo de um mil caracteres")
    private String description;

    public MovieExitDto (String name, String gender, String url, String description){
        this.name = name;
        this.gender = gender;
        this.url=url;
        this.description = description;
    }

}

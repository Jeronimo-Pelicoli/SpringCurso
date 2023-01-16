package com.capflix.capflixbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_MOVIE")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;

    public String gender;

    public String url;

    public String description;

    public Movie() {
    }

    public Movie (Long id, String name, String gender, String url, String description){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.url=url;
        this.description = description;
    }

    public Movie ( String name, String gender, String url, String description){
        this.name = name;
        this.gender = gender;
        this.url=url;
        this.description = description;
    }
}

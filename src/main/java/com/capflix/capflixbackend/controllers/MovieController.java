package com.capflix.capflixbackend.controllers;

import com.capflix.capflixbackend.repositories.MovieRepository;
import com.capflix.capflixbackend.dto.entradaDTO.MovieEntranceDto;
import com.capflix.capflixbackend.dto.saidaDTO.MovieExitDto;
import com.capflix.capflixbackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService;
    private MovieRepository movieRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieExitDto create(@Valid @RequestBody MovieEntranceDto movie) {
        return this.movieService.createMovie(movie);
    }

    @GetMapping("/list")
    public List<MovieExitDto> list(){
        return this.movieService.listAll();
    }

    @GetMapping("/{id}")
    public MovieExitDto findById(@PathVariable Long id) {
        MovieExitDto clienteOptional = movieService.findById(id);
        return clienteOptional;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }


    @PutMapping("/{id}")
    public MovieExitDto updateById(@PathVariable Long id, @RequestBody MovieEntranceDto movie) {

        MovieExitDto clienteOptional = movieService.updateMovie(id, movie);

        if (clienteOptional == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return clienteOptional;
    }



}

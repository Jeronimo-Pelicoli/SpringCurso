package com.capflix.capflixbackend.services;

import com.capflix.capflixbackend.entities.Movie;
import com.capflix.capflixbackend.repositories.MovieRepository;

import com.capflix.capflixbackend.dto.entradaDTO.MovieEntranceDto;
import com.capflix.capflixbackend.dto.saidaDTO.MovieExitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public MovieExitDto createMovie(MovieEntranceDto movie){
        Movie movieModel = new Movie(
                movie.getName(),
                movie.getGender(),
                movie.getUrl(),
                movie.getDescription()
        );
        Movie movieDb = this.movieRepository.save(movieModel);

        MovieExitDto movieExit = new MovieExitDto(
                movieDb.getName(),
                movieDb.getGender(),
                movieDb.getUrl(),
                movieDb.getDescription()
        );
        return movieExit;
    }

    public MovieExitDto findById (Long id){
        Movie movieDb = this.movieRepository.getReferenceById(id);
        MovieExitDto movieModel = new MovieExitDto(
                movieDb.getName(),
                movieDb.getGender(),
                movieDb.getUrl(),
                movieDb.getDescription()
        );
        return movieModel;
    }

    public List<MovieExitDto> listAll() {
        List<Movie> movies = this.movieRepository.findAll();
        List<MovieExitDto> moviesExit = movies.stream().map(
                movie -> new MovieExitDto(
                        movie.getName(),
                        movie.getGender(),
                        movie.getUrl(),
                        movie.getDescription()
                )
        ).collect(Collectors.toList());
        return moviesExit;
    }

    public MovieExitDto updateMovie (Long id, MovieEntranceDto movie){
        Movie movieModel = this.movieRepository.findById(id).get();
        movieModel.setName(movie.getName());
        movieModel.setDescription(movie.getDescription());
        movieModel.setGender(movie.getGender());
        movieModel.setUrl(movie.getUrl());
        Movie movieDb = this.movieRepository.save(movieModel);
        MovieExitDto movieExit = new MovieExitDto(movieDb.getName(),
                movieDb.getGender(),
                movieDb.getUrl(),
                movieDb.getDescription()
        );
        return movieExit;
    }

    public void deleteMovie (Long id){
        this.movieRepository.deleteById(id);
    }
}

package com.capflix.capflixbackend.repository;

import com.capflix.capflixbackend.model.Movie;
import com.capflix.capflixbackend.rest.dto.movieDto.MovieExitDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {


}

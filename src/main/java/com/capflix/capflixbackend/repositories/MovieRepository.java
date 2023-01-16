package com.capflix.capflixbackend.repositories;

import com.capflix.capflixbackend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {


}

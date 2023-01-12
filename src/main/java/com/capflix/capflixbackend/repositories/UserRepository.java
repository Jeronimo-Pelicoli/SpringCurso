package com.capflix.capflixbackend.repositories;

import com.capflix.capflixbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

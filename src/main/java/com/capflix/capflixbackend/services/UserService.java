package com.capflix.capflixbackend.services;

import com.capflix.capflixbackend.dto.entradaDTO.UserEntradaDTO;
import com.capflix.capflixbackend.dto.saidaDTO.UserSaidaDTO;
import com.capflix.capflixbackend.entities.User;
import com.capflix.capflixbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserSaidaDTO createUser(UserEntradaDTO user) {
        User userModel = new User(user.getName(), user.getPassword(), user.getEmail());
        User userBanco = userRepository.save(userModel);
        UserSaidaDTO userSaida = new UserSaidaDTO(userBanco.getName(), userBanco.getPassword(), userBanco.getEmail());
        return userSaida;
    }

    public List<UserSaidaDTO> listAll() {
        List<User> userBanco = userRepository.findAll();
        List<UserSaidaDTO> userSaida = userBanco.stream().map(user -> new UserSaidaDTO(user.getName(), user.getPassword(), user.getEmail())).collect(Collectors.toList());
        return userSaida;
    }
}

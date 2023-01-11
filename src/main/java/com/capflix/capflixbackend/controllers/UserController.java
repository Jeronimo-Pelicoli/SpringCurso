package com.capflix.capflixbackend.controllers;

import com.capflix.capflixbackend.dto.entradaDTO.UserEntradaDTO;
import com.capflix.capflixbackend.dto.saidaDTO.UserSaidaDTO;
import com.capflix.capflixbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getTeste() {
        return "Hello";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public UserSaidaDTO create(@Valid @RequestBody UserEntradaDTO userEntrada) {
        return userService.createUser(userEntrada);
    }


    @GetMapping("list")
    public List<UserSaidaDTO> ListAll() {
        return userService.listAll();
    }

}

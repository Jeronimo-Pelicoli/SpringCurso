package com.capflix.capflixbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/movies")
public class UserController {

    @GetMapping
    public String getTeste() {
        return "Hello";
    }

}

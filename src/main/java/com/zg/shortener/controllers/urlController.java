package com.zg.shortener.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.zg.shortener.utils.generateRandomUrl.generateRandomUrl;

@RestController
public class urlController {

    @GetMapping
    public String teste() {
        return "teste";
    }

    @PostMapping
    public StringBuilder shortUrl() {
        StringBuilder randomUrl = generateRandomUrl();
        return randomUrl;
    }
}

package com.zg.shortener.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class urlController {

    @GetMapping
    public String teste() {
        return "teste";
    }

    @PostMapping
    public StringBuilder shortUrl() {
        StringBuilder url = new StringBuilder();
        String possibleCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int index = 0; index < 5; index += 1) {
            url.append(possibleCharacters.charAt((int) Math.floor(Math.random() * possibleCharacters.length())));
        }
        return url;
    }
}

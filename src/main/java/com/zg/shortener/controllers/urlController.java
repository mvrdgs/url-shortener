package com.zg.shortener.controllers;

import com.zg.shortener.model.entities.ShortUrl;
import com.zg.shortener.model.entities.Url;
import org.springframework.web.bind.annotation.*;

import static com.zg.shortener.utils.generateRandomUrl.generateRandomUrl;

@RestController
public class urlController {

    @GetMapping
    public String teste() {
        return "teste";
    }

    @PostMapping
    @ResponseBody
    public ShortUrl create(@RequestBody Url url) {
        String randomUrl = generateRandomUrl();

        System.out.println(url.getUrl());

        ShortUrl newUrl = new ShortUrl(url.getUrl(), randomUrl);

        return newUrl;
    }
}

package com.zg.shortener.controllers;

import com.zg.shortener.model.entities.ShortUrl;
import com.zg.shortener.model.entities.Url;
import com.zg.shortener.model.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.zg.shortener.utils.generateRandomUrl.generateRandomUrl;

@RestController
public class urlController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping
    public String teste() {
        return "teste";
    }

    @PostMapping
    @ResponseBody
    public ShortUrl create(@RequestBody Url url) {
        String randomUrl = generateRandomUrl();

        ShortUrl newUrl = new ShortUrl(url.getUrl(), randomUrl);
        urlRepository.save(newUrl);

        return newUrl;
    }
}

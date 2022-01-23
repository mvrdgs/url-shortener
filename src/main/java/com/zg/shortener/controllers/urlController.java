package com.zg.shortener.controllers;

import com.zg.shortener.model.entities.ShortUrl;
import com.zg.shortener.model.entities.Url;
import com.zg.shortener.model.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.zg.shortener.utils.generateRandomUrl.generateRandomUrl;

@RestController
public class urlController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping(path="/{url}")
    public Optional<ShortUrl> getUrl(@PathVariable String url) {

        Optional<ShortUrl> urlFound = urlRepository.findByShortUrl(url);
        urlFound.get().increaseCount();
        urlRepository.save(urlFound.get());

        return urlFound;
    }

    @PostMapping
    @ResponseBody
    public ShortUrl create(@RequestBody Url url) {
        String randomUrl = generateRandomUrl();

        boolean urlExists = true;

        while (urlExists) {
            Optional<ShortUrl> urlFound = urlRepository.findByShortUrl(randomUrl);

            if (urlFound.isPresent()) {
                continue;
            }

            urlExists = false;
        }

        ShortUrl newUrl = new ShortUrl(url.getUrl(), randomUrl);
        urlRepository.save(newUrl);

        return newUrl;
    }
}

package com.zg.shortener.model.repositories;

import com.zg.shortener.model.entities.ShortUrl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<ShortUrl, Integer> {

    public Optional<ShortUrl> findByShortUrl(String url);
}

package com.zg.shortener.model.repositories;

import com.zg.shortener.model.entities.ShortUrl;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<ShortUrl, Integer> {


}

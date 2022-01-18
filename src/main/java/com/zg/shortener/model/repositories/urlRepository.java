package com.zg.shortener.model.repositories;

import com.zg.shortener.model.entities.shortUrl;
import org.springframework.data.repository.CrudRepository;

public interface urlRepository extends CrudRepository<shortUrl, Integer> {


}

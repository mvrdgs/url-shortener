package com.zg.shortener.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String url;

    @NotNull
    @Column(unique = true)
    private String shortUrl;

    private int clicks;

    public ShortUrl(){}

    public ShortUrl(String url, String shortUrl) {
        this.id = id;
        this.url = url;
        this.shortUrl = shortUrl;
        this.clicks = 0;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getClicks() {
        return clicks;
    }

    public void increaseCount() {
        this.clicks += 1;
    }
}

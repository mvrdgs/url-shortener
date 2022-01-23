package com.zg.shortener.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

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

    public ShortUrl(String url, String shortUrl) {
        this.id = id;
        this.url = url;
        this.shortUrl = shortUrl;
        this.clicks = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }
}

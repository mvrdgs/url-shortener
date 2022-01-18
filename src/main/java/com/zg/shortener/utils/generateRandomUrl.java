package com.zg.shortener.utils;

public class generateRandomUrl {
    public static StringBuilder generateRandomUrl() {
        StringBuilder url = new StringBuilder();
        String possibleCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int index = 0; index < 5; index += 1) {
            url.append(possibleCharacters.charAt((int) Math.floor(Math.random() * possibleCharacters.length())));
        }

        return url;
    }
}

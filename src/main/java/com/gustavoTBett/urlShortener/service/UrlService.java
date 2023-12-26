package com.gustavoTBett.urlShortener.service;

import com.gustavoTBett.urlShortener.dto.UrlDtoInsert;
import com.gustavoTBett.urlShortener.model.UrlDto;
import com.gustavoTBett.urlShortener.repository.UrlRepository;
import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gustavo
 */
@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public UrlDto save(UrlDtoInsert urlDtoInsert) {
        UrlDto urlDto = urlRepository.findByUrlOriginal(urlDtoInsert.getUrl());
        if (urlDto != null) {
            urlDto.setUrlEncurtada(getSaltString());
            urlDto = urlRepository.save(urlDto);
            return urlDto;

        } else {
            urlDto = new UrlDto();
            urlDto.setUrlOriginal(urlDtoInsert.getUrl());
            urlDto.setUrlEncurtada(getSaltString());

            urlDto = urlRepository.save(urlDto);
            return urlDto;
        }
    }

    public Boolean isValid(UrlDto urlDto) {
        if (urlDto.getUpdatedAt() != null) {
            if (urlDto.getUpdatedAt().plusDays(1).isAfter(LocalDateTime.now())) {
                return true;
            } else {
                return false;
            }
        } else {
            if (urlDto.getCreatedAt().plusDays(1).isAfter(LocalDateTime.now())) {
                return true;
            } else {
                return false;
            }
        }
    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}

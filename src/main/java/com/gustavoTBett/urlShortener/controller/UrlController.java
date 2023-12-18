package com.gustavoTBett.urlShortener.controller;

import com.gustavoTBett.urlShortener.dto.UrlDtoInsert;
import com.gustavoTBett.urlShortener.dto.UrlDtoResponse;
import com.gustavoTBett.urlShortener.model.UrlDto;
import com.gustavoTBett.urlShortener.repository.UrlRepository;
import com.gustavoTBett.urlShortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author gustavo
 */
@RestController
@RequestMapping("shorten-url")
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity create(@RequestBody UrlDtoInsert urlDtoInsert) {
        UrlDto urlDto = urlRepository.findByUrlOriginal(urlDtoInsert.getUrl());
        urlDto = urlService.save(urlDtoInsert);
        return ResponseEntity.ok(new UrlDtoResponse(urlDto));
    }

    @GetMapping("/{urlEncurtada}")
    public ModelAndView get(@PathVariable("urlEncurtada") String urlEncurtada) {
        UrlDto urlDto = urlRepository.findByUrlEncurtada(urlEncurtada);
        if (urlService.isValid(urlDto)) {
            if (urlDto != null) {
                RedirectView redirectView = new RedirectView(urlDto.getUrlOriginal());
                return new ModelAndView(redirectView);
            } else {
                return new ModelAndView("forward:/url-nao-encontrada");
            }
        } else {
            return new ModelAndView("forward:/url-nao-encontrada");
        }
    }

    @GetMapping("/url-passou-validade")
    public ResponseEntity<String> urlPassouValidade() {
        return ResponseEntity.status(400).body("Url não está mais valida, atualize a url encurtada utilizando o mesmo metódo de criar um url");
    }

    @GetMapping("/url-nao-encontrada")
    public ResponseEntity<String> urlNaoEncontrada() {
        return ResponseEntity.status(404).body("Url não cadastrada.");
    }
}

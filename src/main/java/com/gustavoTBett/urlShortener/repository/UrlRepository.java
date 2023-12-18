package com.gustavoTBett.urlShortener.repository;

import com.gustavoTBett.urlShortener.model.UrlDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gustavo
 */
@Repository
public interface UrlRepository extends JpaRepository<UrlDto, Long> {
    UrlDto findByUrlOriginal(String urlOriginal);
    
    UrlDto findByUrlEncurtada(String urlEncurtada);
}

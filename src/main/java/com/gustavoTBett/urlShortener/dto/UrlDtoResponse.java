package com.gustavoTBett.urlShortener.dto;

import com.gustavoTBett.urlShortener.model.UrlDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gustavo
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UrlDtoResponse {
    private String url;
    
    public UrlDtoResponse(UrlDto urlDto) {
        url = urlDto.getUrlEncurtada();
    }
}

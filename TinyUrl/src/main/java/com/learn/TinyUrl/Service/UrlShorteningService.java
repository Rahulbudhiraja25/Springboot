package com.learn.TinyUrl.Service;

import com.learn.TinyUrl.Entity.Url;
import com.learn.TinyUrl.Repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//public class UrlShorteningService {
//
//    @Autowired
//    private UrlRepository urlRepository;
//
//    public String shortenUrl(String originalUrl) {
//        // Generate a short key (you can use any approach)
//        String shortKey = generateShortKey(); // Implement this method
//
//        Url url = new Url();
//        url.setOriginalUrl(originalUrl);
//        url.setShortUrl(shortKey);
//
//        urlRepository.save(url);
//        return shortKey;
//    }
//
//    public String getOriginalUrl(String shortUrl) {
//        return urlRepository.findByShortUrl(shortUrl)
//                .map(Url::getOriginalUrl)
//                .orElseThrow(() -> new RuntimeException("URL not found!"));
//    }
//
//    private String generateShortKey() {
//        // You can generate short key using Base62 encoding or a similar method
//        return RandomStringUtils.randomAlphanumeric(6); // 6 characters long
//    }
//}
@Service
public class UrlShorteningService {

    @Autowired
    private UrlRepository urlRepository;
    public String shortenUrl(String originalUrl) {
        // Generate a short key (you can use any approach)
        String shortKey = generateShortKey(); // Implement this method

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortKey);

        urlRepository.save(url);
        return shortKey;
    }

    public String getOriginalUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found!"));
    }

    private String generateShortKey() {
        // You can generate short key using Base62 encoding or a similar method
        return RandomStringUtils.randomAlphanumeric(6); // 6 characters long
    }
}
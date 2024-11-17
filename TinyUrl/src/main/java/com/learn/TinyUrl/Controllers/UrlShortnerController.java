package com.learn.TinyUrl.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.learn.TinyUrl.Service.UrlShorteningService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/api")
public class UrlShortnerController {

    @Autowired
    private UrlShorteningService urlShorteningService;
@PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody JsonNode requestBody) {
        String shortUrl = urlShorteningService.shortenUrl(requestBody.get("originalUrl").asText());
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String originalUrl = urlShorteningService.getOriginalUrl(shortUrl);
        response.sendRedirect(originalUrl); // Redirecting to original URL xxx
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }

}

package io.cna.acme.stocksapi;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AcmeService {

    private static final String URI_TEMPLATE = UriComponentsBuilder.fromUriString("//stocks-service/recommendation")
            .build()
            .toUriString();

    private final RestTemplate rest;

    public AcmeService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public String recommend() {
        return rest.getForObject(URI_TEMPLATE, String.class);
    }
}

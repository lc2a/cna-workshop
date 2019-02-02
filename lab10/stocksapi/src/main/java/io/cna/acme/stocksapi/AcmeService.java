package io.cna.acme.stocksapi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "backupRecommend")
    public String recommend() {
        return rest.getForObject(URI_TEMPLATE, String.class);
    }

    public String backupRecommend() {
        return "\nRecommendation engine is moentarily down. \nBut we got your back!! \nInvest in PVTL";
    }
}

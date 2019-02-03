package io.cna.acme.stocksapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AcmeController {
    private static Logger log = LoggerFactory.getLogger(AcmeController.class);

    @Value(value = "${stocksapi.banner}")
    private String banner;


    private final RestTemplate restTemplate;
    public AcmeController(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    @GetMapping("/service/greet/{name}")
    public String sayHello(@PathVariable String name) {
        return String.format("Hello %s! \n %s \n", name, banner);
    }

    @GetMapping("/service/quote")
    public String getQuote() {
        String stock = restTemplate.getForObject("http://stocks-service.apps.dalycity.cf-app.com/recommendation",
                String.class);
        return String.format("Today's top stock: %s", stock);
    }

    @GetMapping("/kill-ai")
    public void die()
    {
        log.error("Bye bye AI, RIP!!");
        System.exit(-1);
    }
}

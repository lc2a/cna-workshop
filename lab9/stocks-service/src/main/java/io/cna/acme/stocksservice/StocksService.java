package io.cna.acme.stocksservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

@RestController
public class StocksService {

    private final StockRepository sRepo;

    private Logger log = LoggerFactory.getLogger(StocksService.class);

    @Autowired
    public StocksService(StockRepository sRepo) {
        this.sRepo = sRepo;
    }

    @GetMapping("/recommendation")
    public String getRecommendation() {
        System.out.println("Generating recommendation");
        return sRepo.findRandomStock().toString();
    }
}



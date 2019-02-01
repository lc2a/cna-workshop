package io.cna.acme.stocksservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class StocksServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StocksServiceApplication.class, args);
    }

}

@Component
class SampleDataCLR implements CommandLineRunner {

    private final StockRepository sRepo;

    @Autowired
    public SampleDataCLR(StockRepository sRepo) {
        this.sRepo = sRepo;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("PVTL", "AAPL", "MSFT", "GOOG")
                .forEach(n -> sRepo.save(new Stock(n)));
        sRepo.findAll().forEach(System.out::println);
    }
}


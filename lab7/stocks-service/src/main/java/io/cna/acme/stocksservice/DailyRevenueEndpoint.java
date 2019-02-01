package io.cna.acme.stocksservice;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "daily-revenue")
public class DailyRevenueEndpoint {
    @ReadOperation
    public double getRevenue() {
        return 34300;
    }
}

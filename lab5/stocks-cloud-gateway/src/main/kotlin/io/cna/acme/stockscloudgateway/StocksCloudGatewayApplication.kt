package io.cna.acme.stockscloudgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StocksCloudGatewayApplication

fun main(args: Array<String>) {
    runApplication<StocksCloudGatewayApplication>(*args)
}


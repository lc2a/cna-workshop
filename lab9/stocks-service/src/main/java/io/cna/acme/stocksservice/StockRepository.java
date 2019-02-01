package io.cna.acme.stocksservice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
    public Stock findBySymbol(String symbol);

    // This query is not efficient, but ok for such s small DB
    @Query(value="SELECT * FROM Stock ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Stock findRandomStock();

}

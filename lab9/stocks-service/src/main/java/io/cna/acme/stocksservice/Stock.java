package io.cna.acme.stocksservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue
    private long id;

    private String symbol;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.format("%s", symbol);
    }
}

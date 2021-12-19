package com.suda.stock.app.repository;

import com.suda.stock.app.domain.Stock;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class MockStockRepository implements StockRepository {

    private Stock.StockBuilder stockBuilder;

    public MockStockRepository() {
        this.stockBuilder = Stock.builder().quantity(10);
    }

    @Override
    public Flux<Stock> findAll(){
        return Flux.fromIterable(
                Arrays.asList(stockBuilder
                                .id("1")
                                .company("Apple")
                                .price(1000.00)
                                .build(),
                        stockBuilder
                                .id("2")
                                .company("Facebook")
                                .price(900.00)
                                .build()));
    }

}

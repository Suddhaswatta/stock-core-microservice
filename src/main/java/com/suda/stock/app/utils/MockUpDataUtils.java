package com.suda.stock.app.utils;

import com.suda.stock.app.domain.Stock;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class MockUpDataUtils {

    private static final Stock.StockBuilder stockBuilder
            = Stock
            .builder()
            .currencyCode("USD")
            .quantity(10);

    public static Flux<Stock> stocksMockUpData() {
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

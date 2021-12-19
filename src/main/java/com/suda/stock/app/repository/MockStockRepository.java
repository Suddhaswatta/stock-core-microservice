package com.suda.stock.app.repository;

import com.suda.stock.app.domain.Stock;
import com.suda.stock.app.utils.MockUpDataUtils;
import reactor.core.publisher.Flux;

public class MockStockRepository implements StockRepository {

    private final Stock.StockBuilder stockBuilder;

    public MockStockRepository() {
        this.stockBuilder = Stock.builder().quantity(10);
    }

    @Override
    public Flux<Stock> findAll() {
        return MockUpDataUtils.stocksMockUpData();
    }

}

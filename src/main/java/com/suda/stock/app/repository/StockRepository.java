package com.suda.stock.app.repository;

import com.suda.stock.app.domain.Stock;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface StockRepository {

    Flux<Stock> findAll();
}

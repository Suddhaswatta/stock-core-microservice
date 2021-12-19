package com.suda.stock.app.service;

import com.suda.stock.app.dto.StockDTO;
import reactor.core.publisher.Flux;

public interface StockService {

    Flux<StockDTO> getStocksEvent();
}

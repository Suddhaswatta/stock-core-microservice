package com.suda.stock.app.controller;

import com.suda.stock.app.dto.StockDTO;
import com.suda.stock.app.service.StockService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/${api.version}/${api.name}")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "/${api.uri}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StockDTO> getStocks() {
        return stockService.getStocksEvent();
    }
}

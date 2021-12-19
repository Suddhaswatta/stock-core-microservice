package com.suda.stock.app.controller;

import com.suda.stock.app.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/${api.version}/${api.name}")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "/${api.uri}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<?> getStocks() {

        return new ResponseEntity<>(
                stockService
                .getStocksEvent()
                        .delayElements(Duration.ofSeconds(1)
                        ),
                HttpStatus.OK);
    }
}

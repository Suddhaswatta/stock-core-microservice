package com.suda.stock.app.service;

import com.suda.stock.app.domain.Stock;
import com.suda.stock.app.dto.StockDTO;
import com.suda.stock.app.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StocksServiceImplTest {

    Stock.StockBuilder stockBuilder;

    StockDTO.StockDTOBuilder stockDTOBuilder;

    @Mock
    private StockRepository stockRepository;

    private StockService stocksService;

    @BeforeEach
    void setUp() {
        stockBuilder = Stock.builder().quantity(10);

        stockDTOBuilder = StockDTO.builder();
        stocksService = new StocksServiceImpl(stockRepository);
    }

    @Test
    void when_findAllStocks_then_return_allStocks() {
        when(stockRepository.findAll())
                .thenReturn(stocksMockUpData());
        StepVerifier
                .create(stocksService.getStocksEvent())
                .expectSubscription()
                .expectNext(
                        stockDTOBuilder
                                .stockName("Apple")
                                .price(1000.00).build()
                )
                .expectNext(
                        stockDTOBuilder
                                .stockName("Facebook")
                                .price(900.00).build()
                )
                .verifyComplete();

    }

    private Flux<Stock> stocksMockUpData() {
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
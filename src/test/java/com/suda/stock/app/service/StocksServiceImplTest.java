package com.suda.stock.app.service;

import com.suda.stock.app.domain.Stock;
import com.suda.stock.app.dto.StockDTO;
import com.suda.stock.app.repository.StockRepository;
import com.suda.stock.app.utils.MockUpDataUtils;
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


    StockDTO.StockDTOBuilder stockDTOBuilder;

    @Mock
    private StockRepository stockRepository;

    private StockService stocksService;

    @BeforeEach
    void setUp() {
        stockDTOBuilder = StockDTO.builder();
        stocksService = new StocksServiceImpl(stockRepository);
    }

    @Test
    void when_findAllStocks_then_return_allStocks() {
        when(stockRepository.findAll())
                .thenReturn(MockUpDataUtils.stocksMockUpData());
        StepVerifier
                .create(stocksService.getStocksEvent())
                .expectSubscription()
                .expectNext(
                        stockDTOBuilder
                                .stockName("Apple")
                                .price("1000.00 USD").build()
                )
                .expectNext(
                        stockDTOBuilder
                                .stockName("Facebook")
                                .price("900.00 USD").build()
                )
                .verifyComplete();

    }

}
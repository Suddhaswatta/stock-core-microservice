package com.suda.stock.app.utils;

import com.suda.stock.app.domain.Stock;
import com.suda.stock.app.dto.StockDTO;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

public class DTOUtils {
    public static Mono<StockDTO> responseDTO(Mono<Stock> stockMono) {
        return stockMono
                .map(stock -> StockDTO.builder()
                        .stockName(stock.getCompany())
                        .price(format("%.02f %s",stock.getPrice(),stock.getCurrencyCode()))
                        .build());
    }
}

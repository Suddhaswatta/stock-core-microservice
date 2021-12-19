package com.suda.stock.app.service;

import com.suda.stock.app.dto.StockDTO;
import com.suda.stock.app.repository.StockRepository;
import com.suda.stock.app.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service
public class StocksServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StocksServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Flux<StockDTO> getStocksEvent() {

        return stockRepository
                .findAll()
                .map(Mono::just)
                .flatMap(DTOUtils::responseDTO)
                .log();
    }
}

package com.suda.stock.app.config;

import com.suda.stock.app.repository.MockStockRepository;
import com.suda.stock.app.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class AppConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    @Lazy
    public StockRepository repo() {
        return new MockStockRepository();
    }

}

package com.suda.stock.app.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Stock {

    String id;
    String company;
    Integer quantity;
    Double price;

}

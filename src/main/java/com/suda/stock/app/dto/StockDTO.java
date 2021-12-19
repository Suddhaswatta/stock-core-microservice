package com.suda.stock.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDTO {

    @JsonProperty("stock-name")
    String stockName;
    @JsonProperty("stock-price")
    Double price;
    @JsonProperty("currency")
    String currencyCode;

}

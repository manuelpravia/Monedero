package com.nttdata.bank.infraestructure.data.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Data
@Document(collection = "monedero")
public class Monedero {

    @Id
    private String id;
    private String client;
    private BigDecimal amountBootCoin;
}

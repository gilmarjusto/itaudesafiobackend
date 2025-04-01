package com.itaudesafiobackend.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class TransactionDTO {

    private double valor;
    private OffsetDateTime dataHora;

    public double getValor() {
        return this.valor;
    }

    public OffsetDateTime getDataHora() {
      return this.dataHora;
    }
}
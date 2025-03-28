package com.itaudesafiobackend.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class Transaction {

    private float valor;
    private OffsetDateTime dataHora;

    public Transaction() {
    }

    public Transaction(float valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

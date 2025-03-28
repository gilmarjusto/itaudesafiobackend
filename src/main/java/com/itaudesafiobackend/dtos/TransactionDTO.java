package com.itaudesafiobackend.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public record TransactionDTO(float valor, OffsetDateTime dataHora) {
}

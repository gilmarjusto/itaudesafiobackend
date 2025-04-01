package com.itaudesafiobackend.controllers;
import com.itaudesafiobackend.domain.Transaction;
import com.itaudesafiobackend.dtos.*;
import com.itaudesafiobackend.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Validated @RequestBody TransactionDTO transactionDTO) {
        if (TransactionService.validadeRequest(transactionDTO)){
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(transactionDTO.getValor(), transactionDTO.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build() ;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions() {
        this.transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}

package com.itaudesafiobackend.controllers;

import com.itaudesafiobackend.dtos.TransactionDTO;
import com.itaudesafiobackend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping
    public String createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        transactionService.createTransaction(transactionDTO);
        return "Transação Criada com sucesso!";
    }
}

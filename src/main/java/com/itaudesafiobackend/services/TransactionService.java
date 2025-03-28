package com.itaudesafiobackend.services;

import com.itaudesafiobackend.domain.Transaction;
import com.itaudesafiobackend.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransactionService {

    public int createTransaction(TransactionDTO transactionDTO) throws Exception {
        float valor = transactionDTO.valor();

        OffsetDateTime dataHora = transactionDTO.dataHora();

        if(dataHora.isAfter(OffsetDateTime.now())){
            throw new Exception("Data e Hora não pode estar no futuro");
        }

        if(valor < 0){
            throw new Exception("Valor negativo não é permitido");
        }
        System.out.println("dataHora: " + dataHora.toString());

        Transaction transaction = new Transaction();
        transaction.setValor(transactionDTO.valor());
        transaction.setDataHora(transactionDTO.dataHora());

        return 201;
    }
}

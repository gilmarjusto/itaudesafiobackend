package com.itaudesafiobackend.services;

import com.itaudesafiobackend.domain.Transaction;
import com.itaudesafiobackend.dtos.TransactionDTO;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();

    public static boolean validadeRequest(TransactionDTO transactionDTO) {

        if(transactionDTO.getDataHora().isAfter(OffsetDateTime.now())){
            return true;
        }

        if(transactionDTO.getValor() <= 0x0.0p0) {
            return true;
        }
    return false;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();

        return transactions.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }


    /*
    public int createTransaction(TransactionDTO transactionDTO) throws Exception {
        float valor = transactionDTO.valor();
        OffsetDateTime dataHora = transactionDTO.dataHora();

        System.out.println("dataHora: " + dataHora.toString());
        System.out.println("valor: " + valor);

        String dataHoraValida = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{2}";
                                 //"2007-12-03T10:15:30+01:00"
        String dataHoraTxt = dataHoraValida.toString();
        if (!dataHoraTxt.matches(dataHoraValida)){
            throw new Exception("Data e Hora inválida");
        }

        if(dataHora.isAfter(OffsetDateTime.now())){
            throw new Exception("Data e Hora não pode estar no futuro");
        }

        if(valor < 0){
            throw new Exception("Valor negativo não é permitido");
        }

        Transaction transaction = new Transaction();
        transaction.setValor(valor);
        transaction.setDataHora(dataHora);

        return 201;
    }
    */

}

package com.n26.main.controller;

import com.n26.main.domain.Statistics;
import com.n26.main.domain.Transaction;
import com.n26.main.service.TransactionCreationAsyncService;
import com.n26.main.service.TransactionStatisticsAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by SAMPATH on 4/22/2017.
 */

@RestController
public class TransactionAsyncController {

    @Autowired
    public TransactionStatisticsAsyncService trasactionAsyncService;

    @Autowired
    public TransactionCreationAsyncService transactionCreationAsyncService;

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @ResponseBody
    public void getTransactions(@RequestBody Transaction transaction, HttpServletResponse response) {
        transactionCreationAsyncService.saveTransaction(transaction);
        response.setStatus(HttpStatus.CREATED.value());
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity> getTransactionsSummary() throws InterruptedException, ExecutionException {
        CompletableFuture<ResponseEntity> statisticsResponseEntity =
                trasactionAsyncService.getTransactionSummary().thenApply(statistics -> new ResponseEntity<Statistics>(statistics, HttpStatus.OK));
        return statisticsResponseEntity;
    }

}

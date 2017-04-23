package com.n26.main.service;

import com.n26.main.domain.Statistics;
import com.n26.main.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

/**
 * Created by SAMPATH on 4/22/2017.
 * Get the last 60 seconds transaction summary
 */

@Service
public class TransactionStatisticsAsyncService {

    @Autowired
    private TaskExecutor transactionExecutor;

    @Async
    public CompletableFuture<Statistics> getTransactionSummary() {
        return CompletableFuture.supplyAsync(() -> {
            Transaction t = TransactionCollector.transactions.first();
            if (t.getTimestamp() < (Instant.now().getEpochSecond() * 1000) - 60000)
                return new Statistics();
            else
                return TransactionCollector.transactions.first().getStatistics();
        }, transactionExecutor);
    }

}

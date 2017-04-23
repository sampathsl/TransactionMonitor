package com.n26.main.service;

import com.n26.main.domain.Statistics;
import com.n26.main.domain.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SAMPATH on 4/23/2017.
 * Create and update the transactions and their summary statistics
 */
@Service
public class TransactionCreationAsyncService {

    /**
     * Add the transaction to the collection and update the transaction statistics
     * for any transaction time stamp overlap
     * @param transaction
     * @return
     */
    @Async
    public HttpStatus saveTransaction(Transaction transaction) {
        try {

            TransactionCollector.transactions.add(transaction);
            TransactionCollector.transactions.parallelStream()
                    .filter(t2 -> t2.getTimestamp() >= transaction.getTimestamp())
                    .collect(Collectors.groupingBy(Transaction::getTimestamp))
                    .forEach(
                            (timestamp, transactions) -> this.updateTransactions(transactions)
                    );
            return HttpStatus.CREATED;

        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * Calculate the summary statistics for give transaction list
     * @param Transactions
     */
    private void updateTransactions(List<Transaction> Transactions) {
        DoubleSummaryStatistics stats = TransactionCollector.transactions.parallelStream()
                .filter(t -> t.getTimestamp() >= (Instant.now().getEpochSecond() * 1000) - 60000)
                .collect(Collectors.summarizingDouble(Transaction::getAmount));
        Transactions.forEach(e -> this.updateStatistics(e, stats));
    }

    /**
     * Update the transaction statistics in the transaction object
     * @param transaction
     * @param stats
     */
    private void updateStatistics(Transaction transaction, DoubleSummaryStatistics stats) {
        transaction.setStatistics(new Statistics(stats.getSum(), stats.getAverage(), stats.getMax(), stats.getMin(), stats.getCount()));
    }

}

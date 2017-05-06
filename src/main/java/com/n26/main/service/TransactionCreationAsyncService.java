package com.n26.main.service;

import com.n26.main.domain.Statistics;
import com.n26.main.domain.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.DoubleSummaryStatistics;
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

            /**
             * For Testing
             */
            /*getSampleOldTransactions().forEach(t1 -> {
                try {

                    Thread.sleep(500);
                    TransactionCollector.transactions.put(t1,new Statistics(0,0,
                            0,0,0));

                    TransactionCollector.transactions.entrySet().parallelStream()
                            .filter(t2 -> t2.getKey().getTimestamp() >= transaction.getTimestamp())
                            .forEach(
                                    t3 -> {

                                        DoubleSummaryStatistics stats = TransactionCollector.transactions.entrySet().parallelStream()
                                                .filter(t -> t.getKey().getTimestamp() >= (Instant.now().getEpochSecond() * 1000) - 60000)
                                                .collect(Collectors.summarizingDouble(e -> e.getKey().getAmount()));

                                        TransactionCollector.transactions.put(t3.getKey(),new Statistics(stats.getSum(),stats.getAverage(),
                                                stats.getMax(),stats.getMin(),stats.getCount()));

                                    }
                            );

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });*/

            TransactionCollector.transactions.put(transaction,new Statistics(0,0,
                    0,0,0));

            TransactionCollector.transactions.entrySet().parallelStream()
                    .filter(t2 -> t2.getKey().getTimestamp() >= transaction.getTimestamp())
                    .forEach(
                            t3 -> {

                                DoubleSummaryStatistics stats = TransactionCollector.transactions.entrySet().parallelStream()
                                        .filter(t -> t.getKey().getTimestamp() >= (Instant.now().getEpochSecond() * 1000) - 60000)
                                        .collect(Collectors.summarizingDouble(e -> e.getKey().getAmount()));

                                TransactionCollector.transactions.put(t3.getKey(),new Statistics(stats.getSum(),stats.getAverage(),
                                        stats.getMax(),stats.getMin(),stats.getCount()));

                            }
                    );

            return HttpStatus.CREATED;

        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * For Testing
     */
    /*private List<Transaction> getSampleOldTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        IntStream.range(0, 100).forEach(e -> {
            transactions.add(new Transaction(50,(Instant.now().getEpochSecond() * 1000 - (30000 + e)) ));
        });
        return transactions;
    }*/

}

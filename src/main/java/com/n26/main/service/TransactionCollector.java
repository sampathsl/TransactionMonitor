package com.n26.main.service;

import com.n26.main.domain.Transaction;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by SAMPATH on 4/23/2017.
 */
public final class TransactionCollector {

    static volatile ConcurrentSkipListSet<Transaction> transactions = new ConcurrentSkipListSet<>();

    static {
        transactions.add(new Transaction(0, 0));
    }

}

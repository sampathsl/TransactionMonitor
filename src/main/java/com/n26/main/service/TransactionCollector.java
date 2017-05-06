package com.n26.main.service;

import com.n26.main.domain.Statistics;
import com.n26.main.domain.Transaction;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by SAMPATH on 4/23/2017.
 */
public final class TransactionCollector {

    static volatile ConcurrentSkipListMap<Transaction,Statistics> transactions = new ConcurrentSkipListMap<>();

}

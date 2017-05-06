package com.n26.main.domain;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by SAMPATH on 4/22/2017.
 */

public final class Transaction implements Comparable<Transaction> , Comparator<Transaction> {

    final static AtomicLong NEXT_ID = new AtomicLong(1);
    private final long id = NEXT_ID.getAndIncrement();

	private final long timestamp;
	private final double amount;

    public Transaction() {
        this.timestamp = 0;
        this.amount = 0;
    }

    public Transaction(double amount,long timestamp) {
        this.timestamp = timestamp;
        this.amount = amount;
    }

	public long getTimestamp() {
		return timestamp;
	}

	public double getAmount() {
		return amount;
	}


    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction transaction = (Transaction) obj;
        if (id != transaction.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int compareTo(Transaction o) {
        return (this.id > o.id ) ? -1: (this.id < o.id ) ? 1 : 0 ;
    }

    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.getId() == o2.getId() ? 0 : 1;
    }

}

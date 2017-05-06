package com.n26.main.domain;

/**
 * Created by SAMPATH on 5/4/2017.
 */
public final class TransactionStatistics  implements Comparable<TransactionStatistics> {

    private final Transaction transaction;
    private final Statistics statistics;

    public TransactionStatistics(Transaction transaction, Statistics statistics) {
        this.transaction = transaction;
        this.statistics = statistics;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionStatistics that = (TransactionStatistics) o;

        if (transaction != null ? !transaction.equals(that.transaction) : that.transaction != null) return false;
        return statistics != null ? statistics.equals(that.statistics) : that.statistics == null;
    }

    @Override
    public int hashCode() {
        int result = transaction != null ? transaction.hashCode() : 0;
        result = 31 * result + (statistics != null ? statistics.hashCode() : 0);
        return result;
    }

    /**
     * Keep descending order to get the latest com.n26.main.domain
     */

    @Override
    public int compareTo(TransactionStatistics o) {
        return -1 ;
    }

    @Override
    public String toString() {
        return "TransactionStatistics{" +
                "transaction=" + transaction +
                ", statistics=" + statistics +
                '}';
    }
}

package com.n26.main.domain;

/**
 * Created by SAMPATH on 4/22/2017.
 */

public class Transaction implements Comparable<Transaction> {

	private long timestamp;
	private double amount;
	private Statistics statistics = new Statistics();

	public Transaction(){super();}

	public Transaction(double amount,long timestamp) {
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	/**
	 * Keep descending order to get the latest com.n26.main.domain
	 */
	@Override
	public int compareTo(Transaction o) {
		return -1;
	}

}

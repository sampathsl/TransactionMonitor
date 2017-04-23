package com.n26.main.domain;

/**
 * Created by SAMPATH on 4/22/2017.
 */
public class Statistics {

    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public Statistics(){super();}

    public Statistics(double sum, double avg, double max, double min , long count) {
        super();
        this.setSum(sum);
        this.setAvg(avg);
        this.setMax(max);
        this.setMin(min);
        this.setCount(count);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMax() {
        return max == Double.POSITIVE_INFINITY || max == Double.NEGATIVE_INFINITY ? 0 : max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min == Double.NEGATIVE_INFINITY || min == Double.POSITIVE_INFINITY ? 0 : min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}

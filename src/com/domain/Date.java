package com.domain;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(Date other) {
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }

    // GETTER AND SETTER
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + " " + month + " " + day;
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year)
            return this.year - other.year;
        else if (this.month != other.month)
            return this.month - other.month;
        else return this.day - other.day;
    }
}

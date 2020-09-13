package by.jis4.komarov.bean;

import java.util.Objects;

public class CreditCard {
    private long number;
    private int pin;
    private double balance;
    private double crLimit;
    private double indebtedness;

    public CreditCard() {
    }

    public CreditCard(long number, int pin) {
        this.number = number;
        this.pin = pin;
        this.balance = 0;
        this.crLimit = 0;
        this.indebtedness = 0;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCrLimit() {
        return crLimit;
    }

    public void setCrLimit(double crLimit) {
        this.crLimit = crLimit;
    }

    public double getIndebtedness() {
        return indebtedness;
    }

    public void setIndebtedness(double indebtedness) {
        this.indebtedness = indebtedness;
    }
}

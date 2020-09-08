package BankingExample.model;

import javax.persistence.*;

@Table(name = "creditCard")
@Entity
public class CreditCard {
    @Id
    private int number;
    private int limit;
    private int balance;
    private PinCode pinCode;
    private Bank bank;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public PinCode getPinCode() {
        return pinCode;
    }

    public void setPinCode(PinCode pinCode) {
        this.pinCode = pinCode;
    }

    @ManyToOne
    @JoinColumn(name = "bank_fk")
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}

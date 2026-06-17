package entities;

import java.time.LocalDate;
import james_app.*;

public class Transaction {
    private Account account;
    private double amount;
    private final LocalDate created;
    private static int NEXT_ID = 1;
    private final int transactionID;
    private TransactionType type;

    public Transaction(Account account, TransactionType type, double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.created = LocalDate.now();// aktuelles Datum speichern
        this.transactionID = NEXT_ID;        // ID vergeben und Zähler erhöhen
        NEXT_ID++;
    }

    public Account getAccount() {
        return account;
    }

    public int compareTo(Transaction o) {
        // Vergleicht das Erstellungsdatum dieser Transaktion mit einer anderen
        return this.created.compareTo(o.created);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", accountID=" + account.getId() +
                ", type=" + type +
                ", amount=" + amount +
                ", created=" + created +
                '}';
    }

    public TransactionType getType() {
        return type;
    }

    public String transactionsDetails() {
        return "Transaction ID: " + transactionID +
                ", Account ID: " + account.getId() +
                ", Type: " + type +
                ", Amount: " + amount +
                ", Date: " + created;
    }
}


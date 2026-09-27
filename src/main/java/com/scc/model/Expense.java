package com.scc.model;

public class Expense {
    private String description;
    private double amount;
    private String loggedBy;

    public Expense(String description, double amount, String loggedBy) {
        this.description = description;
        this.amount = amount;
        this.loggedBy = loggedBy;
    }

    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getLoggedBy() { return loggedBy; }
}
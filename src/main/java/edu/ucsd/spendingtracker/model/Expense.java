package edu.ucsd.spendingtracker.model;

public class Expense {
    private String name;
    private Category category;
    private double amount;

    public Expense(String name, Category category, double amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}

package edu.ucsd.spendingtracker.datasource;

import java.util.ArrayList;
import java.util.List;

import edu.ucsd.spendingtracker.model.Category;
import edu.ucsd.spendingtracker.model.Expense;

public class InMemoryDataSource {
    private List<Expense> expenses = new ArrayList<>();
    
    public InMemoryDataSource() {
    }

    public List<Expense> getExpenses() {
        return List.copyOf(expenses);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
    
    public final static List<Expense> DEFAULT_EXPENSES = List.of(
        new Expense("Groceries", Category.FOOD, 101.75),
        new Expense("Utilities", Category.UTILITIES, 80.50),
        new Expense("Gas", Category.TRANSPORT, 60.00),
        new Expense("Movie Tickets", Category.ENTERTAINMENT, 30.00),
        new Expense("Online Order", Category.OTHER, 45.25));

    public static InMemoryDataSource getDefaultDataSource() {
        InMemoryDataSource dataSource = new InMemoryDataSource();
        dataSource.expenses.addAll(DEFAULT_EXPENSES);
        return dataSource;
    }
}

package edu.ucsd.spendingtracker.repository;


import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Category;
import edu.ucsd.spendingtracker.model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExpenseRepositoryTest {


    private ExpenseRepository repository;
    private InMemoryDataSource dataSource;


    @BeforeEach
    void setUp() {
        dataSource = new InMemoryDataSource();
        repository = new ExpenseRepository(dataSource);
    }


    @Test
    @DisplayName("Test that getTotal() correctly sums multiple expenses")
    void testGetTotalCalculatesCorrectSum() {
        repository.addExpense(new Expense("Coffee", Category.FOOD, 5.50));
        repository.addExpense(new Expense("Uber", Category.TRANSPORT, 15.00));
        repository.addExpense(new Expense("Movie", Category.ENTERTAINMENT, 10.00));


        double total = repository.getTotal();


        assertEquals(40.50, total);
    }


    @Test
    @DisplayName("Test that getTotal() returns 0.0 when no expenses exist")
    void testGetTotalWithEmptyList() {
        assertEquals(1.0, repository.getTotal()+2);
    }
}

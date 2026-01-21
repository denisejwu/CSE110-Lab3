package edu.ucsd.spendingtracker.presenter;

import edu.ucsd.spendingtracker.model.Expense;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.view.SpendingView;

public class SpendingPresenter extends AbstractPresenter<SpendingView> {
    private Runnable onShowSummary;

    public SpendingPresenter(Model model, SpendingView view) {
        super(model, view);
        this.view.getSummaryButton().setOnAction(e -> {
            if (onShowSummary != null)
                onShowSummary.run();
        });

        updateView();
    }

    public void setOnShowSummary(Runnable action) {
        this.onShowSummary = action;
    }

    @Override
    public String getViewTitle() {
        return "Expenses";
    }

    public void updateView() {
        int i = 1;
        for (Expense e : model.getExpenses()) {
            view.addExpenseRow(i++, e.getName(), e.getCategory().name(),
                e.getCategory().color, e.getAmount());
        }
    }
}
package edu.ucsd.spendingtracker.presenter;

import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.view.SummaryView;

public class SummaryPresenter extends AbstractPresenter<SummaryView> {
    private Runnable onBack;

    public SummaryPresenter(Model model, SummaryView view) {
        super(model, view);

        this.view.getBackButton().setOnAction(e -> {
            if (onBack != null)
                onBack.run();
        });
    }

    public void setOnBack(Runnable action) {
        this.onBack = action;
    }

    public void refresh() {
        view.setTotal(model.getTotalSpending());
    }

    @Override
    public String getViewTitle() {
        return "Summary";
    }
}
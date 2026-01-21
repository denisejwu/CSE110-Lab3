package edu.ucsd.spendingtracker.presenter;

import javafx.stage.Stage;

public class PresenterManager {
    public void defineInteractions(Stage stage, String appName,
        SpendingPresenter spendingPresenter,
        SummaryPresenter summaryPresenter) {

        PresenterSwitcher switcher = new PresenterSwitcher(stage, appName);

        spendingPresenter.setOnShowSummary(() -> {
            summaryPresenter.refresh();
            switcher.switchTo(summaryPresenter);
        });

        summaryPresenter.setOnBack(() -> {
            switcher.switchTo(spendingPresenter);
        });

        switcher.switchTo(spendingPresenter);
    }
}
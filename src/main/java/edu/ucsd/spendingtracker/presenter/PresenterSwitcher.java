package edu.ucsd.spendingtracker.presenter;

import javafx.stage.Stage;

public class PresenterSwitcher {
    private Stage stage;
    private String appName;

    public PresenterSwitcher(Stage stage, String appName) {
        this.stage = stage;
        this.appName = appName;
    }

    public void switchTo(AbstractPresenter presenter) {
        stage.setTitle(appName + ": " + presenter.getViewTitle());
        stage.setScene(presenter.getView());
        stage.show();
    }
}
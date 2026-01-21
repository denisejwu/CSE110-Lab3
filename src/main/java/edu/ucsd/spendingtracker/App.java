package edu.ucsd.spendingtracker;

import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.presenter.PresenterManager;
import edu.ucsd.spendingtracker.presenter.SpendingPresenter;
import edu.ucsd.spendingtracker.presenter.SummaryPresenter;
import edu.ucsd.spendingtracker.repository.ExpenseRepository;
import edu.ucsd.spendingtracker.view.SpendingView;
import edu.ucsd.spendingtracker.view.SummaryView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        InMemoryDataSource dataSource = InMemoryDataSource.getDefaultDataSource();
        ExpenseRepository repository = new ExpenseRepository(dataSource);

        Model sharedModel = new Model(repository);

        SpendingView spendingView = new SpendingView();
        SummaryView summaryView = new SummaryView();

        SpendingPresenter listPresenter = new SpendingPresenter(sharedModel, spendingView);
        SummaryPresenter summaryPresenter = new SummaryPresenter(sharedModel, summaryView);

        PresenterManager manager = new PresenterManager();
        manager.defineInteractions(primaryStage, "Spending Tracker", listPresenter, summaryPresenter);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

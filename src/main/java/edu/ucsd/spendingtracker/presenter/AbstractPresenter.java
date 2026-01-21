package edu.ucsd.spendingtracker.presenter;

import edu.ucsd.spendingtracker.model.Model;
import javafx.scene.Scene;
import javafx.scene.layout.Region;

public abstract class AbstractPresenter<V extends Region> {
    protected Model model;
    protected V view;
    protected Scene scene;

    public AbstractPresenter(Model model, V view) {
        this.model = model;
        this.view = view;
        this.scene = new Scene(view, 500, 600);
    }

    public abstract String getViewTitle();

    public Scene getView() {
        return this.scene;
    }
}
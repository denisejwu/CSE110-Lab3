package edu.ucsd.spendingtracker.view;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class SummaryView extends VBox {
    private Label totalLabel = new Label();
    private Button backButton = new Button("Back to Expenses");


    public SummaryView() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setStyle("-fx-background-color: #FFFFFF;");


        Label title = new Label("Total Spending");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        totalLabel.setStyle("-fx-font-size: 32px; -fx-text-fill: #2E7D32;");


        this.getChildren().addAll(title, totalLabel, backButton);
    }


    public void setTotal(double total) {
        totalLabel.setText("$" + String.format("%.2f", total));
    }


    public Button getBackButton() {
        return backButton;
    }
}

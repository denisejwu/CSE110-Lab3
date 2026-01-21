package edu.ucsd.spendingtracker.view;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;


public class SpendingView extends BorderPane {
    private VBox listContainer;
    private Button summaryButton = new Button("View Summary");

    public SpendingView() {
        VBox headerBox = new VBox(10);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(20));
       
        Text title = new Text("Spending Tracker");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 24;");
        headerBox.getChildren().addAll(title, summaryButton);

        listContainer = new VBox(5);
        ScrollPane scroller = new ScrollPane(listContainer);
        scroller.setFitToWidth(true);
        scroller.setStyle("-fx-background-color: transparent; -fx-background: #FFFFFF;");


        this.setTop(headerBox);
        this.setCenter(scroller);
        this.setPadding(new Insets(0, 25, 20, 25));
        this.setStyle("-fx-background-color: #FFFFFF;");
    }


    public void addExpenseRow(int idx, String name, String catName, String color, double amount) {
        HBox row = new HBox(10);
        row.setPrefSize(450, 40);
        row.setPadding(new Insets(5, 10, 5, 10));
        row.setAlignment(Pos.CENTER_LEFT);
        row.setStyle("-fx-background-color: " + color + "; -fx-border-color: #D3D3D3; " +
                     "-fx-border-width: 0 0 1 0; -fx-font-weight: bold; " +
                     "-fx-border-radius: 5px; -fx-background-radius: 5px;");


        Label nameL = new Label(name); nameL.setPrefWidth(200);
        Label catL = new Label("[" + catName + "]"); catL.setPrefWidth(100);
        catL.setStyle("-fx-font-size: 10px; -fx-font-weight: normal;");
        Label amtL = new Label("$" + String.format("%.2f", amount)); amtL.setPrefWidth(80);
        amtL.setAlignment(Pos.CENTER_RIGHT);


        row.getChildren().addAll(new Label(idx + "."), nameL, catL, amtL);
        listContainer.getChildren().add(row);
    }

    public Button getSummaryButton() {
        return summaryButton;
    }
}

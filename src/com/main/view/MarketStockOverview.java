package com.main.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MarketStockOverview extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(MarketLoginView.class.getResource("fxml/MarketStockCreate.fxml"));
        Scene scene = new Scene(root, 720, 480);
        String css = this.getClass().getResource("css/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
}

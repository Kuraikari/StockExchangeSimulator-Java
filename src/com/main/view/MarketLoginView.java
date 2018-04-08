package com.main.view;

import com.main.builder.QueryBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MarketLoginView extends Application {

    QueryBuilder queryBuilder = new QueryBuilder();

    public MarketLoginView(){

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(MarketLoginView.class.getResource("fxml/MarketLogin.fxml"));
        Scene scene = new Scene(root, 480, 360);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
}

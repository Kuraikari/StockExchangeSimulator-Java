package com.main.controller;

import com.main.builder.QueryBuilder;
import com.main.helper.DatabaseHelper;
import com.main.helper.MainHelper;
import com.main.view.MarketLoginView;
import com.main.view.MarketStockOverview;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MarketLoginController implements Initializable {

    QueryBuilder queryBuilder = new QueryBuilder();

    @FXML // fx:id="loginButton"
    private Button btnLogin; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField txtPassword; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField txtUsername; // Value injected by FXMLLoader

    public MarketLoginController(){

    }

    public static void main(String[] args) {
        DatabaseHelper.setDatabase();
        DatabaseHelper.establishConnection();
        MarketLoginView marketLoginView = new MarketLoginView();
        try {
            marketLoginView.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'market.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'market.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'market.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'market.fxml'.";

        btnCancel.setOnAction(event -> System.exit(0));
        btnLogin.setOnAction(event -> {
                queryBuilder
                        .select("*")
                        .from("user")
                        .where("username", "admin")
                        .execute();

                if (queryBuilder.returnValueFromRow("username").equals(txtUsername.getText()) &&
                        queryBuilder.returnValueFromRow("password").equals(txtPassword.getText())){
                    MainHelper.guiActionSwitchWindow((Button) event.getSource(), event, MarketStockOverview.class);
                } else {
                    System.out.println("ERROR");
                }
        });
    }
}

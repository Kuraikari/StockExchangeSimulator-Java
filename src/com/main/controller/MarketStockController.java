package com.main.controller;

import com.main.helper.GUIActionHelper;
import com.main.helper.MainHelper;
import com.main.view.MarketStockOverview;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MarketStockController implements Initializable {

    @FXML // fx:id="loginButton"
    private Button btnCreate; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button btnView; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private Button btnUpdate; // Value injected by FXMLLoader

    @FXML //fx:id="rootPane"
    private AnchorPane pneRoot;

    @FXML //fx:id="replaceablePane"
    private AnchorPane pneReplaceable;


    public MarketStockController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert btnCreate != null : "fx:id=\"btnCreate\" was not injected: check your FXML file 'market.fxml'.";
        assert btnView != null : "fx:id=\"btnView\" was not injected: check your FXML file 'market.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'market.fxml'.";
        assert pneReplaceable != null : "fx:id=\"pneReplaceable\" was not injected: check your FXML file 'market.fxml'.";

        btnCreate.setOnAction(event -> MainHelper.contentActionSwitch(btnCreate, event, pneReplaceable, "fxml/StockCreate.fxml", MarketStockOverview.class));
        btnView.setOnAction(event -> MainHelper.contentActionSwitch(btnCreate, event, pneReplaceable, "fxml/StockView.fxml", MarketStockOverview.class));
        btnUpdate.setOnAction(event -> MainHelper.contentActionSwitch(btnCreate, event, pneReplaceable, "fxml/StockUpdate.fxml", MarketStockOverview.class));
    }
}

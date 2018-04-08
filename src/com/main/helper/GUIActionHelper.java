package com.main.helper;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIActionHelper<T> {

    public void switchWindow(T source, Event event, Class<? extends Application> view){
        if (source.getClass() == Button.class) {
            Button eventSource = (Button) event.getSource();
            Stage oldStage = (Stage) eventSource.getScene().getWindow();
            oldStage.close();
            try {
                Application s = view.newInstance();
                try {
                    s.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void switchContent(T source, Event event, AnchorPane anchorPane, String fileName, Class<? extends Application> view){
        if (source.getClass() == Button.class){
            Button eventSource = (Button) event.getSource();
            try {
                anchorPane = FXMLLoader.load(view.getClass().getResource(fileName));
                anchorPane.getChildren().clear();
                anchorPane.getChildren().add(anchorPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

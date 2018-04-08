package com.main.helper;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import javafx.event.*;
import javafx.scene.layout.AnchorPane;

public class MainHelper {
    public static void guiActionSwitchWindow(Button source, Event event, Class<? extends Application> view){
        GUIActionHelper<Button> helper = new GUIActionHelper<Button>();
        helper.switchWindow(source, event, view);
    }

    public static void contentActionSwitch(Button source, Event event, AnchorPane anchorPane, String fileName, Class<? extends Application> view){
        GUIActionHelper<Button> helper = new GUIActionHelper<Button>();
        helper.switchContent(source, event, anchorPane, fileName, view);
    }
}
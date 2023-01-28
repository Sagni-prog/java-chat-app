package com.example.client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ClientChatUi extends Application {

    ArrayList<String> sentMessages = new ArrayList<String>();

    Label sentMsg = new Label();
    Label recMsg = new Label(" Hello this is the receivers");
    @Override
    public void start(Stage stage) throws IOException {
        HBox container = new HBox();
        container.setMinWidth(600);
        container.setMinHeight(400);
        VBox sideBar = new VBox();
        sideBar.setBackground(Background.fill(Color.rgb(5, 28, 36)));
        sideBar.setMinWidth(80);
        sideBar.setMinHeight(400);
        VBox chatContainer = new VBox();
        chatContainer.setMinWidth(600);


        BorderPane sendPane = new BorderPane();
        sendPane.setMinWidth(600);



        VBox bottomBox = new VBox(10);
        bottomBox.setMinHeight(20);
        bottomBox.setMinWidth(600);
        bottomBox.setBackground(Background.fill(Color.rgb(187, 237, 237)));
        TextField sendField = new TextField();
        sendField.setMinHeight(40);

        sendField.setMinWidth(600);
        sendField.setStyle("-fx-background-color: -fx-control-inner-background;");
        sendField.setOnKeyPressed( event -> {


                    if( event.getCode() == KeyCode.ENTER ) {
                        String msg = sendField.getText();
                        sentMessages.add(msg);

                        System.out.println(sentMessages);
                        int len = msg.length();

                        if(len != 0){
                            sentMsg.setPadding(new Insets(10,10,10,10));
                        }

                        if(msg.length() > 30){
                            sentMsg.setMaxWidth(25 * 10);
                        }
                        else if(len < 30) {
                            sentMsg.prefWidth(len * 3);
                        }

                        sentMsg.setText(msg);
                    }
                }
        );

        Button sendButton = new Button("Send");



        sentMsg.setTranslateX(260);
        sentMsg.setWrapText(true);
        // sentMsg.setMinWidth(0);

        // sentMsg.setMinWidth(40);
        // sentMsg.setMaxWidth(200);
        sentMsg.setStyle(" -fx-border-radius: 24 20 20 0; -fx-background-color: rgb(240, 240, 240);-fx-background-radius: 24 20 20 0; -fx-margin-bottom: 100;");

        Label sentMsgg = new Label("Hello this is the receivers ");
        sentMsgg.setWrapText(true);
        sentMsgg.setTranslateX(260);
        sentMsgg.setWrapText(true);
        sentMsgg.setMaxWidth(250);
        sentMsgg.setPadding(new Insets(10,10,10,10));
        sentMsgg.setMaxWidth(200);
        sentMsgg.setStyle(" -fx-border-radius: 24 20 20 0; -fx-background-color: rgb(240, 240, 240);-fx-background-radius: 24 20 20 0; -fx-margin-bottom: 100;");


        recMsg.setWrapText(true);
        recMsg.setTranslateX(30);
        recMsg.setWrapText(true);
        recMsg.setMaxWidth(250);
        recMsg.setPadding(new Insets(10,10,10,10));
        recMsg.setMaxWidth(200);
        recMsg.setStyle(" -fx-border-radius: 20 20 0 25; -fx-background-color: rgb(240, 240, 240);-fx-background-radius: 24 20 0 25; -fx-margin-bottom: 100;");

        Label recMsgg = new Label(" Hello this is the receivers");
        recMsgg.setWrapText(true);
        recMsgg.setTranslateX(30);
        recMsgg.setWrapText(true);
        recMsgg.setMaxWidth(250);
        recMsgg.setPadding(new Insets(10,10,10,10));
        recMsgg.setMaxWidth(200);
        recMsgg.setStyle(" -fx-border-radius: 20 20 0 25; -fx-background-color: rgb(240, 240, 240);-fx-background-radius: 24 20 0 25; -fx-margin-bottom: 100;");

        bottomBox.getChildren().addAll(recMsg,recMsgg,sentMsg,sentMsgg,sendField);


        sendPane.setBottom(bottomBox);
        // sendPane.setBorder(4,sentMsg);

        sendPane.setCenter(chatContainer);

        chatContainer.setBackground(Background.fill(Color.rgb(187, 237, 237)));

        container.getChildren().addAll(sideBar,sendPane);

        Scene scene = new Scene(container,600,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
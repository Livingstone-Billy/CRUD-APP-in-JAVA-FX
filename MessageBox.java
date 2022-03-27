package com.example.main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class MessageBox{

    public static void showMessage(String title, String message){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        AnchorPane root = new AnchorPane();

        HBox hBox = new HBox(10);
        Button close = new Button("OK");
        close.setFont(Font.font(14.0));
        close.setPadding(new Insets(10.0,30.0,10.0,30.0));
        close.setTextFill(Color.RED);
        close.setAlignment(Pos.BOTTOM_CENTER);
        close.setOnAction(e->window.close());
        hBox.getChildren().add(close);

        Label m_Message = new Label(message);
        m_Message.setFont(Font.font(16.0));
        AnchorPane.setLeftAnchor(m_Message,150.0);
        AnchorPane.setTopAnchor(m_Message, 25.0);

        AnchorPane.setRightAnchor(hBox, 200.0);
        AnchorPane.setTopAnchor(hBox, 55.0);
        root.getChildren().addAll(hBox, m_Message);

        Scene scene = new Scene(root, 500, 100,true);
        window.setScene(scene);
        window.setTitle(title);
        window.setResizable(false);
        window.showAndWait();
    }
}

package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Button button_view_courses;
    @FXML
    private Label label_online_exam;


    @FXML
    void click_logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = new Stage();
        stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("LOGIN");
        stage.setScene(new Scene(root,600,400));
        stage.show();
        System.out.println("LOGOUT");
    }

    @FXML
    void view_click(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("courses.fxml"));
        Stage stage = new Stage();
        stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("COURSES");
        stage.setScene(new Scene(root,600,400));
        stage.show();
        System.out.println("VIEW");
    }

    public void setUserInformation(String username){
        label_online_exam.setText("Welcome " + username +"!");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

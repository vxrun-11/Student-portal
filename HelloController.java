package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class HelloController implements Initializable {


    @FXML
    private Button button_login;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    public Boolean validate() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        Database connect = new Database();
        Connection connectdb = connect.getConnection();
        String verify = "SELECT count(1) FROM details WHERE username='" + tf_username.getText() + "' AND password = '" + tf_password.getText() + "'";
        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryresult = statement.executeQuery(verify);
            while (queryresult.next()) {
                if (queryresult.getInt(1) == 1) {

                    return Boolean.TRUE;
                } else {

                    return Boolean.FALSE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }



//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        button_login.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                DBUtils.logInUser(event, tf_username.getText(), tf_password.getText());
//            }
//       });

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleButton2(javafx.scene.input.MouseEvent mouseEvent) throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, NoSuchProviderException, InvalidKeyException {
        if (tf_password.getText().isBlank() != false || tf_username.getText().isBlank() != false) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Fill all Details!!");
            a.show();
        } else {
            Boolean check;

            check = validate();
            if (check == Boolean.TRUE) {
                Parent root = FXMLLoader.load(getClass().getResource("Logged-in.fxml"));
                Stage stage = new Stage();
                stage=(Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setTitle("ONLINE EXAMINATION");
                stage.setScene(new Scene(root,600,400));
                stage.show();
            }
            else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("Invalid Credentials!!");
                a.show();
            }
        }


    }
    @FXML
    private Button button_logout;
    @FXML
    private Button button_view_courses;
    @FXML
    private Label label_online_exam;

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




}


package com.example.demo;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public class Courses implements Initializable {

    @FXML
    private Button button_back;

    @FXML
    private Button button_next;

    @FXML
    private RadioButton radio_cpp;

    @FXML
    private RadioButton radio_dbd;

    @FXML
    private ComboBox<String> combo;

    @FXML
    void backClick(ActionEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Logged-in.fxml"));
        Stage stage = new Stage();
        stage=(Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setTitle("ONLINE EXAMINATION");
        stage.setScene(new Scene(root,600,400));
        stage.show();

    }
    private int score=0;
    private int score1=0;
    @FXML
    private Button c1next;
    @FXML
    private ToggleButtonGroup c1grp;
    @FXML
    private RadioButton c11;

    @FXML
    private RadioButton c12;

    @FXML
    private RadioButton c13;

    @FXML
    private RadioButton c14;

    int c1;
    @FXML
    void c2next(ActionEvent event) throws IOException {
        if(c12.isSelected())
        {
            score++;
        }
        Parent root = FXMLLoader.load(getClass().getResource("cpp2.fxml"));
        Stage stage = new Stage();
        stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("C++");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    @FXML
    private ToggleButtonGroup c2grp;
    @FXML
    private RadioButton course1;

    @FXML
    private RadioButton course2;
    boolean cpp1=false;
    @FXML
    private Button c2prev;
    @FXML
    private Button d1next;

    @FXML
    private RadioButton d1r1;

    @FXML
    private RadioButton d1r2;

    @FXML
    private RadioButton d1r3;

    @FXML
    private RadioButton d1r4;
    @FXML
    private RadioButton c1r1;

    @FXML
    private RadioButton c2r2;

    @FXML
    private RadioButton c2r3;

    @FXML
    private RadioButton c2r4;

    @FXML
    private Button csub;

    @FXML
    void csubmit(ActionEvent event) throws IOException {
        if(c2r2.isSelected())
        {
            score++;
        }
        Parent root = FXMLLoader.load(getClass().getResource("score.fxml"));
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DBD");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    @FXML
    void d2next(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("dbd2.fxml"));
        Stage stage = new Stage();
        stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DBD");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    @FXML
    void nextClick(ActionEvent mouseEvent) throws IOException {
        if (course1.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("cpp.fxml"));
            Stage stage = new Stage();
            stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("C++");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        } else if (course2.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("dbd1.fxml"));
            Stage stage = new Stage();
            stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("DBD");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
    }
    @FXML
    private Button dsub;
    @FXML
    private Label scr;
    @FXML
    void dsubmit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("score.fxml"));
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("DBD");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    @FXML
    private Button d2prev;

    @FXML
    private RadioButton d2r1;

    @FXML
    private RadioButton d2r2;

    @FXML
    private RadioButton d2r3;

    @FXML
    private RadioButton d2r4;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


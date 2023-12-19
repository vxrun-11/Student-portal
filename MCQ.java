package com.example.demo;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.stage.Popup;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class MCQ extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private int cppscore = 0;
    private int cppqindex = 0;
    private String[] questionscpp = {"Which of the following user-defined header file extension used in C++?", "Which of the following is used for comments in C++?"};
    private String[][] optionscpp = {{"hg", "cpp", "h", "hf"}, {"/* comment */", "// comment */", "// comment", "both // comment or /* comment */"}};
    private int[] answerscpp = {2, 3};

    private int dbdscore = 0;
    private int dbdqindex = 0;
    private String[] questionsdbd = {"Which of these can help us detect poor E-R design?", "What is the best way to represent the attributes in a large database?"};
    private String[][] optionsdbd = {{"Database Design Process", "E-R Design Process", "Relational scheme", " Functional dependencies"}, {"Relational-and", "Concatenation", "Dot representation", "All of the mentioned"}};
    private int[] answersdbd = {3, 1};

    @Override
    public void start(Stage primaryStage) {
        GridPane firstgrid = new GridPane();
        Button b = new Button("Student Login");
        firstgrid.setMinSize(600, 600);
        firstgrid.setAlignment(Pos.CENTER);
        firstgrid.add(b,5,5);
        Scene entryscene = new Scene(firstgrid);

        GridPane logingrid1 = new GridPane();
        Text t11 = new Text("Username");
        Text t12 = new Text("Password");
        TextField tf11 = new TextField();
        TextField tf12 = new TextField();
        Button b11 = new Button("Submit");
        logingrid1.setMinSize(600, 600);
        logingrid1.setPadding(new Insets(10, 10, 10, 10));
        logingrid1.setVgap(5);
        logingrid1.setHgap(5);
        logingrid1.setAlignment(Pos.CENTER);
        logingrid1.add(t11, 1,1);
        logingrid1.add(tf11, 3,1);
        logingrid1.add(t12, 1,3);
        logingrid1.add(tf12, 3,3);
        logingrid1.add(b11, 5,5);
        Scene loginscene = new Scene(logingrid1);
        b.setOnAction(e->primaryStage.setScene(loginscene));

        GridPane testsgrid2 = new GridPane();
        Text t21 = new Text("1.C++ Tutorial");
        Text t22 = new Text("2.DBD Tutorial");
        Button b21 = new Button("Attempt");
        Button b22 = new Button("Attempt");
        testsgrid2.setMinSize(600, 600);
        testsgrid2.setPadding(new Insets(10, 10, 10, 10));
        testsgrid2.setVgap(5);
        testsgrid2.setHgap(5);
        testsgrid2.setAlignment(Pos.TOP_LEFT);
        testsgrid2.add(t21, 1,1);
        testsgrid2.add(b21, 5,1);
        testsgrid2.add(t22, 1,3);
        testsgrid2.add(b22, 5,3);
        Scene testsscene = new Scene(testsgrid2);
        b11.setOnAction(e->primaryStage.setScene(testsscene));

        Stage testwindow = new Stage();
        testwindow.setTitle("Tutorial Questions");
        //--------------------------------------------------------------------------------------------------------------
        Label cppLabel = new Label(questionscpp[cppqindex]);
        ToggleGroup cppgroup = new ToggleGroup();
        RadioButton[] radioButtons = new RadioButton[optionscpp[cppqindex].length];
        for (int i = 0; i < optionscpp[cppqindex].length; i++) {
            RadioButton radioButton = new RadioButton(optionscpp[cppqindex][i]);
            radioButton.setToggleGroup(cppgroup);
            radioButtons[i] = radioButton;
        }
        Button submitButtoncpp = new Button("Submit");
        submitButtoncpp.setOnAction(e -> {
            int selectedOption = cppgroup.getToggles().indexOf(cppgroup.getSelectedToggle());
            if (selectedOption == answerscpp[cppqindex]) {
                cppscore++;
            }
            cppqindex++;
            if (cppqindex < questionscpp.length) {
                cppLabel.setText(questionscpp[cppqindex]);
                for (int i = 0; i < optionscpp[cppqindex].length; i++) {
                    radioButtons[i].setText(optionscpp[cppqindex][i]);
                }
            } else {
                showScore(testwindow,1);
            }
        });
        VBox vboxcpp = new VBox(10, cppLabel, radioButtons[0], radioButtons[1], radioButtons[2], radioButtons[3], submitButtoncpp);
        vboxcpp.setPadding(new Insets(20));
        vboxcpp.setAlignment(Pos.CENTER);
        Scene scenecpp = new Scene(vboxcpp, 400, 400);
        b21.setOnAction(e-> {testwindow.setScene(scenecpp);testwindow.show();});
        TimerApp.setTimer(testwindow,vboxcpp);
        //--------------------------------------------------------------------------------------------------------------
        Label dbdLabel = new Label(questionsdbd[dbdqindex]);
        ToggleGroup dbdgroup = new ToggleGroup();
        RadioButton[] radioButtonsx = new RadioButton[optionsdbd[dbdqindex].length];
        for (int i = 0; i < optionsdbd[dbdqindex].length; i++) {
            RadioButton radioButton = new RadioButton(optionsdbd[dbdqindex][i]);
            radioButton.setToggleGroup(dbdgroup);
            radioButtonsx[i] = radioButton;
        }
        Button submitButtondbd = new Button("Submit");
        submitButtondbd.setOnAction(e -> {
            int selectedOption = dbdgroup.getToggles().indexOf(dbdgroup.getSelectedToggle());
            if (selectedOption == answersdbd[dbdqindex]) {
                dbdscore++;
            }
            dbdqindex++;
            if (dbdqindex < questionsdbd.length) {
                dbdLabel.setText(questionsdbd[dbdqindex]);
                for (int i = 0; i < optionsdbd[dbdqindex].length; i++) {
                    radioButtonsx[i].setText(optionsdbd[dbdqindex][i]);
                }
            } else {
                showScore(testwindow,2);
            }
        });
        VBox vboxdbd = new VBox(10, dbdLabel, radioButtonsx[0], radioButtonsx[1], radioButtonsx[2], radioButtonsx[3], submitButtondbd);
        vboxdbd.setPadding(new Insets(20));
        vboxdbd.setAlignment(Pos.CENTER);
        Scene scenedbd = new Scene(vboxdbd, 400, 400);
        b22.setOnAction(e-> {testwindow.setScene(scenedbd);testwindow.show();});
        TimerApp.setTimer(testwindow,vboxdbd);
        //--------------------------------------------------------------------------------------------------------------

        primaryStage.setTitle("Online Exam Sample Portal");
        primaryStage.setScene(entryscene);
        primaryStage.show();
    }
    public void showScore(Stage currStage,int subnum) {
        currStage.close();
        Button closeButton = new Button("Close");
        GridPane gridPane = new GridPane();
        if (subnum == 1) {
            Label scoreLabel = new Label("Your final score is " + cppscore + " out of " + questionscpp.length);
            gridPane.add(scoreLabel, 0, 0);
        }
        else if (subnum == 2) {
            Label scoreLabel = new Label("Your final score is " + dbdscore + " out of " + questionsdbd.length);
            gridPane.add(scoreLabel, 0, 0);
        }

        gridPane.add(closeButton, 0, 1);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        Scene scoreScene = new Scene(gridPane, 400, 200);
        Stage scoreStage = new Stage();
        scoreStage.setScene(scoreScene);
        closeButton.setOnAction(e -> scoreStage.close());
        scoreStage.setScene(scoreScene);
        scoreStage.show();
    }
}

class TimerApp  {
    private static Timeline timeline;
    private static Label timeLabel = new Label("00:00:00");
    private static int seconds = 0;
    private static int minutes = 1; // set the initial duration in minutes here
    private static int hours = 0;

    public static void setTimer(Stage currStage, VBox currBox) {
        currBox.getChildren().add(timeLabel);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (seconds == 0 && minutes == 0 && hours == 0) {
                timeline.stop();
                currStage.close();
            } else if (seconds == 0 && minutes > 0) {
                seconds = 59;
                minutes--;
            } else if (seconds == 0 && minutes == 0 && hours > 0) {
                seconds = 59;
                minutes = 59;
                hours--;
            } else {
                seconds--;
            }
            updateTimeLabel();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private static void updateTimeLabel() {
        String hourString = hours > 9 ? Integer.toString(hours) : "0" + hours;
        String minuteString = minutes > 9 ? Integer.toString(minutes) : "0" + minutes;
        String secondString = seconds > 9 ? Integer.toString(seconds) : "0" + seconds;
        timeLabel.setText(hourString + ":" + minuteString + ":" + secondString);
    }
}
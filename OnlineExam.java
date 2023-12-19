package com.example.demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class OnlineExam extends Application {
    private Stage window;
    private Scene loginScene, examScene, resultScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // Login Scene
        VBox loginLayout = new VBox(10);
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // TODO: Implement login logic
            window.setScene(examScene);
        });
        loginLayout.getChildren().addAll(
                new Label("Username:"),
                usernameField,
                new Label("Password:"),
                passwordField,
                loginButton
        );
        loginScene = new Scene(loginLayout, 400, 300);

        // Exam Scene
        VBox examLayout = new VBox(10);
        Label questionLabel = new Label("Question 1: What is 2 + 2?");
        ToggleGroup answerGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton("1");
        answer1.setToggleGroup(answerGroup);
        RadioButton answer2 = new RadioButton("2");
        answer2.setToggleGroup(answerGroup);
        RadioButton answer3 = new RadioButton("3");
        answer3.setToggleGroup(answerGroup);
        RadioButton answer4 = new RadioButton("4");
        answer4.setToggleGroup(answerGroup);
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // TODO: Evaluate user answers and show result
            window.setScene(resultScene);
        });
        examLayout.getChildren().addAll(
                questionLabel,
                answer1,
                answer2,
                answer3,
                answer4,
                submitButton
        );
        examScene = new Scene(examLayout, 400, 300);

        // Result Scene
        VBox resultLayout = new VBox(10);
        Label resultLabel = new Label("You scored 8 out of 10.");
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> window.setScene(loginScene));
        resultLayout.getChildren().addAll(
                resultLabel,
                restartButton
        );
        resultScene = new Scene(resultLayout, 400, 300);

        // Set Login Scene
        window.setScene(loginScene);
        window.setTitle("Online Exam");
        window.show();
    }
}

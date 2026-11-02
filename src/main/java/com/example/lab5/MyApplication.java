package com.example.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;


public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("Введите номер задания (1-4): ");
        System.out.println("1 - Текстовые поля: ");
        System.out.println("2 - Виджеты: ");
        System.out.println("3 - Меню: ");
        System.out.println("4 - Флаги: ");
        String task_title = "label-changer.fxml";
        String scene_title = "Текстовые поля";
        Scanner task = new Scanner(System.in);
        switch (task.next()) {
            case "1" -> {
                task_title = "labels.fxml";
                scene_title = "Текстовые поля";
            }
            case "2" -> {
                task_title = "widgets.fxml";
                scene_title = "Виджеты";
            }
            case "3" -> {
                task_title = "menu.fxml";
                scene_title = "ЯРЧЕ на улице Васильева!";
            }
            case "4" -> {
                task_title = "flag.fxml";
                scene_title = "Флаги";
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource(task_title));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(scene_title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
package com.example.lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LabelController {

    @FXML
    private TextField leftField;
    @FXML
    private TextField rightField;
    @FXML
    private Button moveButton;

    private boolean toRight = true;

    @FXML
    private void onMove(ActionEvent event) {
        if (toRight) {
            rightField.setText(leftField.getText());
            leftField.clear();
            moveButton.setText("←");
        } else {
            leftField.setText(rightField.getText());
            rightField.clear();
            moveButton.setText("→");
        }
        toRight = !toRight;
    }
}
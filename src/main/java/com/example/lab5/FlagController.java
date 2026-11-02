package com.example.lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlagController {

    @FXML private RadioButton topRed, topGreen, topBlue, topWhite, topBlack;
    @FXML private RadioButton midRed, midGreen, midBlue, midWhite, midBlack;
    @FXML private RadioButton botRed, botGreen, botBlue, botWhite, botBlack;

    @FXML private Rectangle topStripe, midStripe, botStripe;
    @FXML private Label resultLabel;

    private final ToggleGroup topGroup = new ToggleGroup();
    private final ToggleGroup midGroup = new ToggleGroup();
    private final ToggleGroup botGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        topRed.setToggleGroup(topGroup);
        topGreen.setToggleGroup(topGroup);
        topBlue.setToggleGroup(topGroup);
        topWhite.setToggleGroup(topGroup);
        topBlack.setToggleGroup(topGroup);

        midRed.setToggleGroup(midGroup);
        midGreen.setToggleGroup(midGroup);
        midBlue.setToggleGroup(midGroup);
        midWhite.setToggleGroup(midGroup);
        midBlack.setToggleGroup(midGroup);

        botRed.setToggleGroup(botGroup);
        botGreen.setToggleGroup(botGroup);
        botBlue.setToggleGroup(botGroup);
        botWhite.setToggleGroup(botGroup);
        botBlack.setToggleGroup(botGroup);

        topWhite.setSelected(true);
        midBlue.setSelected(true);
        botRed.setSelected(true);
    }

    @FXML
    private void drawFlag(ActionEvent event) {
        Color c1 = getColor(topGroup);
        Color c2 = getColor(midGroup);
        Color c3 = getColor(botGroup);

        topStripe.setFill(c1);
        midStripe.setFill(c2);
        botStripe.setFill(c3);

        String text = getColorName(topGroup) + ", " + getColorName(midGroup) + ", " + getColorName(botGroup);
        resultLabel.setText(text);
    }

    private Color getColor(ToggleGroup group) {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        if (rb == null) return Color.WHITE;

        return switch (rb.getText()) {
            case "Красный" -> Color.RED;
            case "Зеленый" -> Color.GREEN;
            case "Синий" -> Color.BLUE;
            case "Черный" -> Color.BLACK;
            default -> Color.WHITE;
        };
    }

    private String getColorName(ToggleGroup group) {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        return rb == null ? "Белый" : rb.getText();
    }
}
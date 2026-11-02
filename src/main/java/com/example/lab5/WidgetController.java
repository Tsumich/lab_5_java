package com.example.lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class WidgetController {

    @FXML
    private ImageView noAnime;
    @FXML
    private ImageView animeImage;
    @FXML
    private CheckBox checkAnime;

    @FXML
    private ImageView image2;
    @FXML
    private CheckBox check2;

    @FXML
    private ImageView image3;
    @FXML
    private CheckBox check3;

    @FXML
    protected void changeToAnime() {
        boolean isChecked = checkAnime.isSelected();
        noAnime.setVisible(!isChecked);
        animeImage.setVisible(isChecked);
    }

    @FXML
    protected void toggleWidget2() {
        image2.setVisible(check2.isSelected());
        image2.setManaged(check2.isSelected());
    }

    @FXML
    protected void toggleWidget3() {
        image3.setVisible(check3.isSelected());
        image3.setManaged(check3.isSelected());
    }


}
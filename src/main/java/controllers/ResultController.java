package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ResultController {

    @FXML
    private AnchorPane methodPane;

    @FXML
    private void goToMenuButtonClick() throws Exception{
        RorschachController rorschachController = new RorschachController();
        GridPane gridPane = rorschachController.getMainPane();
        methodPane.getChildren().setAll(gridPane);
    }

}

package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import models.Result;

public class ApparentMovementController {
    @FXML
    private AnchorPane methodPane;
    @FXML
    private ImageView movementView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private JFXButton answerButton;
    @FXML
    private JFXSlider sliderStart;
    @FXML
    private JFXSlider sliderFinish;

    private int timerCount = 26;
    private double progress = 0;

    private Timeline progressTimer = new Timeline(
            new KeyFrame(
                    Duration.millis(1000),
                    ae -> {
                        progress += 0.04;
                        progressBar.setProgress(progress);

                        timerCount--;

                        if (timerCount == 0) {
                            Image image = new Image("/images/apparentMovement/finish.gif");
                            movementView.setImage(image);
                            answerButton.setDisable(false);
                        }
                    }
            )
    );

    public void initialize() {
        sliderStart.setValue(0);
        sliderFinish.setValue(timerCount);
        progressBar.setProgress(progress);
        answerButton.setDisable(true);

        Image image = new Image("/images/apparentMovement/horse.gif");
        movementView.setImage(image);

        progressTimer.setCycleCount(timerCount);
        progressTimer.play();
    }

    @FXML
    private void menuButtonClick() throws Exception {
        RorschachController rorschachController = new RorschachController();
        GridPane gridPane = rorschachController.getMainPane();
        methodPane.getChildren().setAll(gridPane);
    }

    @FXML
    private void answerButtonClick() {
        try {
            searchResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void searchResult() throws Exception {
        if ((sliderStart.getValue() == 0 && sliderFinish.getValue() == 0) ||
                (Math.abs(sliderFinish.getValue() - sliderStart.getValue()) >= 7)) {
            Result result = new Result(false);
            AnchorPane pane = result.getPane();
            methodPane.getChildren().setAll(pane);
        }
        else if (Math.abs(sliderFinish.getValue() - sliderStart.getValue()) < 7){
            Result result = new Result(true);
            AnchorPane pane = result.getPane();
            methodPane.getChildren().setAll(pane);
        }
    }
}

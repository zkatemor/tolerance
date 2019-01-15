package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import models.Result;
import models.ReversibleFiguresMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReversibleFiguresController {
    @FXML
    private Label infoImageLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private ImageView reversibleFigureImage;
    @FXML
    private AnchorPane methodPane;
    @FXML
    private Button firstButton;
    @FXML
    private Button secondButton;

    private int index = 1;
    private int timerCount = 6;
    private int[] time = {6};
    private ArrayList<String> answerList = new ArrayList<>();
    private Timeline timeline = new Timeline(
                new KeyFrame(
                    Duration.millis(1000),
                    ae -> {
                        time[0]--;
                        infoLabel.setText("Осталось времени (в секундах): " + --timerCount);
                        ReversibleFiguresMethod figuresMethod = new ReversibleFiguresMethod(index);
                        reversibleFigureImage.setImage(figuresMethod.getImage());
                        infoImageLabel.setText(figuresMethod.getInfoAboutImage());
                        firstButton.setText("");
                        secondButton.setText("");
                        firstButton.setDisable(true);
                        secondButton.setDisable(true);

                        if (timerCount == 0){
                            infoLabel.setText("Выберите, что вы увидели на изображении:");
                            reversibleFigureImage.setImage(null);
                            infoImageLabel.setText("");
                            ObservableList<String> buttonsText = figuresMethod.getButtonsText();
                            firstButton.setText(buttonsText.get(0));
                            secondButton.setText(buttonsText.get(1));
                            firstButton.setDisable(false);
                            secondButton.setDisable(false);
                        }
                    }
            )
    );

    @FXML
    private void initialize() {
        reversibleFigureImage.setImage(null);

        infoLabel.setText("МЕТОДИКА ДВОЙСТВЕННЫХ ИЗОБРАЖЕНИЙ");
        infoImageLabel.setText("");

        firstButton.setText("");
        secondButton.setText("");
        firstButton.setDisable(true);
        secondButton.setDisable(true);

        firstButton.setOnAction(event -> answerButtonClick(event));
        secondButton.setOnAction(event -> answerButtonClick(event));

        timeline.setCycleCount(6);
        timeline.play();
    }

    @FXML
    private void answerButtonClick(ActionEvent a){
        if (index < 10) {
            timeline.stop();
            infoImageLabel.setText("");
            index++;

            JFXButton jfxButton = (JFXButton)a.getSource();
            answerList.add(jfxButton.getText());

            time[0] = 6;
            timerCount = 6;
            timeline.setCycleCount(6);
            timeline.play();
        }
        else {
            List listDistinct = answerList.stream().distinct().collect(Collectors.toList());
            if (listDistinct.size() >= 7){
                try {
                    Result result = new Result(true);
                    AnchorPane anchorPane = result.getPane();
                    methodPane.getChildren().setAll(anchorPane);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Result result = new Result(false);
                    AnchorPane anchorPane = result.getPane();
                    methodPane.getChildren().setAll(anchorPane);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    @FXML
    private void menuButtonClick() throws Exception{
        RorschachController rorschachController = new RorschachController();
        GridPane gridPane = rorschachController.getMainPane();
        methodPane.getChildren().setAll(gridPane);
    }
}
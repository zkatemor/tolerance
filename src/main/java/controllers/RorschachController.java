package controllers;

import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import models.Result;
import models.RorschachMethod;

public class RorschachController {
    @FXML
    private ImageView imageView;
    @FXML
    private Label counterLabel;
    @FXML
    private AnchorPane methodPane;
    @FXML
    private GridPane choiceGridPane;

    private int numberOfTest = 1;
    private int sumOfPoints = 0;
    private int tmpSum = 0;

    @FXML
    private void initialize() {
        dynamicAddRadioButtons();
    }

    private void dynamicAddRadioButtons(){
        choiceGridPane.getChildren().clear();

        RorschachMethod rorschachMethod = new RorschachMethod(numberOfTest);

        imageView.setImage(rorschachMethod.getImage());

        ObservableList<JFXRadioButton> radioButtons = rorschachMethod.getRadioButtonsList();

        ToggleGroup tg = new ToggleGroup();
        for(JFXRadioButton i : radioButtons){
            i.setToggleGroup(tg);
        }

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n) {
                JFXRadioButton rb = (JFXRadioButton) tg.getSelectedToggle();
                for (JFXRadioButton i : radioButtons) {
                    if (!i.equals(rb))
                        i.setSelected(false);
                    else if (i.equals(rb))
                        sumOfPoints += radioButtons.indexOf(i) + 1; //если буду выводить только основной рез-т
                }
            }
        });

        for (int i = 0; i < radioButtons.size(); i++) {
            choiceGridPane.getRowConstraints().add(new RowConstraints(50));
            choiceGridPane.addRow(i, radioButtons.get(i));
        }
    }

    @FXML
    private void nextImageButtonClick() throws Exception{
        if (numberOfTest < 10) {
            if (sumOfPoints == tmpSum){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Внимание");
                alert.setHeaderText("Нет ответа на данную карточку");
                alert.setContentText("Пожалуйста, выберите один из предложенных вариантов ответа!");
                alert.showAndWait();
            }
            else {
                numberOfTest++;
                counterLabel.setText("Карточка " + numberOfTest + " из 10");
                dynamicAddRadioButtons();
                tmpSum = sumOfPoints;
            }
        }
        else
        {
            if (sumOfPoints >= 38 / 2) {
                Result result = new Result(true);
                AnchorPane anchorPane = result.getPane();
                methodPane.getChildren().setAll(anchorPane);
            }
            else
            {
                Result result = new Result(false);
                AnchorPane anchorPane = result.getPane();
                methodPane.getChildren().setAll(anchorPane);
            }
        }
    }

    @FXML
    private void menuButtonClick() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/main.fxml"));
        GridPane pane = loader.load();
        pane.getStylesheets().addAll(this.getClass().getResource("../css/mainstyle.css").toExternalForm());
        methodPane.getChildren().setAll(pane);
    }

    public GridPane getMainPane() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/main.fxml"));
        GridPane pane = loader.load();
        pane.getStylesheets().addAll(this.getClass().getResource("../css/mainstyle.css").toExternalForm());
        return pane;
    }
}

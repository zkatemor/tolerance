package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutMethodController implements Initializable {

    private int method;

    @FXML
    private ImageView aboutMethodView;
    @FXML
    private AnchorPane methodPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void menuButtonClick() throws Exception{
        RorschachController rorschachController = new RorschachController();
        GridPane gridPane = rorschachController.getMainPane();
        methodPane.getChildren().setAll(gridPane);
    }

    public void setAboutMethodImage(Image image){
        aboutMethodView.setImage(image);
    }

    public void setMethod(int method){
        this.method = method;
    }

    @FXML
    private void startButtonClick() throws Exception{
        switch (method){
            case 1 : {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/rorschach.fxml"));
                AnchorPane anchorPane = loader.load();
                anchorPane.getStylesheets().addAll(this.getClass().getResource("../css/rorschach.css").toExternalForm());
                methodPane.getChildren().setAll(anchorPane);
            }
            break;
            case 2:{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/reversiblefigures.fxml"));
                AnchorPane anchorPane = loader.load();
                anchorPane.getStylesheets().addAll(this.getClass().getResource("../css/reversible.css").toExternalForm());
                methodPane.getChildren().setAll(anchorPane);
            }
            break;
            case 3:{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/apparentmovement.fxml"));
                AnchorPane anchorPane = loader.load();
                anchorPane.getStylesheets().addAll(this.getClass().getResource("../css/apparentmovement.css").toExternalForm());
                methodPane.getChildren().setAll(anchorPane);
            }
            break;
        }
    }
}

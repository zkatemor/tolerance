package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainController {
    @FXML
    private AnchorPane paneForMethod;
    @FXML
    private ImageView imageView;

    public void initialize(){
        Image image = new Image("/images/about/main.jpg");
        imageView.setImage(image);
    }

    @FXML
    private void rorschachButtonClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/aboutmethod.fxml"));
        AnchorPane anchorPane = loader.load();
        AboutMethodController aboutMethodController = loader.getController();
        Image image = new Image("/images/about/rorschach.jpg");
        aboutMethodController.setAboutMethodImage(image);
        aboutMethodController.setMethod(1);
        paneForMethod.getChildren().setAll(anchorPane);
    }

    @FXML
    private void reversibleButtonClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/aboutmethod.fxml"));
        AnchorPane anchorPane = loader.load();
        AboutMethodController aboutMethodController = loader.getController();
        Image image = new Image("/images/about/reversiblefigures.jpg");
        aboutMethodController.setAboutMethodImage(image);
        aboutMethodController.setMethod(2);
        paneForMethod.getChildren().setAll(anchorPane);
    }

    @FXML
    private void apparentMovementButtonClick() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/aboutmethod.fxml"));
        AnchorPane anchorPane = loader.load();
        AboutMethodController aboutMethodController = loader.getController();
        Image image = new Image("/images/about/apparentmovement.jpg");
        aboutMethodController.setAboutMethodImage(image);
        aboutMethodController.setMethod(3);
        paneForMethod.getChildren().setAll(anchorPane);
    }
}

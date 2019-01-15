package models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        root.setId("pane");
        primaryStage.setTitle("Диагностика толерантности к нереалистическому опыту");
        Scene scene = new Scene(root, 1220, 855);
        scene.getStylesheets().addAll(this.getClass().getResource("../css/mainstyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        Image image = new Image(getClass().getResourceAsStream("../images/icons/main.png"));
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

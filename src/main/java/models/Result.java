package models;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Result {
    private boolean isTolerance;

    public Result(boolean isTolerance){
        this.isTolerance = isTolerance;
    }

    public AnchorPane getPane()throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        if (isTolerance) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/tolerance.fxml"));
            anchorPane = loader.load();
            anchorPane.getStylesheets().addAll(this.getClass().getResource("../css/result.css").toExternalForm());
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/intolerance.fxml"));
            anchorPane = loader.load();
            anchorPane.getStylesheets().addAll(this.getClass().getResource("../css/result.css").toExternalForm());
        }
        return anchorPane;
    }
}

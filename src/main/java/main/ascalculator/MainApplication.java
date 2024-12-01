package main.ascalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("asCalculatorGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Calculator");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);

        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/icon-removebg-preview.png"))));
        stage.setScene(scene);
        stage.show();
        ((MainAppController)fxmlLoader.getController()).init(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}
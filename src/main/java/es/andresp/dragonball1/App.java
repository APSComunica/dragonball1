package es.andresp.dragonball1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Image image1 = new Image(getClass().getResourceAsStream("/imagenes/uno.png"));
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
    }

    public static void main(String[] args) {
        launch();
    }

}
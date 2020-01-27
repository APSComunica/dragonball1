package es.andresp.dragonball1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 480;
    final short SCENE_WIDTH = 800;
           
    short freePosY = (short)((SCENE_HEIGHT)/2);
    byte freeCurrentSpeed = 4;
    byte freeDirection = 0;
    
    
    
    
    
    
    
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
        
        Image image1 = new Image(getClass().getResourceAsStream("/imagenes/uno.png"));
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        
        Image image2 = new Image(getClass().getResourceAsStream("/imagenes/normal.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(SCENE_WIDTH - SCENE_WIDTH);
        imageView2.setY(freePosY);
        root.getChildren().add(imageView2);
        
        
        
        // CONTROL DEL TECLADO
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent keyEvent) {
                switch(keyEvent.getCode()) {
                    case UP:
                        freeDirection = -1;
                        break;
                    case DOWN:
                        freeDirection = 1;
                        break;
                }                
            }
        });
        
        
        
        
        
        
        Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
     
                    // ANIMACIÓN DE Free
                    imageView2.setY(freePosY);
                    freePosY += freeCurrentSpeed * freeDirection;
                    if(freePosY <= 0 || freePosY >= SCENE_HEIGHT) {
                        freeDirection = 0;
                    }
                    if(freePosY <= 0) {
                        freeDirection = 0;
                        freePosY = 0;
                    } else if (freePosY >= SCENE_HEIGHT) {
                        freeDirection = 0;
                        freePosY = (short)(SCENE_HEIGHT);
                    }
                }
            }));
        
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}
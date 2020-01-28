package es.andresp.dragonball1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 470;
    final short SCENE_WIDTH = 800;
           
    short freePosY = (short)((SCENE_HEIGHT)/2);
    byte freeCurrentSpeed = 4;
    byte freeDirectionY = 0;
    byte freeDirectionX = 0;
    short freePosX = (short)(SCENE_WIDTH - SCENE_WIDTH);
    
    
    
    
    
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
        
        Image image1 = new Image(getClass().getResourceAsStream("/imagenes/uno.png"));
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        
        
        //free
        Image image2 = new Image(getClass().getResourceAsStream("/imagenes/normal.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(freePosX);
        imageView2.setY(freePosY);
        root.getChildren().add(imageView2);
        
  
        
        // CONTROL DEL TECLADO
        scene.setOnKeyPressed((final KeyEvent keyEvent) -> {
            switch(keyEvent.getCode()) {
                case UP:
                    freeDirectionY = -1;
                    break;
                case DOWN:
                    freeDirectionY = 1;
                    break;  
                    
                case RIGHT:
                    freeDirectionX = 1;
                    break;  
                    
                case LEFT:
                    freeDirectionX = -1;
                    break;  
                
                    
                    //CAMBIAR A DORADO
                case T:
                     image image3= new Image(getClass().getResourceAsStream("/imagenes/dorado.png"));
                    break; 
            }
        });
        
 
        // CONTROL DEL TECLADO
        scene.setOnKeyReleased((final KeyEvent keyEvent) -> {
            switch(keyEvent.getCode()) {
                case UP:
                    freeDirectionY = 0;
                    break;
                case DOWN:
                    freeDirectionY = 0;
                    break;  
                    
                case RIGHT:
                    freeDirectionX = 0;
                    break;  
                    
                case LEFT:
                    freeDirectionX = 0;
                    break; 
                    
                case T:
                     ;
                    break;    
            }
        });
        

        Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                // ANIMACIÓN DE Free
                imageView2.setY(freePosY);
                imageView2.setX(freePosX);
                freePosY += freeCurrentSpeed * freeDirectionY;
                freePosX += freeCurrentSpeed * freeDirectionX;
                if(freePosY <= 0 || freePosY >= SCENE_HEIGHT) {
                    freeDirectionY = 0;
                }
                if(freePosX <= 0 || freePosX >= SCENE_WIDTH) {
                    freeDirectionX = 0;
                }
                if(freePosY <= 0) {
                    freeDirectionY = 0;
                    freePosY = 0;
                } else if (freePosY >= SCENE_HEIGHT) {
                    freeDirectionY = 0;
                    freePosY = (short)(SCENE_HEIGHT);
                }
                
                
                if(freePosX <= 0) {
                    freeDirectionX = 0;
                    freePosX = 0;
                } else if (freePosX >= SCENE_WIDTH) {
                    freeDirectionX = 0;
                    freePosX = (short)(SCENE_WIDTH);
                }
                
                
        }));
        
         timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}
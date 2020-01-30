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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 470;
    final short SCENE_WIDTH = 800;
    
    //freezer
    short freePosY = (short)((SCENE_HEIGHT)/2);
    byte freeCurrentSpeed = 4;
    byte freeDirectionY = 0;
    byte freeDirectionX = 0;
    short freePosX = (short)(SCENE_WIDTH - SCENE_WIDTH);
    
    //Glubin
    short gluPosY = (short)((SCENE_HEIGHT)/2);
    short gluPosX = (short)(SCENE_WIDTH - (SCENE_WIDTH/6)); 
    
    //Bola
    short ballCenterX = 0;
    byte ballCurrentSpeedX = 3;
    byte ballDirectionX = 0;
 
    
    
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
        
        //free dorado
        Image image3= new Image(getClass().getResourceAsStream("/imagenes/dorado.png"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setX(freePosX);
        imageView3.setY(freePosY);
        
        //free patada
        Image image4= new Image(getClass().getResourceAsStream("/imagenes/puñetazo.png"));
        ImageView imageView4 = new ImageView(image4);
        imageView3.setX(freePosX);
        imageView3.setY(freePosY);
        
        //free bolas
        Image image5= new Image(getClass().getResourceAsStream("/imagenes/lanzandobola.png"));
        ImageView imageView5 = new ImageView(image5);
        imageView3.setX(freePosX);
        imageView3.setY(freePosY);
        
        
                //enemigo
        Image image6= new Image(getClass().getResourceAsStream("/imagenes/glubin.png"));
        ImageView imageView6 = new ImageView(image6);
        imageView6.setX(gluPosX);
        imageView6.setY(gluPosY);
        root.getChildren().add(imageView6);
        
        
                //enemigo2
        Image image7= new Image(getClass().getResourceAsStream("/imagenes/glubin2.png"));
        ImageView imageView7 = new ImageView(image7);
        imageView7.setX(freePosX);
        imageView7.setY(freePosY);
        
        //Bola
        Circle circleBall = new Circle();
        circleBall.setRadius(7);  
        circleBall.setFill(Color.WHITE);
        root.getChildren().add(circleBall);
        
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
                
                    
                 case T:
                    imageView2.setImage(image3);
                    break;   
                    
                case V:
                    imageView2.setImage(image2);
                    break;     
                    
                 case P:
                     imageView2.setImage(image4);
                    break;   
                    
                case B:
                    imageView2.setImage(image5);
                    ballDirectionX = 1;
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
                    
                case P:
                     imageView2.setImage(image2);
                    break;   
                    
                case B:
                     imageView2.setImage(image2);
                     ballDirectionX = 1;
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
                
             
                // ANIMACIÓN DE LA BOLA
                circleBall.setCenterX(ballCenterX);
                ballCenterX += ballCurrentSpeedX * ballDirectionX;
                if(ballCenterX >= SCENE_WIDTH) {
                    ballDirectionX = 0;
                    circleBall.setCenterX(freePosX);
                    circleBall.setCenterY(freePosY);
                    ballCenterX = 0;
                    //la bola se cree que sigue fuera hay que actualizar la variable
                }
        }));
        
         timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}
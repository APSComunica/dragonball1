package es.andresp.dragonball1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 470;
    final short SCENE_WIDTH = 800;
    final short TEXT_SIZE = 24;
    
    //freezer
    short freePosY = (short)((SCENE_HEIGHT)/2);
    byte freeCurrentSpeed = 4;
    byte freeDirectionY = 0;
    byte freeDirectionX = 0;
    short freePosX = (short)(SCENE_WIDTH - SCENE_WIDTH);
    
    //Glubin
    short gluPosY = (short)((SCENE_HEIGHT)/2);
    short gluPosX = (short)(SCENE_WIDTH - (SCENE_WIDTH/6)); 
    byte gluDirectionY = 1;
    
    
    //Bola
    short ballCenterX = freePosX;
    byte ballCurrentSpeedX = 3;
    byte ballDirectionX = 0;
    short ballCenterY = freePosY;
 
    //Bola2 enemigo
    short ball2CenterX = 0;
    byte ball2CurrentSpeedX = 3;
    byte ball2DirectionX = 1;
    short ball2CenterY = 0;
    byte ball2CurrentSpeedY = 3;
    byte ball2DirectionY = 1;
    
    
    
    // Cuadros de texto para las puntuaciones
    Text textScore;
    Text textHighScore;
    // Puntuación actual
    int score;
    // Puntuación máxima
    int highScore;
    
    
   //CUADRADO FREE
     short freeHeight = 4;
     short freeWidth = 100;
     
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
        
                
        
        //free bolas dorado
        Image image8= new Image(getClass().getResourceAsStream("/imagenes/lanzandoboladora.png"));
        ImageView imageView8 = new ImageView(image8);
        imageView8.setX(freePosX);
        imageView8.setY(freePosY);
        
        
        //Bola
        Circle circleBall = new Circle();
        circleBall.setRadius(7);  
        circleBall.setFill(Color.WHITE);
        root.getChildren().add(circleBall);
        
        
        //bola aleatoria
        Circle circleBall2 = new Circle();
        circleBall2.setCenterX(gluPosX);
        circleBall2.setCenterY(gluPosY);
        circleBall2.setRadius(7);  
        circleBall2.setFill(Color.RED);
        root.getChildren().add(circleBall2);

        
        
        //rectangulo ATRAS freezer colision
        Rectangle rectangle1 = new Rectangle(freeHeight,freeWidth);
        root.getChildren().add(rectangle1);
        rectangle1.setFill(Color.YELLOW);
        rectangle1.setX(freePosX);
        rectangle1.setY(freePosY); 
        
        //rectangulo ADELANTE freezer colision
        Rectangle rectangle2 = new Rectangle(freeHeight,freeWidth);
        root.getChildren().add(rectangle2);
        rectangle2.setFill(Color.RED);
        rectangle2.setX(freePosX + 90);
        rectangle2.setY(freePosY); 
        
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
                    ballCenterY = (short) (freePosY + 35);
                    ballCenterX = (short) (freePosX + 80);
                    circleBall.setCenterY(ballCenterY);
                    circleBall.setCenterX(ballCenterX);
                    ballDirectionX = 1;
                    break;     
 
                case D:
                    imageView2.setImage(image8);
                    ballCenterY = (short) (freePosY + 35);
                    ballCenterX = (short) (freePosX + 80);
                    circleBall.setCenterY(ballCenterY);
                    circleBall.setCenterX(ballCenterX);
                    ballDirectionX = 1;
                    break; 
            }
        });
        
        
        
        
        
        //Vidas
        // Panel para mostrar textos (puntuaciones)
        HBox paneTextScore = new HBox();
        paneTextScore.setTranslateY(20);
        paneTextScore.setMinWidth(SCENE_WIDTH);
        paneTextScore.setAlignment(Pos.CENTER);
        root.getChildren().add(paneTextScore);

        // Texto de etiqueta para la puntuación
        Text textTitleScore = new Text("Freezer: ");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.WHITE);
        // Texto para la puntuación
        textScore = new Text("3");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
        // Texto de etiqueta para la puntuación máxima
        Text textTitleMaxScore = new Text("          Glubin Enemigo: ");
        textTitleMaxScore.setFont(Font.font(TEXT_SIZE));
        textTitleMaxScore.setFill(Color.WHITE);
        // Texto para la puntuación máxima
        textHighScore = new Text("3");
        textHighScore.setFont(Font.font(TEXT_SIZE));
        textHighScore.setFill(Color.WHITE);

        // Añadir los textos al panel reservado para ellos 
        paneTextScore.setSpacing(10);
        paneTextScore.getChildren().add(textTitleScore);
        paneTextScore.getChildren().add(textScore);
        paneTextScore.getChildren().add(textTitleMaxScore);
        paneTextScore.getChildren().add(textHighScore);
        
        
        
        
        
         
 
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
                    break;  
                    
                case D:
                    imageView2.setImage(image3);   
                    break;
            }
        });
        

        Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                // ANIMACIÓN DE Free
                rectangle1.setY(freePosY);
                rectangle1.setX(freePosX); 
                rectangle2.setX(freePosX + 90);
                rectangle2.setY(freePosY);
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
                if(ballCenterX >= SCENE_WIDTH + 10) {
                    ballDirectionX = 0;
                    ballCenterX = -10;
                    ballCenterY = freePosY;
                }
                
                
                //Movimiento glubin
                imageView6.setY(gluPosY);
                gluPosY += freeCurrentSpeed * gluDirectionY;
                if(gluPosY <= 0 || gluPosY >= SCENE_HEIGHT) {
                    gluDirectionY = 0;
                }
                if(gluPosY <= 0) {
                    gluDirectionY = 1;
                } else if (gluPosY >= (SCENE_HEIGHT - 100)) {
                    gluDirectionY = -1;
                }

                
                
                
                
                // ANIMACIÓN DE LA BOLA2
                    circleBall2.setCenterX(ball2CenterX);
                    circleBall2.setCenterY(ball2CenterY);
                    ball2CenterX += ball2CurrentSpeedX * ball2DirectionX;
                    ball2CenterY += ball2CurrentSpeedY * ball2DirectionY;
                    
                    
                    
                // Control de rebote horizontal
                if(ball2CenterX >= SCENE_WIDTH) {
                    if(score < 0) {
                            score = 0;
                            textHighScore.setText(String.valueOf(highScore));
                        }
                        score = 3;
                        textScore.setText(String.valueOf(score));
                    ball2DirectionX = -1;
                } else if(ball2CenterX <= 0){
                    ball2DirectionX = 1;
                }
                // Control de rebote vertical
                if(ball2CenterY >= SCENE_HEIGHT) {
                    ball2DirectionY = -1;
                } else if(ball2CenterY <= 0){
                    ball2DirectionY = 1;
                }
              
                
                //colsion hay que poner 4 rectangulos
                // DETECCIÓN DE COLISIÓN 1 DE BOLA Y FREE
                    Shape shapeCollision = Shape.intersect(circleBall2, rectangle1);
                    boolean colisionVacia = shapeCollision.getBoundsInLocal().isEmpty();
                    if(colisionVacia == false && ball2DirectionX == 1) {
                        ball2DirectionX = -1;
                        score--;
                        textScore.setText(String.valueOf(score));
                    }   
  
                
                    
                // DETECCIÓN DE COLISIÓN 2 DE BOLA Y FREE
                    Shape shapeCollision2 = Shape.intersect(circleBall2, rectangle2);
                    boolean colisionVacia2 = shapeCollision.getBoundsInLocal().isEmpty();
                    if(colisionVacia2 == false && ball2DirectionX == -1) {
                        ball2DirectionX = 1;
                        score--;
                        textScore.setText(String.valueOf(score));
                    }       
                    
                    
                    
                    
        }));
        
         timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}
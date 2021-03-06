package es.andresp.dragonball1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
    final short TEXT_SIZE2 = 50;
    
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
    byte ballCurrentSpeedX = 30;
    byte ballDirectionX = 0;
    short ballCenterY = freePosY;
 
    
    //Bola3TRANSFORMADO
    short ballCenter3X = freePosX;
    byte ballCurrentSpeed3X = 30;
    byte ballDirection3X = 0;
    short ballCenter3Y = freePosY;
    
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
    Text textScore2;
    // Puntuación actual
    int score = 5;
    // Puntuación máxima
    int highScore;
    // Puntuación actual2
    int score2 = 5;
    
   //CUADRADOS FREE
     short freeHeight = 4;
     short freeWidth = 100;
     short freeHeight2 = 90;
     short freeWidth2 = 4;
   
     //Cuadrado enemigo
     short gluHeight = 20;
     short gluWidth = 100;
     
     
     //Jefe final
     int esperarsegundos2 = 6;

    //variable timeline fina
     Timeline timelinefinal;
     
    // Ronda final
    int esperarsegundos = 5;
    Text textScore4;
    Text textHighScore4;
    Timeline timelinefinal2;
    
    
    //variable timeline fina
     Timeline timeline;
    
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
        
        //Primer escenario
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
        
        
        //Ultimo escenario
        Image image9 = new Image(getClass().getResourceAsStream("/imagenes/ultimo.png"));
        ImageView imageView9 = new ImageView(image9);
        
        
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

        
        //Bolatransformado
        Circle circleBall3 = new Circle();
        circleBall3.setRadius(7);  
        circleBall3.setFill(Color.YELLOW);
        root.getChildren().add(circleBall3);
        
        
        //rectangulo ATRAS freezer colision
        Rectangle rectangle1 = new Rectangle(freeHeight,freeWidth);
        root.getChildren().add(rectangle1);
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.setX(freePosX);
        rectangle1.setY(freePosY); 
        
        //rectangulo ADELANTE freezer colision
        Rectangle rectangle2 = new Rectangle(freeHeight,freeWidth);
        root.getChildren().add(rectangle2);
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setX(freePosX + 90);
        rectangle2.setY(freePosY); 
        
        
        
        //rectangulo ARRIBA freezer colision
        Rectangle rectangle3 = new Rectangle(freeHeight2,freeWidth2);
        root.getChildren().add(rectangle3);
        rectangle3.setFill(Color.TRANSPARENT);
        rectangle3.setX(freePosX);
        rectangle3.setY(freePosY + 100); 
        
        //rectangulo ABAJO freezer colision
        Rectangle rectangle4 = new Rectangle(freeHeight2,freeWidth2);
        root.getChildren().add(rectangle4);
        rectangle4.setFill(Color.TRANSPARENT);
        rectangle4.setX(freePosX);
        rectangle4.setY(freePosY); 
        
        //rectangulo GLUBIN colision
        Rectangle rectangle5 = new Rectangle(gluHeight,gluWidth);
        root.getChildren().add(rectangle5);
        rectangle5.setFill(Color.TRANSPARENT);
        rectangle5.setX(gluPosX);
        rectangle5.setY(gluPosY);

        
        // DIBUJO DE LA RED que no debe pasar
        for(int i=0; i<SCENE_HEIGHT; i+=30) {
        Line line = new Line(SCENE_WIDTH/2, i, SCENE_WIDTH/2, i+10);
        line.setStroke(Color.WHITE);
        line.setStrokeWidth(4);
        root.getChildren().add(line);
        }
        
        
        // Terminar partida texto
        HBox hbox = new HBox();
        root.getChildren().add(hbox);
        hbox.setTranslateY(30);
        
        VBox vbox = new VBox();
        hbox.getChildren().add(vbox);
        vbox.setVisible(false);


        Label label = new Label("Se acabó la partida");
        label.setFont(Font.font(TEXT_SIZE));
        vbox.getChildren().add(label);
        
        
        HBox hbox2 = new HBox();
        root.getChildren().add(hbox2);
        hbox2.setTranslateY(50);
        
        VBox vbox2 = new VBox();
        hbox2.getChildren().add(vbox2);
        vbox2.setVisible(false);
        
        
        Label label2 = new Label("Transformar a la T y dispara a la D");
        label2.setFont(Font.font(TEXT_SIZE));
        vbox2.getChildren().add(label2);


        HBox hbox3 = new HBox();
        root.getChildren().add(hbox3);
        hbox3.setTranslateY(70);
        
        VBox vbox3 = new VBox();
        hbox3.getChildren().add(vbox3);
        vbox3.setVisible(false);
        
        
        Label label3 = new Label("Haz que el namekiano llegue a 10");
        label3.setFont(Font.font(TEXT_SIZE));
        vbox3.getChildren().add(label3);

        HBox hbox4 = new HBox();
        root.getChildren().add(hbox4);
        hbox4.setTranslateY(70);
        hbox4.setTranslateY(70);
        
        VBox vbox4 = new VBox();
        hbox4.getChildren().add(vbox4);
        vbox4.setVisible(false);
        
        
        Label label4 = new Label("Has ganado");
        label4.setFont(Font.font(TEXT_SIZE2));
        vbox4.getChildren().add(label4);
        
        HBox hbox5 = new HBox();
        root.getChildren().add(hbox5);
        hbox5.setTranslateY(70);
        hbox5.setTranslateY(70);
        
        VBox vbox5 = new VBox();
        hbox5.getChildren().add(vbox5);
        vbox5.setVisible(false);
        
        
        Label label5 = new Label("Has perdido");
        label5.setFont(Font.font(TEXT_SIZE2));
        vbox5.getChildren().add(label5);
        
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
                    ballCenter3Y = (short) (freePosY + 35);
                    ballCenter3X = (short) (freePosX + 80);
                    circleBall3.setCenterY(ballCenter3Y);
                    circleBall3.setCenterX(ballCenter3X);
                    ballDirection3X = 1;
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
        textScore = new Text(String.valueOf(score));
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
       
        // Texto de etiqueta para la puntuación máxima
        Text textTitleScore2 = new Text("Namekiano: ");
        textTitleScore2.setFont(Font.font(TEXT_SIZE));
        textTitleScore2.setFill(Color.WHITE);
       
        // Texto para la puntuación
        textScore2 = new Text(String.valueOf(score2));
        textScore2.setFont(Font.font(TEXT_SIZE));
        textScore2.setFill(Color.WHITE);

        // Añadir los textos al panel reservado para ellos 
        paneTextScore.setSpacing(70);
        paneTextScore.getChildren().add(textTitleScore);
        paneTextScore.getChildren().add(textScore);
        paneTextScore.getChildren().add(textTitleScore2);
        paneTextScore.getChildren().add(textScore2);
        
        
        
        
        
         
 
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
        
        

        timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                // ANIMACIÓN DE Free
                rectangle1.setY(freePosY);
                rectangle1.setX(freePosX); 
                rectangle2.setX(freePosX + 90);
                rectangle2.setY(freePosY);
                rectangle3.setY(freePosY + 100);
                rectangle3.setX(freePosX); 
                rectangle4.setX(freePosX);
                rectangle4.setY(freePosY);
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
                    //Hacer que pare todo
                }
                
                
                // ANIMACIÓN DE LA BOLA TRANSFORMADO
                circleBall3.setCenterX(ballCenter3X);
                ballCenter3X += ballCurrentSpeed3X * ballDirection3X;
                if(ballCenter3X >= SCENE_WIDTH + 10) {
                    ballDirection3X = 0;
                    ballCenter3X = -10;
                    ballCenter3Y = freePosY;
                    //Hacer que pare todo
                }
                
                //Movimiento glubin
                rectangle5.setY(gluPosY);
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
                boolean colisionVacia2 = shapeCollision2.getBoundsInLocal().isEmpty();
                if(colisionVacia2 == false && ball2DirectionX == -1) {
                    ball2DirectionX = 1;
                    score--;
                    textScore.setText(String.valueOf(score));
                }       
                    
                 
                    
                    
                // DETECCIÓN DE COLISIÓN 3 DE BOLA Y FREE
                Shape shapeCollision3 = Shape.intersect(circleBall2, rectangle3);
                boolean colisionVacia3 = shapeCollision3.getBoundsInLocal().isEmpty();
                if(colisionVacia3 == false && ball2DirectionY == -1) {
                    ball2DirectionY = 1;
                    score--;
                    textScore.setText(String.valueOf(score));
                }   
                    
                    
                    
                    
                // DETECCIÓN DE COLISIÓN 4 DE BOLA Y FREE
                Shape shapeCollision4 = Shape.intersect(circleBall2, rectangle4);
                boolean colisionVacia4 = shapeCollision4.getBoundsInLocal().isEmpty();
                if(colisionVacia4 == false && ball2DirectionY == 1) {
                    ball2DirectionY = -1;
                    score--;
                    textScore.setText(String.valueOf(score));
                }    
                    
                    
                    
                    
                    
                // DETECCIÓN DE COLISIÓN 1 DE BOLA Y GLUBIN
                Shape shapeCollision5 = Shape.intersect(circleBall, rectangle5);
                boolean colisionVacia5 = shapeCollision5.getBoundsInLocal().isEmpty();
                if(colisionVacia5 == false && ballDirectionX == 1) {
                    ball2DirectionY = 1;
                    score2--;
                    textScore2.setText(String.valueOf(score2));
                }       


                //Hacer que pare glubin, y la bola CUANDO GLUBIN TENGA DE 0 VIDAS
                if (score2 < 1){
                    gluDirectionY = 0;
                    ball2DirectionX = 0;
                    ball2DirectionY = 0;
                    vbox.setVisible(true);
                    vbox2.setVisible(true);
                    vbox3.setVisible(true);
                }    

                //Hacer que pare glubin, y la bola CUANDO FREE TENGA DE 0 VIDAS
                if (score < 1){
                    gluDirectionY = 0;
                    ball2DirectionX = 0;
                    ball2DirectionY = 0;
                    vbox.setVisible(false);
                    vbox2.setVisible(false);
                    vbox3.setVisible(false);
                    vbox4.setVisible(false);
                    vbox5.setVisible(true);
                }    



                //reiniciar partida con glubin nuevo
                if (score2 < 1){
                    timelinefinal.play ();
                }

                if (score < 1){
                timeline.stop();
                }



                // DETECCIÓN DE COLISIÓN 2 DE BOLA Y GLUBIN FREE TRANSFORMADO
                Shape shapeCollision6 = Shape.intersect(circleBall3, rectangle5);
                boolean colisionVacia6 = shapeCollision6.getBoundsInLocal().isEmpty();
                if(colisionVacia6 == false && ballDirection3X == 1) {
                    score2++;
                    textScore2.setText(String.valueOf(score2));
                }       


                //reiniciar partida con glubin nuevo
                if (score2 > 9){
                    timeline.stop();
                    vbox.setVisible(false);
                    vbox2.setVisible(false);
                    vbox3.setVisible(false);
                    vbox4.setVisible(true);
                }

                if (score < 1){
                    timeline.stop();
                }
                    
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        
        
        
        //Esperar para jefe final    
       // Panel para mostrar textos (Tiempo de espera)
        HBox paneTextScore4 = new HBox();
        paneTextScore4.setTranslateY(0);
        paneTextScore4.setMinWidth(SCENE_WIDTH);
        root.getChildren().add(paneTextScore4);

        // Texto para ronda final
        Text textTitleScore4 = new Text("Ronda final: ");
        textTitleScore4.setFont(Font.font(TEXT_SIZE));
        textTitleScore4.setFill(Color.RED);
        
        textScore4 = new Text(String.valueOf(esperarsegundos));
        textScore4.setFont(Font.font(TEXT_SIZE));
        textScore4.setFill(Color.RED);
        
        // Añadir los textos al panel reservado para ellos 
        paneTextScore4.getChildren().add(textTitleScore4);
        paneTextScore4.getChildren().add(textScore4);


        
        timelinefinal = new Timeline(
            // 0.017 ~= 60 FPS
        new KeyFrame(Duration.seconds(1), (ActionEvent ae) -> {
            timeline.stop();
       
        //Tiempo de espera ronda final    
        // Texto para esperar
        textScore4.setText(String.valueOf(esperarsegundos));
        esperarsegundos --;
        
            //reiniciar partida con glubin nuevo
            if (esperarsegundos < 1){
                timelinefinal2.play ();
            }
        
        }));
        
        timelinefinal.setCycleCount(esperarsegundos2);
        
        
      
        timelinefinal2 = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(1), (ActionEvent ae) -> {
                timeline.play();

         //freezer
         freePosY = (short)((SCENE_HEIGHT)/2);
         freeCurrentSpeed = 4;
         freeDirectionY = 0;
         freeDirectionX = 0;
         freePosX = (short)(SCENE_WIDTH - SCENE_WIDTH);

        //Glubin
         gluPosY = (short)((SCENE_HEIGHT)/2);
         gluPosX = (short)(SCENE_WIDTH - (SCENE_WIDTH/6)); 
         gluDirectionY = 1;


        //Bola
         ballCenterX = freePosX;
         ballCurrentSpeedX = 30;
         ballDirectionX = 0;
         ballCenterY = freePosY;

        //Bola2 enemigo
         ball2CenterX = 0;
         ball2CurrentSpeedX = 7;
         ball2DirectionX = 1;
         ball2CenterY = 0;
         ball2CurrentSpeedY = 7;
         ball2DirectionY = 1;

        // Puntuación actual
         score = 3;

        // Puntuación actual2
         score2 = 1;

        //CUADRADOS FREE
         freeHeight = 4;
         freeWidth = 100;
         freeHeight2 = 90;
         freeWidth2 = 4;

         //Cuadrado enemigo
         gluHeight = 20;
         gluWidth = 100;

         textScore2.setText(String.valueOf(score2));
         textScore.setText(String.valueOf(score));
         imageView6.setImage(image7);
         imageView1.setImage(image9);
         circleBall2.setFill(Color.BLUE);
         
         
            }));    
        
        timelinefinal2.setCycleCount(1);

        
        
    }
    
    
    //iniciar una segunda pantalla con un public void

    
    
    public static void main(String[] args) {
        
        launch();
    }

}

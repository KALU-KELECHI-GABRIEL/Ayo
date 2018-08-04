/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayo;

/**
 *
 * @author User
 */
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImageRotate extends Application {
    @Override 
    public void start(Stage stages){
      // int i = 2;
        Seeds sd = new Seeds();

        AboutScene pane5  = new AboutScene();
        Scene scene5 = new Scene(pane5);
        pane5.setOnMouseClicked(e->{
            System.out.println(e.getY());
        });
        Stage stage5 = new Stage();
        stage5.setScene(scene5);




        Stage stage4 = new Stage();
        settingsScene pane4 = new settingsScene();
        pane4.mp.setOnEndOfMedia(() -> {
            pane4.mp.setAutoPlay(true);
        });

//
//        pane4.s.setOnDragDetected(new EventHandler<MouseEvent>() {
//            public int i = 2;
//           @Override
//           public void handle(MouseEvent e) {
//               i++;
//               pane4.mp.volumeProperty().bind(pane4.s.majorTickUnitProperty());
//           }
//       });

        pane4.btneasy.setOnMouseMoved(e->{
            pane4.btneasy.setTextFill(Color.RED);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:red;-fx-background-color:blue;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");

        });
        pane4.btnhard.setOnMouseMoved(e->{
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.RED);
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:red;-fx-background-color:blue;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");
        });
        pane4.btnnormal.setOnMouseMoved(e->{
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.RED);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:red;-fx-background-color:blue;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");
        });
        pane4.btnmancala.setOnMouseMoved(e->{
            pane4.btnmancala.setTextFill(Color.RED);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:red;-fx-background-color:blue;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");

        });
        pane4.btnoware.setOnMouseMoved(e->{
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.RED);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:red;-fx-background-color:blue;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");
        });
        pane4.btn23.setOnMouseMoved(e->{
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.RED);
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:red;-fx-background-color:blue;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");
        });
        pane4.on.setOnMouseMoved(e->{
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:blue;-fx-background-color:red;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");
        });

        pane4.off.setOnMouseMoved(e->{
            pane4.btnmancala.setTextFill(Color.BLACK);
            pane4.btnoware.setTextFill(Color.BLACK);
            pane4.btn23.setTextFill(Color.BLACK);
            pane4.btneasy.setTextFill(Color.BLACK);
            pane4.btnnormal.setTextFill(Color.BLACK);
            pane4.btnhard.setTextFill(Color.BLACK);
            pane4.on.setStyle("-fx-border-color:blue;-fx-background-color:red;");
            pane4.off.setStyle("-fx-border-color:red;-fx-background-color:blue;");
        });
        pane4.on.setOnMouseClicked(e->{
            if(pane4.mp.getStatus().equals(Status.PLAYING)){
                pane4.mp.pause();
                pane4.off.setTranslateX(100);
                pane4.off.setTranslateY(500);
//                     pane4.off.setScaleX(0.7);
//                     pane4.off.setScaleY(0.7);
                pane4.getChildren().remove(pane4.getChildren().size() -1);
                pane4.getChildren().add(pane4.off);
            }
//                }else{
//                    pane4.mp.play();
//                    pane4.on.setLayoutX(100);
//                     pane4.on.setLayoutY(500);
//                     pane4.getChildren().remove(pane4.getChildren().size() -1);
//                     pane4.getChildren().add(pane4.on);
//                }

        });
        pane4.off.setOnMouseClicked(e->{
            if(pane4.mp.getStatus().equals(Status.PAUSED)){
                pane4.mp.play();
                pane4.getChildren().remove(pane4.getChildren().size() -1);
                pane4.getChildren().add(pane4.on);
            }
//                }else{
//                    pane4.mp.play();
//                    pane4.on.setLayoutX(100);
//                     pane4.on.setLayoutY(500);
//                     pane4.getChildren().remove(pane4.getChildren().size() -1);
//                     pane4.getChildren().add(pane4.on);
//                }

        });
        Scene scene4 = new Scene(pane4);
        stage4.setScene(scene4);



        Stage stage3 = new Stage();
        secondScene pane3  = new secondScene();



//            ImageView imm = new ImageView("image/player1.jpg");
//            imm.setTranslateX(16);
//            imm.setTranslateY(274);
//            imm.setOnMouseClicked(e->{
//                stages.show();
//                stage3.close();
//            });
//
//            ImageView imm1 = new ImageView("image/player2.jpg");
//            imm1.setTranslateX(574);
//            imm1.setTranslateY(274);
//
//            ImageView imm2 = new ImageView("image/resume.png");
//            imm2.setTranslateX(16);
//            imm2.setTranslateY(447);
//
//            ImageView imm3 = new ImageView("image/settings.png");
//            imm3.setTranslateX(574);
//            imm3.setTranslateY(447);
//
//            ImageView imm4 = new ImageView("image/about.png");
//            imm4.setTranslateX(17);
//            imm4.setTranslateY(610);
//
//            ImageView imm5 = new ImageView("image/help.png");
//            imm5.setTranslateX(574);
//            imm5.setTranslateY(610);



            //enter settings


        Scene scene3 = new Scene(pane3);
//        stage3.setHeight(pane3.im.getFitHeight());
        stage3.setWidth(pane3.getWidth());
        stage3.setScene(scene3);
        pane4.backB.setOnMouseClicked(e->{
            stage3.show();
            stage4.close();
        });
                //for pane5 backButton
        pane5.backB.setOnMouseClicked(e->{
            stage3.show();
            stage5.close();
        });

        Stage stage1 = new Stage();

        Stage stage2 = new Stage();
        Scenes pane2 = new Scenes();
        Scene scene2 = new Scene(pane2);

        pane2.mp.setOnEndOfMedia(() -> {
            stage2.close();
            stage1.show();
        });
        stage2.setScene(scene2);
        stage2.show();

        background pane1 = new background();

        pane1.pimage.setOnMouseClicked(e->{
           // stage.show();
            stage3.show();
            stage1.close();
        });
        Scene scene1 = new Scene(pane1);
        stage1.setScene(scene1);

        rot pane = new rot();
        Pane p1 = new Pane();
        ImageView backB1 = new ImageView("image/AgainBack.png");
        backB1.setScaleX(0.6);
        backB1.setScaleY(0.6);
        p1.getChildren().add(backB1);
        VBox vb = new VBox();
        vb.getChildren().addAll(p1,pane);
        pane.setOnMouseClicked(e -> pane.play());
        backB1.setOnMouseClicked(e->{
            stage3.show();
            stages.close();
        });
        Rotate r1 = new Rotate();
        r1.setAngle(45);
        r1.setAxis(Rotate.X_AXIS);
        Camera c = new PerspectiveCamera();
        c.getTransforms().addAll(r1);
        Scene scene = new Scene (vb);
//        scene.setFill(Color.DARKRED);
        scene.setCamera(c);
        stages.setResizable(false);
        stages.setScene(scene);
    }
    
//    public static void main(String[] args){
//        Application.launch(args);
//    }
}

class rot extends Pane{
    private final Image m = new Image("image/AyoPic.png");
    private final ImageView im = new ImageView(m);
    ImageView backB = new ImageView("image/AgainBack.png");
    private final Timeline animation;
    private int r = 90;
    private final int height  = 800;
    private final int width = 694;
    rot(){
//         this.getChildren().add(im);
        add(im);
        this.setTranslateY(100);
        this.setScaleX(0.6);
        this.setScaleY(0.5);
        this.setScaleZ(0.6);
        this.r = 90;
        im.fitHeightProperty().bind(this.prefHeightProperty());
        im.fitWidthProperty().bind(this.prefWidthProperty());
        this.setHeight(height);
        this.setPrefHeight(width);

        animation = new Timeline(new KeyFrame(Duration.millis(50),e -> {
            moveImage();
         }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
}
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }


    public void play(){
        animation.play();
    }
    public void moveImage(){
        r++;
        if (r == 360){
            animation.stop();
            backB.setTranslateX(-0.0);
            backB.setScaleY(0.6);
            backB.setScaleX(0.6);
            //this.getChildren().add(backB);
        }
        this.setRotate(r);
        this.setRotationAxis(Rotate.Z_AXIS);
    }
}

class background extends BorderPane{
    private final ImageView image = new ImageView("image/ayoback.jpg");
      ImageView pimage = new ImageView("image/play.png");
      //Media video = new Media("file:///F:/Users/Phillz%20Mike/Documents/NetBeansProjects/CSC302Projects/src/Ayo/ayo.mp4");
      //MediaPlayer pv = new MediaPlayer(video);
      //MediaView sv = new MediaView(pv);
      
    background(){
        this.setPrefSize(1093, 694);
        image.fitHeightProperty().bind(this.prefHeightProperty());
        image.fitWidthProperty().bind(this.prefWidthProperty());
        //sv.setLayoutX(USE_PREF_SIZE);
        //pv.setAutoPlay(true);
        //pv.setVolume(0);
        /**sv.setScaleX(0.5);
        sv.setScaleY(0.5);
        //sv.fitHeightProperty().bind(this.prefHeightProperty());
       // sv.fitWidthProperty().bind(this.prefWidthProperty());
        sv.setX(161);
        sv.setY(419);
        sv.setFitHeight(400);
        sv.setFitWidth(1400);
//        sv.setTranslateX(161);
//        sv.setTranslateY(419);
//        sv.setFitHeight(400);
//        sv.setFitWidth(1400);
        add(image,sv);
        */
        add(image);
        this.setCenter(pimage);
       // this.setBottom(sv);

    }
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }
}

class secondScene extends Pane{
     ImageView im = new ImageView("image/ayoscene2.jpg");
     ImageView imm = new ImageView("image/player1.jpg");
     ImageView imm1 = new ImageView("image/player2.jpg");
     ImageView imm2 = new ImageView("image/resume.png");
     ImageView imm3 = new ImageView("image/settings.png");
     ImageView imm4 = new ImageView("image/about.png");
     ImageView imm5 = new ImageView("image/help.png");
    secondScene(){

        im.fitHeightProperty().bind(this.prefHeightProperty());
        im.fitWidthProperty().bind(this.prefWidthProperty());imm.setTranslateX(16);
        imm.setTranslateY(274);



        imm1.setTranslateX(574);
        imm1.setTranslateY(274);


        imm2.setTranslateX(16);
        imm2.setTranslateY(447);


        imm3.setTranslateX(574);
        imm3.setTranslateY(447);


        imm4.setTranslateX(17);
        imm4.setTranslateY(610);


        imm5.setTranslateX(574);
        imm5.setTranslateY(610);
        add(im,imm,imm1,imm2,imm3,imm4,imm5);
    }
    
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }
}

class settingsScene extends Pane{
    //Media m = new Media("file:///F:/Users/Phillz%20Mike/Documents/NetBeansProjects/CSC302Projects/src/Ayo/ayo.mp3");
    Media m = new Media(new File("src/Ayo/sound/ayo.mp3").toURI().toString());
    MediaPlayer mp = new MediaPlayer(m);
    MediaView mv = new MediaView(mp);
    private final ImageView mode = new ImageView("image/mode.png");//private Label pdifficulty = new Label("Mode");
    Button btneasy = new Button("Easy");
    Button btnnormal = new Button("Normal");
    Button btnhard = new Button("Hard");
    private final ImageView gametype = new ImageView("image/gametype.png");//Label pdifficulty1 = new Label("Game Type");
    Button btnmancala = new Button("Mancala");
    Button btnoware = new Button("Oware");
    Button btn23 = new Button("2-3");
    private final ImageView volume= new ImageView("image/volumev.png");// Label volume = new Label("Volume");
    //Button on = new Button("on");
    //Button off = new Button("off");
    ImageView on = new ImageView("image/unmute.png");
    ImageView off = new ImageView("image/mute(2).png");
   // Slider s = new Slider();
    ImageView backB = new ImageView("image/AgainBack.png");
    private final HBox h = new HBox();
    private final HBox h1 = new HBox();
    private final HBox h2 = new HBox();
    private final ImageView image = new ImageView("image/ayoback.jpg");
    settingsScene(){
        mp.setAutoPlay(true);
        image.fitHeightProperty().bind(this.prefHeightProperty());
        image.fitWidthProperty().bind(this.prefWidthProperty());
        mode.setTranslateX(100);
        mode.setTranslateY(250);
        add(image,mode);
        h.setTranslateX(100);
        h.setTranslateY(300);
        h.getChildren().addAll(btneasy, btnnormal, btnhard);
        add(h);
        mp.setOnEndOfMedia(() -> {
           mp.setAutoPlay(true);
           //primaryStage.show();

           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });

        gametype.setTranslateX(100);
        gametype.setTranslateY(450);
        add(gametype);
        h1.setTranslateX(100);
        h1.setTranslateY(500);
       // h.setAlignment(Pos.CENTER);
        h1.getChildren().addAll(btnmancala, btnoware, btn23);
        //h.getChildren().add(pdifficulty);
        //h.setAlignment(Pos.CENTER);
       // pdifficulty.setAlignment(Pos.TOP_LEFT);
        add(h1);
        //h.setAlignment(Pos.CENTER);
        volume.setTranslateX(100);
        volume.setTranslateY(650);

        //this.getChildren().add(volume);

       // h2.setTranslateX(100);
        //h2.setTranslateY(700);
        on.setTranslateX(50);
        on.setTranslateY(500);
        on.setScaleX(0.6);
        on.setScaleY(0.6);
        off.setTranslateX(-220);
        off.setTranslateY(400);
        off.setScaleX(0.3);
        off.setScaleY(0.3);

        backB.setScaleY(0.6);
        backB.setScaleX(0.6);
        //h2.getChildren().addAll(on,off);
        add(backB,on);
        this.on.fitHeightProperty().bind(this.minHeightProperty());
        this.on.fitWidthProperty().bind(this.minWidthProperty());
        this.setOnMouseClicked(e->{
            System.out.println(e.getX());
            System.out.println(e.getY());
        });

    }
    
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }

}

class AboutScene extends Pane{
    private final ImageView bg  = new ImageView("image/ayoback.jpg");
    ImageView backB  = new ImageView("image/AgainBack.png");
    private final Label about = new Label();
    AboutScene(){
        about.setText("This game was developed by Group 2. A project desi-\n"+"gned to show the variations of the Ayo game.\n"+"It w"
                + "orks for the oware, mancala , and the 2-3\n"+"gameplay of the Ayo Variations. The following\n"+"were involved in"
                + " the development of the game:\n"+"Timilehin Fasipe\nAnalogbe Chibueze\nAdebayo-Lateef Adetola\n Nifise\nSukanmi\n"
                + "Derek and Ayo.");
       //about.setStyle(-fx-border-color:blue;-fx-background-color:red;);
        about.setFont(Font.font(20));
        about.setTextFill(Color.BLACK);
        about.setTranslateX(106);
        about.setTranslateY(252);
        about.setPrefWidth(484);
        backB.setScaleX(0.6);
        backB.setScaleY(0.6);
        add(bg,backB,about);
    }
    
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }
}
class HelpScene extends Pane{
    private final ImageView bg  = new ImageView("image/ayoback.jpg");
    ImageView backB  = new ImageView("image/AgainBack.png");
    private final Label help = new Label();
    
    HelpScene(){
        help.setText("AYO: here who plays first picks 4 seed \nfrom he’s house pot and distribute it round the board anti-clockwise in direction\n if he’s last seed is placed on a hole with seeds he picks back all the seeds and begin to redistribute\n he stops playing when the last seed falls in an empty house pot. To score a point the player must make 4 \nseeds in any of his house pots or have his last seed fall in an opponent’s pot containing 3 seeds to make it 4 or his opponent\n makes a set of 4 in his house when the 4 seed is not the last seed.\n" +
                        "MANCALA: here, the first player picks 4 seeds from his house \nand distributes it round the board in anti-clockwise direction. \nIf his last seed falls in his house pot which is not empty,\n the player picks up all the seeds and then redistributes.\n This stops if the last seed falls in the opponent’s pot.\n To score a point the player must have his last seed fall \nin his house pot that has no seed which allows him to \nharvest that seed and the seeds in his opponent’s house\n opposite that pot.\n" +
                        "Evaluating the game status to check for when the game should end and how to determine the winner is the same for both variations\n" +
                        "•	If score difference exceeds 24");
       //about.setStyle(-fx-border-color:blue;-fx-background-color:red;);
        help.setFont(Font.font(20));
        help.setTextFill(Color.BLACK);   
        help.setTranslateX(106);
        help.setTranslateY(252);
        help.setPrefWidth(484);
        backB.setScaleX(0.6);
        backB.setScaleY(0.6);
        add(bg,backB,help);
    }
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayo;

/**
 *
 * @author Phillz Mike
 */
import Game.playing;
import Game.Bruce;
import Game.Diana;
import Game.Mancala;
import Game.Oware;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static Ayo.House.chops;
import java.io.File;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
public class Seeds extends Application{
    ImageView im1 = new ImageView("image/AgainBack.png");
    static Pane pane = new Pane();
    House[] player1 = new House[12];
    static boolean p1turn = true;
    public static byte diffLevel;
    public static String gameType;
    static playing game;
    static Game.AI ai;
    static Mancala mancala;
    static MediaPlayer p;
    public static Byte playerNo;
    static Label player = new Label("Player1's Turn");
    public static Scene scene;
    static Label scoreP1 = new Label();
    static Label scoreP2 = new Label();
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        shitting twice scene
        Scenes shittingTwice = new Scenes();
        Scene scene1 = new Scene(shittingTwice);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        
//        background scene stage2
        background pane2 = new background();
        Scene scene2 = new Scene(pane2);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
//        end of background stage
       
//        menu page scene
        secondScene pane3 = new secondScene();
        Scene scene3 = new Scene(pane3);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
//        end of menu page
        
//        settings page scene
        settingsScene pane4 = new settingsScene();
        Scene scene4 = new Scene(pane4);
        Stage stage4 =  new Stage();
        stage4.setScene(scene4);
//        end of settings page scene
        
//        aboutpage scene
        AboutScene pane5 = new AboutScene();
        Scene scene5 = new Scene(pane5);
        Stage stage5 = new Stage();
        stage5.setScene(scene5);
//        end of aboutpage scene
        
//        helppage Scenes
        HelpScene pane6 = new HelpScene();
        Scene scene6 = new Scene(pane6);
        Stage stage6 = new Stage();
        stage6.setScene(scene6);
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
        pane2.pimage.setOnMouseClicked(e->{
            stage3.show();
           stage2.close();
        });
//        when i click on the settings
        pane3.imm3.setOnMouseClicked(e->{
            stage4.show();
            stage3.close();
        });
        
//        when i click on about
        pane3.imm4.setOnMouseClicked(e->{
            stage5.show();
            stage3.close();
        });
        
//        when i click on the backbutton in settings stage4
        pane4.backB.setOnMouseClicked(e->{
            stage3.show();
            stage4.close();
        });
        
//        when i click on the backbtton in about stage5
        pane5.backB.setOnMouseClicked(e->{
           stage3.show();
           stage5.close();
        });
        
//        when  i click on the easy button in stage4 setings stage
        pane4.btneasy.setOnMouseClicked(e->{
            diffLevel = 0;
            pane4.btneasy.setTextFill(Color.DARKBLUE);
            pane4.btnnormal.setTextFill(Color.WHITE);
            pane4.btnhard.setTextFill(Color.WHITE);
        });
        pane4.btnnormal.setOnMouseClicked(e->{
            diffLevel = 1;
            pane4.btneasy.setTextFill(Color.WHITE);
            pane4.btnnormal.setTextFill(Color.DARKBLUE);
            pane4.btnhard.setTextFill(Color.WHITE);
        });
//        when i click on the hard button in stage4 settings stage
        pane4.btnhard.setOnMouseClicked(e->{
            diffLevel = 2;
            pane4.btnhard.setTextFill(Color.DARKBLUE);
            pane4.btneasy.setTextFill(Color.WHITE);
            pane4.btnnormal.setTextFill(Color.WHITE);
        });
//        when i click on the mancalla buttn in the stage4 settings
        pane4.btnmancala.setOnMouseClicked(e->{
            gameType = "M";
            pane4.btnmancala.setTextFill(Color.DARKBLUE);
            pane4.btnoware.setTextFill(Color.WHITE);
            pane4.btn23.setTextFill(Color.WHITE);
        });
        
//        when i click on the oware button in the stage4 settings
        pane4.btnoware.setOnMouseClicked(e->{
            gameType = "A";
            pane4.btnoware.setTextFill(Color.DARKBLUE);
            pane4.btnmancala.setTextFill(Color.WHITE);
            pane4.btn23.setTextFill(Color.WHITE);
        });
//        when i click on the 23 button i nthe stage4 settings
        pane4.btn23.setOnMouseClicked(e->{
            gameType = "T";
            pane4.btn23.setTextFill(Color.DARKBLUE);
            pane4.btnoware.setTextFill(Color.WHITE);
            pane4.btnmancala.setTextFill(Color.WHITE);
        });
//        when i click on the volume image int he stage4 settings
        pane4.on.setOnMouseClicked(e->{
            pane4.mp.stop();
            pane4.getChildren().remove(pane4.on);
             pane4.off.fitHeightProperty().bind(pane4.minHeightProperty());
        pane4.off.fitWidthProperty().bind(pane4.minWidthProperty());
            pane4.getChildren().add(pane4.off);
        });
//        when i click on the unmute image in the stage4 settings
        pane4.off.setOnMouseClicked(e->{
            pane4.mp.play();
            pane4.getChildren().remove(pane4.off);
            pane4.on.fitHeightProperty().bind(pane4.minHeightProperty());
        pane4.on.fitWidthProperty().bind(pane4.minWidthProperty());
            pane4.getChildren().add(pane4.on);
        });
        
        
//        when i click on the player1 in the main menu stage
//        pane3.imm.setOnMouseClicked(e->{
//           diffLevel = 0;
//            gameType = "M";
//            
//            playerNo = 1;
//            primaryStage.show();
//            stage3.close();
//        });
        
        
        shittingTwice.mp.setOnEndOfMedia(() -> {
            stage2.show();
            stage1.close();
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         });
        //when rhe game song ends
//        pane4.mp.setOnEndOfMedia(new Runnable(){
//            @Override
//            public void run() {
//                pane4.mp.setAutoPlay(true);
//                //primaryStage.show();
//                
//               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//            
//        });
       // theGuy();
        //primaryStage.setScene(scene);
        
        
         //when i click on the player1 in the main menu stage
        pane3.imm.setOnMouseClicked(e->{
          // diffLevel = 0;
          //  gameType = "M";
            
            playerNo = 1;
            
            theGuy();
            primaryStage.setScene(scene);
            primaryStage.show();
            pane4.mp.stop();
            stage3.close();
        });
        //when i click on the back button in paleyer 1
       im1.setOnMouseClicked(e->{
           stage3.show();
        primaryStage.close();
       });
        
       //when i click in the help scene inthe main menu stage
       pane3.imm5.setOnMouseClicked(e->{
          stage6.show();
          stage3.close();
       });
       
       //when i click on the backbutton in the help scene
       pane6.backB.setOnMouseClicked(e->{
          stage6.close();
          stage3.show();
       });
       
        //when i click on two players in the main menu stage
        pane3.imm1.setOnMouseClicked(e->{
            playerNo = 2;
            theGuy();
            scene.setCursor(Cursor.OPEN_HAND);
            primaryStage.setScene(scene);
//            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
            pane4.mp.stop();
            stage3.close();
        });
       
    }
    public void theGuy(){
        //Media m = new Media("file:///F:/Users/Phillz%20Mike/Documents/NetBeansProjects/CSC302Projects/src/Ayo/seed.mp3");
        Media m = new Media(new File("src/Ayo/sound/seed.mp3").toURI().toString());
        p = new MediaPlayer(m);
        MediaView sound = new MediaView(p);
        ImageView image = new ImageView("img/AyoHouse.png");

        if(gameType == null){
           Alert al = new Alert(Alert.AlertType.CONFIRMATION,"Please choose the mode u want to play",new ButtonType("Ayo!"), new ButtonType("Mancala!"), new ButtonType("Oware!"));
           al.setHeaderText("Choose Mode");
           al.showAndWait();
            switch (al.getResult().getText()) {
                case "Oware!":
                    gameType = "A";
                    break;
                case "Mancala!":
                    gameType = "M";
                    break;
                default:
                    gameType = "T";
                    break;
            }
            if(playerNo == 1){
            Alert diff = new Alert(Alert.AlertType.CONFIRMATION,"Please choose the difficulty level",new ButtonType("Novice"), new ButtonType("Amateur"),
                    new ButtonType("Professional"), new ButtonType("World Class"));
            diff.setHeaderText("Set Difficulty");
            diff.showAndWait();
               switch (diff.getResult().getText()) {
                   case "Novice":
                       diffLevel = 0;
                       break;
                   case "Amateur":
                       diffLevel = 1;
                       break;
                   case "Professional":
                       diffLevel = 2;
                       break;
                   case "World Class":
                       diffLevel =3;
                   default:
                       break;
               }
           
            }
        }
        if(gameType.equals("A")){
            game = new Oware(); 
        }
      else{
           game = new Mancala();
        }
        player.setFont(Font.font("Verdana", 20));
        player.setTextFill(Color.RED);
        if(!gameType.equals("T")){
            if(diffLevel==0)
                ai = new Bruce();
            else
                ai = new Diana();
        }
        for(int i=0;i<player1.length;i++){
            player1[i] = new House(4);
        }
        player.setTranslateX(450);
        player.setTranslateY(500);
        scoreP1.setFont(Font.font("Verdana", 20));
        scoreP1.setTextFill(Color.RED);
        scoreP2.setFont(Font.font("Verdana", 20));
        scoreP2.setTextFill(Color.RED);
        scoreP1.setText("P1 :" + chops[0]);
        scoreP2.setText("P2 :" + chops[1]);
        scoreP1.setTranslateX(100);
        scoreP1.setTranslateY(500);
        scoreP2.setTranslateX(1000);
        scoreP2.setTranslateY(500);
        VBox vb = new VBox();
        
        im1.setScaleX(0.6);
        im1.setScaleY(0.6);
        if(!pane.getChildren().contains(scoreP1)){
        pane.getChildren().add(scoreP1);
        pane.getChildren().add(scoreP2);
        pane.getChildren().add(player);
        pane.getChildren().add(image);
        pane.getChildren().addAll(House.allGroup);
        pane.getChildren().add(sound);
        im1.setTranslateX(0);
        im1.setTranslateY(0);
        pane.getChildren().add(im1);
        pane.setTranslateX(100);
        pane.setTranslateY(0);
         vb.getChildren().addAll(im1,pane);
        scene = new Scene(vb,1200,600);
        }
    }
}
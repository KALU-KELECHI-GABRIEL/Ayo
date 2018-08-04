/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayo;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Sphere;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.text.Font;
import static Ayo.Seeds.gameType;
import Game.charPositions;
import javafx.application.Platform;
import static Ayo.Seeds.game;
import static Ayo.Seeds.ai;
import static Ayo.Seeds.p;
import static Ayo.Seeds.playerNo;
import static Ayo.Seeds.player;
import static Ayo.Seeds.scoreP1;
import static Ayo.Seeds.scoreP2;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.scene.Node;
/**
 *
 * @author Phillz Mike
 */
public final class House extends Group{
    
    int index;
    static int formerI = 0;
    static double positionX = 886.5;
    int positionY = 48;
    ImageView image;
    static int count;
    List<Sphere> seeds;
    static List<House> allGroup = new ArrayList<>();
    public static int[] chops = new int[2];
    Label label = new Label();
    AyoSecond ayo = new AyoSecond();
    public static boolean playerTurn = true;
    public static boolean player2Turn = false;
    Image img = new Image("img/player1Home.png");
    double labelY;
    Alert al = new Alert(Alert.AlertType.INFORMATION,"Not Player's turn to play",ButtonType.OK);
    Alert win = new Alert(Alert.AlertType.INFORMATION,"",ButtonType.FINISH);
//    AI jarvis = new AI();
    charPositions conv = new charPositions();
    boolean lock = false;
    boolean lockL = true;
    static Lock locki = new ReentrantLock();
    public House(int n){
        count++;
        if(count>6)
            positionY = 225;
        image = new ImageView(img);
        seeds = new ArrayList<>();
        label.setFont(Font.font("Verdana", 40));
        label.setTextFill(Color.RED);
        label.setVisible(false);
        image.setTranslateX(positionX);
        image.setTranslateY(positionY);
        for(int i =0;i<n;i++){
            Sphere sphere = new Sphere(15);
            PhongMaterial p = new PhongMaterial();
            p.setDiffuseColor(Color.AQUAMARINE);
            sphere.setMaterial(p);
            DropShadow d = new DropShadow();
            d.setOffsetX(5.0);
            d.setOffsetY(5.0);
            d.setColor(Color.GRAY);
            sphere.setEffect(d);
            int randX = 50 + (int)(Math.random()*(img.getWidth()-100));
            int randY = 50 +(int)(Math.random()*(img.getHeight()-100));
            sphere.setTranslateX(image.getTranslateX() + randX);
            sphere.setTranslateY(image.getTranslateY() + randY);
            seeds.add(sphere);
        }
        positionX = increaseX();
        label.setTranslateX(image.getTranslateX() + img.getWidth()/2);
        label.setTranslateY(labelY);
        add(seeds);
        add(label);
        label.setText(String.valueOf(seeds.size()));
        this.setOnMouseEntered(e ->{
            label.setVisible(true);
            if(gameType.equals("T")){
                int x = (index+seeds.size()) % 12;
                allGroup.get(x).label.setVisible(true);
            }
        });
        this.setOnMouseExited(e ->{
            label.setVisible(false);
            clearLabel();
        });
        this.setOnMouseClicked(e ->{
           if(!checkForWin()){
               if(playerTurn){
                   
                if(index < 6){
                    switch (gameType) {
                        case "A":
                            {
                                Thread t =  new Thread(() -> {
                                    game.makemoves(game.moves(conv.convertint(index), seeds.size()));
                                }
                                );
                                t.start();
                                if(playerNo == 1){
                                    Thread t2 = new Thread(() -> {
                                        while(t.isAlive()){
                                            
                                        }
                                        playerTurn = false;
                                        player2Turn = true;
                                        changeLabel();
                                        char c= ai.movestomake(ai.getgamestate(game.pot()));
                                        System.out.println(c);
                                        game.makemoves(game.moves(c,game.pot()[conv.convertChar(c)] ));
                                        System.out.println("comp has played");
                                        changeLabel();
                                        playerTurn = true;
                                        player2Turn = false;
                                    });
                                    t2.start();
                                }else{
                                    playerTurn = false;
                                    player2Turn = true;
                                    changeLabel();
                                }            break;
                            }
                        case "T":
                            new Thread(()->{
                                ayo.moveP1(groupToArray(allGroup), chops, index);
                            }).start(); break;
                        case "M":
                            {
                                Thread t = new Thread(() ->{
                                    game.makemoves(game.moves(conv.convertint(index), seeds.size()));
                                });        t.start();
                                if(playerNo == 1){
                                    Thread t2 = new Thread(() -> {
                                        while(t.isAlive()){
                                            
                                        }
                                        playerTurn = false;
                                        player2Turn = true;
                                        changeLabel();
                                        char c= ai.movestomake(ai.getgamestate(game.pot()));
                                        System.out.println(c);
                                        game.makemoves(game.moves(c,game.pot()[conv.convertChar(c)] ));
                                        System.out.println("comp has played");
                                        changeLabel();
                                        playerTurn = true;
                                        player2Turn = false;
                                    });
                                    t2.start();
                                }else{
                                    Thread t1= new Thread(()->{
                                        while(t.isAlive()){
                                            
                                        }
                                        playerTurn = false;
                                        player2Turn = true;
                                        changeLabel();
                                    });
                                    t1.start();
                                    
                                }
                                break;
                            }
                        default:
                            break;
                    }
                }else{
                    al.setContentText("This is not part of player1's hole");
                    al.showAndWait();
                }
                
            }else if(player2Turn){
                if(index >= 6){
                    switch (gameType) {
                        case "A":
                            {
                                Thread t =  new Thread(() -> {
                                    game.makemoves(game.moves(conv.convertint(index), seeds.size()));
                                }
                                );           t.start();
                                if(playerNo == 1){
                                }
                                else{
                                    playerTurn = true;
                                    player2Turn = false;
                                    changeLabel();
                                }            break;
                            }
                        case "T":
                            new Thread(()->{
                                ayo.moveP2(groupToArray(allGroup), chops, index);
                            }).start(); break;
                        case "M":
                            {
                                Thread t = new Thread(() ->{
                                    game.makemoves(game.moves(conv.convertint(index), seeds.size()));
                                    changeLabel();
                                });        t.start();
                                if(playerNo == 1){
                                }else{
                                    new Thread(() ->{
                                        while(t.isAlive()){
                                            
                                        }
                                        playerTurn = true;
                                        player2Turn = false;
                                    }).start();
                                    
                                    
                                }           break;
                            }
                        default:
                            break;
                    }
                }else{
                    al.setContentText("This is not part of player2's hole");
                    al.showAndWait();
                }
            }
           }else{
               win.setHeaderText("Game Over!!!!");
               if(chops[0]>chops[1])
                   win.setContentText("Congrats Player1 is the winner!!!");
               else if(chops[0]==chops[1])
                   win.setContentText("Good Game, its a Draw");
               else if(chops[0]<chops[1] && playerNo==1)
                   win.setContentText("You just can't beat me this human");
               else
                   win.setTitle("Congrats Player2 is the winner!!!");
               win.showAndWait();
           }
        });
        index = formerI;
        formerI++;
        addToAllGroup();
    }
    private void addToAllGroup(){
        allGroup.add(this);
    }
    private void add(Node... m){
        this.getChildren().addAll(m);
    }

    private void add(List<Sphere> m) {
        this.getChildren().addAll(m);
    }
    
    public double increaseX(){
        if(count>6)
            labelY = image.getTranslateY()+img.getHeight()+10;
        if(count>6)
            return positionX+172.5;
        else if(count==6)
            return positionX;
        else
            labelY = image.getTranslateY()-10;
            return positionX-172.5;
    }
    public void removeSeeds(){
        Platform.runLater(() -> {
            seeds.clear();
            House.this.getChildren().clear();
            House.this.getChildren().add(label);
//            System.out.println(Arrays.toString(chops));
            scoreP1.setText("P1: " + chops[0]);
            scoreP2.setText("P2 : " + chops[1]);
            unlock();
        });
        
    }
    public boolean  checkForWin(){
        boolean p1Guyz = false;
        boolean p2Guyz = true;
        if(chops[0]>24||chops[1]>24)
            return true;
        for(int i=0;i<6;i++){
            if(!allGroup.get(i).seeds.isEmpty()){
                p1Guyz = true;
                break;
            }
        }
//        for(int i=6;i<12;i++){
//            if(!allGroup.get(i).seeds.isEmpty()){
//                p2Guyz = true;
//                break;
//            }
//        }
        return !p1Guyz || !p2Guyz;
    }
    public void addSeeds(){
        Platform.runLater(() -> {
            p.play();
            Sphere sphere = new Sphere(15);
            int randX = 50 + (int)(Math.random()*(img.getWidth()-100));
            int randY = 50 +(int)(Math.random()*(img.getHeight()-100));
            sphere.setTranslateX(image.getTranslateX() + randX);
            sphere.setTranslateY(image.getTranslateY() + randY);
            PhongMaterial ph = new PhongMaterial();
            ph.setDiffuseColor(Color.AQUAMARINE);
            sphere.setMaterial(ph);
            seeds.add(sphere);
            label.setText(String.valueOf(seeds.size()));
            House.this.getChildren().add(sphere);
            scoreP1.setText("P1: " + chops[0]);
            scoreP2.setText("P2 : " + chops[1]);
            p.getStartTime();
            unlock();
        });
        
    }
    public void unlock(){
        lock = false;
    }
     public void moveSeeds(int i){
        System.out.println(seeds.size());
        
        for(int j =index+1, k =j;j<index+1+seeds.size();j++,k++){
            if(k==allGroup.size())
                k=0;
            
            House.allGroup.get(k).addSeeds();
        }
    }
     public static void changeLabel(){
         Platform.runLater(()->{
             if(player.getText().equals("Player1's Turn"))
                player.setText("Player2's Turn");
             else
                 player.setText("Player1's Turn");
         });
         
     }
     public void clearLabel(){
         for(int i=0;i<12;i++){
             allGroup.get(i).label.setVisible(false);
         }
     }
      public int[] groupToArray(List<House> h){
        int[] x = new int[h.size()];
        for(int i=0;i<h.size();i++){
            x[i] = h.get(i).seeds.size();
        }
        return x;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayo;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author User
 */
public class Scenes extends Pane{
    private final ImageView image = new ImageView("image/mustsee3.png");
    //private final Media m = new Media("file:///D:/Users/Phillz%20Mike/Documents/NetBeansProjects/CSC302Projects/build/classes/Ayo/explode.mp3");
    private final Media m = new Media(new File("src/Ayo/sound/explode.mp3").toURI().toString());
    
    MediaPlayer mp = new MediaPlayer(m);
    private final MediaView mv = new MediaView(mp);
    private boolean playing = false;
     
    
    Scenes(){
//        this.getChildren().addAll(image,mv);
        add(image,mv);
        mp.setAutoPlay(true);
       // mp.getOnEndOfMedia();
    }
    public final void add(Node... m){
        this.getChildren().addAll(m);
    }
     public boolean isPlayed(){
         
        mp.setOnEndOfMedia(() -> {
            playing = false;
        });
      return playing;
    }
            
}

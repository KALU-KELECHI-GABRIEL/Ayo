/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Ayo.House.playerTurn;
import static Ayo.House.player2Turn;
import java.util.Arrays;
import static Ayo.House.chops;
/**
 *
 * @author USER
 */
public class Oware extends playing {
    Ayo.Ayo ayo = new Ayo.Ayo();
    public Oware() {
        super();
//        baby.displayBoard(game.getpot(),game.getscore());
//        System.out.println("\n");
    }
    
    @Override
    public void makemoves(List<Integer> moves) {
        int [] currentgame = game.getpot();
       chops = game.getscore();
       if(moves.isEmpty()==true){
           baby.displayBoard(game.getpot(),game.getscore());
       }
       for(int i:moves){
           currentgame[i]=currentgame[i]+1;
           game.setpot(currentgame);
           game.setpot(currentgame);
           try {
               Thread.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
            baby.displayBoard(game.getpot(), chops);
            ayo.sArrayToHouse(currentgame, chops);
           if(currentgame[i]==4 && player2Turn && i>5){
               
               currentgame[i]=0;
               chops[1]=chops[1]+4;
               game.setscore(chops);
               game.setpot(currentgame);
               try {
               Thread.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
               ayo.sArrayToHouse(currentgame, chops);
       baby.displayBoard(game.getpot(), chops);
           }else if(currentgame[i]==4 && player2Turn && i<6 && i!=moves.get(moves.size()-1)){
               currentgame[i]=0;
               chops[0]=chops[0]+4;
               game.setscore(chops);
               game.setpot(currentgame);
              try {
               Thread.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
              ayo.sArrayToHouse(currentgame, chops);
       baby.displayBoard(game.getpot(), chops);
           }else if(currentgame[i]==4 && player2Turn && i<6 && i==moves.get(moves.size()-1)){
               currentgame[i]=0;
               chops[1]=chops[1]+4;
               game.setscore(chops);
               ayo.sArrayToHouse(currentgame, chops);
               baby.displayBoard(game.getpot(), chops);
           }else if(currentgame[i]==4 && playerTurn && i>5&&i!=moves.get(moves.size()-1)){
               currentgame[i]=0;
               chops[1]=chops[1]+4;
               game.setscore(chops);
               game.setpot(currentgame);
               try {
               Thread.sleep(200);
               
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
               ayo.sArrayToHouse(currentgame, chops);
               baby.displayBoard(game.getpot(), chops);
           }else if(currentgame[i]==4 && playerTurn && i<6){
               currentgame[i]=0;
               chops[0]=chops[0]+4;
               game.setscore(chops);
               game.setpot(currentgame);
               try {
               Thread.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
               ayo.sArrayToHouse(currentgame, chops);
            baby.displayBoard(game.getpot(), chops);
           }else if(currentgame[i]==4 && playerTurn && i>5 && i==moves.get(moves.size()-1)){
               currentgame[i]=0;
               chops[0]=chops[0]+4;
               game.setscore(chops);
               game.setpot(currentgame);
               try {
               Thread.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
        ayo.sArrayToHouse(currentgame, chops);
       baby.displayBoard(game.getpot(), chops);
           }
//          ayo.sArrayToHouse(currentgame, chops); 
       }
        System.out.println("ChopsGuy" + Arrays.toString(chops));
       game.setpot(currentgame);
       game.setscore(chops);
//       ayo.sArrayToHouse(currentgame, chops);
        
       if(currentgame[moves.get(moves.size()-1)]!=0){
       check(conv.convertint(moves.get(moves.size()-1)),currentgame[moves.get(moves.size()-1)]);
       }
       else{
//           System.out.println("Current guy");
//           char c= ai.movestomake(ai.getgamestate(game.getpot()));
//           System.out.println(c);
//           player2Turn = false;
//           makemoves(moves(c,game.getpot()[conv.convertChar(c)] ));
       }
   }
    @Override
   public void check(char lastpot,int lastpotseeds){
       if(lastpotseeds!=1&&lastpotseeds>0&&lastpotseeds!=4){
           makemoves(moves(lastpot, lastpotseeds));
       }
    } 
}
    
    


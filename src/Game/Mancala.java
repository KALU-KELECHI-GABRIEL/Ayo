/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ayo.Ayo;
import static Ayo.House.playerTurn;
import static Ayo.House.player2Turn;
import static Ayo.House.chops;
/**
 *
 * @author USER
 */
public class Mancala extends playing {
    static Ayo ayo = new Ayo();
    static boolean turn = false;
    public Mancala() {
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
           return;
       }
       for(int i:moves){
           currentgame[i]=currentgame[i]+1;
           game.setpot(currentgame);
           try {
               Thread.sleep(300);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
           baby.displayBoard(game.getpot(), game.getscore());
           ayo.sArrayToHouse(game.getpot(), game.getscore());
       }
       game.setpot(currentgame);
       game.setscore(chops);
       if(currentgame[moves.get(moves.size()-1)]!=0){
            check(conv.convertint(moves.get(moves.size()-1)),currentgame[moves.get(moves.size()-1)]);
            turn = !turn;
       }
   }
    @Override
   public void check(char lastpot,int lastpotseeds){
       chops = game.getscore();
       int[] currentgame = game.getpot();
       if(lastpotseeds!=1&&lastpotseeds>0&& player2Turn &&conv.convertChar(lastpot)>=6){
           makemoves(moves(lastpot, lastpotseeds));
       }else if(lastpotseeds!=1&&lastpotseeds>0&& playerTurn &&conv.convertChar(lastpot)<=5){
           makemoves(moves(lastpot, lastpotseeds));
       }else if(lastpotseeds==1&& playerTurn &&conv.convertChar(lastpot)<=5){
           int upper = 11-conv.convertChar(lastpot);
           int i = currentgame[upper];
           currentgame[upper]=0;
           currentgame[conv.convertChar(lastpot)]=0;
           chops[0]=chops[0]+1+i;
           game.setpot(currentgame);
           game.setscore(chops);
            try {
               Thread.sleep(300);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
           ayo.sArrayToHouse(game.getpot(), chops);
           baby.displayBoard(game.getpot(), game.getscore());
           
       }else if(lastpotseeds==1&& player2Turn &&conv.convertChar(lastpot)>=6){
           int lower = 11- conv.convertChar(lastpot);
           int j = currentgame[lower];
           currentgame[lower]=0;
           currentgame[conv.convertChar(lastpot)]=0;
           chops[1]=chops[1]+1+j;
           game.setpot(currentgame);
           game.setscore(chops);
           try {
               Thread.sleep(300);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
           ayo.sArrayToHouse(game.getpot(), chops);
           baby.displayBoard(game.getpot(), game.getscore());
           
       }
    
   }    
}

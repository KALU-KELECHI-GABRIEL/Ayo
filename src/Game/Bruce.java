/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Bruce extends AI{

   
    
    @Override
    public char movestomake(List<Integer> gamestate) {
       for(int i:gamestate){
            System.out.println(conv.convertint(i));
        }
        System.out.println("");
        char c = conv.convertint(gamestate.get((int)(Math.random()*gamestate.size())));
        //System.out.println("Play: "+c);z
       return c;
    }

    @Override
    public List<Integer> getgamestate(int[] gamenow) {
    List<Integer> gamestate = new ArrayList<>();
        for(int i=0;i<gamenow.length;i++){
            if(i>=6 && gamenow[i]>0){
                gamestate.add(i);
            }
        }
        return gamestate;
    }
}

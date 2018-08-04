/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.List;

/**
 *
 * @author USER
 */
public abstract class AI {
    base game = new base();
    charPositions conv = new charPositions();
    public abstract char movestomake(List<Integer> gamestate);
    public abstract List<Integer> getgamestate(int[] gamenow);
    
}

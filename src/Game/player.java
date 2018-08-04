/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author USER
 */
public class player {
     private String Name;
    private boolean turn = false;
    public player(String name){
        this.Name=name;
    }
    public player(){
        
    }
    public boolean canplay(){
        return turn;
    }
    public void newturn(){
        turn = turn==false;
    }
    public void setname(String name){
        this.Name=name;
    }
}

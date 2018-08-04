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
public class Player {
    private String name;
    private boolean turn = false;
    public Player(String name){
        this.name=name;
    }
    public Player(){
        
    }
    public boolean canPlay(){
        return turn;
    }
    public void newTurn(){
        turn = turn==false;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}

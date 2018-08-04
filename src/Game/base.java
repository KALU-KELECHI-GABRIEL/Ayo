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
public class base {
    private  int[] pot = {4,4,4,4,4,4,4,4,4,4,4,4};
    private  int[] score = {0,0};
    //private board baby = new board();
    public  void setpot(int [] newpot){
        System.arraycopy(newpot, 0, pot, 0, pot.length);
    }
    public  int[] getpot(){
        return pot;
    }
    public  void setscore(int[] newscore){
        System.arraycopy(newscore, 0, score, 0, score.length);
    }
    public  int[] getscore(){
        return score;
    }
}

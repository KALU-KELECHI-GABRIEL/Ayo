/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public abstract class playing {
   board baby = new board();
   static base game = new base();
   public boolean status = true;
   player pc = new player("AI");
   player player1 = new player("player1");
   Scanner in = new Scanner(System.in);
   AI ai;
    charPositions conv = new charPositions();
    public playing() {
//        System.out.println("Who do you want to play Against?..........");
//        System.out.println("1. Bruce a simple guy but he's never patient just wants to play play play");
//        System.out.println("2.Diana she's complicated and belives her playing algorithm is flawless...do you dare?");
//        System.out.println("\n\nEnter 1 to play with Bruce\n\nEnter 2 to play with Diana");
//        int pik = pick();
//        if(pik==1){
//            ai = new Bruce();
//        }else if(pik==2){
//            ai=new Diana();
//        }
//        System.out.println("\n-----------------------------------------------------------------------\n");
//        
//        
    }
    private int pick(){
        System.out.print("\nChoice: ");
        int pik = in.nextInt();
        if(pik>2 && pik<0){
            System.out.println("No choice like that....");
            pick();
        }
        return pik;
    }
    
   public void begin(player p1,player p2,boolean gamestat){
       gamestat=canContinue(game.getpot(), game.getscore());
       if (gamestat==false){
           int [] currentgame = game.getpot();
           int [] currentscore = game.getscore();
           if(sumboard(currentgame)>=4){
               if(p1.canplay()==true){
                   currentscore[1]=currentscore[1]+sumboard(currentgame);
                   for(int i=0;i<currentgame.length;i++){
                       currentgame[i]=0;
                   }
               }else{
                   currentscore[0]=currentscore[0]+sumboard(currentgame);
                   for(int i=0;i<currentgame.length;i++){
                       currentgame[i]=0;
                   }
               }
               game.setpot(currentgame);
               game.setscore(currentscore);
               baby.displayBoard(game.getpot(),game.getscore());
           }
           if(game.getscore()[0]>game.getscore()[1]){
               System.out.println("PLAYER 1 WINS");
           }else if(game.getscore()[0]<game.getscore()[1]){
               System.out.println("PLAYER 2 WINS");
           }else{
               System.out.println("DRAW GAME");
           }
       }else{
       if(p1.canplay()==false && p2.canplay()==false){
           System.out.print("Who should play first[ 1:player1 2:pc ]: ");
           int choice = in.nextInt();
           if(choice==1){
               p1.newturn();
           }else if(choice==2){
               p2.newturn();
           }
           play(p1.canplay(),p2.canplay(),gamestat);
       }else{
       play(p1.canplay(),p2.canplay(),gamestat);
       }
   }
   }
    public boolean canContinue(int[]board,int[]scores){
       return !(sumboard(board)<=4||scores[1]-scores[0]>24 || scores[0]-scores[1]>24||scores[0]>24||scores[1]>24);
       
   }
   public int sumboard(int[]board){
       int sum=0;
       for (int i:board){
           sum= sum+i;
       }
       return sum;
   }
    public void play(boolean p1turn,boolean p2turn,boolean gamestat){
        char c; String choice;
       if(gamestat==true){
       if(p1turn==true){
           System.out.println("Player1 play(a-f): ");
            choice = in.next();
            c=choice.charAt(0);
            if(!(c>='a' && c<='f')){
                System.out.println("NOT YOUR POT NIGGA\n");
                play(player1.canplay(),pc.canplay(),gamestat);
            }
       }else if(p2turn==true){
           //System.out.println("PC play(A-F): ");
            //choice = in.next();
            c= ai.movestomake(ai.getgamestate(game.getpot()));
            System.out.println("\nPC will play: "+c+"\n");
//            if(!(c>='A' && c<='F')){
//                System.out.println("NOT YOUR POT NIGGA\n");
//                play(player1.canplay(),pc.canplay(),gamestat);
//            }
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
//       This line under is in the real class
//       makemoves(moves(c,game.getpot()[conv.convertChar(c)]));
       //baby.displayBoard(game.getpot(), game.getscore());
       pc.newturn();player1.newturn();
       begin(player1,pc,true);
   }else{
           begin(player1,pc,false);
       }
     }
    public List<Integer> moves(char c,int seeds){
       List<Integer> moves = new ArrayList<>();
       int start = conv.convertChar(c);
       if(game.getpot()[start]==0){
           return moves;
       }
       game.getpot()[start]=0;
       int movefrom;
       if(start<6){
           if(start==0){
               movefrom=1;
           }else{
               movefrom = start+1;
           }
       }else{
            if(start==11){
                movefrom=0;
            }else{
                movefrom =start+1;
            }
       }
       for(int i = start+1;i<=start+seeds;i++){
            if(movefrom==0){
               moves.add(movefrom);
               movefrom=1;
           }else if(movefrom>0 && movefrom<6){
               moves.add(movefrom);
               movefrom++;
           }
           else if(movefrom==11){
               moves.add(movefrom);
               movefrom=0;
           }else if(movefrom>5 && movefrom<11){
               moves.add(movefrom);
               movefrom++;
           }
       }
      return moves;
   }
    public int[] pot(){
        return game.getpot();
    }
    public abstract void makemoves(List<Integer> moves);
        
    
     public abstract void check(char lastpot,int lastpotseeds);
     
}

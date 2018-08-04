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
import static Ayo.Oware.game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Ayo.Oware.diffLevel;
public class Oware {
static board baby = new board();
   static oware2 game = new oware2();
   static playing haha = new playing();
   static String diffLevel;
//    public static void main(String[] args) {
//        haha.begin(haha.Player1, haha.pc, true);
//        List<Integer> moves = haha.moves('F', 4);
//        for(int i: moves){
//            System.out.print(i+"\t");
//    }
//        System.out.println("");
//        baby.displayBoard(game.getpot(), game.getscore());
//        System.out.println("--------------------------------------------------------");
//        int [] newscore = {0,4,5,5,5,5,5,5,5,5,4,0};
//        game.setpot(newscore);
//        baby.displayBoard(game.getpot(), game.getscore());
//    }
}
class oware2{
    static private  int[] pot = {4,4,4,4,4,4,4,4,4,4,4,4};
    static private  int[] score = {0,0};
    private board baby = new board();
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
class board{
    //oware1 game = new oware1();
    public void displayBoard(int [] pots,int [] scores){
        int i =0;
        System.out.println("a\tb\tc\td\te\tf\t\tN");
        for(;i<6;i++){
            System.out.print(pots[i]+"\t");
        }
        System.out.println("\t"+scores[0]+"\n");
        for(;i<pots.length;i++){
            System.out.print(pots[i]+"\t");
        }
        System.out.println("\t"+scores[1]);
        System.out.println("A\tB\tC\tD\tE\tF\t\tS");
        System.out.println("\n-----------------------------------------------------------------------\n");
    }

    }


    
class playing{
   board baby = new board();
   oware2 game = new oware2();
   public boolean status = true;
   Player pc = new Player("AI");
   Player Player1 = new Player("Player1");
   Scanner in = new Scanner(System.in);
    AIBrains bruce =new AIBrains();
    
   public void begin(Player p1,Player p2,boolean gamestat){
       gamestat=canContinue(game.getpot(), game.getscore());
       if (gamestat==false){
           int [] currentgame = game.getpot();
           int [] currentscore = game.getscore();
           if(sumboard(currentgame)==4){
               if(p1.canPlay()==true){
                   currentscore[1]=currentscore[1]+4;
                   for(int i=0;i<currentgame.length;i++){
                       currentgame[i]=0;
                   }
               }else{
                   currentscore[0]=currentscore[0]+4;
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
       if(p1.canPlay()==false && p2.canPlay()==false){
           System.out.println("What difficulty level do you want to play: ");
           diffLevel = in.next();
           System.out.print("Who should play first[ 1:Player1 2:pc ]: ");
           int choice = in.nextInt();
           if(choice==1){
               p1.newTurn();
           }else if(choice==2){
               p2.newTurn();
           }
           play(p1.canPlay(),p2.canPlay(),gamestat);
        }else{
             play(p1.canPlay(),p2.canPlay(),gamestat);
        }
        }
   }
   private void play(boolean p1turn,boolean p2turn,boolean gamestat){
       char c='a'; String choice;
       if(gamestat==true){
       if(p1turn==true){
           System.out.println("Player1 play(a-f): ");
            choice = in.next();
            c=choice.charAt(0);
            if(!(c>='a' && c<='f')){
                System.out.println("NOT YOUR POT NIGGA\n");
                play(Player1.canPlay(),pc.canPlay(),gamestat);
            }
       }else if(p2turn==true){
           bruce.movestomake();
           System.out.println("PC play(A-F): ");
            choice = in.next();
            c= choice.charAt(0);
            if(!(c>='A' && c<='F')){
                System.out.println("NOT YOUR POT NIGGA\n");
                play(Player1.canPlay(),pc.canPlay(),gamestat);
                
            }
       }
       makemoves(moves(c,game.getpot()[convertChar(c)]));
       //baby.displayBoard(game.getpot(), game.getscore());
       pc.newTurn();Player1.newTurn();
       begin(Player1,pc,true);
//           System.out.println(Arrays.toString(game.getpot()));
   }else{
           begin(Player1,pc,false);
       }
   }
   public List<Integer> moves(char c,int seeds){
       List<Integer> moves = new ArrayList<>();
       int start = convertChar(c);
       if(game.getpot()[start]==0){
           return moves;
       }
       game.getpot()[start]=0;
       int movefrom;
       if(start<6){
           if(start==0){
               movefrom=6;
           }else{
               movefrom = start-1;
           }
       }else{
            if(start==11){
                movefrom=5;
            }else{
                movefrom =start+1;
            }
       }
       for(int i = start+1;i<=start+seeds;i++){
            if(movefrom==0){
               moves.add(movefrom);
               movefrom=6;
           }else if(movefrom>0 && movefrom<6){
               moves.add(movefrom);
               movefrom--;
           }
           else if(movefrom==11){
               moves.add(movefrom);
               movefrom=5;
           }else if(movefrom>5 && movefrom<11){
               moves.add(movefrom);
               movefrom++;
           }
       }
      return moves;
   }
   
   public void makemoves(List<Integer> moves){
       int [] currentgame = game.getpot();
       int [] currentscore = game.getscore();
       if(moves.isEmpty()==true){
           baby.displayBoard(game.getpot(),game.getscore());
           return;
       }
       for (int i : moves) {
           currentgame[i]=currentgame[i]+1;
           game.setpot(currentgame);
           //baby.displayBoard(game.getpot(), game.getscore());
           if(currentgame[i]==4 && i>5){
               currentgame[i]=0;
               currentscore[1]=currentscore[1]+4;
               game.setscore(currentscore);
//               baby.displayBoard(game.getpot(), game.getscore());
           }
           if(currentgame[i]==4 && i<6){
               currentgame[i]=0;
               currentscore[0]=currentscore[0]+4;
               game.setscore(currentscore);
               //baby.displayBoard(game.getpot(), game.getscore());
           }
//           else if(currentgame[i]==4 && Player1.canPlay()==true && i>5){
//               currentgame[i]=0;
//               currentscore[1]=currentscore[1]+4;
//               game.setscore(currentscore);
//               //baby.displayBoard(game.getpot(), game.getscore());
//           }else if(currentgame[i]==4 && Player1.canPlay()==true && i<6){
//               currentgame[i]=0;
//               currentscore[0]=currentscore[0]+4;
//               game.setscore(currentscore);
//               //baby.displayBoard(game.getpot(), game.getscore());
//           }
       }
       game.setpot(currentgame);
       game.setscore(currentscore);
       baby.displayBoard(game.getpot(), game.getscore());
        try {
               Thread.sleep(500);
           } catch (InterruptedException ex) {
               Logger.getLogger(playing.class.getName()).log(Level.SEVERE, null, ex);
           }
       if(currentgame[moves.get(moves.size()-1)]!=0){
       check(convertint(moves.get(moves.size()-1)),currentgame[moves.get(moves.size()-1)]);
       }
   }
   private void check(char lastpot,int lastpotseeds){
       if(lastpotseeds!=1&&lastpotseeds>0){
           makemoves(moves(lastpot, lastpotseeds));
       }
   }
   
   public int convertChar(char c){
       int ans=0;
       switch(c){
           case 'a':
               ans=0;
               break;
           case 'b':
               ans=1;
               break;
           case 'c':
               ans = 2;
               break;
           case 'd':
               ans=3;
               break;
           case 'e':
               ans=4;
               break;
           case 'f':
               ans=5;
               break;
           case 'A':
               ans = 6;
               break;
           case 'B':
               ans=7;
               break;
           case 'C':
               ans =8;
               break;
           case 'D':
               ans = 9;
               break;
           case 'E':
               ans = 10;
               break;
           case 'F':
               ans = 11;
               break;
       }
       return ans;
   
   }
   public char convertint(int c){
       char ans=0;
       switch(c){
           case 0:
               ans='a';
               break;
           case 1:
               ans='b';
               break;
           case 2:
               ans = 'c';
               break;
           case 3:
               ans='d';
               break;
           case 4:
               ans='e';
               break;
           case 5:
               ans='f';
               break;
           case 6:
               ans = 'A';
               break;
           case 7:
               ans='B';
               break;
           case 8:
               ans ='C';
               break;
           case 9:
               ans = 'D';
               break;
           case 10:
               ans = 'E';
               break;
           case 11:
               ans = 'F';
               break;
       }
       return ans;
   
   }
   public boolean canContinue(int[]board,int[]scores){
       return !(sumboard(board)==4||scores[1]-scores[0]>24 || scores[0]-scores[1]>24);
       
   }
   public int sumboard(int[]board){
       int sum=0;
       for (int i:board){
           sum= sum+i;
       }
       return sum;
   }
}
class AIBrains{
    public void movestomake(){
        if(diffLevel.equalsIgnoreCase("Easy")){
        int[]currentboard = game.getpot();
//        System.out.println(Arrays.toString(currentboard));
        int[] currentScore = game.getscore();
        List<Integer>possiblemoves = new ArrayList<>();
        for(int i=6;i<=11;i++){
            if(currentboard[i]!=0){
                possiblemoves.add(i);
            }
        }
        System.out.println(possiblemoves);
        System.out.println(Arrays.toString(currentScore));
        int movetoplay = possiblemoves.get((int)(Math.random()*possiblemoves.size()));
        System.out.println("PC will PLAY: "+convertint(movetoplay));
        }
        else{
            System.out.println("This is not right");
            int[] tempArray = new int[game.getpot().length];
            System.arraycopy(game.getpot(), 0, tempArray, 0, tempArray.length);
            List<Integer>possiblemoves = new ArrayList<>();
            for(int i=6;i<=11;i++){
            if(game.getpot()[i]!=0){
                possiblemoves.add(i);
            }
            }
            
        }
    }
    public char convertint(int c){
       char ans=0;
       switch(c){
           case 0:
               ans='a';
               break;
           case 1:
               ans='b';
               break;
           case 2:
               ans = 'c';
               break;
           case 3:
               ans='d';
               break;
           case 4:
               ans='e';
               break;
           case 5:
               ans='f';
               break;
           case 6:
               ans = 'A';
               break;
           case 7:
               ans='B';
               break;
           case 8:
               ans ='C';
               break;
           case 9:
               ans = 'D';
               break;
           case 10:
               ans = 'E';
               break;
           case 11:
               ans = 'F';
               break;
       }
       return ans;
   
   }
}

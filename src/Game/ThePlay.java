/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ThePlay {
static board baby = new board();
   static base game = new base();
   static playing haha;
   static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        long TimeStart = System.currentTimeMillis();
        System.out.print("Enter M for Mancala\nOr A for Ayo\nChoice: ");
        String Choice = in.nextLine();
        if(null==Choice){
            System.out.println("Not a Choice Exiting........");
        }else switch (Choice) {
             case "M":
                 haha = new Mancala();
                 break;
             case "A":
                 haha = new Oware();
                 break;
             default:
                 System.out.println("Not a Choice Exiting........");
                 break;
         }
        System.out.println("");
        haha.begin(haha.player1, haha.pc, true);
        long TimeEnd = System.currentTimeMillis();
        long TimePlayed = (TimeEnd-TimeStart)/1000;
        int TimeMins = (int)(TimePlayed/60);
        int TimeSecs = (int)(TimePlayed%60);
        System.out.println("Game Lasted for: "+TimeMins+" Minutes and "+TimeSecs+" Seconds");
    }
}

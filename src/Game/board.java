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
public class board {
    public void displayBoard(int [] pots,int [] scores){
        int i;
        System.out.println("f\te\td\tc\tb\ta\t\tN");
        for(i=5;i>=0;i--){
            System.out.print(pots[i]+"\t");
        }
        System.out.println("\t"+scores[0]+"\n");
        for(i=6;i<pots.length;i++){
            System.out.print(pots[i]+"\t");
        }
        System.out.println("\t"+scores[1]);
        System.out.println("A\tB\tC\tD\tE\tF\t\tS");
        System.out.println("\n-----------------------------------------------------------------------\n");
    }
}

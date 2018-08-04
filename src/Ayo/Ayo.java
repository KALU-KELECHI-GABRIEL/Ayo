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
import AI.AI;
import AI.TwoThree;
import java.util.List;
import java.util.Scanner;
import static Ayo.Seeds.diffLevel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import static Ayo.Seeds.p;
import static Ayo.House.changeLabel;
import static Ayo.Seeds.playerNo;
import static Ayo.House.playerTurn;
import static Ayo.House.player2Turn;
public class Ayo {
    AyoSecond ayo = new AyoSecond();
    public void sArrayToHouse(int[] array, int[] chops){
        ayo.arrayToHouse(array, chops);
    }
}

 class AyoSecond{

    static int[] board = new int[12];
    boolean p1;
    boolean start = true;
    int p1House = 6;
    int p2House = 6;
    Scanner input = new Scanner(System.in);
    Image img = new Image("img/player1Home.png");
    AI jarvis = new TwoThree(diffLevel);
    int index, noSeeds;

    public void moveP1(int[] array, int[] chops, int index) {
        this.index = index;
        int noOfSeeds = array[index];
        int endIndex = -2;
        array[index] = 0;
        for (int i = index + 1, j = index + 1; i < index + noOfSeeds + 1; i++, j++) {

            if (j == index) {
                j++;
            }
            if (j >= array.length) {
                j = 0;
            }
            array[j]++;
            endIndex = j;
            arrayToHouse(array, chops);
        }
        if (endIndex > 5) {
            while (array[endIndex] < 4 && array[endIndex] >= 2) {
                chops[0] += array[endIndex];
                array[endIndex] = 0;
                endIndex = (endIndex > 6) ? --endIndex : endIndex;
            }
        }
        arrayToHouse(array,chops);
        printBoard(array);
        System.out.println("\n");
        p1 = !p1;
        changeLabel();
        playerTurn = false;
        player2Turn = true;
        if(playerNo==1)
            moveP2(array,chops,jarvis.getMove(array));

    }
    
    public void arrayToHouse(int[] array, int[] chops) {
        List<House> h;
        h = House.allGroup;
        for (int i = 0; i < House.allGroup.size(); i++) {
            if (h.get(i).seeds.size() < array[i]) {
                final House h1 = h.get(i);
                Thread thread = new Thread(new Runnable(){
                    House h2 = h1;
                    @Override
                    public void run() {
                        p.stop();
                        h2.lock = true;
                        h2.addSeeds();
                        
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AyoSecond.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    
                });
                thread.start();
                try {
                    thread.join();
                }catch(Exception e){
                    
                }
                
            } else if (array[i] == 0) {
                House h2 = h.get(i);
                Thread thread2 = new Thread(() -> {
                    h2.lock = true;
                    h2.removeSeeds();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AyoSecond.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                thread2.start();
                try {
                    thread2.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AyoSecond.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }

    }

    public void moveP2(int[] array, int[] chops, int index) {

        int noOfSeeds = array[index];
        int endIndex = -2;
        array[index] = 0;
        for (int i = index + 1, j = index + 1; i < index + noOfSeeds + 1; i++, j++) {
            if (j == index) {
                j++;
            }
            if (j >= array.length) {
                j = 0;
            }
            array[j]++;
            endIndex = j;
            arrayToHouse(array, chops);
        }
        if (endIndex <= 5) {
            while (array[endIndex] < 4 && array[endIndex] >= 2) {
                chops[1] += array[endIndex];
                array[endIndex] = 0;
                endIndex = (endIndex > 0) ? --endIndex : endIndex;
                System.out.println("EndIndex" + endIndex);
            }
        }
        arrayToHouse(array,chops);
        printBoard(array);
        System.out.println("\n");
        p1 = !p1;
        changeLabel();
        playerTurn = true;
        player2Turn = false;
    }

    private void printBoard(int[] array) {
        for (int i = 5; i >= 0; i--) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 5; i >= 0; i--) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n");
        for (int i = 6; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        for (int i = 6; i < array.length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    
 }



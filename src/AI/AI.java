/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Phillz Mike
 */
public abstract class AI {
    private final int depth;
    private int count = 1;
    private int formerMin = 100;
    public AI(byte diffLevel){
        depth = 2 * (1 + diffLevel);
    }
    public int getMove(int[] tempBoard){
        boolean test;
        int x = -2;
        
        test = false;
        for (int i = 0; i < 6; i++) {
            if (tempBoard[i] != 0) {
                test = true;
                break;
            }
        }
        if(test){
            System.out.println("depth  " + depth);
            int[] chops = {0,0};
            x = minimax(tempBoard,chops,depth)[1];
        }else{
            for(int i=tempBoard.length-1;i>=6;i--){
                if((tempBoard[i] + i) >= tempBoard.length)
                    x = i;
            }
        }
        return x;
    }
    private int[] copyArray(int[] array){
        int[] newArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            newArray[i] = (int)array[i];
        }
        return newArray;
    }
    private List<Integer> checkValidity(int[] array){
        List<Integer> possibleGuyz = new ArrayList<>();
        for(int i = 6;i<array.length;i++){
            if(array[i] != 0)
                possibleGuyz.add(i);
        }
        return possibleGuyz;
    }
    private List<Integer> checkPValidity(int[] array){
        List<Integer> possibleGuyz = new ArrayList<>();
        for(int i = 0;i<array.length-6;i++){
            if(array[i] != 0)
                possibleGuyz.add(i);
        }
        return possibleGuyz;
    }
    private int[] minimax(int[] array,int[] chops,int times){
        int chop;
        int index = -1;
        int noSeeds =100;
        if(times %2==0){
            chop = -100;
            List<Integer> possibleMoves = checkValidity(array);
            List<Integer> possibleGuyz = new ArrayList<>();
            int[] tempChop = new int[possibleMoves.size()];
            for(int i=0;i<possibleMoves.size();i++){
                int[] tempArray = copyArray(array);
                int[] tempChops = copyArray(chops);
                int[][] boardState  = aiMove(tempArray,tempChops,possibleMoves.get(i));
                tempChop[i] = minimax(boardState[0],boardState[1],times-1)[0];
                if(formerMin>tempChop[i])
                    formerMin = tempChop[i];
            }
            if(tempChop.length>0){
            for(int i = 0;i<tempChop.length;i++){
                if(chop < tempChop[i] && tempChop[i] < 100){
                    chop = tempChop[i];
                }
            }
            
            }
            if(times == depth){
                System.out.println("tempChop " + Arrays.toString(tempChop));
                for(int i=0;i<tempChop.length;i++){
                    if(tempChop[i]==chop)
                        possibleGuyz.add(possibleMoves.get(i));
                }
                System.out.println(possibleGuyz);
                for(int i=0;i<possibleGuyz.size();i++){
                    if(noSeeds > array[possibleGuyz.get(i)]){
                        noSeeds = array[possibleGuyz.get(i)];
                        index = possibleGuyz.get(i);
                    }
                }
            }
        }else{
            chop = 100;
            int newChop = 100;
            List<Integer> possibleMoves = checkPValidity(array);
            for(int i=0;i<possibleMoves.size();i++){
                int[] tempArray = copyArray(array);
                int[] tempChops = copyArray(chops);
                int[][] boardState  = playerMove(tempArray,tempChops,possibleMoves.get(i));
                if(times > 1){
                    chop =minimax(boardState[0],boardState[1],times-1)[0];
                    if(chop >= -100){
                        newChop = (newChop < chop) ? newChop: chop;
                        chop = newChop;
                    }
                }
                else{
                    count++;
                    chop = (chop < boardState[1][1]-boardState[1][0]) ? chop:boardState[1][1]-boardState[1][0];
                    
                }
                if(chop <= formerMin)
                        break;
            }
        }
        
        int[] chopAndIndex = {chop,index};
        return chopAndIndex;
            
    }
    protected abstract int[][] aiMove(int[] array, int[] chops, int index);
    protected abstract int[][] playerMove(int[] array, int[] chops, int index);
}

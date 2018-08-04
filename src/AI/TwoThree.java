/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

/**
 *
 * @author Phillz Mike
 */
public class TwoThree extends AI{
      
    public TwoThree(byte diffLevel){
        super(diffLevel);
    }
    @Override
    protected int[][] aiMove(int[] array, int[] chops, int index){
            int noSeeds = array[index];
            array[index] = 0;
            int endIndex = -2;
            for (int i = index + 1, j = index + 1; i < index + 1 + noSeeds; i++, j++){
                if (j == index) 
                    j++;
                if (j >= array.length)
                    j = 0;
                array[j]++;
                endIndex = j;
            }
            if (endIndex <= 5 && noSeeds != 0) {
                while (array[endIndex] < 4 && array[endIndex] >= 2) {
                    chops[1] += array[endIndex];
                    array[endIndex] = 0;
                    endIndex = (endIndex > 0) ? --endIndex : endIndex;
                }
            }
            int[][] arrayAll = {array,chops};
            return arrayAll;
        }
    @Override
    protected int[][] playerMove(int[] array, int[] chops, int index){
        int noSeeds = array[index];
        array[index] = 0;
        int endIndex = -2;
        for (int i = index + 1, j = index + 1; i < index + 1 + noSeeds; i++, j++) {
            if (j == index) {
                j++;
            }
            if (j >= array.length) {
                j = 0;
            }
            array[j]++;
            endIndex = j;
        }
        if (endIndex > 5 && noSeeds != 0) {
            while (array[endIndex] < 4 && array[endIndex] >= 2) {
                chops[0] += array[endIndex];
                array[endIndex] = 0;
                endIndex = (endIndex > 6) ? --endIndex : endIndex;
            }
        }
        int[][] arrayAll = {array,chops};
        return arrayAll;
    }
}

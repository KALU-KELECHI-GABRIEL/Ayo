/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Diana extends AI {

   
    
    @Override
    public char movestomake(List<Integer> gamestate) {
         char c =makeless(gamestate);
         return c;
    }

    @Override
    public List<Integer> getgamestate(int[] gamenow) {
        List<Integer> gamestate = new ArrayList<Integer>();
        for(int i=0;i<gamenow.length;i++){
                gamestate.add(gamenow[i]);
            
        }
        return gamestate;
    }
     public char makeless(List<Integer> gamestate){
        List<Integer> quasi = new ArrayList<>();
        setfalsegame(gamestate, quasi);
        int min=100; int pick=0;
        for(int i=6;i<quasi.size();i++){
            int seeds = quasi.get(i);
            if(seeds==1&&i<11){
                if(quasi.get(i+1)==0){
                    min = -100;
                    pick=i;
                    break;
                    
                }
            }else if(seeds!=0){
            imaginaryPlay(seeds,quasi,i);
            int sepration =sum(quasi,11,6)-sum(quasi,5,0);
            //System.out.println("diff if "+i+" was played is "+sepration);
            if(sepration<min){
                    pick=i;
                    min=sepration;
            }
            setfalsegame(gamestate, quasi);
        }
        }
        if (min==100){
         for(int i=0;i<gamestate.size();i++){
             if(gamestate.get(i)!=0){
                 min=i;
                 pick=i;
                 break;
             }
         }   
        }
        //System.out.println("Picking: "+min+" : "+conv.convertint(pick));
        char c = conv.convertint(pick);
        return c;
    }
    public void setfalsegame(List<Integer> gstate,List<Integer>qstate){
        qstate.clear();
        for(int i=0;i<gstate.size();i++){
            qstate.add(gstate.get(i));
        }
    }
    public int sum(List<Integer> list,int torange, int fromrange){
        int sum=0;
        for(int i=fromrange;i<=torange;i++){
            sum = sum+list.get(i);
        }
        return sum;
    }
    public void imaginaryPlay(int seeds,List<Integer>quasi,int i){
        int begin=0;
        if(i==11){
            begin=0;
        }else if(i==0){
            begin=1;
        }else if(i>=6){
            begin=i+1;
        }else if(i<=5){
            begin=i+1;
        }
        int formerseed;
        quasi.set(i, 0);
        int j;
        for(j=i+1;j<seeds+i;j++){
                if(begin==11){
                    formerseed = quasi.get(begin);
                    quasi.set(begin, formerseed+1);
                    begin=0;
                }else if(begin==0){
                    formerseed = quasi.get(begin);
                    quasi.set(begin, formerseed+1);
                    begin=1;
                }else if(begin<=5){
                    formerseed = quasi.get(begin);
                    quasi.set(begin, formerseed+1);
                    begin++;
                }else if(begin>=6){
                    formerseed = quasi.get(begin);
                    quasi.set(begin, formerseed+1);
                    begin++;
                }
            }
        if(begin>=6){
            int sids = quasi.get(begin);
            if(sids==0){
                quasi.set(begin, 0);
                int r = 11- begin;
                quasi.set(r, 0);
            }else{
                //System.out.println("Continue");
                imaginaryPlay(sids, quasi, begin);
            }
        }else{
            int fmerseed = quasi.get(begin);
            quasi.set(begin, fmerseed+1);
        }
    }
    
    
}

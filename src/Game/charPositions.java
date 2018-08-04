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
public class charPositions {
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
 
}



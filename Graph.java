/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */

import java.util.*;
public class Graph {
	public void graph(){

    int[] arr_loc = new int[7];
        Random r = new Random();
        if(Game.level < 4){
           for (int i = 0; i < 7; i++) {
            arr_loc[i] = r.nextInt(3) + 1;
            
        } 
        }
        else{
           for (int i = 0; i < 7; i++) {
            arr_loc[i] = r.nextInt(4) + 1;
          
        } 
        
        }


        int [] arr=new int[3];
            arr[0]=r.nextInt(7);
            int temp=r.nextInt(7);
            if(temp!=arr[0]){
                arr[1]=temp;
            }
            int temp2=r.nextInt(7);
            if(temp2!=arr[0] && temp2!=arr[1]){
                arr[2]=temp;
            }
	}

}

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
abstract class Sidekick {
    Scanner Sc=new Scanner(System.in);
    private int xp=0;
    private int hp;
    public int attack_value;
    
    public void setxp(int a){
        this.xp=a;
    }
    public int getxp(){
        return this.xp;
    }
    public void sethp(int a){
        this.hp=a;
    }
    public int gethp(){
        return this.hp;
    }
    public abstract void Attack(Monster mon);
    public abstract void buy(hero obj);
    
}
class Minion extends Sidekick implements Cloneable{
    static int kill=0;
    public void Attack(Monster mon){
        mon.sethp(mon.gethp()-this.attack_value);
        System.out.println("Sidekick attacked and inflicted "+this.attack_value+ "damage to the monster.");
        
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    public void buy(hero obj){
        System.out.println("XP to spend:(should be greater than 5)" );
        int a=Sc.nextInt();
        if(a>=5){
            this.attack_value=1+(int)(0.5*(a-5));
            obj.set_xp(obj.get_xp()-a);
        }
        
        System.out.println("You bought a sidekick: minion\n" + "XP of sidekick is 0.0\n" + "Attack of sidekick is 2");
        System.out.println("Press c to use cloning ability. Else press f to move to the fight");
        String in=Sc.next();
        if(in.equals("c")){
            kill=1;
            
            try{
                if(kill==0){
                    Object clonedobj_1= this.clone();
                    Object clonedobj_2= this.clone();
                    Object clonedobj_3= this.clone();
                    Object clonedobj_4= this.clone();
                    System.out.println("Cloning done.");
                }
                
                
            }
            catch(CloneNotSupportedException c){}  
        }
    }
}
class Knight extends Sidekick{
    public void buy(){
        System.out.println("XP to spend: 7\n" + "You bought a sidekick: minion\n" + "XP of sidekick is 0.0\n" + "Attack of sidekick is 2");
    }
}
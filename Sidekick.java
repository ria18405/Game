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
    private int hp=100;
    public int attack_value;
    public int cloningpresent=0;
   ArrayList <Sidekick> clonedspecies =new ArrayList <Sidekick> ();
    
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
    public Minion(){
        
    }
    public void Attack(Monster mon){
        mon.sethp(mon.gethp()-this.attack_value);
        System.out.println("Sidekick attacked and inflicted "+this.attack_value+ " damage to the monster.");
        System.out.println("Sidekick Hp:"+this.gethp()+"/100");
        if(this.cloningpresent==1){
            
            Minion clonedobj_1= this.clone();
            Minion clonedobj_2= this.clone();
            Minion clonedobj_3= this.clone();
            
            clonedspecies.add(clonedobj_1);
            clonedspecies.add(clonedobj_2);
            clonedspecies.add(clonedobj_3);
            clonedobj_1.attack_value=this.attack_value;
            clonedobj_2.attack_value=this.attack_value;
            clonedobj_3.attack_value=this.attack_value;
            
            mon.sethp(mon.gethp()-clonedobj_1.attack_value);
            mon.sethp(mon.gethp()-clonedobj_2.attack_value);
            mon.sethp(mon.gethp()-clonedobj_3.attack_value);
            System.out.println("Sidekick attacked and inflicted "+clonedobj_1.attack_value+ "damage to the monster.");
            System.out.println("Sidekick attacked and inflicted "+clonedobj_2.attack_value+ "damage to the monster.");
            System.out.println("Sidekick attacked and inflicted "+clonedobj_3.attack_value+ "damage to the monster.");

            
            System.out.println("Sidekick Hp:"+clonedobj_1.gethp()+"/100");
            System.out.println("Sidekick Hp:"+clonedobj_2.gethp()+"/100");
            System.out.println("Sidekick Hp:"+clonedobj_3.gethp()+"/100");
            
            
             
        }
    }
    protected Minion clone()  {
        Minion a=new Minion();
        return a; 
    }
    public void buy(hero obj){
        System.out.println("XP to spend:(should be greater than 5)" );
        int a=Sc.nextInt();
        if(a>=5){
            this.attack_value=1+(int)(0.5*(a-5));
            obj.set_xp(obj.get_xp()-a);
        }
        
        System.out.println("You bought a sidekick: minion\n" + "XP of sidekick is 0.0\n" + "Attack of sidekick is"+this.attack_value);
        System.out.println("Press c to use cloning ability. Else press f to move to the fight");
        String in=Sc.next();
        if(in.equals("c")){
            kill=1;
            this.cloningpresent=1;
            
//            try{
//                if(kill==0){
//                    Object clonedobj_1= this.clone();
//                    Object clonedobj_2= this.clone();
//                    Object clonedobj_3= this.clone();
//                    Object clonedobj_4= this.clone();
                    System.out.println("Cloning done.");
//                }
                
                
//            }
//            catch(CloneNotSupportedException c){}  
        }
    }
}
//class Knight extends Sidekick{
//    public void buy(){
//        System.out.println("XP to spend: 7\n" + "You bought a sidekick: minion\n" + "XP of sidekick is 0.0\n" + "Attack of sidekick is 2");
//    }
//}
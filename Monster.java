
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */

class Monster{
    
    public int hp;
    public int maxhp;
    public void attack(hero obj){
        Random r=new Random();
        double rvar=r.nextGaussian();
       while(rvar>3 && rvar<-3){
           rvar=r.nextGaussian();
       }
        double y=(rvar+3)/6;
        int k=(int)(y*this.hp/4);
        //k=no to be subtracted
//        System.out.Sprintln("new gauss"+(k));

        obj.hp-=k;
        System.out.println("Monster attack!\n" +"monster attacked and inflicted "+k+ " damage to you.");

        
        //reduce opponenent by a;
//        Random r=new Random();
//        int a=r.nextInt(this.hp);
//        System.out.println(a);
//        opponent.hp-=a;
    }
}
class Goblins extends Monster{
    public Goblins(){
          this.hp=100; 
          this.maxhp=100;
    }

}
class Zombies extends Monster{
    public Zombies(){
        this.hp=100;
        this.maxhp=100;
    }
}
class Fiends extends Monster{
    public Fiends(){
        this.hp=200;
        this.maxhp=200;
    }
}
class Lionfang extends Monster{
    public Lionfang(){
        this.hp=250;
        this.maxhp=250;
    }
    @Override
    public void attack(hero obj){
        //probability=1/10
        int check=9;
        Random r= new Random();
        int k=r.nextInt(10);
//        while(k!=check){
//            k=r.nextInt(10);
//        }
        if(k==check){
          obj.hp=obj.hp/2;  
        }
        else{
//            obj.attack(mon);
           super.attack(obj);
        }
    }
    //opponent.hp=(opponent.hp/2);
    
}
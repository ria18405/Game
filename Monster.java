
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
    public void attack(){
        //reduce opponenent by a;
        Random r=new Random();
        int a=r.nextInt(this.hp);
        System.out.println(a);
//        opponent.hp-=a;
    }
}
class Goblins extends Monster{
    
}
class Zombies extends Monster{
    
}
class Fiends extends Monster{
    
}
class Lionfang extends Monster{
    
    //opponent.hp=(opponent.hp/2);
    
}
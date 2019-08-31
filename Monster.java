
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
    
    private int hp;
    private int maxhp;
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

        obj.set_hp(obj.get_hp()-k);
        System.out.println("Monster attack!\n" +"monster attacked and inflicted "+k+ " damage to you.");

        
        //reduce opponenent by a;
//        Random r=new Random();
//        int a=r.nextInt(this.hp);
//        System.out.println(a);
//        opponent.hp-=a;
    }
    public void attackhelper(Sidekick helper,int diff){
        int attackvaluehelper=(int)(1.5*diff);
        helper.sethp(helper.gethp()-attackvaluehelper);
        System.out.println("Sidekicks hp "+helper.gethp()+" /100");
        if(helper.cloningpresent==1){
            for(int i=0;i<helper.clonedspecies.size();i++){
                helper.clonedspecies.get(i).sethp(helper.clonedspecies.get(i).gethp()-attackvaluehelper);
                System.out.println(" Sidekicks hp "+helper.clonedspecies.get(i).gethp()+" /100");
            }
        }
    }
    public int gethp(){
        return this.hp;
    }
    public int getmaxhp(){
        return this.maxhp;
    }
    public void setmaxhp(int a){
        this.maxhp=a;
    }
    public void sethp(int a){
        this.hp=a;
    }
    
}
class Goblins extends Monster{
    public Goblins(){
          this.sethp(100); 
          this.setmaxhp(100);
    }

}
class Zombies extends Monster{
    public Zombies(){
        this.sethp(100);
        this.setmaxhp(100);
    }
}
class Fiends extends Monster{
    public Fiends(){
        this.sethp(200);
        this.setmaxhp(200);
    }
}
class Lionfang extends Monster{
    public Lionfang(){
        this.sethp(250);
        this.setmaxhp(250);
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
          obj.set_hp(obj.get_hp()/2);  
        }
        else{
//            obj.attack(mon);
           super.attack(obj);
        }
    }
    //opponent.hp=(opponent.hp/2);
    
}
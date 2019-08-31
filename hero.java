/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */
 abstract class hero{
     
    private int xp=0;
    private int hp=100;
    private int attack_value=0;
    private int defence_value;
    private int special_value=0;
    public int maxhp;
    

//    public int attack_value;
//    public int defence;
//    public int special;
    public abstract void attack(Monster mon);
    public abstract void defence(Monster mon);
    public abstract void special(Monster mon);
//   public hero(){
//       this.xp=0;
//       this.hp=100;
//   }

//    public void attack(){
////        opponent.hp-=attack_value;
//    }
    public int get_attackvalue(){
        return this.attack_value;
    }
    public int get_defencekvalue(){
        return this.defence_value;
    }
    public int get_specialvalue(){
        return this.special_value;
    }
    public int get_hp(){
        return this.hp;
    }
     public int get_xp(){
        return this.xp;
    }
     
     public void set_attackvalue(int a){
        this.attack_value=a;
    }
     public void set_defencevalue(int a){
        this.defence_value=a;
    }
     public void set_specialvalue(int a){
        this.special_value=a;
    }
      public void set_hp(int a){
        this.hp=a;
    }
      public void set_xp(int a){
        this.xp=a;
    }
    }
    class Warrior extends hero{
        public Warrior(){
            this.set_attackvalue(10);
//            this.attack_value=10;
            this.set_defencevalue(3);
//            this.maxhp=
        }
        
        public void attack(Monster mon){
            if(this.get_specialvalue()>0){
                this.set_attackvalue(15);
                this.set_defencevalue(8);
                this.set_specialvalue(this.get_specialvalue()-1);
            }
            else{
                this.set_attackvalue(10);
                this.set_defencevalue(3);
            }
            mon.sethp(mon.gethp()-this.get_attackvalue());
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.get_attackvalue()+" damage to the monster.");        
            
    }
        public void defence(Monster mon){
//          System.out.println("defence_warrior"); 
            if(this.get_specialvalue()>0){
                this.set_attackvalue(15);
                this.set_defencevalue(8);
                this.set_specialvalue(this.get_specialvalue()-1);
            }
            else{
                this.set_attackvalue(10);
                this.set_defencevalue(3);
            }
          
          System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.get_defencekvalue());
//          this.hp+=this.defence_value;
          this.set_hp(this.get_defencekvalue()+this.get_hp());
          mon.attack(this);
        }
         
        public void special(Monster mon){
            this.set_specialvalue(3);
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have increased your attack and defence ues by 5 Hp");
//            this.attack_value+=5;
//            this.defence_value+=5;
        }
    }
    class Mage extends hero{
         public Mage(){
            this.set_attackvalue(5);
            this.set_defencevalue(5);
        }
        
        public void attack(Monster mon){
            if(this.get_specialvalue()>0){
                mon.sethp(mon.gethp()-(int)(0.05*mon.gethp()));
                this.set_specialvalue(this.get_specialvalue()-1);
            }
            
            mon.sethp(mon.gethp()-this.get_attackvalue());
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.get_attackvalue()+" damage to the monster.");
//            System.out.println("Your HP: "+this.hp+" Monsters HP: "+ mon.hp);
        }
        public void defence(Monster mon){
//          System.out.println("yo");
            if(this.get_specialvalue()>0){
                mon.sethp(mon.gethp()-(int)(0.05*mon.gethp()));
                this.set_specialvalue(this.get_specialvalue()-1);
            }
            
            System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.get_defencekvalue());
            this.set_hp(this.get_hp()+this.get_defencekvalue());
            mon.attack(this);
          
        }
        public void special(Monster mon){
            this.set_specialvalue(3);
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have decreased monsters's hp by 5%");

//            mon.hp-=(0.05*mon.hp);
        }
    }
    
    class Thief extends hero{
       
        public Thief(){
            this.set_attackvalue(6);
            this.set_defencevalue(4);
        }
        public void attack(Monster mon){
            mon.sethp(mon.gethp()-this.get_attackvalue());
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.get_attackvalue()+" damage to the monster.");
//            System.out.println("Your HP: "+this.hp+" Monsters HP: "+ mon.hp);
        }
        public void defence(Monster mon){
          
//          System.out.println("defence");  
           System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.get_defencekvalue());
          this.set_hp(this.get_hp()+this.get_defencekvalue());
          mon.attack(this);
          
        }
        public void special(Monster mon){
           this.set_specialvalue(3);
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have stolen "+ 0.3*mon.gethp() +"Hp from the monster!");
            this.set_hp(this.get_hp()+(int)(0.3*mon.gethp()));
            mon.sethp(mon.gethp()-(int)(0.3*mon.gethp()));
         
            //stealing 30% hp        
        }
    }
    
    class Healer extends hero{
        public Healer(){
            this.set_attackvalue(4);
            this.set_defencevalue(8);
        }
        public void attack(Monster mon){
            if(this.get_specialvalue()>0){
                this.set_hp(this.get_hp()+(int)(0.05*this.get_hp()));
                this.set_specialvalue(this.get_specialvalue()-1);
            }
            mon.sethp(mon.gethp()-this.get_attackvalue());
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.get_attackvalue()+" damage to the monster");

        }
        public void defence(Monster mon){
            if(this.get_specialvalue()>0){
                this.set_hp(this.get_hp()+(int)(0.05*this.get_hp()));
                this.set_specialvalue(this.get_specialvalue()-1);
            }
//          System.out.println("defence");
            System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.get_defencekvalue());
          this.set_hp((this.get_hp()+this.get_defencekvalue()));
            mon.attack(this);

        }
        public void special(Monster mon){
            this.set_specialvalue(3);
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have increased your own Hp by 5%");
//            this.hp+=(0.05*this.hp);
        }
    }
    



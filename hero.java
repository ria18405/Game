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
     
    public int xp=0;
    public int hp=100;
    int attack_value;
    int defence_value;
    

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
    }
    class Warrior extends hero{
        public Warrior(){
            this.attack_value=10;
            this.defence_value=3;
        }
        
        public void attack(Monster mon){
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+attack_value+" damage to the monster.");        }
         
        public void defence(Monster mon){
//          System.out.println("defence_warrior"); 
          mon.attack(this);
          this.hp+=defence_value;
        }
         
        public void special(Monster mon){
            System.out.println("special"); 
//            counter=0;
            this.attack_value+=5;
            this.defence_value+=5;
        }
    }
    class Mage extends hero{
         public Mage(){
            this.attack_value=5;
            this.defence_value=5;
        }
        
        public void attack(Monster mon){
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.attack_value+" damage to the monster.");

        }
        public void defence(Monster mon){
//          System.out.println("yo");
            mon.attack(this);
            this.hp+=this.defence_value;
          
        }
        public void special(Monster mon){
            System.out.println("special"); 
        }
    }
    
    class Thief extends hero{
       
        public Thief(){
            this.attack_value=6;
            this.defence_value=4;
        }
        public void attack(Monster mon){
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.attack_value+" damage to the monster.");

        }
        public void defence(Monster mon){
          mon.attack(this);
//          System.out.println("defence");  
          this.hp+=this.defence_value;
        }
        public void special(Monster mon){
            System.out.println("special"); 

            
        }
    }
    
    class Healer extends hero{
        public Healer(){
            this.attack_value=4;
            this.defence_value=8;
        }
        public void attack(Monster mon){
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.attack_value+" damage to the monster");

        }
        public void defence(Monster mon){
          mon.attack(this);
//          System.out.println("defence");  
          this.hp+=this.defence_value;
        }
        public void special(Monster mon){
            System.out.println("special"); 
        }
    }
    



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */
class hero{
    
    public int xp;
    public int hp;
//    public int attack_value;
//    public int defence;
//    public int special;
   public hero(){
       this.xp=0;
       this.hp=100;
   }

//    public void attack(){
////        opponent.hp-=attack_value;
//    }
    }
    class Warrior extends hero{
        int attack_value;
        public Warrior(){
            attack_value=10;
        }
        public void attack(Monster mon){
            mon.hp-=attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+attack_value+" damage to the monster.\n" +"Your Hp: 85/100 Monsters Hp: 88/100");

        }
        public void defence(){
          System.out.println("defence_warrior");  
        }
        public void special(){
            System.out.println("special"); 
        }
    }
    class Mage extends hero{
        int attack_value;
        public Mage(){
            attack_value=10;
        }
        public void attack(Monster mon){
            mon.hp-=attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+attack_value+" damage to the monster.\n" +"Your Hp: 85/100 Monsters Hp: 88/100");

        }
        public void defence(){
          System.out.println("yo");  
        }
        public void special(){
            System.out.println("special"); 
        }
    }
    
    class Thief extends hero{
       int attack_value;
        public Thief(){
            attack_value=10;
        }
        public void attack(Monster mon){
            mon.hp-=attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+attack_value+" damage to the monster.\n" +"Your Hp: 85/100 Monsters Hp: 88/100");

        }
        public void defence(){
          System.out.println("defence");  
        }
        public void special(){
            System.out.println("special"); 
        }
    }
    
    class Healer extends hero{
              int attack_value;
        public Healer(){
            attack_value=10;
        }
        public void attack(Monster mon){
            mon.hp-=attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+attack_value+" damage to the monster.\n" +"Your Hp: 85/100 Monsters Hp: 88/100");

        }
        public void defence(){
          System.out.println("defence");  
        }
        public void special(){
            System.out.println("special"); 
        }
    }
    



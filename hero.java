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
    int special_value=0;
    

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
            if(this.special_value>0){
                this.attack_value=15;
                this.defence_value=8;
                this.special_value-=1;
            }
            else{
                this.attack_value=10;
                this.defence_value=3;
            }
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+attack_value+" damage to the monster.");        
            
    }
        public void defence(Monster mon){
//          System.out.println("defence_warrior"); 
            if(this.special_value>0){
                this.attack_value=15;
                this.defence_value=8;
                this.special_value-=1;
            }
            else{
                this.attack_value=10;
                this.defence_value=3;
            }
          
          System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.defence_value);
          this.hp+=this.defence_value;
          mon.attack(this);
        }
         
        public void special(Monster mon){
            this.special_value=3;
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have increased your attack and defence ues by 5 Hp");
//            this.attack_value+=5;
//            this.defence_value+=5;
        }
    }
    class Mage extends hero{
         public Mage(){
            this.attack_value=5;
            this.defence_value=5;
        }
        
        public void attack(Monster mon){
            if(this.special_value>0){
                mon.hp-=(int)(0.05*mon.hp);
                this.special_value-=1;
            }
            
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.attack_value+" damage to the monster.");
//            System.out.println("Your HP: "+this.hp+" Monsters HP: "+ mon.hp);
        }
        public void defence(Monster mon){
//          System.out.println("yo");
            if(this.special_value>0){
                mon.hp-=(int)(0.05*mon.hp);
                this.special_value-=1;
            }
            
            System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.defence_value);
            this.hp+=this.defence_value;
            mon.attack(this);
          
        }
        public void special(Monster mon){
            this.special_value=3;
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have decreased monsters's hp by 5%");

//            mon.hp-=(0.05*mon.hp);
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
//            System.out.println("Your HP: "+this.hp+" Monsters HP: "+ mon.hp);
        }
        public void defence(Monster mon){
          
//          System.out.println("defence");  
           System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.defence_value);
          this.hp+=this.defence_value;
          mon.attack(this);
          
        }
        public void special(Monster mon){
           this.special_value=3;
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have stolen "+ 0.3*mon.hp +"Hp from the monster!");
            this.hp+=(int)(0.3*mon.hp);
            mon.hp-=(int)(0.3*mon.hp);
         
            //stealing 30% hp        
        }
    }
    
    class Healer extends hero{
        public Healer(){
            this.attack_value=4;
            this.defence_value=8;
        }
        public void attack(Monster mon){
            if(this.special_value>0){
                this.hp+=(int)(0.05*this.hp);
                this.special_value-=1;
            }
            mon.hp-=this.attack_value;
            System.out.println("You choose to attack\n" + "You attacked and inflicted "+this.attack_value+" damage to the monster");

        }
        public void defence(Monster mon){
            if(this.special_value>0){
                this.hp+=(int)(0.05*this.hp);
                this.special_value-=1;
            }
//          System.out.println("defence");
            System.out.println("You choose to defend\n" + "Monster attack reduced by"+ this.defence_value);
          this.hp+=this.defence_value;
            mon.attack(this);

        }
        public void special(Monster mon){
            this.special_value=3;
            System.out.println("Special power activated\n" +"Performing special attack\n" +"You have increased your own Hp by 5%");
//            this.hp+=(0.05*this.hp);
        }
    }
    



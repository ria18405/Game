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

public class Game {

    static int counter = 0;
    static int level=1;

    public static void main(String[] args) {
//        Graph a =new Graph();
//        a.graph();
        
        int[] arr_loc = new int[7];
        Random r = new Random();
        if(level <4){
           for (int i = 0; i < 7; i++) {
            arr_loc[i] = r.nextInt(3) + 1;
            //storing levels
        } 
        }
        else{
           for (int i = 0; i < 7; i++) {
            arr_loc[i] = r.nextInt(4) + 1;
            //storing levels
        } 
        }
        
//        for (int i = 3; i < 7; i++) {
//            arr_loc[i] = r.nextInt(4) + 1;
//            //storing levels
//        }
//        for(int j=0;j<7;j++){
//            System.out.print(arr_loc[j]+ " ");
//        }
//        System.out.println();
        ArrayList<user> userarray = new ArrayList<user>();
        startgame(userarray, arr_loc);
        
    }

    public static void startgame(ArrayList<user> userarray, int[] arr_loc) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Welcome to ArchLegends\n" + "Choose your option\n" + "1) New User\n" + "2) Existing User\n" + "3) Exit");
        int in = Sc.nextInt();
        if (in == 1) {
            System.out.println("Enter Username");
            final String name = Sc.next();
            System.out.println("Choose a Hero\n" + "1) Warrior\n" + "2) Mage\n" + "3) Thief \n" + "4) Healer");
            final int type = Sc.nextInt();
            user newuser = new user(name, type);
            String [] montypearr=new String[]{"Warrior","Mage","Theif","Healer" };
            userarray.add(newuser);
            System.out.println("User Creation done. Username:"+name+". Hero type: "+montypearr[type-1]+". Log in to play the game . Exiting");
            startgame(userarray, arr_loc);
        } else if (in == 2) {
            System.out.println("Enter Username");
            String in_name = Sc.next();
            
            int in_type = 0;
            hero obj;
            Random r = new Random();
            int [] arr=new int[3];
            arr[0]=r.nextInt(7);
            int temp=r.nextInt(7);
            if(temp!=arr[0]){
                arr[1]=temp;
            }
            int temp2=r.nextInt(7);
            if(temp2!=arr[0] && temp2!=arr[1]){
                arr[2]=temp2;
            }
            
            
            //traverse through arraylist and find location corresponding to the name : then make an object accordingly.
            for (int i = 0; i < userarray.size(); i++) {
                if (userarray.get(i).name.equals(in_name)) {
                    in_type = userarray.get(i).type;
                    System.out.println("User Found... logging in\n" + "Welcome " + in_name + "\n" + "You are at the starting location. ");
                    System.out.println( "Choose path:\n" + "1) Go to Location " + arr[0] +"\n"+ "2) Go to Location "+arr[1]+"\n" + "3) Go to Location "+arr[2]+"\n" + "Enter -1 to exit");
                    
                }
                
            }
            
            if (in_type == 1) {
                //make an object of warrior class
                obj = new Warrior();
            } else if (in_type == 2) {
                obj = new Mage();
            } else if (in_type == 3) {
                obj = new Thief();
            } else {
                obj = new Healer();
            }
            
            int loc = Sc.nextInt();
            int location;
            if (loc == -1) {
                startgame(userarray, arr_loc);
            } 
            else{ 
                if(loc==1){
                location=arr[0];
                }
            else if(loc==2){
                location=arr[1];
                }
            else {
                location=arr[2];
                }
                location(location, arr_loc, obj);
            }            
        } 
        else {
            return;
        }        
    }

    public static void location(int location, int[] arr_loc, hero obj) {
        Scanner Sc = new Scanner(System.in);
        if(obj.get_hp()<0){
            System.out.println("SORRY!,YOU LOST");
            return;
        }
        System.out.println("Moving to location " + location + "\n" + "Fight Started. You're fighting a level " + arr_loc[location] + "  Monster.");
//        me.attack;
        Monster mon;
        if(level==4){
            mon=new Lionfang();
        }
        else if (arr_loc[location ] == 1) {
            mon = new Goblins();
            mon.level=1;
        } else if (arr_loc[location ] == 2) {
            mon = new Zombies();
            mon.level=2;
        } else if (arr_loc[location ] == 3) {
            mon = new Fiends();
            mon.level=3;
        }
            else {
            mon = new Lionfang();
            mon.level=4;
        }
        while (mon.gethp() > 0 && obj.get_hp()>0) {
            fight(obj, mon);
//               obj.xp+=20;
        }
        
        
        if (mon.gethp() <= 0 && obj.get_hp()>0) {
            System.out.println("Monster killed!\n" + "20 XP awarded\n" );
            obj.set_xp(20+obj.get_xp());
            System.out.println("If you would you like to buy a sidekick, type yes. Else type no to upgrade level.");
            String sidekick_bool=Sc.next();
            
            
            
            
            if(sidekick_bool.equals("yes")){
                //call sidekick
                Sidekick helper;
                mon.sethp(mon.getmaxhp());
                System.out.println("Your current XP is "+obj.get_xp()+"\n" +"If you want to buy a minion, press 1.\n" +"If you want to buy a knight, press 2.");
                int num=Sc.nextInt();
                if(num==1){
                    helper=new Minion();
                  helper.buy(obj);
                    /*System.out.println("XP to spend:(should be greater than 5)" );
                    int a=Sc.nextInt();
                    if(a>=5){
                        helper.attack_value=1+(int)(0.5*(a-5));
                        obj.set_xp(obj.get_xp()-a);
                    }

                    System.out.println("You bought a sidekick: minion\n" + "XP of sidekick is 0.0\n" + "Attack of sidekick is"+helper.attack_value);
                    System.out.println("Press c to use cloning ability. Else press f to move to the fight");
                    String in=Sc.next();
                    if(in.equals("c")){
                        helper.cloningpresent=1;
                        System.out.println("Cloning done.");
                    }
                    else{
                        //start fight 
                        fightwithhelper(obj,mon,helper);
                    }*/
                    
                    
                    
                    
                    while(mon.gethp()>0 && obj.get_hp()>0){
                        fightwithhelper(obj,mon,helper);
                    }
                    if(obj.get_hp()<=0){
                        return;
                    }
                    if(helper.gethp()<0){
                        //dead
                    }
                    if(mon.gethp()<=0 && helper.gethp()>=0 && obj.get_hp()>=0){
                        System.out.println("YOU WON THIS LEVEL WITH THE MINION");
                        helper.setxp(helper.gethp()+2*mon.level);
                        helper.sethp(100);
                        location(location, arr_loc, obj);
                    }
                        
                }
                else{
                    helper=new Knight();
                    helper.buy(obj);
                   /* System.out.println("XP to spend:(minimum 8)");
                     int a=Sc.nextInt();
                     if(a>=8){
                    helper.attack_value=2+(int)(0.5*(a-8));
                    obj.set_xp(obj.get_xp()-a);
                     }
                    System.out.println("You bought a sidekick: knight \n" + "XP of sidekick is 0.0\n" + "Attack of sidekick is"+helper.attack_value);
                    */
                    while(mon.gethp()>0 && obj.get_hp()>0){
                        fightwithhelper(obj,mon,helper);
                    }
                    if(mon.gethp()<=0 && helper.gethp()>=0 && obj.get_hp()>=0){
                        System.out.println("YOU WON THIS LEVEL WITH THE KNIGHT");
                        helper.setxp(helper.gethp()+2*mon.level);
                        helper.sethp(100);
                        location(location, arr_loc, obj);
                    }
                    
                }
            }
            else{
                
            level++;
            System.out.println("Monster killed!\n" + "20 XP awarded\n" + "Level Up: level:"+level);
            if(level>=4){
                System.out.println("Fight started with the BOSS Lionfang");
                mon=new Lionfang();
                while(mon.gethp()>0 && obj.get_hp()>0){
                    fight(obj,mon);
                }
            }
//            obj.set_xp(20+obj.get_xp());
            obj.set_attackvalue(obj.get_attackvalue()+1);
            obj.set_defencevalue(1+obj.get_defencekvalue());
            counter=0;
            if(level==2){
                obj.set_hp(150);
            }
            if(level==3){
                obj.set_hp(200);
            }
            if(level==4){
                obj.set_hp(250);
            }
            Random r=new Random();
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
            System.out.println("Fight won proceed to the next location.\n" + "You are at location"+location +"Choose path:\n" + "1) Go to Location "+arr[0]+"\n" + "2) Go to Location "+arr[1]+"\n" + "3) Go to Location"+arr[2]+"\n" + "4) Go back\n" + "Enter -1 to exit");
            int in_loc = Sc.nextInt();
            if(in_loc==1){
                location=arr[0];
            }
            else if(in_loc==2){
                location=arr[1];
            }
            else if(in_loc ==3){
                location=arr[2];
            }
            else if(in_loc==-1){
                return;
            }
            location(location, arr_loc, obj);
        }
        }
        else{
            System.out.println("YOU LOST");
            return;
        }
    }

    public static void fight(hero obj, Monster mon) {
        counter++;
        Scanner Sc = new Scanner(System.in);
        if (counter > 3) {
            System.out.println("Choose move:\n" + "1) Attack\n" + "2) Defense\n" + "3) Special Attack");
        } 
        else {
            System.out.println("Choose move:\n" + "1) Attack\n" + "2) Defense");            
        }
        int total=0;
            if(level==1){
                total=100;
            }
            else if(level==2){
                total=150;
            }
            else if(level==3){
                total=200;
            }
            else{
                total=250;
            }
            

        int move = Sc.nextInt();
        if (move == 1) {

            obj.attack(mon);
            System.out.println("Your HP: "+obj.get_hp() +"/"+ total+ " Monsters HP: "+ mon.gethp()+"/"+mon.getmaxhp());
            mon.attack(obj);
            System.out.println("Your Hp:"+ obj.get_hp()+"/" + total +" Monsters Hp:" +mon.gethp()+"/"+mon.getmaxhp());
            
        } else if (move == 2)
        {
            obj.defence(mon);
            System.out.println("Your HP: "+obj.get_hp() +"/"+ total+ " Monsters HP: "+ mon.gethp()+"/"+mon.getmaxhp());
            
        } else {
            counter=0;
            obj.special(mon);
            System.out.println("Your HP: "+obj.get_hp() +"/"+ total+ " Monsters HP: "+ mon.gethp()+"/"+mon.getmaxhp());
            mon.attack(obj);
            System.out.println("Your HP: "+obj.get_hp() +"/"+ total+ " Monsters HP: "+ mon.gethp()+"/"+mon.getmaxhp());
            
        }
    }
    public static void fightwithhelper(hero obj,Monster mon, Sidekick helper){
        Scanner Sc=new Scanner(System.in);
        int total=0;
            if(level==1){
                total=100;
            }
            else if(level==2){
                total=150;
            }
            else if(level==3){
                total=200;
            }
            else{
                total=250;
            }
            System.out.println("Choose move \n"+"1. Attack\n"+"2. Defence\n");
            int move=Sc.nextInt();
            if(move==1){
                obj.attack(mon);
                helper.Attack(mon);
        //        if(helper.cloningpresent==1){
        //            
        //        }
                System.out.println("Your Hp: "+obj.get_hp()+" /"+total+ "Monsters Hp : "+mon.gethp()+" /"+mon.getmaxhp());
                int start=obj.get_hp();
                mon.attack(obj);
                int end=obj.get_hp();
                int diff=start-end;
                mon.attackhelper(helper,diff);
                System.out.println("Your Hp: "+obj.get_hp()+" /"+total+ "Monsters Hp : "+mon.gethp()+" /"+mon.getmaxhp());

            }
            else{
              if(mon.level==2){
                  obj.set_defencevalue(obj.get_defencekvalue()+5);
              }
                obj.defence(mon);
                System.out.println("Your Hp: "+obj.get_hp()+" /"+total+ " Monsters Hp : "+mon.gethp()+" /"+mon.getmaxhp());
                int start=mon.gethp();
                mon.attack(obj);
                int end=mon.gethp();
                int diff=start-end;
                mon.attackhelper(helper, diff);
            }
    }
    
}

class user {

    public String name;
    public int type;
//    public hero obj;

    public user(String name, int type) {
        this.name = name;
        this.type = type;
    }

    
}

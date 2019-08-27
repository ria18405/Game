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
        
        int[] arr_loc = new int[7];
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            arr_loc[i] = r.nextInt(3) + 1;
            //storing levels
        }
        for (int i = 3; i < 7; i++) {
            arr_loc[i] = r.nextInt(4) + 1;
            //storing levels
        }
        for(int j=0;j<7;j++){
            System.out.println(arr_loc[j]+ " ");
        }
        ArrayList<user> userarray = new ArrayList<user>();
        startgame(userarray, arr_loc);
        
    }

    public static void startgame(ArrayList<user> userarray, int[] arr_loc) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Welcome to ArchLegends\n" + "Choose your option\n" + "1) New User\n" + "2) Existing User\n" + "3) Exit");
        int in = Sc.nextInt();
        if (in == 1) {
            System.out.println("Enter Username");
            String name = Sc.next();
            System.out.println("Choose a Hero\n" + "1) Warrior\n" + "2) Thief\n" + "3) Mage\n" + "4) Healer");
            int type = Sc.nextInt();
            user newuser = new user(name, type);
            
            userarray.add(newuser);
            System.out.println("User Creation done. Username: pan. Hero type: Thief. Log in to play the game . Exiting");
            startgame(userarray, arr_loc);
        } else if (in == 2) {
            System.out.println("Enter Username");
            String in_name = Sc.next();
            
            int in_type = 0;
            hero obj;
            Random r = new Random();
            //traverse through arraylist and find location corresponding to the name : then make an object accordingly.
            for (int i = 0; i < userarray.size(); i++) {
                if (userarray.get(i).name.equals(in_name)) {
                    in_type = userarray.get(i).type;
                    System.out.println("User Found... logging in\n" + "Welcome " + in_name + "\n" + "You are at the starting location. ");
                    System.out.println( "Choose path:\n" + "1) Go to Location" + r.nextInt(7) +"\n"+ "2) Go to Location"+r.nextInt(7)+"\n" + "3) Go to Location 6\n" + "Enter -1 to exit");
                    
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
            if (loc == -1) {
                startgame(userarray, arr_loc);
            } else {
                location(loc, arr_loc, obj);
            }            
        } else {
            return;
        }        
    }

    public static void location(int location, int[] arr_loc, hero obj) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Moving to location " + location + "\n" + "Fight Started. You're fighting a level " + arr_loc[location - 1] + "  Monster.");
//        me.attack;
        Monster mon;
        if (arr_loc[location - 1] == 1) {
            mon = new Goblins();
        } else if (arr_loc[location - 1] == 2) {
            mon = new Zombies();
        } else if (arr_loc[location - 1] == 3) {
            mon = new Fiends();
        } else {
            mon = new Lionfang();
        }
        while (mon.hp > 0) {
            fight(obj, mon);
//               obj.xp+=20;
        }
        if (mon.hp <= 0) {
            level++;
            System.out.println("Monster killed!\n" + "20 XP awarded\n" + "Level Up: level:"+level);
            
            obj.xp += 20;
            obj.attack_value+=1;
            obj.defence_value+=1;
            if(level==2){
                obj.hp=150;
            }
            if(level==3){
                obj.hp=200;
            }
            if(level==4){
                obj.hp=250;
            }
            System.out.println("Fight won proceed to the next location.\n" + "You are at location 0 Choose path:\n" + "1) Go to Location 1\n" + "2) Go to Location 4\n" + "3) Go to Location 7\n" + "4) Go back\n" + "Enter -1 to exit");
            int in_loc = Sc.nextInt();
            location(location, arr_loc, obj);
        }
        
    }

    public static void fight(hero obj, Monster mon) {
        counter++;
        Scanner Sc = new Scanner(System.in);
        if (counter > 3) {
            System.out.println("Choose move:\n" + "1) Attack\n" + "2) Defense\n" + "3) Special Attack");
        } else {
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
            System.out.println("Your HP: "+obj.hp +"/"+ total+ "Monsters HP: "+ mon.hp);
            mon.attack(obj);
            System.out.println("Your Hp:"+ obj.hp+"/" + total +" Monsters Hp:" +mon.hp);
            
        } else if (move == 2) {
            obj.defence(mon);
            System.out.println("Your HP: "+obj.hp +"/"+ total+ "Monsters HP: "+ mon.hp);
        } else {
            counter=0;
            obj.special(mon);
            System.out.println("Your HP: "+obj.hp +"/"+ total+ "Monsters HP: "+ mon.hp);
            mon.attack(obj);
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

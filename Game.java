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
        for(int j=0;j<7;j++){
            System.out.print(arr_loc[j]+ " ");
        }
        System.out.println();
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
            System.out.println("Choose a Hero\n" + "1) Warrior\n" + "2) Mage\n" + "3) Thief \n" + "4) Healer");
            int type = Sc.nextInt();
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
            counter=0;
            if(level==2){
                obj.hp=150;
            }
            if(level==3){
                obj.hp=200;
            }
            if(level==4){
                obj.hp=250;
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
            System.out.println("Your HP: "+obj.hp +"/"+ total+ " Monsters HP: "+ mon.hp+"/"+mon.maxhp);
            mon.attack(obj);
            System.out.println("Your Hp:"+ obj.hp+"/" + total +" Monsters Hp:" +mon.hp+"/"+mon.maxhp);
            
        } else if (move == 2)
        {
            obj.defence(mon);
            System.out.println("Your HP: "+obj.hp +"/"+ total+ " Monsters HP: "+ mon.hp+"/"+mon.maxhp);
            
        } else {
            counter=0;
            obj.special(mon);
            System.out.println("Your HP: "+obj.hp +"/"+ total+ " Monsters HP: "+ mon.hp+"/"+mon.maxhp);
            mon.attack(obj);
            System.out.println("Your HP: "+obj.hp +"/"+ total+ " Monsters HP: "+ mon.hp+"/"+mon.maxhp);
            
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

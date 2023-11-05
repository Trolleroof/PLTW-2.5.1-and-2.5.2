/*
 * Activity 2.5.2
 */

import java.util.Scanner;

public class Player
{
 private String name = ""; 
 private double points;
 
 public Player(){
    System.out.print("Enter Player name: ");
    Scanner sc = new Scanner(System.in);
    String newName = sc.nextLine();
    name = newName;
    points = 0;
    System.out.println("Welcome to the game, "+newName);
 }

 public Player(String inputName){
    this.name = inputName;
    points = 0;
    System.out.println("Welcome to the game, "+inputName);

 }


 public String getName()
 {
   return name;
 }
 
 public void setName(String x)
 {
   name = x;
 }
  
 public double getPoints()
 {
   return points;
 }
  
} 


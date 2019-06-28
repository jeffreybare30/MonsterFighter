/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterFighter;
import java.util.*;

/**
 *
 * @author JeffBare
 */
public class DragonSlayerTest {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic 
        
        int i = 1;
        int j = 0;
        int random = 0;
        char terrain = 'a';
        String move = "a";
        char [][] terrainMap = new char [8][8];
        Scanner input = new Scanner(System.in);
        int enemyType;
        int attacked;
        
        //Set up Terrain Map
        
        
        char grass = 'G';
        char water = 'W';
        char mountain = 'M';
       
        //Testing Enemy and Hero Creation Classes and methods.
        
        Random numGen = new Random();
        
        EnemyClass newEnemy = new EnemyClass(enemyType = (numGen.nextInt(3)+ 1));
        
        System.out.println("Random Number: " + enemyType);
        
        newEnemy.printEnemy(newEnemy);
        
        HeroClass newHero = new HeroClass();
        
        newHero.printHero();
        
        newHero.addEXP(28);
        newHero.printHero();
        
        newHero.addEXP(30);
        newHero.printHero();
        
        newHero.addEXP(17);
        newHero.printHero();
        
        
        //Lines to test the new Map Creation Class and it's methods
        
        MapBuilder map = new MapBuilder();
        
        map.printMap();
        
        //String test = newEnemy.printEnemy(newEnemy);
        //System.out.println(test);
        //System.out.println("The enemy attack power is: " + newEnemy.getAttack());
        
        
         //Commented out the majority of code to test the enemy creation class
         
        /* 
        for(i = 0; i <= 7; i++)
        {
           if(i != 0) 
           {
               System.out.print("\n");
           }
           
           for(j = 0; j <= 7; j++)
           {
               terrain = terrain();
               terrainMap[i][j] = terrain;
               System.out.print("[" + terrain + "]");
           }
            
        }
        
        System.out.println();
        
        System.out.println("TEST OF ARRAY OUTPUT: ");
        
        System.out.println("Array Check 1: " + terrainMap[5][7]);
        System.out.println("Aaray Check 2: " + terrainMap[3][4]);
    
        //System.out.println(printTerrain(8));
        
        System.out.println("Please enter your move: W to move up, S to move down,");
        System.out.println("A to move to the left, or D to move to the right.");
        
        move = input.next();
                
        
        System.out.println("Your entered move: " + (move.toUpperCase()));
        
        //while(move != "Q" && inputCheck(move))

            int curX = 0;
            int curY = 0;
            char curTerrain = 'E';
            
            int newX;
            int newY;

            curX = numGen.nextInt(7) + 1;
            curY = numGen.nextInt(7) + 1;
            
            System.out.println("Your starting position is [" + curX + "," +curY + "]");
            
            curTerrain = terrainMap[curX][curY];
            terrainMap[curX][curY] = 'I';
            
            
        while(!(move.equals("Q")))
        {
            
            
            
            //Print Map
            for(i = 0; i <= 7; i++)
            {
                if(i != 0) 
                {
                    System.out.print("\n");
                }
           
                for(j = 0; j <= 7; j++)
                {

                    System.out.print("[" + terrainMap[i][j] + "]");
                }
            
        }
            
            
            //move = "Q";
            System.out.println();
            System.out.print("Please enter your next move:");
            move = input.next();
            move = move.toUpperCase();
        
            terrainMap[curX][curY] = curTerrain;
        
            //Update position for Moving up in the map.
            if(move.equals("W") && (curX - 1 > -1))
            {
                curX = curX - 1;
                curTerrain = terrainMap[curX][curY];
                terrainMap[curX][curY] = 'I';
            }
            else if(move.equals("S") && (curX + 1 < 8))
            {
                curX = curX + 1;
                curTerrain = terrainMap[curX][curY];
                terrainMap[curX][curY] = 'I';
            }
            else if(move.equals("A") && (curY + 1 > -1))
            {
                curY = curY - 1;
                curTerrain = terrainMap[curX][curY];
                terrainMap[curX][curY] = 'I';
            }
            else if(move.equals("D") && (curY + 1 < 8))
            {
                curY = curY + 1;
                curTerrain = terrainMap[curX][curY];
                terrainMap[curX][curY] = 'I';
            }
            
            //Random number generator to see if the player is attacked.
            attacked = numGen.nextInt(99)+ 1;
            System.out.println("Random Attack Roll: " + attacked);
            
            attackCheck(attacked);

            
        }
        
        System.out.println("Thanks for playing!");
        */

    }

    
    public static char terrain()
    {
        Random numGen = new Random();
        int num = numGen.nextInt(3) + 1;
        char terrainChar;
        
        switch(num)
        {
            case 1:
            terrainChar = 'G';
                break;
            case 2:
                terrainChar = 'W';
                break;
            case 3:
                terrainChar = 'M';
                break;
            default:
                terrainChar = 'E';
            
        }
        
        return terrainChar;
    }
    
    public static boolean inputCheck(String input)
    {
        String i = input;
        i = i.toUpperCase();
        boolean result = false;
        
        if(i=="W"|| i=="A" || i=="S" || i=="D")
         {
          result = true;
         }
        else
        {
            System.out.println("You had bad input: " + i);
            result = false;
        }
                
        return result;
               
    }
    
    public static void attackCheck(int num)
    {
        int check = num;
        
        if(check < 26)
        {
            System.out.println("You have been attacked.");
        }
        else
        {
            System.out.println("You were not attacked.");
        }
    }
}
    
   /* public static char printTerrain(int length)
    {
        int len = length;
        int i, j;
        char map[][] = new char [length] [length];
        char type = 'a';
        
        for(i = 0; i <= 7; i++)
        {
           if(i != 0) 
           {
               System.out.print("\n");
           }
           
           for(j = 0; j <= 7; j++)
           {
               type = terrain();
               map[i][j] = type;
           }
            
        }
        
        return type;
        
        
    }
    
    
    
    void mapCreate(char map[][])
    {
        int i = 0;
        int j = 0;
        char grass = 'G';
        char water = 'W';
        char mountain = 'M';
        char terrain = 'e';
        char terrainMap[][] = map;
        
        Random numGen = new Random();
        
        
        for(i = 0; i <= 7; i++)
        {
           if(i != 0) 
           {
               System.out.print("\n");
           }
           
           for(j = 0; j <= 7; j++)
           {
               terrain = terrain();
               terrainMap[i][j] = terrain;
               System.out.print("[" + terrain + "]");
           }
            
        }
        
        System.out.println();
        
        System.out.println("TEST OF ARRAY OUTPUT: ");
        
        System.out.println("Array Check 1: " + terrainMap[5][7]);
        System.out.println("Aaray Check 2: " + terrainMap[3][4]);
    
    }
    
}
* 
*/

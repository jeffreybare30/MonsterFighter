/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterFighter;

import java.util.*;

/**
 * 
 * This class holds all of the methods that are used to generate the enemies,
 * may be expanded to pull from a class that only holds the enemy stats.
 * 
 *
 * @author JeffBare
 */
public class EnemyClass {
    
    //Type of enemy being created.  Pulled from a switch statement that keeps
    //track of the types of enemies available to battle.
    private int enemyType;
    
    //Holds the maximum of Hit Points
    private int maxHP;
    
    //Holds the amount of enemy attack power.
    private int attackPower;
    
    //Holds the amount of enemy defense power.
    private int defensePower;
    
    //Enemy Nmae
    private String enemyName;
    
    //Amount of expierence gained for defeating enemy
    private int expGained;
    
    //Name of picture file.
    private String logoName;
    
    //Amount of enemy health
    private int hp;
    
    //Does the enemy hold the key
    private boolean key;

    //How much gold the enemy can be carrying.
    private int gold;
    
    EnemyClass(int eType)
    {
        
        int hp, atk, def, exp, gld;
        int type = eType;
        String name = "";
        String lName = "";
    
        switch(type){
            case(1):
                name = "Imp";
                lName = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\impguy.jpg";
                hp = 15;
                atk = 2;
                def = 1;
                exp = 6;
                gld = 6;
                break;
            case(2):
                name = "Wolf";
                lName = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\wolfguy.jpg";
                hp = 25;
                atk = 4;
                def = 3;
                exp = 10;
                gld = 10;
                break;
            case(3):
                name = "Ogre";
                lName = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\ogreguy.jpg";
                hp = 50;
                atk = 10;
                def = 10;
                exp = 28;
                gld = 28;
                break;
            default:
                name = "UNKNOWN";
                hp = 0;
                atk = 0;
                def = 0;
                exp = 0;
                gld = 0;
                break;      
    }
        enemyType = eType;
        enemyName = name;
        logoName = lName;
        maxHP = hp;
        attackPower = atk;
        defensePower = def;
        expGained = exp;
        gold = gld;
        keyHolder();

        
    }
    
    
    


    public void setMaxHP(int enemyType)
    {
        int hp;
        int type = enemyType;

        switch(type){
            case(1):
                hp = 15;
                break;
            case(2):
                hp = 25;
                break;
            case(3):
                hp = 50;
                break;
            default:
                hp = 0;
                break;      
        }

        maxHP = hp;

    }

    public void setAttack(int enemyType)
    {
        int attack = 15;
        int type = enemyType;

        switch(type){
            case(1):
                attack = 1;
                break;
            case(2):
                attack = 2;
                break;
            case(3):
                attack = 5;
                break;
            default:
                attack = 0;
                break;      
        }
    
     attackPower = attack;

}


    public void setDefense(int enemyType)
    {
        int defense;
        int type = enemyType;

        switch(type){
            case(1):
                defense = 1;
                break;
            case(2):
                defense = 2;
                break;
            case(3):
                defense = 5;
                break;
            default:
                defense = 0;
                break;      
        }

         defensePower = defense;

    }

    public int getHP()
    {

        return maxHP;
    }
    
    public void setHP(int i)
    {
        int newHP = i;
        hp = newHP;
    }

    public int getAttack()
    {

        return attackPower;
    }

    public int getDefense()
    {

        return defensePower;
    }

    public String getName()
    {
        return enemyName;
    }

    public int getExp()
    {
        return expGained;
    }
    
    
    public void printEnemy(EnemyClass e)
    {
        //String test;
        System.out.println("The enemy's Name: " + e.getName());
        System.out.println("The enemy's HP: " + e.getHP());
        System.out.println("The enemy's Attack Power: " + e.getAttack());
        System.out.println("The enemy's Defense Power: " + e.getDefense());
        System.out.println("You gained " + e.getExp() + " experience points.");
        //test = "The enemy's HP is: " + e.getHP() + "\n The enemy's Attack Power is: " +
        //        e.getAttack() + "\n The enemy's Defense Power is: " + e.getDefense();

        //return test;
    }


    public String getLogo()
    {
        return logoName;
    }
    
    public int attack(EnemyClass e)
    {
        int damage;
        
        damage = (int)(e.getAttack() * .8);
        
        return damage;
    }

    
    public void keyHolder()
    {


            Random numGen = new Random();
            int num = numGen.nextInt(99) + 1;
            
            if(num <= 15)
            {
                key = true;
            }
            else{
                key = false;
            }
  
                 
    }
    
    public boolean keyCheck()
    {
        return key;
    }
    
    public int maxGold()
    {
        return gold;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MonsterFighter;
import java.util.*;
/**
 * This class holds the methods for creating the hero class and relaying attack
 * damage dealt to an enemy.
 *
 * @author JBare
 */
public class HeroClass {
    
    private String name;
    private int maxHP;
    private int currentHP;
    private int attackPower;
    private int defensePower;
    private int expPoints;
    private int levelUpPoints;
    private int level;
    private int potionCount;
    private Random num;
    private boolean key;
    private int goldCount;
    private int displayLevel;
    private Weapon weap;
    private String weapImageName;
    private String weapText;

    
    HeroClass()
    {
        String tempName;
        Scanner input = new Scanner(System.in);
        /*
        System.out.println("Please enter the name of your Hero: ");
        tempName = input.next();
        int length = tempName.length();
        if (length < 6)
        {
            //Do Nothing
        }
        else
        {
            tempName = tempName.substring(0,6);
        }
                */
        Random gen = new Random();
        
        int wNum = gen.nextInt(2) + 1;
        weap = new Weapon(wNum);
        name = "Wilbo";
        //name = tempName.toUpperCase();
        maxHP = 70;
        currentHP = maxHP;
        attackPower = 10;
        defensePower = 8;
        expPoints = 0;
        levelUpPoints = 50;
        level = 1;
        potionCount = 3;
        key = false;
        displayLevel = 0;
        //chooseWeapon();
        weapImageName = weap.getImageName();
        weapText = weap.getWeapText();
        System.out.println("Weapon roll value: " + wNum);
        System.out.println("Wearpn Image: " + weap.getImageName());
        
        
     
    }
    
    public int attack()
    {
        int damage;
        Random num = new Random();
        //System.out.println("Begin Method");
        int atkPwr = getAtkPwr();
        //System.out.println("Attack Power: " + atkPwr);
        damage = num.nextInt(attackPower)+ 6;
        
        damage = damage + (int)(Math.floor(damage * (2 / atkPwr)));
        //System.out.println("Damage Dealt: " + damage);
        return damage;      
    }
    
    public int getAtkPwr()
    {
        return attackPower;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void damageHP(int damage)
    {
        int hp = getHP();
        currentHP = hp - damage;
    }

    public int getHP()
    {
        return currentHP;
    }
    
    public void setHP(int i)
    {
        currentHP =  i;
        
    }
    
    public void setHP()
    {
        //To set HP as max amount.
        currentHP = maxHP;
    }
    
    public int getMaxHP()
    {
        return maxHP;
    }
    
    public void addEXP(int exp)
    {
        expPoints = expPoints + exp;
        
        /*
        if(expPoints >= levelUpPoints)
        {
            setLevelUp();
            setExp(0);
            level++;
            
        }
        */
    }
    
    public int getExp()
    {
        return expPoints;
    }
    
    public void setExp(int num)
    {
        expPoints = num;
    }
    
    public int getLevelUpExp()
    {
        return levelUpPoints;
    }
    
    public void setLevelUp()
    {
        int levUP = getLevelUp();
        double levPercent = levUP * 1.5;
        double hpIncrease = maxHP * 2;
        maxHP = ((int)(hpIncrease));
        levelUpPoints += (int)(levPercent);
        level++;
        setExp(0);
        System.out.println("You have leveled up to: " + level);
        System.out.println("New Max HP: " + maxHP);
        System.out.println("New Exp Points to Level Up: " + levelUpPoints);
    }
    
    public int getLevelUp()
    {
        return levelUpPoints;
    }
    
    public void printHero()
    {
        //Prints out Hero's Stats
        System.out.println("Your Hero's name is: " + name);
        System.out.println(name + " is level " + level);
        System.out.println("Your max HP is: " + maxHP);
        System.out.println("Your current HP is: " + currentHP);
        System.out.println("Your total EXP Points: " + expPoints);
        System.out.println("You need " + (levelUpPoints - getExp()) + " to level up.");
    }
    
    public int usePotion()
    {
        
        int healAmount = 0;
        int temp = 0;
        double temp1;
        int remainingPots = getPotionCount();
        Random num = new Random();
        //System.out.println("Starting UsePotion Method.");
        if(remainingPots > 0)
        {
            temp1 = maxHP * .4;
            temp = (int)(temp1);
            healAmount = num.nextInt(temp) + 5;
            decreasePotionCount();
        }
        else
        {
            System.out.println("You don't have enough Potions.");
        }
        
        //System.out.println("Ending UsePotion Method.");
        return healAmount;
    }
    
    public int getPotionCount()
    {
        return potionCount;
    }
    
    public void decreasePotionCount()
    {
        //System.out.println("Starting DecreasePotion Method.");
        potionCount = potionCount - 1;
        //System.out.println("You have " + getPotionCount() + " potions remaining.");
        //System.out.println("Ending DecreasePotion Method.");
    }
    
    public void increasePotionCount(int numPots)
    {
        
        potionCount += numPots;
    }
    
    public void foundKey()
    {
        key = true;
    }
    
    public boolean keyCheck()
    {
        boolean x;
        if(key == true)
        {
            x = true;
        }
        else
        {
            x = false;
        }
        
        return x;
        
    }
    
    public void addGold(int gold)
    {
        goldCount += gold;
    }
    
    public int getGold()
    {
        return goldCount;
    }
    
    public String increaseLevel()
    {
        displayLevel++;
        return ("Level: " + displayLevel);
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public String getWeapImageName()
    {
        return weapImageName;
    }
    
    public String getWeapText()
    {
        return weapText;
    }
}

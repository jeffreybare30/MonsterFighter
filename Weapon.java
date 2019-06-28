/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterFighter;
import java.util.*;

/**
 *
 * @author JBare
 */
public class Weapon {
    
    private Random num;
    //private int randomNum = chooseWeapon();
    int numFromHero;
    private int attackPow;
    private String imageName;
    private String weapText;
    private int critChance;
    
    
    private int chooseWeapon()
    {
        Random number = new Random();
        
        int num1 = number.nextInt() + 1;
        
        return num1;
    }
    
    public int setAttackPower(int num)
    {
        int atkPwr;
        
        switch(num){
            case (1):
                //Sword
                atkPwr = 10;
                break;
            case (2):
                //Axe
                atkPwr = 14;
                break;
            default:
                atkPwr = 0;
                break;
        }
                
        return atkPwr;
    }
    
    public String setImageName(int num)
    {
        String name;
        
        switch(num){
            case (1):
                //Sword
                name = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\sword.jpg";
                break;
            case (2):
                //Axe
                name = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\axe.jpg";
                break;
            default:
                name = "Error";
                break;
        }
        
        return name;
    }
    
    public String setWeapText(int num)
    {
        String weapText;
        
        switch(num){
            case (1):
                //Sword
                weapText = "Sword";
                break;
            case (2):
                //Axe
                weapText = "Axe";
                break;
            default:
                weapText = "Error";
                break;
        }
        
        return weapText;
    }
    
    public int setCritChange(int num)
    {
        int critChance;
        
        switch(num){
            case (1):
                //Sword
                critChance = 7;
                break;
            case (2):
                //Axe
                critChance = 5;
                break;
            default:
                critChance = 0;
                break;
        }
        
        return critChance;
    }
    
    public String getImageName()
    {        
        return imageName;
    }
    
    public int getAttackPower()
    {       
        return attackPow;
    }
    
    public String getWeapText()
    {
        return weapText;
    }
    
    Weapon(int num)
    {
        
        numFromHero = num;
        imageName = setImageName(numFromHero);
        attackPow = setAttackPower(numFromHero);
        weapText = setWeapText(numFromHero);
        
        System.out.printf("your weapon is: %s\n", weapText);
        System.out.printf("number from hero: %d\n", numFromHero);
    }
    
}

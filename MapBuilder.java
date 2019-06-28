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
public class MapBuilder {
    
    int xLength;            //Width of game board
    int yLength;            //Height of game board
    int currPost;           //Player's current position
    int lastPost;           //Player's last postion
    int curX;               //Current position on the X-Axis
    int curY;               //Current position on the Y-Axis
    int xStart;             //Starting position for hero on X-Axis
    int yStart;             //Starting position for hero on Y-Axis
    int xStore;             //Position for Store on X-Axis
    int yStore;             //Position for Store on Y-Axis
    int moveCount = 0;      //Counts number of moves made by player
    char[][] newMap;        //Creates the 2-D array that holds the map information
    char currTerrain;       //Holds the current terrrian tile type
    char origTerrain;       //Holds the starting position terrain
    String[] discovered = new String[64];
    boolean newLoc = false;
    String loc = "";

    MapBuilder()
    {

        int i;
        int j;
        char terrain;
        xLength = 8;
        yLength = 8;
        //char newMap[][];
        newMap = new char[xLength][yLength];
        boolean flag = false;
        //boolean discovered = false;
        
        
        for(i = 0; i <= xLength - 1; i++)
        {
           if(i != 0) 
           {
               //System.out.print("\n");
           }
           
           for(j = 0; j <= yLength - 1; j++)
           {
               terrain = terrain();
               newMap[i][j] = terrain;
               //System.out.print("[" + terrain + "]");
           }
            
        }
        
        
        Random numGen = new Random();
        //Places the Treasure Chest on the map

        int xNum, xNum1, xNum2, yNum, yNum1, yNum2;

 
        xNum = numGen.nextInt(6) + 1;
        yNum = numGen.nextInt(6) + 1;
        currTerrain = newMap [xNum][yNum];
        System.out.printf("Original terrain for hero: %c\n", currTerrain);
        origTerrain = currTerrain;
        xStart = xNum;
        yStart = yNum;
        newMap[xNum][yNum] = 'I';
        setPost(xNum,yNum);
        System.out.printf("Hero Position:%d , %d\n", xNum, yNum);
        
        /*
        *Do-While loop to attempt to place the treasure chest on the game map
        *will exucte once to choose a location, if it is the same location as
        *the player it will execute again to choose new location.
        */
        do{
            
            xNum1 = numGen.nextInt(6) + 1;
            yNum1 = numGen.nextInt(6) + 1;
            
            
            //newMap[xNum1][yNum1] = 'T';
            System.out.printf("Treasure placed at %d , %d \n", xNum1, yNum1);
        }while(xNum == xNum1 && yNum == yNum1);
        
        //Places the treasure chest
        newMap[xNum1][yNum1] = 'T';
               
        /*
        *Do-While loop to attempt to place the store on the game map
        *will exucte once to choose a location, if it is the same location as
        *the treasure chest or player it will execute again to choose new location.
        */
        do{
           //Places the Treasure Chest on the map
            xNum2 = numGen.nextInt(6) + 1;
            yNum2 = numGen.nextInt(6) + 1; 
            
            System.out.printf("Store placed at %d , %d \n", xNum2, yNum2);
        }while((xNum == xNum2 && yNum == yNum2)||(xNum1 == xNum2 && yNum1 == yNum2));
        //Places the Store on the map.
        newMap[xNum2][yNum2] = 'S';
        xStore = xNum2;
        yStore = yNum2;
        
        currTerrain = origTerrain;
    }
    
    /**
     *
     * @return
     */
    public static char terrain()
    {
        Random numGen = new Random();
        int num = numGen.nextInt(99) + 1;
        char terrainChar;
        
        if(num >= 50)
        {
            //create grass land tile
            num = 1;
        }
        else if(num < 50 && num >= 20)
        {
            //creates forrest tile
            num = 2;
        }
        else if(num < 20)
        {
            //creates mountain tile
            num = 3;
        }
        
        
        switch(num)
        {
            case 1:
            terrainChar = 'G';
                break;
            case 2:
                terrainChar = 'F';
                break;
            case 3:
                terrainChar = 'M';
                break;
            default:
                terrainChar = 'E';
            
        }
        return terrainChar;
    }
    
    /**
     *
     */
    public void printMap()
    {
        int i;
        int j;
        //char [][]newMap = map;
        
        for(i = 0; i <= xLength - 1; i++)
        {
            if(i != 0)
            {
                System.out.print("\n");
            }
                    
            
            for(j = 0; j <= yLength - 1; j++)
            {
                System.out.print("[" + getTerrain(i,j) + "]");
            }
        }
        System.out.println(); //Add blank line after map output.
        System.out.println();
    }
    
    /**
     * Returns the type of terrain based on the coords provided.
     * @param x
     * @param y
     * @return character denoting type of terrain
     */
    public char getTerrain(int x, int y)
    {
        //System.out.println("ERROR in getTerrain method X = " + x + " Y = " + y);
        char terrain = newMap[x][y];
        //System.out.println("Current Terrain: " + terrain);
        return terrain;

    }
    
    /**
     *
     * @return
     */
    public char getTerrain()
    {
        return currTerrain;
    }
    
    /**
     * Method to move the players icon around the game board
     * Condenses the similar MoveNorth, MoveSouth, MoveEast, MoveWest methods
     * @param x Direction to move the player.
     * @return
     */
    public char movePlayer(char x)
    {
        
        char terrainType = 'a';
        moveCounter();
        
        switch(x){
            case 'N':
                
                setTerrain(curX, curY, currTerrain);

                if((curX - 1) > -1)
                {
                    currTerrain = newMap[curX - 1][curY];
                    terrainType = getTerrain();
                    newMap[curX - 1][curY] = 'I';
                    curX = curX - 1;
                    //terrainType = newMap[curX][curY];
                }
                else
                {
                    return 'e';
                }
            break;
            case 'E':
                setTerrain(curX, curY, currTerrain);
        
                if((curY + 1) < yLength)
                {
                    currTerrain = newMap[curX][curY + 1];
                    terrainType = getTerrain();
                    newMap[curX][curY + 1] = 'I';
                    curY = curY + 1;
                    //terrainType = newMap[curX][curY];
                }
                else
                {
                    return 'e';
                }
            break;
            case 'W':
                
                setTerrain(curX, curY, currTerrain);
                if((curY - 1) > -1)
                {
                    currTerrain = newMap[curX][curY - 1];
                    terrainType = getTerrain();
                    newMap[curX][curY - 1] = 'I';
                    curY = curY - 1;
                    //terrainType = newMap[curX][curY];
                }
                else
                {
                    return 'e';
                }
            break;
            case 'S':
                setTerrain(curX, curY, currTerrain);
        
                if((curX + 1) < xLength)
                {
                    currTerrain = newMap[curX + 1][curY];
                    terrainType = getTerrain();
                    newMap[curX + 1][curY] = 'I';
                    curX = curX + 1;
                    //terrainType = newMap[curX][curY];
                }
                else
                {
                    return 'e';
                }
        }
        
        return terrainType;
    }
    
    /**
     * Moves the Player one tile North
     * Moves the value contained in currTerrain to the tile the player was standing on
     * Moves the terrain value for the new tile to currTerrain
     * Moves the player icon to the new tile.
     * @return
     */
    public char moveNorth()
    {
        char terrainType = 'a';
        moveCounter();
        setTerrain(curX, curY, currTerrain);
        
        if((curX - 1) > -1)
        {
            currTerrain = newMap[curX - 1][curY];
            terrainType = getTerrain();
            newMap[curX - 1][curY] = 'I';
            curX = curX - 1;
            //terrainType = newMap[curX][curY];
        }
        else
        {
            return 'e';
        }
        
        return terrainType;
    }
    
    /**
     * Moves the Player one tile East
     * Moves the value contained in currTerrain to the tile the player was standing on
     * Moves the terrain value for the new tile to currTerrain
     * Moves the player icon to the new tile.
     * @return
     */
    public char moveEast()
    {

        char terrainType = 'a';
        moveCounter();
        setTerrain(curX, curY, currTerrain);
        
        if((curY + 1) < yLength)
        {
            currTerrain = newMap[curX][curY + 1];
            terrainType = getTerrain();
            newMap[curX][curY + 1] = 'I';
            curY = curY + 1;
            //terrainType = newMap[curX][curY];
        }
        else
        {
            return 'e';
        }
        
        return terrainType;
    }
    
    /**
     * Moves the Player one tile South
     * Moves the value contained in currTerrain to the tile the player was standing on
     * Moves the terrain value for the new tile to currTerrain
     * Moves the player icon to the new tile.
     * @return
     */
    public char moveSouth()
    {
        char terrainType = 'a';
        moveCounter();
        setTerrain(curX, curY, currTerrain);
        
        if((curX + 1) < xLength)
        {
            currTerrain = newMap[curX + 1][curY];
            terrainType = getTerrain();
            newMap[curX + 1][curY] = 'I';
            curX = curX + 1;
            //terrainType = newMap[curX][curY];
        }
        else
        {
            return 'e';
        }
        
        return terrainType;
    }
    
    /**
     * Moves the Player one tile West
     * Moves the value contained in currTerrain to the tile the player was standing on
     * Moves the terrain value for the new tile to currTerrain
     * Moves the player icon to the new tile.
     * @return
     */
    public char moveWest()
    {
        char terrainType = 'a';
        moveCounter();
        if(moveCount == 1)
        {
          //Do Nothing  
        }
        else{
            System.out.println("Running Move West set Terrain");
            setTerrain(curX, curY, currTerrain);
        }
        
        if((curY - 1) > -1)
        {
            currTerrain = newMap[curX][curY - 1];
            terrainType = getTerrain();
            newMap[curX][curY - 1] = 'I';
            curY = curY - 1;
            //terrainType = newMap[curX][curY];
        }
        else
        {
            return 'e';
        }
        
        return terrainType;
    }
    
    /**
     * Sets the player cursor to position [x,y]
     * @param x position in the x-axis
     * @param y position in the y-axis
     */
    public void setPost(int x, int y)
    {  
        //Save inital terrain type
        
        curX = x;
        curY = y;
        currTerrain = newMap[x][y];
        
        //move player cursor to terrain.
        //setTerrain(x,y,'I');
        //newMap[x][y] = 'I';
    }

    /**
     * Sets the terrain type of position [x,y] to type t
     * @param x position in the x-axis
     * @param y position in the y-axis
     * @param t terrain type being set at [x,y]
     */
    public void setTerrain(int x, int y, char t)
    {
        newMap[x][y] = t;
        System.out.println("Running setTerrain()");
        System.out.printf("Replacing %d,%d with %c\n",x,y,t);
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void addLoc(int x, int y)
    {
        String xLoc = Integer.toString(x);
        String yLoc = Integer.toString(y);
        String loc = xLoc + yLoc;
        
        int counter = 0;
        
        checkLoc();
        
        //discovered[counter] = loc;
        
        counter++;
    }
    
    /**
     *
     */
    public void checkLoc()
    {
        int len = discovered.length;
        int i = 0;
        boolean flag = false;
        
        for(i = 0; i < len + 1; i++)
        {
            if(discovered[i] != loc)
            {
                flag = true;
            }
            
        }
        
        if(flag = true)
        {
            discovered[len + 1] = loc;
        }
    }
    
    
    /*
        
    */

    /**
     * This method returns the image file for the terrain tile that is passed
     * as parameters
     * @param x
     * @param y
     * @return
     */
    
    public String getTerrainColor(int x, int y)
    {
        //System.out.println("ERROR in getTerrain method X = " + x + " Y = " + y);
        char terrain = newMap[x][y];
        String color = "Error";
        //System.out.println("Current Terrain: " + terrain);
        switch(terrain){
            case 'G':
                color = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\grassColor.jpg";
                break;
            case 'F':
                color = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\forestColor.jpg";
                break;
            case 'M':
                color = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\mountianColor.jpg";
                break;
            case 'T':
                color = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\chestColor.jpg";
                break;
            case 'I':
                color = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\player.jpg";
                break;
            case 'S':
                color = "C:\\Users\\JBare\\Documents\\NetBeansProjects\\MonsterFighter\\store2.jpg";
                break;
            default:
                System.out.printf("Unable to set color for %d,%d.\n", x, y);
            }    
        return color;

    }
    
    /**
     *
     */
    public void moveCounter()
    {
        moveCount++;
        System.out.printf("Number of moves: %d\n", moveCount);
        
        switch(moveCount)
        {
            case 1:
                System.out.println("Starting change terrain");
                changeTerrain(origTerrain);
                moveCount++;
                break;
            default:
                System.out.println("No changes to map made");
        }
        
        /*
        if(moveCount == 1)
        {
            System.out.println("Starting change terrain");
            changeTerrain(origTerrain);
        }
                */
    }
     
    /**
     *
     * @param x
     */
    public void changeTerrain(char x)
    {
        //char y = x;
        System.out.printf("Replacing starting tile with %c\n", x);
        //setTerrain(xStart, yStart,x);
        newMap[xStart][yStart] = x;
    }
}

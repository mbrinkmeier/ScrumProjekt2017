import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int xPosition=0;
    public int yPosition=0;  
    public String key;
    
    public Player(int x, int y) {
        xPosition = x;
        yPosition = y;
    }
    public void act() 
    {
        // Add your action code here.
        key = Greenfoot.getKey();
     
      if(key != null) {
              switch (key) {
                  case "up": yPosition -=1; break;
                  case "down": yPosition +=1; break;
                  case "right": xPosition +=1; break;
                  case "left": xPosition -=1; break;
             }
              setLocation(xPosition,yPosition);
      }
    }   
}    


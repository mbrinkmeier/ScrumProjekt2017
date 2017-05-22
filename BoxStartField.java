import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoxStartField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxStartField extends Actor
{
    /**
     * Act - do whatever the BoxStartField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        boolean BoxPlace=0;
        
        if (start&&!Boxplaced){
            addObject(Actor Box,getX(),getY());
            BoxPlace=1;
        }// Add your action code here.
    }    
}

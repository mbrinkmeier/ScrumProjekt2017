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
        boolean BoxPlaced=false;
        
        //if (start &&!BoxPlaced){//TODO was ist das?
        if (!BoxPlaced){
            getWorld().addObject(new Box(),getX(),getY());
            BoxPlaced=true;
        }// Add your action code here.
    }    
}

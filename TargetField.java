import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TargetField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TargetField extends Actor
{
    /**
     * Act - do whatever the TargetField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        boolean valid=false;
        while ((world.getObjectsAt(getX(),getY()).equals(Box))){
            valid=true;}
        valid=false;    // Add your action code here.
     
}
    public boolean getValid(){
        return valid;
    }
}

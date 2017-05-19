import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author sklecker, eossovski
 * @version 19.05.2017 12:56
 */
public class Wall extends Actor
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    
    protected void addedToWorld(World world) {
       int cellsize = getWorld().getCellSize();
       //System.out.println("Cellsize ist "+cellsize);
       getImage().scale(cellsize,cellsize);
    }
}

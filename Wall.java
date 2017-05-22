import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author sklecker, eossovski
 * @version 19.05.2017 19:51
 */
public class Wall extends Interactable
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
       GreenfootImage wallPic = getImage();
       wallPic.scale(cellsize,cellsize);
       this.setImage(wallPic);
    }
    
    public boolean interact(String keyDirection){
        return false;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kiste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Interactable
{
    /**
     * Act - do whatever the Kiste wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
<<<<<<< HEAD
    }    
    
    protected void addedToWorld(World world) {
       int cellsize = getWorld().getCellSize();
       GreenfootImage boxPic = getImage();
       boxPic.scale(cellsize,cellsize);
       this.setImage(boxPic);
=======
    }
    
    public boolean interact(String keyDirection) {
        int x = getX();
        int y = getY();
        
        // Key Direcetion links, rechts, oben, unten
        
        switch(keyDirection){
            case "left": 
                 setLocation(x,y-1); break;
            case "right":
                 setLocation(x,y+1); break;
            case "up":
                 setLocation(x+1,y); break;
            case "down":
                 setLocation(x-1,y); break;
            default: break;
        }
        return true;
>>>>>>> fc1d33e92314db6e7e514d63b5336777eede1d99
    }
}

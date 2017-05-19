import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicLayout here.
 * 
 * @author ossovski, sklecker, langebrake, NordmannDiekbreder, SchusterGarske
 * @version (a version number or a date)
 * 
 * mbrinkmeier: Weltgeometrie geändert
 * 
 */
public class BasicLayout extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public BasicLayout()
    {    
        // Create a new world with 20x20 cells with a cell size of 40 pixels.
        super(20, 20, 40);
        
        for(int i=0; i<20;i++){ //left side
            addObject(new Wall(),0,i);
        }
        
        for(int i=0; i<20;i++){ //right side
            addObject(new Wall(),19,i);
        }
        
        for(int i=1; i<19;i++){ //upper side
            addObject(new Wall(),i,0);
        }
        
         for(int i=1; i<19;i++){ //lower side
            addObject(new Wall(),i,19);
        }
    }
}

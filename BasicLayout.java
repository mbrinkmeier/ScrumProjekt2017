import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    public void act(){
        String keyPressed = Greenfoot.getKey();
        //um Exception zu vermeiden, Aufruf von equals nicht an keyPressed
        if ("1".equals(keyPressed)){
            Greenfoot.setWorld(new Level1());
        }
        if ("t".equals(keyPressed)){
            Greenfoot.setWorld(new TestWorld());
        }
    }
    
    public void started(){
        //Methodenrumpf mit Anweisungen fuellen, die nach der Initialisierung erfolgen muessen
        showText("Press '1' for Level 1",10,2);
        showText("Press 't' for Testlevel",10,3);
    }
    /**
     * Fügt entsprechend der Markierungen in map die Interactables der Welt hinzu
     */
    protected void transferMapToLevel(String[][] map){
        for (int y = 1; y < map.length-1; y++){
            for (int x = 1; x < map[y].length-1; x++){
                switch(map[y][x]){
                    case "w": addObject(new Wall(),x,y);
                        break;
                    case "p": //addObject(new Player(),x,y);
                        break;
                    case "k": //addObject(new Kiste(),x,y);
                        break;
                    case "f": //addObject(new Finish(),x,y);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    /**
     * liest eine Datei aus dem Ordner "leveldatein" ein, die durch fileName spezifiziert ist und wandelt diese in eine Map um, die zu einem Level verarbeitet werden kann
     */
    protected String[][] transferFileToMap(String fileName){
        fileName = "leveldatein/"+fileName;
        File file = new File(fileName);
        String[][] map = new String[20][0];
        if (!file.canRead() || !file.isFile()){
            System.exit(0);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String zeile = null;
            int zeilennummer = 0;
            while ((zeile = in.readLine()) != null) {
                char[] charzeile = zeile.toCharArray();
                String[] stringzeile = new String[charzeile.length];
                for (int spalte = 0; spalte < charzeile.length; spalte++){
                    stringzeile[spalte] = ""+charzeile[spalte];
                }
                map[zeilennummer] = stringzeile;
                zeilennummer++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
        return map;
    }
}

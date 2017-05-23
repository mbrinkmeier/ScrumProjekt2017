import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Write a description of class BasicLayout here.
 * 
 * @author ossovski, sklecker, langebrake, NordmannDiekbreder, SchusterGarske
 * @version 20.05.2017 19:44
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
     * Ermöglicht es das durch map spezifizierte Level zu spielen
     * @param map - Karte, die in ein Level umgewandelt wird
     */
    protected void transferMapToLevel(String[][] map){
        if (map.length != getHeight()){
            throw new RuntimeException("map hat nicht die richtige Hoehe!");
        }
        for (int i = 0; i < map.length; i++){
            if (map[i].length != getWidth()){
               throw new RuntimeException("map["+i+"] hat nicht die richtige Breite!");
            }
        }
        //map-Rand wird ignoriert, da sonst z.B. Waende doppelt gesetzt werden
        for (int y = 1; y < map.length-1; y++){
            for (int x = 1; x < map[y].length-1; x++){
                switch(map[y][x]){
                    case "w": addObject(new Wall(),x,y);
                        break;
                    case "p": addObject(new Player(x,y),x,y);
                        break;
                    case "b": addObject(new Box(),x,y);
                        break;
                    case "f": addObject(new TargetField(),x,y);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    /**
     * Liest eine Datei aus dem Ordner "leveldatein" ein,
     * die durch fileName spezifiziert ist und wandelt 
     * diese in eine Map um, die zu einem Level 
     * verarbeitet werden kann.
     * 
     * @param fileName - Name der Datei, die verarbeitet werden sollte
     * @return String[][] - kann mittels transferMapToLevel(map) in ein spielbares Level umgewandelt werden
     * @throw RuntimeException, falls Datei nicht richtige Zeilen/Spaltenanzahl hat
     */
    protected String[][] transferFileToMap(String fileName){
        fileName = "leveldatein/"+fileName;
        File file = new File(fileName);
        String[][] map = new String[getHeight()][0];
        if (!file.canRead() || !file.isFile()){
            System.out.println("Leveldatei [leveldatein/"+fileName+"] nicht lesbar");
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
                if (stringzeile.length != getWidth()){
                    throw new RuntimeException("Datei hat in Zeile "+zeilennummer+" nicht die richtige Anzahl Spalten!");
                }
                zeilennummer++;
            }
            if (zeilennummer != getHeight()){
                throw new RuntimeException("Datei hat nicht die richtige Anzahl Zeilen!");
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

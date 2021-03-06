/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.escapeFromInsanityIsland.control;

import byui.cit260.escapeFromInsanityIsland.exceptions.MapControlException;
import byui.cit260.escapeFromInsanityIsland.model.Game;
import byui.cit260.escapeFromInsanityIsland.model.Item;
import byui.cit260.escapeFromInsanityIsland.model.Player;
import byui.cit260.escapeFromInsanityIsland.model.Map;
import byui.cit260.escapeFromInsanityIsland.model.Scene;
import byui.cit260.escapeFromInsanityIsland.model.Location;
import escape.from.insanity.island.EscapeFromInsanityIsland;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;

/**
 *
 * @author user
 */
public class GameControl {
    
    private PrintWriter console;
    
        public void GameControlException() {
            this.console = EscapeFromInsanityIsland.getOutFile();
        }

    public static void createNewGame(Player player) throws MapControlException {
        
        Game game = new Game(); // create new game
        EscapeFromInsanityIsland.setCurrentGame(game); // save in EscapeFromInsanityIsland
        
        game.setPlayer(player); // save player in game
        
        // create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        // game.setInventory(inventoryList)

        
        
        Map map = MapControl.createMap(); // create and initialize new map
        game.setMap(map); // save map in game
        
        // move character to starting position on the map
     //   MapControl.moveCharactersToStartingLocation(map);
        
    } 

    public static InventoryItem[] createInventoryList() {
        
        // created array(list) of inventory items
        InventoryItem[] inventory = new InventoryItem[3];
        
        InventoryItem wood = new InventoryItem();
        wood.setDescription("Wood");
        wood.setQuantityInStock(0);
        wood.setRequiredAmount(0);
        inventory[0] = wood;
        
        InventoryItem ore = new InventoryItem();
        ore.setDescription("Ore");
        ore.setQuantityInStock(0);
        ore.setRequiredAmount(0);
        inventory[1] = ore;
        
        InventoryItem cloth = new InventoryItem();
        cloth.setDescription("Cloth");
        cloth.setQuantityInStock(0);
        cloth.setRequiredAmount(0);
        inventory[2] = cloth;        
        
        return inventory;
    }

    
    public static WorldResources[] createWorldResourceList() {
        
        // created array(list) of inventory items
        
        /*public enum material {
            iron,
            gold,
            diamond,
            stone,
            plank,
            dirt,
        } */
        
        WorldResources[] resource = new WorldResources[6];
        
        WorldResources iron = new WorldResources();
        iron.setDescription("Iron");
        iron.setQuantityInStock(0);
        iron.setRequiredAmount(0);
        resource[1] = iron;
        
        WorldResources gold = new WorldResources();
        gold.setDescription("Gold");
        gold.setQuantityInStock(0);
        gold.setRequiredAmount(0);
        resource[2] = gold;
        
        WorldResources diamond = new WorldResources();
        diamond.setDescription("Diamond");
        diamond.setQuantityInStock(0);
        diamond.setRequiredAmount(0);
        resource[3] = diamond;
        
        WorldResources stone = new WorldResources();
        stone.setDescription("Stone");
        stone.setQuantityInStock(0);
        stone.setRequiredAmount(0);
        resource[4] = stone;
        
        WorldResources plank = new WorldResources();
        plank.setDescription("Plank");
        plank.setQuantityInStock(0);
        plank.setRequiredAmount(0);
        resource[5] = plank;
        
        WorldResources dirt = new WorldResources();
        dirt.setDescription("Dirt");
        dirt.setQuantityInStock(0);
        dirt.setRequiredAmount(0);
        resource[6] = dirt;
       
        return resource;
    }
    
    
    public static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startScene = newScene();
        startScene.setDescription(
                "You awake in a strange land, and you don't know how you got here."
              + "What are you going to do now?");
        startScene.setMapSymbol(" ST ");
        startScene.setBlocked(false);
        startScene.setTravelTime(50);
        scenes[SceneType.start.ordinal()] = startScene;
        
        Scene forestScene = newScene();
        forestScene.setDescription(
                "You have entered a forest. There are a lot of trees and they are staring at you."
              + "Now what?");
        forestScene.setMapSymbol(" ST ");
        forestScene.setBlocked(false);
        forestScene.setTravelTime(75);
        scenes[SceneType.start.ordinal()] = forestScene;
        
        Scene plainsScene = newScene();
        plainsScene.setDescription(
                "You are in the flat plains. There is grass, plenty of flowers, and something buzzing around."
              + "What are you going to do now");
        plainsScene.setMapSymbol(" ST ");
        plainsScene.setBlocked(false);
        plainsScene.setTravelTime(40);
        scenes[SceneType.start.ordinal()] = plainsScene;      
        
        Scene beachScene = newScene();
        beachScene.setDescription(
                "You nearly burn your feet as you step on the hot sand of the beach. The water looks dangerous, yet refreshing."
              + "So, now what?");
        beachScene.setMapSymbol(" ST ");
        beachScene.setBlocked(false);
        beachScene.setTravelTime(20);
        scenes[SceneType.start.ordinal()] = beachScene;  
        
        Scene mountainsScene = newScene();
        mountainsScene.setDescription(
                "You've approaches some very tall mountains, and their shadow plummets you into darkness."
              + "You thought you heard something. What should you do?");
        mountainsScene.setMapSymbol(" ST ");
        mountainsScene.setBlocked(false);
        mountainsScene.setTravelTime(60);
        scenes[SceneType.start.ordinal()] = mountainsScene;        
        
        Scene dockScene = newScene();
        dockScene.setDescription(
                "You arrived at the dock. You might actually be able to escape this insane place."
              + "What are you waiting for?");
        dockScene.setMapSymbol(" ST ");
        dockScene.setBlocked(false);
        dockScene.setTravelTime(10);
        scenes[SceneType.start.ordinal()] = dockScene;       
        
        return scenes;
    }
    
    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        // start point
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.forest.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.plains.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.mountains.ordinal()]);   
        locations[0][5].setScene(scenes[SceneType.dock.ordinal()]);        
        
    }

    private static Scene newScene() {
        System.out.println("*** newScene() function called in GameControl ***");
        Scene Scene = null;
        return Scene;
    }

       private static class GameControlException extends Exception {

        public GameControlException() {
        }

        private GameControlException(String message) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    
    public enum SceneType {
        start,
        forest,
        plains,
        beach,
        mountains,
        dock;
    }
    
    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        
        EscapeFromInsanityIsland.setPlayer(player); // save the player
        
        return player;
    }
    

    public static class InventoryItem {

        public InventoryItem() {
        }

        private void setDescription(String wood) {
            System.out.println("*** setDescription() function called in GameControl ***");
        }

        private void setQuantityInStock(int i) {
            System.out.println("*** setQuantityInStock() function called in GameControl ***");
        }

        private void setRequiredAmount(int i) {
            System.out.println("*** setRequiredAmount() function called in GameControl ***");
        }
    }
    
    public static void saveGame(Game game, String filepath)
            throws GameControlException {
        
        try( FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game); // write the game object out to file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filepath)
                        throws GameControlException {
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); // read the game object from file
        }
         catch(Exception e) {
            throw new GameControlException(e.getMessage());
        } 
        
        // close the output file
        // EscapeFromInsanityIsland.setCurrentGame(game); // save in EscapeFRom InsanityIsland 
    }
}
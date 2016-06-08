/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escapeFromInsanityIsland.view;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class GameMenuView {

    private String promptMessage;
    private String menu;
    public GameMenuView() {
        this.menu = "\n"
                  + "\n---------------------------------------"
                  + "\n| Game Menu                          |"
                  + "\n---------------------------------------"
                  + "\nC - Cunfused"
                  + "\nA - Angry"
                  + "\nW - Worried"
                  + "\nH - Happy"
                  + "\nQ - Quit"
                  + "\n---------------------------------------";
        
        this.promptMessage = "Enter in you current mood";
    }
    
  public void displayMenu() {
      boolean done = false; // set flag to not done
        do{
            //prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q") )// user wants to quit)
                        return; // exist the game
            
            // do the requested action and display the next view
            done = this. doAction(menuOption);
        } while (!done);   
        }

      private String getMenuOption() {
         Scanner Keyboard = new Scanner (System.in); // get infile for keyboard
     String value = ""; // value to be returned
     boolean valid = false; // initialize to not valid
     
     while (!valid){ // loop while an invalid value is enter
         System.out.println("\n" + this.menu);
         System.out.println("\n" + this.promptMessage);
         
         value = Keyboard.nextLine(); // get next line typed on keyboard
         value = value. trim(); // trim off leading and trailing blanks
         
         if (value.length()< 1) { // value is blank
             System.out.println("\nInvalid value: value can not be blank");
             continue;    
         }
         break; // end the loop
    }
    return value;
        
    }

    private boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase();
         switch (menuOption){
            case "C":
                 this.confusedInventory();
                 break;
            case "A":
                this.angryInventory();
                break;
            case "W":
                this.worriedInventory();
                break;
            case "H":
                this.happyInventory();
                break;
            default:
                System.out.println("***Invalid Selection*** Try again");
                break;
         }
       return false; 
    }

    private void confusedInventory() {
        InventoryControlView inventoryControlView = new InventoryControlView();
        inventoryControlView.displayInventoryControlView();
    }

    private void angryInventory() {
        InventoryControlView inventoryControlView = new InventoryControlView();
        inventoryControlView.displayInventoryControlView(); 
    }

    private void worriedInventory() {
        InventoryControlView inventoryControlView = new InventoryControlView();
        inventoryControlView.displayInventoryControlView();
    }

    private void happyInventory() {
        InventoryControlView inventoryControlView = new InventoryControlView();
        inventoryControlView.displayInventoryControlView();
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.escapeFromInsanityIsland.control;

import java.util.Random;

/**
 *
 * @author user
 */
public class CombatControl {
    
    public static int attack(int strength , int defense) {
        if (strength < 5 || strength > 20) {
            return -1;
        }
        
        if (defense <5) {
            return -1;
        }
        
        int healthReturned = strength * defense;
        
        return healthReturned; 
    }       
    
}

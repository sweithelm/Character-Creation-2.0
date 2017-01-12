/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0.Races;

import character.creation.software.pkg2.pkg0.Race;
import javafx.scene.control.Label;

/**
 *
 * @author Glenn
 */
public class Dwarf extends Race{

    public static void displayRaceMenu(){
        
    }
    
    public static void setRaceInfo(){
        raceName = "Dwarf";
        constitution = constitution + 2;
        CONMod = CONMod + 1;
        wisdom = wisdom + 2;
        WISMod = WISMod + 1;
        charisma = charisma - 2;
        CHAMod = CHAMod - 1;
        size = 'M';
        type = "humanoid";
        subType = "Dwarf";
        speed = 20;
        
        languages = new String[2];
        languages[0] = "Common";
        languages[1] = "Dwarven";
        
        
    }
   
}

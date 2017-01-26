/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

/**
 *
 * @author Glenn
 */
public class Character{
    protected static String characterName, alignment, player, deity, raceName, hair, eyes;
    protected static String type, subType;
    protected static String[] languages;
    protected static String[] abilities;
    protected static int skillPoints, fortSave, dexSave, willSave, BAB, SR, CMB, CMD, attackBonus, HP, speed, AC, numOfLanguages;
    protected static int numOfFeats, level, startingGold, numOfFlaws, numOfDrawbacks, numOfTraits, lightLoad, experience, age;
    protected static char size, gender;
    protected static double height, weight;
    protected static boolean caster;
    protected static double strength, dexterity, constitution, intelligence, wisdom, charisma;
    protected static double STRMod, DEXMod, CONMod, INTMod, WISMod, CHAMod;
    
    public Character(){
        strength = 0;
        dexterity = 0;
        constitution = 0;
        intelligence = 0;
        wisdom = 0;
        charisma = 0;
        STRMod = -5;
        DEXMod = -5;
        CONMod = -5;
        INTMod = -5;
        WISMod = -5;
        CHAMod = -5;
    }
    
}

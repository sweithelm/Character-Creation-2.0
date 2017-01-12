/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

import java.util.Random;

/**
 *
 * @author Glenn
 */
public class DiceRolls extends Character{
    private static int dieRollOne;
    private static int dieRollTwo;
    private static int dieRollThree;
    private static int dieRollFour; 
    private static Random randomNum1 = new Random();
    private static Random randomNum2 = new Random();
    private static Random randomNum3 = new Random();
    private static Random randomNum4 = new Random();
        
    public static int rollAbilityScores(){
            
        dieRollOne = randomNum1.nextInt(6);
        dieRollTwo = randomNum2.nextInt(6);
        dieRollThree = randomNum3.nextInt(6);
        dieRollFour = randomNum4.nextInt(6);
        
        if(dieRollTwo >= dieRollOne && dieRollThree >= dieRollOne && dieRollFour >= dieRollOne){
            return ((dieRollTwo + 1) + (dieRollThree + 1) + (dieRollFour + 1));
        }
        else if(dieRollOne >= dieRollTwo && dieRollThree >= dieRollTwo && dieRollFour >= dieRollTwo){
            return ((dieRollOne + 1) + (dieRollThree + 1) + (dieRollFour + 1));
        }
        else if(dieRollOne >= dieRollThree && dieRollTwo >= dieRollThree && dieRollFour >= dieRollThree){
            return ((dieRollOne + 1) + (dieRollTwo + 1) + (dieRollFour + 1));
        }
        else{
            return ((dieRollOne + 1) + (dieRollTwo + 1) + (dieRollThree + 1));
        }
    }
}

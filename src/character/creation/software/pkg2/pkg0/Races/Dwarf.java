/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0.Races;

import character.creation.software.pkg2.pkg0.Race;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import static javafx.scene.text.FontWeight.BOLD;
import javafx.scene.text.Text;

/**
 *
 * @author Glenn
 */
public class Dwarf extends Race{
    protected static Button btBack = new Button("Back");
    protected static Button btSelect = new Button("Select Race");
    protected static Label description = new Label("DESCRIPTION:");
    protected static Label raceTraits = new Label("RACIAL TRAITS:");
    protected static Label alternateTraits = new Label("ALTERNATIVE TRAITS:");
    protected static Label favoredClass = new Label("FAVORED CLASS OPTIONS:");
    protected static Label archetypes = new Label("RACIAL ARCHETYPES:");
    protected static Label raceFeats = new Label("RACIAL FEATS:");
    protected static Text tDescription = new Text();
    protected static Text tTraits = new Text();
    protected static Text tAlternate = new Text();
    protected static Text tFavored = new Text();
    protected static Text tArchetypes = new Text();
    protected static Text tRaceFeats = new Text();
    protected static Label raceLabel;

    public static void displayRaceMenu(){
        raceLabel = new Label("DWARVES \n\n");
        raceLabel.setFont(Font.font("Times New Roman", BOLD, 25));
        
        setButtons(btBack, 0, 20);
        rbMenu.add(new Label("\t\t\t\t\t\t\t\t\t\t\t\t"), 1, 20);
        setButtons(btSelect, 2, 20);
        rbMenu.add(raceLabel, 0, 1);
        setLabels(description, 0, 2);
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
   
    public static void setLabels(Label lb, int col, int row){
        lb.setFont(Font.font("Times New Roman", BOLD, 16));
        rbMenu.add(lb, col, row);
    }
    
    public static void setButtons(Button bt, int col, int row){
        bt.setPrefSize(80, 35);
        rbMenu.add(bt, col, row);
    }
}

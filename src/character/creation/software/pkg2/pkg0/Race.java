/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

import character.creation.software.pkg2.pkg0.Races.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Glenn
 */
public class Race extends Character{
    private static ComboBox sortBox = new ComboBox();
    private static int unsignedInteger;
    private static ToggleButton tbAlpha = new ToggleButton("Alphabetical");
    private static ToggleButton tbScoreInc = new ToggleButton("Scores Incremented");
    private static ToggleButton tbScoreDec = new ToggleButton("Scores Decremented");
    private static ToggleButton tbPoints = new ToggleButton("Race Points");
    private static Button btContinue = new Button("Continue");
    private static String[] races = RaceArrayData.racesArray;
    private static RadioButton[] rbRaces = new RadioButton[races.length];
    private static int[] incNumArray = RaceArrayData.incRaceLabelLink;
    private static int[] decNumArray = RaceArrayData.decRaceLabelLink;
    private static String[] incNumStrings = RaceArrayData.incLabels;
    private static String[] decNumStrings = RaceArrayData.decLabels;
    private static ScrollPane raceMenu = new ScrollPane();
    protected static GridPane rbMenu = new GridPane();
    public static Scene raceScene = new Scene(raceMenu, 600, 600);
    
    static void startRaceMenu(){
        ToggleGroup raceGroup = new ToggleGroup();
        raceMenu.setContent(rbMenu);
        rbMenu.setVgap(10);
        sortBox.getItems().addAll("All Races", new Separator(),"All Paizo Races", "Core", "Featured", "Uncommon", "Other",
                new Separator(),"All 3rd Party Races", "Adamant Entertainment", "Alluria Publishing", "Dreamscarred Press", 
                "Fat Goblin Games", "GUNGNIR Gamedev", "Jon Brazer Enterprises", "Little Red Goblin Games", "Kobold Press", 
                "Lost Spheres Publishing", "Louis Porter Jr. Design, Inc.", "Northwinter Press", "Paizo Fans United",
                "Rite Publishing","Rogue Genius Games", "Silver Games", "Storm Bunny Studios", "Total Party Kill Games");
        sortBox.setValue("All Races");
        
        for(int i = 0; i < races.length; i++){
            rbRaces[i] = new RadioButton(races[i]);
            rbRaces[i].setToggleGroup(raceGroup);
            rbMenu.add(rbRaces[i], 0 , (i*2) + 3, 2, 1);
            rbMenu.add(new Separator(), 0, (i*2) + 4, 5, 1);
        }
        rbMenu.add(sortBox, 0, 0, 5 ,1);
        rbMenu.add(btContinue, 5, 0);
        addToggleButtons();
        addIncScores(0, races.length);
        addDecScores(0, races.length);
        rbRaces[0].setSelected(true);
        
        btContinue.setOnAction(e -> {
            for (int i = 0; i < rbRaces.length; i++){
                if (rbRaces[i].isSelected()){
                    contToSeperateRace(i);
                    break;
                }
            }
        });
        
        sortBox.setOnAction(e -> {
            if(sortBox.getValue() == "All Races"){
                rbMenu.getChildren().clear();
                setSortMenu(0, races.length);
            }
            else if(sortBox.getValue() == "All Paizo Races"){
                rbMenu.getChildren().clear();
                setSortMenu(0, 66);
                addIncScores(0, 66);
            }
            else if(sortBox.getValue() == "Core"){
                rbMenu.getChildren().clear();
                setSortMenu(0, 7);
            }
            else if(sortBox.getValue() == "Featured"){
                rbMenu.getChildren().clear();
                setSortMenu(7, 23);
            }
            else if(sortBox.getValue() == "Uncommon"){
                rbMenu.getChildren().clear();
                setSortMenu(23, 37);
            }
            else if(sortBox.getValue() == "Other"){
                rbMenu.getChildren().clear();
                setSortMenu(37, 66);
            }
            else if(sortBox.getValue() == "All 3rd Party Races"){
                rbMenu.getChildren().clear();
                setSortMenu(66, races.length);
            }
            else if(sortBox.getValue() == "Adamant Entertainment"){
                rbMenu.getChildren().clear();
                setSortMenu(66, 69);
            }
            else if(sortBox.getValue() == "Alluria Publishing"){
                rbMenu.getChildren().clear();
                setSortMenu(69, 84);
                rbMenu.add(rbRaces[57], 0, 33, 2, 1);
                rbMenu.add(new Separator(), 0, 34, 5, 1);
            }
            else if(sortBox.getValue() == "Dreamscarred Press"){
                rbMenu.getChildren().clear();
                setSortMenu(84, 92);
            }
            else if(sortBox.getValue() == "Fat Goblin Games"){
                rbMenu.getChildren().clear();
                setSortMenu(33, 34);
            }
            else if(sortBox.getValue() == "GUNGNIR Gamedev"){
                rbMenu.getChildren().clear();
                setSortMenu(92, 93);
            }
             else if(sortBox.getValue() == "Jon Brazer Enterprises"){
                 rbMenu.getChildren().clear();
                setSortMenu(93, 98);
             }
            else if(sortBox.getValue() == "Little Red Goblin Games"){
                rbMenu.getChildren().clear();
                setSortMenu(98, 116);
             }
            else if(sortBox.getValue() == "Kobold Press"){
                rbMenu.getChildren().clear();
                setSortMenu(116, 122);
            }
            else if(sortBox.getValue() == "Lost Spheres Publishing"){
                rbMenu.getChildren().clear();
                setSortMenu(122, 123);
            }
            else if(sortBox.getValue() == "Louis Porter Jr. Design, Inc."){
                rbMenu.getChildren().clear();
                setSortMenu(123, 132);
            }
            else if(sortBox.getValue() == "Northwinter Press"){
                rbMenu.getChildren().clear();
                setSortMenu(132, 133);
            }
             else if(sortBox.getValue() == "Paizo Fans United"){
                 rbMenu.getChildren().clear();
                setSortMenu(133, 137);
            }
            else if(sortBox.getValue() == "Rite Publishing"){
                rbMenu.getChildren().clear();
                setSortMenu(137, 144);
            }
            else if(sortBox.getValue() == "Rogue Genius Games"){
                rbMenu.getChildren().clear();
                setSortMenu(144, 148);
            }
            else if(sortBox.getValue() == "Silver Games"){
                rbMenu.getChildren().clear();
                setSortMenu(148, 150);
            }
            else if(sortBox.getValue() == "Storm Bunny Studios"){
                rbMenu.getChildren().clear();
                setSortMenu(150, 152);
            }
            else if(sortBox.getValue() == "Total Party Kill Games"){
                rbMenu.getChildren().clear();
                setSortMenu(152, races.length);
            }
        });
    }
    
    static void addToggleButtons(){
        ToggleGroup sortGroup = new ToggleGroup();
        rbMenu.add(tbAlpha, 0, 2);
        rbMenu.add(tbScoreInc, 1, 2);
        rbMenu.add(tbScoreDec, 2, 2);
        rbMenu.add(tbPoints, 3, 2);
        tbAlpha.setToggleGroup(sortGroup);
        tbScoreInc.setToggleGroup(sortGroup);
        tbScoreDec.setToggleGroup(sortGroup);
        tbPoints.setToggleGroup(sortGroup);
    }
    
    static void setSortMenu(int start, int end){
        unsignedInteger = 0;
        rbMenu.add(sortBox, 0, 0, 5 ,1);
        addToggleButtons();
        
        for(int i = start; i < end; i++){
            rbMenu.add(rbRaces[i], 0 , (unsignedInteger * 2) + 3, 2, 1);
            rbMenu.add(new Separator(), 0, (unsignedInteger * 2) + 4, 5, 1);
            unsignedInteger = unsignedInteger + 1;
        }
        rbRaces[start].setSelected(true);
        addIncScores(start, end);
        addDecScores(start, end);
    }
    
    static void addIncScores(int start, int finish){
        unsignedInteger = 0;
        for(int i = start; i < finish; i++){
            rbMenu.add(new Label(incNumStrings[incNumArray[i]]), 2 , (unsignedInteger * 2) + 3, 2, 1);
            rbMenu.add(new Separator(), 2, (unsignedInteger * 2) + 4, 5, 1);
            unsignedInteger = unsignedInteger + 1;
        }
    }
    
    static void addDecScores(int start, int finish){
        unsignedInteger = 0;
        for(int i = start; i < finish; i++){
            rbMenu.add(new Label(decNumStrings[decNumArray[i]]), 3 , (unsignedInteger * 2) + 3, 2, 1);
            unsignedInteger = unsignedInteger + 1;
        }
    }
    
    static void contToSeperateRace(int selector){
        rbMenu.getChildren().clear();
        switch(selector){
            case 0:
                Dwarf.displayRaceMenu();
                break;
            case 1:
                Elf.displayRaceMenu();
                break;
            case 2:
                Gnome.displayRaceMenu();
                break;
            case 3:
                HalfElf.displayRaceMenu();
                break;
            case 4:
                Halfling.displayRaceMenu();
                break;
            case 5:
                HalfOrc.displayRaceMenu();
                break;
            case 6:
                Human.displayRaceMenu();
                break;
        }
    }
    
}

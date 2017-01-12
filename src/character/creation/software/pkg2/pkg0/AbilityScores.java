/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

import static java.lang.StrictMath.floor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Glenn
 */
public class AbilityScores extends Character {
    static GridPane abilityMenu = new GridPane();
    static Scene abilityScene = new Scene(abilityMenu, 600, 600);
    private static Label STR = new Label("   STR  ");
    private static Label DEX = new Label("  DEX  ");
    private static Label CON = new Label("  CON  ");
    private static Label INT = new Label("   INT  ");
    private static Label WIS = new Label("   WIS  ");
    private static Label CHA = new Label("  CHA  ");
    private static Text textWarning = new Text();
    private static TextField tfSTR = new TextField("0");
    private static TextField tfDEX = new TextField("0");
    private static TextField tfCON = new TextField("0");
    private static TextField tfINT = new TextField("0");
    private static TextField tfWIS = new TextField("0");
    private static TextField tfCHA = new TextField("0");
    private static TextField tfSTRMod = new TextField("-5");
    private static TextField tfDEXMod = new TextField("-5");
    private static TextField tfCONMod = new TextField("-5");
    private static TextField tfINTMod = new TextField("-5");
    private static TextField tfWISMod = new TextField("-5");
    private static TextField tfCHAMod = new TextField("-5");
    private static Button btFinalize = new Button("Finalize");
    private static Button btReroll = new Button("Reroll");
    private static String checkValue;
    private static boolean moveForward;
    private static int[] statsArray = new int[6];
    private static final boolean[] crossOuts = new boolean[6];
    private static boolean[] check = new boolean[6];
    private static Label[] statsArrayLabel = new Label[6];
    
    static void AbilityScores(){
        abilityMenu.setVgap(3);
        abilityMenu.setHgap(5);
        btFinalize.setPrefSize(90, 50);
        btReroll.setPrefSize(90, 50);
        setMenu();
        rollStats();
        
        tfSTR.setOnMouseClicked(e -> {
            tfSTR.selectAll();
        });
        
        tfSTR.setOnKeyPressed(e -> {
           checkInputs(tfSTR); 
        });
        
        tfSTR.setOnKeyReleased(e -> {
            checkInputs(tfSTR);
            setMods(tfSTR,tfSTRMod, STRMod, strength);
            compareRolls(tfSTR);
            compareRolls(tfDEX);
            compareRolls(tfCON);
            compareRolls(tfINT);
            compareRolls(tfWIS);
            compareRolls(tfCHA);
            crossOutScore();
        });
        
        tfDEX.setOnMouseClicked(e -> {
            tfDEX.selectAll();
        });
        
        tfDEX.setOnKeyPressed(e -> {
           checkInputs(tfDEX); 
        });
        
        tfDEX.setOnKeyReleased(e -> {
            checkInputs(tfDEX);
            setMods(tfDEX,tfDEXMod, DEXMod, dexterity);
            compareRolls(tfSTR);
            compareRolls(tfDEX);
            compareRolls(tfCON);
            compareRolls(tfINT);
            compareRolls(tfWIS);
            compareRolls(tfCHA);
            crossOutScore();
        });
        
        tfCON.setOnMouseClicked(e -> {
            tfCON.selectAll();
        });
        
        tfCON.setOnKeyPressed(e -> {
           checkInputs(tfCON); 
        });
        
        tfCON.setOnKeyReleased(e -> {
            checkInputs(tfCON);
            setMods(tfCON,tfCONMod, CONMod, constitution);
            compareRolls(tfSTR);
            compareRolls(tfDEX);
            compareRolls(tfCON);
            compareRolls(tfINT);
            compareRolls(tfWIS);
            compareRolls(tfCHA);
            crossOutScore();
        });
        
        tfINT.setOnMouseClicked(e -> {
            tfINT.selectAll();
        });
        
        tfINT.setOnKeyPressed(e -> {
           checkInputs(tfINT); 
        });
        
        tfINT.setOnKeyReleased(e -> {
            checkInputs(tfINT);
            setMods(tfINT,tfINTMod, INTMod, intelligence);
            compareRolls(tfSTR);
            compareRolls(tfDEX);
            compareRolls(tfCON);
            compareRolls(tfINT);
            compareRolls(tfWIS);
            compareRolls(tfCHA);
            crossOutScore();
        });
        
        tfWIS.setOnMouseClicked(e -> {
            tfWIS.selectAll();
        });
        
        tfWIS.setOnKeyPressed(e -> {
           checkInputs(tfWIS); 
        });
        
        tfWIS.setOnKeyReleased(e -> {
            checkInputs(tfWIS); 
            setMods(tfWIS,tfWISMod, WISMod, wisdom);
            compareRolls(tfSTR);
            compareRolls(tfDEX);
            compareRolls(tfCON);
            compareRolls(tfINT);
            compareRolls(tfWIS);
            compareRolls(tfCHA);
            crossOutScore();
        });
        
        tfCHA.setOnMouseClicked(e -> {
            tfCHA.selectAll();
        });
        
        tfCHA.setOnKeyPressed(e -> {
           checkInputs(tfCHA); 
        });
        
        tfCHA.setOnKeyReleased(e -> {
            checkInputs(tfCHA);
            setMods(tfCHA,tfCHAMod, CHAMod, charisma);
            compareRolls(tfSTR);
            compareRolls(tfDEX);
            compareRolls(tfCON);
            compareRolls(tfINT);
            compareRolls(tfWIS);
            compareRolls(tfCHA);
            crossOutScore();
        });
        
        btReroll.setOnAction(e -> {
            rollStats();
        });
        
        btFinalize.setOnAction(e -> {
            finalizeInputs();
            finalizeStats();
        });
    }
    
    static void setLabels(Label label, int col, int row){
        label.setOpacity(100);
        label.setTextFill(Color.web("#FFFFFF"));
        label.setStyle("-fx-background-color: #000000;");
        label.setFont(new Font("Baskerville Old Face", 30));
        label.setMinWidth(100);
        abilityMenu.add(label, col, row);
    }
    
    static void setTextFields(TextField field, int col, int row){
        field.setPrefWidth(45);
        field.setPrefHeight(36);
        field.setFont(new Font("Baskerville Old Face", 20));
        abilityMenu.add(field, col, row);
    }
    
    static void setModFields(TextField tf, int col, int row){
        tf.setPrefWidth(45);
        tf.setPrefHeight(36);
        tf.setFont(new Font("Baskerville Old Face", 20));
        tf.setEditable(false);
        abilityMenu.add(tf, col, row);
    }
    
    static void checkInputs(TextField tf){
        if(tf.getText().length() > 2){
            tf.setText(tf.getText(0, 2));
            tf.end();
        }
        else if(tf.getText().length() < 1){
            tf.setText("0");
            tf.selectAll();
        }
        
        
        for(int i = 0; i < tf.getText().length(); i++){
            checkValue = (tf.getText(i, i + 1));
            if ((!checkValue.equals("0")) && (!checkValue.equals("1")) && (!checkValue.equals("2")) && (!checkValue.equals("3")) && (!checkValue.equals("4"))
                   && (!checkValue.equals("5")) && (!checkValue.equals("6")) && (!checkValue.equals("7")) && (!checkValue.equals("8")) && (!checkValue.equals("9"))){
                tf.deleteText(i, i + 1);
                }
        }
    }
    
    static void setMods(TextField tf, TextField tfMod, double Mod, double abilityScore){
        if(tf.getText().length() < 1){
            Mod = -5;
            tfMod.setText(String.valueOf((int) Mod));
        }
        else{
            abilityScore = Double.parseDouble(tf.getText());
            Mod = floor((abilityScore - 10) / 2);
            tfMod.setText(String.valueOf((int) Mod));
        }
        for (int i = 0; i < 6; i++){
            crossOuts[i] = false;
            check[i] = true;
        }
    }
    
    static void rollStats(){
        for (int i = 0; i < 6; i ++){
            crossOuts[i] = false;
            check[i] = true;
        }
        
        for (int j = 0; j < 6; j++){
            abilityMenu.getChildren().remove(statsArrayLabel[j]);
            statsArray[j] = DiceRolls.rollAbilityScores();
            statsArrayLabel[j] = new Label(String.valueOf(statsArray[j]));
            abilityMenu.add(statsArrayLabel[j], 4, j);
        }
    }
    
    static void setMenu(){
        setLabels(STR, 0, 0);
        setLabels(DEX, 0, 1);
        setLabels(CON, 0, 2);
        setLabels(INT, 0, 3);
        setLabels(WIS, 0, 4);
        setLabels(CHA, 0, 5);
        setTextFields(tfSTR, 1, 0);
        setTextFields(tfDEX, 1, 1);
        setTextFields(tfCON, 1, 2);
        setTextFields(tfINT, 1, 3);
        setTextFields(tfWIS, 1, 4);
        setTextFields(tfCHA, 1, 5);
        setModFields(tfSTRMod, 2, 0);
        setModFields(tfDEXMod, 2, 1);
        setModFields(tfCONMod, 2, 2);
        setModFields(tfINTMod, 2, 3);
        setModFields(tfWISMod, 2, 4);
        setModFields(tfCHAMod, 2, 5);
        abilityMenu.add(btFinalize, 5, 7);
        abilityMenu.add(btReroll, 4, 7);
    }
    
    static void crossOutScore(){
        for (int j = 0; j < 6; j++){
            if(crossOuts[j] == true){
                statsArrayLabel[j].setVisible(false);
            }
            else{
                statsArrayLabel[j].setVisible(true);
            }
        }
    }
    
    static void compareRolls(TextField tf){
        
        if((int) Double.parseDouble(tf.getText()) == statsArray[0] && check[0]){
            crossOuts[0] = true;
            check[0] = false;
        }
        else if ((int) Double.parseDouble(tf.getText()) == statsArray[1] && check[1]){
            crossOuts[1] = true;
            check[1] = false;
        }
        else if ((int) Double.parseDouble(tf.getText()) == statsArray[2] && check[2]){
            crossOuts[2] = true;
            check[2] = false;
        }
        else if ((int) Double.parseDouble(tf.getText()) == statsArray[3] && check[3]){
            crossOuts[3] = true;
            check[3] = false;
        }
        else if ((int) Double.parseDouble(tf.getText()) == statsArray[4] && check[4]){
            crossOuts[4] = true;
            check[4] = false;
        }
        else if ((int) Double.parseDouble(tf.getText()) == statsArray[5] && check[5]){
            crossOuts[5] = true;
            check[5] = false;
        }
        else{
            //intentional blank
        }
    }
    
    static void setMods(){
        strength = Double.parseDouble(tfSTR.getText()) + strength;
        STRMod = floor((strength - 10) / 2);
        dexterity = Double.parseDouble(tfDEX.getText()) + dexterity;
        DEXMod = floor((dexterity - 10) / 2);
        constitution = Double.parseDouble(tfCON.getText()) + constitution;
        CONMod = floor((constitution - 10) / 2);
        intelligence = Double.parseDouble(tfINT.getText()) + intelligence;
        INTMod = floor((intelligence - 10) / 2);
        wisdom = Double.parseDouble(tfWIS.getText()) + wisdom;
        WISMod = floor((wisdom - 10) / 2);
        charisma = Double.parseDouble(tfCHA.getText()) + charisma;
        CHAMod = floor((charisma - 10) / 2);
    }
    
    static void finalizeInputs(){
        Stage popUp = new Stage();
        GridPane warning = new GridPane();
        Scene popWindow = new Scene(warning, 300, 120);
        Button btOkay = new Button("Okay");
        
        for (int i = 0; i < 6; i++){
            if(check[i] == true){
                popUp.initModality(Modality.APPLICATION_MODAL);
                btOkay.setPrefSize(80, 35);
                textWarning.setWrappingWidth(300);
                textWarning.setText("One of your inputs is not a valid ability Score."
                        + " Please input a valid ability score that is still available.");
                warning.add(textWarning, 0, 0, 2, 1);
                warning.add(new Label("\t\t\t\t"), 0, 2);
                warning.add(new Label(), 0, 1);
                warning.add(btOkay, 1, 2);
                popUp.setTitle("Invalid Ability Score");
                popUp.setScene(popWindow);
                popUp.show();
                moveForward = false;
                break;
            }
            else{
                moveForward = true;
            }
        }
        
        btOkay.setOnAction(e -> {
                popUp.close();
        });
    }
    
    static void finalizeStats(){
        Stage popUp = new Stage();
        GridPane sure = new GridPane();
        Scene popWindow = new Scene(sure, 300, 120);
        Button btYes = new Button("Yes");
        Button btNo = new Button("No");
        Text areYouSure = new Text("Are you sure these are the ability Scores you would like? You cannot come back"
                + " if you change your mind.");
        
        if(moveForward == true){
            popUp.initModality(Modality.APPLICATION_MODAL);
            areYouSure.setWrappingWidth(300);
            btYes.setPrefSize(80, 35);
            btNo.setPrefSize(80, 35);
            sure.add(areYouSure, 0, 0, 4, 1);
            sure.add(new Label(), 0, 1);
            sure.add(new Label("\t\t\t"), 0, 2);
            sure.add(btYes, 1, 2);
            sure.add(new Label("    "), 2, 2);
            sure.add(btNo, 3, 2);
            popUp.setTitle("Are You Sure");
            popUp.setScene(popWindow);
            popUp.show();
            
            btYes.setOnAction (e -> {
                setMods();
            });
            
            btNo.setOnAction (e -> {
                popUp.close();
            });
        }
        else{
            //intentionally blank
        }
    }
}
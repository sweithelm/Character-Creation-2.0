/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import static javafx.scene.text.FontWeight.BOLD;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Glenn
 */
public class NewCharacter extends Character{
    private static GridPane newChar = new GridPane();
    private static Scene newCharScene = new Scene(newChar, 550, 230);
    private static Label lName = new Label("   Character Name:");
    private static Label lSpeed = new Label("Progression Speed:");
    private static Label lLevel = new Label("       Starting Level:");
    private static Label lGold = new Label("        Starting Gold:");
    private static Label lTraits = new Label("\t    Base Traits:");
    private static Label lDrawbacks = new Label("Drawbacks:  ");
    private static Label lXP = new Label("Experience:");
    private static Label lPlayer = new Label("Player Name:");
    private static Label lFlaws = new Label("Flaws:");
    private static TextField tfName = new TextField("");
    private static TextField tfPlayer = new TextField("");
    private static TextField tfLevel = new TextField("1");
    private static TextField tfXP = new TextField("0");
    private static TextField tfTraits = new TextField("2");
    private static TextField tfDrawbacks = new TextField("1");
    private static TextField tfFlaws = new TextField("0");
    private static TextField tfGold =new TextField("1000");
    private static RadioButton rbStandard = new RadioButton("Class Standard");
    private static RadioButton rbCustom = new RadioButton("Custom");
    private static RadioButton rbSlow = new RadioButton("Slow");
    private static RadioButton rbMedium = new RadioButton("Medium");
    private static RadioButton rbFast = new RadioButton("Fast");
    private static Button btOK = new Button("Okay");
    
    public static void beginNewChar(){
        
        //sets up the window and handles overall needed logics
        
        Stage newCharStage = new Stage();
        newCharStage.initModality(Modality.APPLICATION_MODAL);
        newCharStage.setTitle("New Character");
        newCharStage.setScene(newCharScene);
        newCharStage.setResizable(false);
        newCharStage.show();
        
        newChar.setVgap(5);
        newChar.setHgap(5);
        newChar.setPadding(new Insets(15, 15, 15, 15));
        newChar.setStyle("-fx-background-color: #b1afb3");
        
        ToggleGroup GoldGroup = new ToggleGroup();
        rbStandard.setToggleGroup(GoldGroup);
        rbCustom.setToggleGroup(GoldGroup);
        rbStandard.setSelected(true);
        
        ToggleGroup XPGroup = new ToggleGroup();
        rbSlow.setToggleGroup(XPGroup);
        rbMedium.setToggleGroup(XPGroup);
        rbFast.setToggleGroup(XPGroup);
        rbMedium.setSelected(true);
        
        setNewCharMenu();
        logic();
        
        btOK.setOnAction(e -> {
            if(tfName.getText().length() >= 1 && tfPlayer.getText().length() >= 1 && tfLevel.getText().length() >= 1 &&
              tfXP.getText().length() >= 1 && tfTraits.getText().length() >= 1 && tfDrawbacks.getText().length() >= 1 &&
              tfFlaws.getText().length() >= 1){
                characterName = tfName.getText();
                player = tfPlayer.getText();
                level = (int)Double.parseDouble(tfLevel.getText());
                experience = (int)Double.parseDouble(tfXP.getText());
                numOfTraits = (int)Double.parseDouble(tfTraits.getText());
                numOfDrawbacks = (int)Double.parseDouble(tfDrawbacks.getText());
                numOfFlaws = (int)Double.parseDouble(tfFlaws.getText());
                if(rbCustom.isSelected()){
                    if(tfGold.getText().length() >= 1){
                        startingGold = (int)Double.parseDouble(tfGold.getText());
                        AbilityScores.AbilityScores();
                        newCharStage.close();
                    }
                    else{
                        newCharWarning();
                    }
                }
                else{
                    startingGold = -1;
                    AbilityScores.AbilityScores();
                    newCharStage.close();
                }
            }
            else{
                newCharWarning();
            }
        });
    }
    
    public static void setNewCharLabeling(Label lb, int col, int row, int colw, int roww){
        
        //next two: saves space by css'ing all labels and buttons once instead of every time
        
        lb.setFont(Font.font("Times New Roman", BOLD, 14));
        newChar.add(lb, col, row, colw, roww);
    }
    
    public static void setNewCharButtons(Button bt, int col, int row, int colw, int roww){
        bt.setPrefSize(80, 35);
        newChar.add(bt, col, row, colw, roww);
    }
    
    public static void setNewCharMenu(){
        
        //Sets up the Gridpane in one area
        
        setNewCharLabeling(lName, 0, 0, 10, 1);
        newChar.add(tfName, 11, 0, 10, 1);
        setNewCharLabeling(lPlayer, 22, 0, 10, 1);
        newChar.add(tfPlayer, 33, 0, 10, 1);
        setNewCharLabeling(lSpeed, 0, 1, 10, 1);
        newChar.add(rbSlow, 11, 1, 5, 1);
        newChar.add(rbMedium, 16, 1, 5, 1);
        newChar.add(rbFast, 21, 1, 10, 1);
        setNewCharLabeling(lLevel, 0, 2, 10, 1);
        newChar.add(tfLevel, 11, 2, 1, 1);
        setNewCharLabeling(lXP, 12, 2, 8, 1);
        newChar.add(tfXP, 20, 2, 6, 1);
        setNewCharLabeling(lGold, 0, 4, 10, 1);
        newChar.add(rbStandard, 11, 4, 10, 1);
        newChar.add(rbCustom, 11, 5, 5, 1);
        newChar.add(tfGold, 16, 5, 5, 1);
        setNewCharLabeling(lTraits, 0, 6, 10, 1);
        newChar.add(tfTraits, 11, 6);
        setNewCharLabeling(lDrawbacks, 12, 6, 10, 1);
        newChar.add(tfDrawbacks, 20, 6, 3, 1);
        setNewCharLabeling(lFlaws, 24, 6, 10, 1);
        newChar.add(tfFlaws, 29, 6, 3, 1);
        setNewCharButtons(btOK, 19, 7, 10, 1);
        
        tfLevel.setPrefWidth(30);
        tfXP.setPrefWidth(67);
        tfGold.setPrefWidth(65);
        tfTraits.setPrefWidth(1);
        tfDrawbacks.setPrefWidth(1);
        tfFlaws.setPrefWidth(50);
        
        tfGold.setVisible(false);
    }
    
    public static void checkForNonNumbers(TextField tf){
        String checkValue;
        
        //Removes Any letters or symbols that are input into the numbers-only text fields
        
        for(int i = 0; i < tf.getText().length(); i++){
            checkValue = (tf.getText(i, i + 1));
            if ((!checkValue.equals("0")) && (!checkValue.equals("1")) && (!checkValue.equals("2")) && (!checkValue.equals("3")) && (!checkValue.equals("4"))
                   && (!checkValue.equals("5")) && (!checkValue.equals("6")) && (!checkValue.equals("7")) && (!checkValue.equals("8")) && (!checkValue.equals("9"))){
                tf.deleteText(i, i + 1);
                }
        }
    }
    
    public static void oneThroughTwentyThree(){
        double temp;
        
        //only usable by tfLevel to make sure that the levels allowed to be input are between 1 and 23
        
        if(tfLevel.getText().length() > 2){
            tfLevel.setText(tfLevel.getText(0, 2));
            tfLevel.end();
        }
        
        temp = Double.parseDouble(tfLevel.getText());
         
        if (temp < 1){
            tfLevel.setText("1");
        }
        if (temp > 23){
            tfLevel.setText("23");
        }
    }
    
    public static void levelToXPCalc(){
        if (tfLevel.getText().length() >= 1){
            if (rbSlow.isSelected()){
                slowLevelProgression((int)Double.parseDouble(tfLevel.getText()));
                goldProgression((int)Double.parseDouble(tfLevel.getText()));
            }
            else if (rbMedium.isSelected()){
                mediumLevelProgression((int)Double.parseDouble(tfLevel.getText()));
                goldProgression((int)Double.parseDouble(tfLevel.getText()));
            }
            else {
                fastLevelProgression((int)Double.parseDouble(tfLevel.getText()));
                goldProgression((int)Double.parseDouble(tfLevel.getText()));
            }
        }
    }
    
    public static void xpToLevelCalc(){
        if(tfXP.getText().length() >= 1){
            if(rbSlow.isSelected()){
                slowXPProgression((int)Double.parseDouble(tfXP.getText()));
                goldProgression((int)Double.parseDouble(tfLevel.getText()));
            }
            else if(rbMedium.isSelected()){
                mediumXPProgression((int)Double.parseDouble(tfXP.getText()));
                goldProgression((int)Double.parseDouble(tfLevel.getText()));
            }
            else{
                fastXPProgression((int)Double.parseDouble(tfXP.getText()));
                goldProgression((int)Double.parseDouble(tfLevel.getText()));
            }
        }
    }
    
    public static void newCharWarning(){
        GridPane FailPane = new GridPane();
        Stage Fail = new Stage();
        Scene FailScene = new Scene(FailPane, 200, 110);
        Fail.setScene(FailScene);
        Text FailText = new Text("");
        Button btFail = new Button("Okay");
        Fail.setResizable(false);
        Fail.setTitle("Invalid Input");
        FailPane.setPadding(new Insets(5, 5, 5, 5));
        
        Fail.initModality(Modality.APPLICATION_MODAL);
        
        FailText.setText("A textfield is empty. Please fill in all fields before proceeding");
        FailText.setWrappingWidth(190);
        FailText.setTextAlignment(TextAlignment.CENTER);
        btFail.setPrefSize(65, 35);
        FailPane.add(FailText, 0, 0, 2, 1);
        FailPane.add(new Label("\t\t   "), 0, 2);
        FailPane.add(new Label(""), 0, 1);
        FailPane.add(btFail, 1, 3);
        Fail.show();
        
        btFail.setOnAction(e -> {
            Fail.close();
        });
    }
    
    public static void logic(){
        
        //Puts all the Events at the bottom of the page to neatly define everything needed (there is alot)
        
        rbSlow.setOnAction(e -> {
            levelToXPCalc();
        });
        
        rbSlow.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                case TAB:
                    levelToXPCalc();
                    break;
            }
        });
        
        rbSlow.setOnKeyReleased(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                case TAB:
                    levelToXPCalc();
                    break;
            }
        });
        
        rbMedium.setOnAction(e -> {
            levelToXPCalc();
        });
        
        rbMedium.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                case TAB:
                    levelToXPCalc();
                    break;
            }
        });
        
        rbMedium.setOnKeyReleased(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                case TAB:
                    levelToXPCalc();
                    break;
            }
        });
        
        rbFast.setOnAction(e -> {
            levelToXPCalc();
        });
        
        rbFast.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                case TAB:
                    levelToXPCalc();
                    break;
            }
        });
        
        rbFast.setOnKeyReleased(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                case TAB:
                    levelToXPCalc();
                    break;
            }
        });
        
        tfLevel.setOnKeyPressed(e -> {
                checkForNonNumbers(tfLevel);
                if (tfLevel.getText().length() >= 1){
                    oneThroughTwentyThree();
                }
        });
        
        tfLevel.setOnKeyReleased(e -> {
            checkForNonNumbers(tfLevel);
            if (tfLevel.getText().length() >= 1){
                oneThroughTwentyThree();
            }
            levelToXPCalc();
        });
        
        tfXP.setOnKeyPressed(e -> {
            checkForNonNumbers(tfXP);
            if(tfXP.getText().length() > 8){
                tfXP.setText(tfXP.getText(0, 8));
                tfXP.end();
            }
            xpToLevelCalc();
            
        });
        
        tfXP.setOnKeyReleased(e -> {
            checkForNonNumbers(tfXP);
            if(tfXP.getText().length() > 8){
                tfXP.setText(tfXP.getText(0, 8));
                tfXP.end();
            }
            xpToLevelCalc();
        });
        
        rbStandard.setOnAction(e -> {
            tfGold.setVisible(false);
        });
        
        rbCustom.setOnAction(e -> {
            tfGold.setVisible(true);
        });
        
        rbStandard.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                    tfGold.setVisible(true);
                    break;
            }
        });
        
        rbCustom.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case DOWN:
                case LEFT:
                case RIGHT:
                case UP:
                    tfGold.setVisible(false);
                    break;
            }
        });
        
        tfGold.setOnKeyPressed(e -> {
            checkForNonNumbers(tfGold);
            if(tfGold.getText().length() > 7){
                tfGold.setText(tfGold.getText(0, 7));
                tfGold.end();
            }
        });
        
        tfGold.setOnKeyReleased(e -> {
            checkForNonNumbers(tfGold);
            if(tfGold.getText().length() > 7){
                tfGold.setText(tfGold.getText(0, 7));
                tfGold.end();
            }
        });
        
        tfTraits.setOnKeyPressed(e -> {
            checkForNonNumbers(tfTraits);
                if(tfTraits.getText().length() > 2){
                    tfTraits.setText(tfTraits.getText(0, 2));
                    tfTraits.end();
                }
        });
        
        tfTraits.setOnKeyReleased(e ->{
            checkForNonNumbers(tfTraits);
            if(tfTraits.getText().length() > 2){
                tfTraits.setText(tfTraits.getText(0, 2));
                tfTraits.end();
            }
        });
        
        tfDrawbacks.setOnKeyPressed(e -> {
            checkForNonNumbers(tfDrawbacks);
            if(tfDrawbacks.getText().length() > 2){
                tfDrawbacks.setText(tfDrawbacks.getText(0, 2));
                tfDrawbacks.end();
            }
        });
        
        tfDrawbacks.setOnKeyReleased(e -> {
            checkForNonNumbers(tfDrawbacks);
            if(tfDrawbacks.getText().length() > 2){
                tfDrawbacks.setText(tfDrawbacks.getText(0, 2));
                tfDrawbacks.end();
            }
        });
        
        tfFlaws.setOnKeyPressed(e -> {
            checkForNonNumbers(tfFlaws);
            if(tfFlaws.getText().length() > 2){
                tfFlaws.setText(tfFlaws.getText(0, 2));
                tfFlaws.end();
            }
        });
        
        tfFlaws.setOnKeyReleased(e -> {
            checkForNonNumbers(tfFlaws);
            if(tfFlaws.getText().length() > 2){
                tfFlaws.setText(tfFlaws.getText(0, 2));
                tfFlaws.end();
            }
        });
    }
    
    public static void goldProgression(int level){
        switch(level){
            case 1:
                tfGold.setText("500");
                break;
            case 2:
                tfGold.setText("1000");
                break;
            case 3:
                tfGold.setText("3000");
                break;
            case 4:
                tfGold.setText("6000");
                break;
            case 5:
                tfGold.setText("10500");
                break;
            case 6:
                tfGold.setText("16000");
                break;
            case 7:
                tfGold.setText("23500");
                break;
            case 8:
                tfGold.setText("33000");
                break;
            case 9:
                tfGold.setText("46000");
                break;
            case 10:
                tfGold.setText("62000");
                break;
            case 11:
                tfGold.setText("82000");
                break;
            case 12:
                tfGold.setText("108000");
                break;
            case 13:
                tfGold.setText("140000");
                break;
            case 14:
                tfGold.setText("185000");
                break;
            case 15:
                tfGold.setText("240000");
                break;
            case 16:
                tfGold.setText("315000");
                break;
            case 17:
                tfGold.setText("410000");
                break;
            case 18:
                tfGold.setText("530000");
                break;
            case 19:
                tfGold.setText("685000");
                break;
            case 20:
                tfGold.setText("880000");
                break;
            default:
                tfGold.setText("1000000");
                break;
        }
    }
    
    public static void slowXPProgression(int xp){
        if(xp <= 2999){
            tfLevel.setText("1");
        }
        else if(xp <= 7499){
            tfLevel.setText("2");
        }
        else if(xp <= 13999){
            tfLevel.setText("3");
        }
        else if(xp <= 22999){
            tfLevel.setText("4");
        }
        else if(xp <=34999){
            tfLevel.setText("5");
        }
        else if(xp <= 52999){
            tfLevel.setText("6");
        }
        else if(xp <= 76999){
            tfLevel.setText("7");
        }
        else if(xp <= 114999){
            tfLevel.setText("8");
        }
        else if(xp <= 159999){
            tfLevel.setText("9");
        }
        else if(xp <= 234999){
            tfLevel.setText("10");
        }
        else if(xp <= 329999){
            tfLevel.setText("11");
        }
        else if(xp <= 474999){
            tfLevel.setText("12");
        }
        else if(xp <= 664999){
            tfLevel.setText("13");
        }
        else if(xp <= 954999){
            tfLevel.setText("14");
        }
        else if(xp <= 1349999){
            tfLevel.setText("15");
        }
        else if(xp <= 1899999){
            tfLevel.setText("16");
        }
        else if(xp <= 2699999){
            tfLevel.setText("17");
        }
        else if(xp <= 3849999){
            tfLevel.setText("18");
        }
        else if(xp <= 5349999){
            tfLevel.setText("19");
        }
        else if(xp <= 10699999){
            tfLevel.setText("20");
        }
        else if(xp <= 21399999){
            tfLevel.setText("21");
        }
        else if(xp <= 42799999){
            tfLevel.setText("22");
        }
        else if(xp <= 85599999){
            tfLevel.setText("23");
        }
        else if(xp >= 86000000){
            tfXP.setText("85599999");
            tfLevel.setText("23");
        }
    }
    
    public static void mediumXPProgression(int xp){
        if(xp <= 1999){
            tfLevel.setText("1");
        }
        else if(xp <= 4999){
            tfLevel.setText("2");
        }
        else if(xp <= 8999){
            tfLevel.setText("3");
        }
        else if(xp <= 14999){
            tfLevel.setText("4");
        }
        else if(xp <=22999){
            tfLevel.setText("5");
        }
        else if(xp <= 34999){
            tfLevel.setText("6");
        }
        else if(xp <= 50999){
            tfLevel.setText("7");
        }
        else if(xp <= 74999){
            tfLevel.setText("8");
        }
        else if(xp <= 104999){
            tfLevel.setText("9");
        }
        else if(xp <= 154999){
            tfLevel.setText("10");
        }
        else if(xp <= 219999){
            tfLevel.setText("11");
        }
        else if(xp <= 314999){
            tfLevel.setText("12");
        }
        else if(xp <= 444999){
            tfLevel.setText("13");
        }
        else if(xp <= 634999){
            tfLevel.setText("14");
        }
        else if(xp <= 889999){
            tfLevel.setText("15");
        }
        else if(xp <= 1299999){
            tfLevel.setText("16");
        }
        else if(xp <= 1799999){
            tfLevel.setText("17");
        }
        else if(xp <= 2549999){
            tfLevel.setText("18");
        }
        else if(xp <= 3599999){
            tfLevel.setText("19");
        }
        else if(xp <= 7199999){
            tfLevel.setText("20");
        }
        else if(xp <= 14399999){
            tfLevel.setText("21");
        }
        else if(xp <= 28799999){
            tfLevel.setText("22");
        }
        else if(xp <= 57599999){
            tfLevel.setText("23");
        }
        else if(xp >= 57600000){
            tfXP.setText("57599999");
            tfLevel.setText("23");
        }
    }
    
    public static void fastXPProgression(int xp){
        if(xp <= 1299){
            tfLevel.setText("1");
        }
        else if(xp <= 3299){
            tfLevel.setText("2");
        }
        else if(xp <= 5999){
            tfLevel.setText("3");
        }
        else if(xp <= 9999){
            tfLevel.setText("4");
        }
        else if(xp <= 14999){
            tfLevel.setText("5");
        }
        else if(xp <= 22999){
            tfLevel.setText("6");
        }
        else if(xp <= 33999){
            tfLevel.setText("7");
        }
        else if(xp <= 49999){
            tfLevel.setText("8");
        }
        else if(xp <= 70999){
            tfLevel.setText("9");
        }
        else if(xp <= 104999){
            tfLevel.setText("10");
        }
        else if(xp <= 144999){
            tfLevel.setText("11");
        }
        else if(xp <= 209999){
            tfLevel.setText("12");
        }
        else if(xp <= 294999){
            tfLevel.setText("13");
        }
        else if(xp <= 424999){
            tfLevel.setText("14");
        }
        else if(xp <= 599999){
            tfLevel.setText("15");
        }
        else if(xp <= 849999){
            tfLevel.setText("16");
        }
        else if(xp <= 1199999){
            tfLevel.setText("17");
        }
        else if(xp <= 1699999){
            tfLevel.setText("18");
        }
        else if(xp <= 2399999){
            tfLevel.setText("19");
        }
        else if(xp <= 4799999){
            tfLevel.setText("20");
        }
        else if(xp <= 9599999){
            tfLevel.setText("21");
        }
        else if(xp <= 19199999){
            tfLevel.setText("22");
        }
        else if(xp <= 38399999){
            tfLevel.setText("23");
        }
        else if(xp >= 38400000){
            tfXP.setText("38399999");
            tfLevel.setText("23");
        }
    }
    
    public static void slowLevelProgression(int level){
        switch(level){
            case 1:
                tfXP.setText("0");
                break;
            case 2:
                tfXP.setText("3000");
                break;
            case 3:
                tfXP.setText("7500");
                break;
            case 4:
                tfXP.setText("14000");
                break;
            case 5:
                tfXP.setText("23000");
                break;
            case 6:
                tfXP.setText("35000");
                break;
            case 7:
                tfXP.setText("53000");
                break;
            case 8:
                tfXP.setText("77000");
                break;
            case 9:
                tfXP.setText("115000");
                break;
            case 10:
                tfXP.setText("160000");
                break;
            case 11:
                tfXP.setText("235000");
                break;
            case 12:
                tfXP.setText("330000");
                break;
            case 13:
                tfXP.setText("475000");
                break;
            case 14:
                tfXP.setText("665000");
                break;
            case 15:
                tfXP.setText("955000");
                break;
            case 16:
                tfXP.setText("1350000");
                break;
            case 17:
                tfXP.setText("1900000");
                break;
            case 18:
                tfXP.setText("2700000");
                break;
            case 19:
                tfXP.setText("3850000");
                break;
            case 20:
                tfXP.setText("5350000");
                break;
            case 21:
                tfXP.setText("10700000");
                break;
            case 22:
                tfXP.setText("21400000");
                break;
            case 23:
                tfXP.setText("42800000");
                break;
        }
    }
    
    public static void mediumLevelProgression(int level){
        switch(level){
            case 1:
                tfXP.setText("0");
                break;
            case 2:
                tfXP.setText("2000");
                break;
            case 3:
                tfXP.setText("5000");
                break;
            case 4:
                tfXP.setText("9000");
                break;
            case 5:
                tfXP.setText("15000");
                break;
            case 6:
                tfXP.setText("23000");
                break;
            case 7:
                tfXP.setText("35000");
                break;
            case 8:
                tfXP.setText("51000");
                break;
            case 9:
                tfXP.setText("75000");
                break;
            case 10:
                tfXP.setText("105000");
                break;
            case 11:
                tfXP.setText("155000");
                break;
            case 12:
                tfXP.setText("220000");
                break;
            case 13:
                tfXP.setText("315000");
                break;
            case 14:
                tfXP.setText("445000");
                break;
            case 15:
                tfXP.setText("635000");
                break;
            case 16:
                tfXP.setText("890000");
                break;
            case 17:
                tfXP.setText("1300000");
                break;
            case 18:
                tfXP.setText("1800000");
                break;
            case 19:
                tfXP.setText("2550000");
                break;
            case 20:
                tfXP.setText("3600000");
                break;
            case 21:
                tfXP.setText("7200000");
                break;
            case 22:
                tfXP.setText("14400000");
                break;
            case 23:
                tfXP.setText("28800000");
                break;
        }
    }
    
    public static void fastLevelProgression(int level){
        switch(level){
            case 1:
                tfXP.setText("0");
                break;
            case 2:
                tfXP.setText("1300");
                break;
            case 3:
                tfXP.setText("3300");
                break;
            case 4:
                tfXP.setText("6000");
                break;
            case 5:
                tfXP.setText("10000");
                break;
            case 6:
                tfXP.setText("15000");
                break;
            case 7:
                tfXP.setText("23000");
                break;
            case 8:
                tfXP.setText("34000");
                break;
            case 9:
                tfXP.setText("50000");
                break;
            case 10:
                tfXP.setText("71000");
                break;
            case 11:
                tfXP.setText("105000");
                break;
            case 12:
                tfXP.setText("145000");
                break;
            case 13:
                tfXP.setText("210000");
                break;
            case 14:
                tfXP.setText("295000");
                break;
            case 15:
                tfXP.setText("425000");
                break;
            case 16:
                tfXP.setText("600000");
                break;
            case 17:
                tfXP.setText("850000");
                break;
            case 18:
                tfXP.setText("1200000");
                break;
            case 19:
                tfXP.setText("1700000");
                break;
            case 20:
                tfXP.setText("2400000");
                break;
            case 21:
                tfXP.setText("4800000");
                break;
            case 22:
                tfXP.setText("9600000");
                break;
            case 23:
                tfXP.setText("19200000");
                break;
        }
    }
}

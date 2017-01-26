/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*******************************
 **                           **
 **     @author Glenn S.      **
 **                           **
 *******************************/

package character.creation.software.pkg2.pkg0;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Application {
    private Button btNewCharacter = new Button("Create New Character");
    private Button btLoadCharacter = new Button("Load Existing Character");
    private Button btCharSRD = new Button("Character References");
    private Button btItemSRD = new Button("Item References");
    private Button btSheetSRD = new Button("Char Sheet Information");
    private Button btTutorial = new Button("Tutorial: On");
    private String choice;
    private boolean tutorial = true;
    private static Stage MainStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        //setup Main Menu
        
        GridPane mainMenu = new GridPane();
        mainMenu.setStyle("-fx-background-color: #FFFFFF");
        btNewCharacter.setPrefSize(150, 50);
        btLoadCharacter.setPrefSize(150, 50);
        btCharSRD.setPrefSize(150, 50);
        btItemSRD.setPrefSize(150, 50);
        btSheetSRD.setPrefSize(150, 50);
        btTutorial.setPrefSize(150, 50);
        mainMenu.setPadding(new Insets(10, 10, 10, 10));
        mainMenu.setVgap(10);
        introduction(mainMenu, choice);
        mainMenu.add(btNewCharacter, 0, 1);
        mainMenu.add(btLoadCharacter, 0, 2);
        mainMenu.add(btTutorial, 0, 3);
        mainMenu.add(btCharSRD, 2, 1);
        mainMenu.add(btItemSRD, 2, 2);
        mainMenu.add(btSheetSRD, 2, 3);
        
        //end of Main Menu
        
        //start of button Actions
        
        btNewCharacter.setOnAction( e -> {
            Character Char = new Character();
            NewCharacter.beginNewChar();
        });
        
        btItemSRD.setOnAction(e -> {
            
        });
        
        btTutorial.setOnAction(e -> {
            if (tutorial == true){
                btTutorial.setText("Tutorial: Off");
                tutorial = false;
            }
            else {
                btTutorial.setText("Tutorial: On");
                tutorial = true;
            }
            
        });
        
        //Setup window Pane
        
        Scene startScene = new Scene(mainMenu, 600, 600);
        MainStage.setTitle("Character Creation Software 2.0");
        MainStage.setScene(startScene);
        MainStage.show();
    }
    
    void introduction(GridPane window, String choice){
        Text introductionText = new Text();
        introductionText.setWrappingWidth(580);
        introductionText.setText("Welcome to the Pathfinder Character Creation Software 2.0! "
                + "Choosing tutorial will walk you through steps and explain the rules as if you are new. "
                + "Choosing without the tutorial will skip Pathfinder rule descriptions. Enjoy!");
        introductionText.setFont(Font.font("Old English Text MT", 18));
        window.add(introductionText, 0, 0, 2, 1);
    }
    
    public static void setNewScene(Scene newScene){
        MainStage.setScene(newScene);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

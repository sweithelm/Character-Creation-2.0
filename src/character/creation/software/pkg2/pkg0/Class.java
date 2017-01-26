/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Glenn
 */
public class Class extends Character {
    private static Label lAlignment = new Label("Alignment:");
    private static ComboBox cbAlignment = new ComboBox();
    
    public static void ClassOptions(){
        cbAlignment.getItems().addAll("Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral",
            "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil");
        cbAlignment.setValue("Lawful Good");
        
        
    }
}

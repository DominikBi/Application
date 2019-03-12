package team.doma;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String args[]){


        // Text des Users einlesen
        JFormattedTextField amountField;

        amountField = new JFormattedTextField(100);
        amountField.setValue(50);
        amountField.setColumns(10);
//        amountField.addPropertyChangeListener("value", this);
         }
         //setup Methode
    public void setUpJframe(int width, int height,Component... comp){
        //neues Jframe erstellen
        JFrame jFrame = new JFrame();

        //Titel des Jframes setzen
        jFrame.setTitle("Application");

        //loop so lange bis alle components drinne sind
        for(int i = 0; i < comp.length; i++ ){
            jFrame.add(comp[i]);
        }
        //Grösse einstellen
        jFrame.setSize(width ,height);

        //Jframe sichtbar machen
        jFrame.setVisible(true);
    }
}

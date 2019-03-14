package team.doma;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]){

        int breite = 300;
        int hoehe = 100;
        JTextField eingabeText = new JTextField();


        ArrayList <Component> eingabemaske = new ArrayList<>();

        eingabemaske.add(eingabeText);
        setUpJframe(breite, hoehe, Color.YELLOW, eingabemaske);
         }
         //setup Methode
    public static void setUpJframe(int width, int height, Color farbe, ArrayList <Component> comp){
        //neues Jframe erstellen
        JFrame jFrame = new JFrame();

        //Titel des Jframes setzen
        jFrame.setTitle("Application");

        //loop so lange bis alle components drinne sind
        for(int i = 0; i < comp.size(); i++ ){
            comp.get(i).setBackground(farbe);
            jFrame.add(comp.get(i));
        }
        //Grösse einstellen
        jFrame.setSize(width ,height);

        //Jframe sichtbar machen
        jFrame.setVisible(true);
    }
}

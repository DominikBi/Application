package team.doma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    int i;

    public static void main(String args[]){
        Main main = new Main();
        main.run();

         }
         public void run(){

             int breite = 700;
             int hoehe = 100;
             JFrame frame = new JFrame();

             JTextField eingabeTextDeutsch = new JTextField();
             eingabeTextDeutsch.setToolTipText("Deutsch");
             JTextField eingabeTextSpanisch = new JTextField();
             eingabeTextSpanisch.setToolTipText("Spanisch");

             JButton button = new JButton("Submit");

             eingabeTextDeutsch.setSize(300,100);
             eingabeTextSpanisch.setSize(300,100);
             button.setSize(100,100);
             eingabeTextDeutsch.setText("                    ");
             eingabeTextSpanisch.setText("                    ");

             frame.setLayout(new FlowLayout());
             frame.setSize(breite, hoehe);
             frame.add(eingabeTextDeutsch);
             frame.add(eingabeTextSpanisch);
             frame.add(button);
             frame.setVisible(true);
             System.out.println("Ich habe die Box angezeigt");
             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if(eingabeTextDeutsch.getText()  != "" || eingabeTextSpanisch.getText()  != "") {
                         i++;
                         WordObj wortPaar = new WordObj();
                         wortPaar.deutschWord = eingabeTextDeutsch.getText();
                         wortPaar.spanischWord = eingabeTextSpanisch.getText();
                         wortPaar.priority = 1;
                         System.out.println(wortPaar.deutschWord);
                         System.out.println(wortPaar.spanischWord);
                         eingabeTextDeutsch.setText("");
                         eingabeTextSpanisch.setText("");
                         try {
                             writeFile("SpanischZeug",wortPaar);
                         } catch (IOException exception1) {
                            System.out.println("had ned geklappt, denn:" + exception1);
                         }
                     }
                 }
             });

         }

    public void writeFile(String name, WordObj wordObj) throws IOException {

        String home = System.getProperty("user.home");
        String lineSep = System.getProperty("file.separator");
        String enter = System.getProperty("line.separator");
        String path = home + lineSep + "IdeaProjects" + lineSep + "Application" + lineSep + "data" + lineSep + name + ".txt";



        FileOutputStream fos = new FileOutputStream(path);
        for(int e =  0; e < i; e++) {
            fos.write(enter.getBytes());
        }
        System.out.println("Ich schreibe in den Pfad "+ path);
        fos.write(cutWhitespace(wordObj.getDeutschWord()).getBytes());
        fos.write("/".getBytes());
        fos.write(cutWhitespace(wordObj.getSpanischWord()).getBytes());
        fos.write("/".getBytes());
        System.out.println(wordObj.getPriority());
        fos.write(String.valueOf(wordObj.getPriority()).getBytes());

        fos.flush();
        fos.close();



    }
    public String cutWhitespace(String s){
        s.replaceAll(" ","");
        return s;
    }

}

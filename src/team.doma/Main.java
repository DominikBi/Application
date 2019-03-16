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

    public static void main(String args[]){
        Main main = new Main();
        main.run();

         }
         public void run(){
        String i = System.getProperty("user.home");
        System.out.println(i);
             int breite = 300;
             int hoehe = 100;
             JFrame frame = new JFrame();

             JTextField eingabeTextDeutsch = new JTextField();
             eingabeTextDeutsch.setToolTipText("Deutsch");
             JTextField eingabeTextSpanisch = new JTextField();
             eingabeTextSpanisch.setToolTipText("Spanisch");

             JButton button = new JButton("Submit");

             eingabeTextDeutsch.setSize(100,100);
             eingabeTextSpanisch.setSize(100,100);
             button.setSize(100,100);
             eingabeTextDeutsch.setText("DeutschesWort");
             eingabeTextSpanisch.setText("SpanischesWort");

             frame.setLayout(new FlowLayout());
             frame.add(eingabeTextDeutsch);
             frame.add(eingabeTextSpanisch);
             frame.add(button);
             frame.setVisible(true);

             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if(eingabeTextDeutsch.getText()  != "" || eingabeTextSpanisch.getText()  != "") {
                         WordObj wordObj = new WordObj();
                         wordObj.deutschWord = eingabeTextDeutsch.getText();
                         wordObj.spanischWord = eingabeTextSpanisch.getText();
                         eingabeTextDeutsch.setText("");
                         eingabeTextSpanisch.setText("");
                         try {
                             writeFile("SpanischZeug",wordObj);
                         } catch (IOException e1) {

                         }
                     }
                 }
             });

         }

    public void writeFile(String name, WordObj wordObj) throws IOException {

        String home = System.getProperty("user.home");
        String lineSep = System.getProperty("line.separator");
        String path = home + "IdeaProjects" + lineSep + "Application" + lineSep + "data" + lineSep + name + ".txt";
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(wordObj.getDeutschWord().getBytes());
        fos.write("/".getBytes());
        fos.write(wordObj.getSpanischWord().getBytes());
        fos.write("/".getBytes());
        fos.write(wordObj.getPrority());
        fos.flush();
        fos.close();


    }

}

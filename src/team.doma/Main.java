package team.doma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    String home = System.getProperty("user.home");
    String lineSep = System.getProperty("file.separator");

    int i;
    JButton testButton = new JButton("Test");

    public static void main(String args[]) throws IOException {

        Main main = new Main();
        main.run();

         }
         public void run() throws IOException {
             i = 0;
// definiere Größe des Eingabe-Fensters
             int breite = 700;
             int hoehe = 100;
// erzeuge Frame
             JFrame frame = new JFrame();
// erzeuge Textfelder zur Erfassung der Wortpärchen
             JTextField eingabeTextDeutsch = new JTextField();
             eingabeTextDeutsch.setToolTipText("Deutsch");
             JTextField eingabeTextSpanisch = new JTextField();
             eingabeTextSpanisch.setToolTipText("Spanisch");

             JButton submitButton = new JButton("Submit");

// setze Größe der Textfelder
             submitButton.setSize(100,100);
             eingabeTextDeutsch.setText("                    ");
             eingabeTextSpanisch.setText("                    ");
// befülle Eingabe-Fenster und zeige es an
             frame.setLayout(new FlowLayout());
             frame.setSize(breite, hoehe);
             frame.add(eingabeTextDeutsch);
             frame.add(eingabeTextSpanisch);
             frame.add(submitButton);
             frame.add(testButton);
             frame.setVisible(true);
             System.out.println(readFile("SpanischZeug").get(0));
             System.out.println("Ich habe die Boxen angezeigt");
// Lege leere Listen an
             String[] alDeutsch = new String[2000];
             String[] alSpanisch = new String[2000];
             int[] alPriority = new int[2000];

             submitButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if(eingabeTextDeutsch.getText()  != "" && eingabeTextSpanisch.getText()  != "") {
// Lese erfasste Wortpärchen aus den Textfeldern und schreibe sie in Listen

                         alDeutsch[i] = eingabeTextDeutsch.getText();
                         alSpanisch[i] = eingabeTextSpanisch.getText();
                         alPriority[i] = 1;
                         eingabeTextDeutsch.setText("");
                         eingabeTextSpanisch.setText("");
                     }
                     else {
                         System.out.println("fehlerhafte Eingabe!");
                     }
                     i++;
                 }
             });

             testButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {

                     try {
//schreibe Wortpärchen in Datei
                         writeFile("SpanischZeug", alDeutsch, alSpanisch, alPriority);
                     }
                     catch (IOException exception1) {
                         System.err.println("had ned geklappt, denn: " + exception1);
                     }
                 }
             });
         }

    public void writeFile(String filename, String[] deutschAl, String[] spanischAl, int [] priorityAl) throws IOException {
// Bestimme Ablagepfad
        String path = home + lineSep + "IdeaProjects" + lineSep + "Application" + lineSep + "data" + lineSep + filename + ".txt";


        FileWriter fr = new FileWriter(path);
        BufferedWriter fos = new BufferedWriter(fr);
// schreibe Datei mit allen Eingaben
        for (int e = 0; e < i; e++) {
            System.out.println("Ich schreibe in den Pfad " + path);
            fos.newLine();
            fos.append(cutWhitespace(deutschAl[e]));
            fos.append(":");
            fos.append(cutWhitespace(spanischAl[e]));
            fos.append(":");
            fos.append(String.valueOf(priorityAl[e]));
            try {
                fos.flush();
            } catch (IOException e1) {
                System.err.println("Could not flush BufferedWriter:" + e1);
            }
            try {
                fr.close();
            } catch (IOException e1) {
                System.err.println("Could not close FileWriter:" + e1);
            }
        }
    }

    public Map<Integer,String> readFile(String filename) throws IOException {
        Map<Integer,String> map = new HashMap<>();
        int inObjCounter = 0;
        int totalCounter = 0;
        String path = home + lineSep + "IdeaProjects" + lineSep + "Application" + lineSep + "data" + lineSep + filename + ".txt";
        char c;
        String result = "";
        String spanischWort = "";
        String deutschesWort = "";
        String priority = "";
            FileInputStream fis = new FileInputStream(path);
            while(fis.available() > 0) {
                char b = (char) fis.read();

                if (b == ':') {



                    System.out.println(inObjCounter);
                    switch (inObjCounter) {
                        case 0:
                            deutschesWort = cutWhitespace(result.toLowerCase());
                        case 1:
                            spanischWort = cutWhitespace(result.toLowerCase());
                        case 2:
                            priority = result;
                    }
                    result = "";
                    inObjCounter++;



                } else {
                    c = b;

                    if (c != ' ') {

                        result += c;
                        System.out.println(result);
                    }
                    if (inObjCounter == 2) {

                        map.put(totalCounter, deutschesWort);
                        map.put(totalCounter, spanischWort);
                        map.put(totalCounter, priority);
                        totalCounter++;
                        inObjCounter = 0;
                    }
                }
            }
            return map;




    }
    public String cutWhitespace(String s){
        s.replaceAll(" ","");
        return s;
    }

}

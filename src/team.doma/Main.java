package team.doma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int i;
    boolean Testing;
    JButton TestButton = new JButton("Test");


    public static void main(String args[]){

        Main main = new Main();
        main.run();

         }
         public void run(){
             i = 0;
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
             frame.add(TestButton);
             frame.setVisible(true);
             System.out.println("Ich habe die Box angezeigt");
             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if(eingabeTextDeutsch.getText()  != "" || eingabeTextSpanisch.getText()  != "") {

                         String[] alDeutsch;
                         String[] alSpanisch;
                         int[] alPriority;
                         System.out.println(alDeutsch.size());
                         alDeutsch[i] = eingabeTextDeutsch.getText();
                         alSpanisch[i] =  eingabeTextSpanisch.getText();
                         alPriority.set(i, 1);
                         eingabeTextDeutsch.setText("");
                         eingabeTextSpanisch.setText("");
                         try {
                             writeFile("SpanischZeug", alDeutsch, alSpanisch, alPriority);
                         } catch (IOException exception1) {
                            System.err.println("had ned geklappt, denn: " + exception1);
                         }
                     }
                     i++;
                 }
             });


         }

    public void writeFile(String name, List<String> deutschAl, List<String> spanischAl, List<Integer> priorityAl) throws IOException {

        String home = System.getProperty("user.home");
        String lineSep = System.getProperty("file.separator");

        String path = home + lineSep + "IdeaProjects" + lineSep + "Application" + lineSep + "data" + lineSep + name + ".txt";
        FileWriter fr = new FileWriter(path);
        BufferedWriter fos = new BufferedWriter(fr);

            for (int e = 0; e < i;e++) {
                System.out.println("Ich schreibe in den Pfad " + path);
                fos.newLine();
                fos.append(cutWhitespace(deutschAl.get(e)));
                fos.append("/");
                fos.append(cutWhitespace(spanischAl.get(e)));
                fos.append("/");
                fos.append(String.valueOf(priorityAl.get(e)));
            }
            TestButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        fos.flush();
                    } catch (IOException e1) {
                        System.err.println("Could not flush BufferedWriter" + e1);
                    }
                    try {
                        fr.close();
                    } catch (IOException e1) {
                        System.err.println("Could not close FileWriter" + e1);
                    }
                }
            });



        }


    public String cutWhitespace(String s){
        s.replaceAll(" ","");
        return s;
    }

}

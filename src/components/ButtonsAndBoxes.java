package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Max on 23.03.14.
 */
public class ButtonsAndBoxes {

    final static int fontSize=14;
    final static Font fontVerdana = new Font("Verdana", Font.PLAIN, fontSize);
    final static Font fontArial = new Font("Arial black",Font.PLAIN,fontSize);
    final static Font fontLobster = new Font("Lobster",Font.PLAIN,fontSize);
    final static Font fontLobster2 = new Font("Lobster",Font.PLAIN,fontSize+2);
    final static Font fontLobster3 = new Font("Lobster",Font.PLAIN,fontSize+4);

    public static Box getButtonsStructure(){
        Box mainBox = Box.createVerticalBox();
        final JTextArea text1 = new JTextArea();
        //final MyTextArea text1=new MyTextArea();

        Box bh1 = Box.createHorizontalBox();
        Box bh2 = Box.createHorizontalBox();
        Box bh3 = Box.createHorizontalBox();
        // Box bv2 = Box.createVerticalBox();


        Box leftVerticBox = Box.createVerticalBox();
        JButton oneBut = new JButton("1");
        JButton twoBut = new JButton("2");
        JButton threeBut = new JButton("3");
        JButton fourBut = new JButton("4");
        JButton fiveBut = new JButton("5");
        JButton sixBut = new JButton("6");
        JButton chooseFile = new JButton("выбрать файл");
        JButton but1 = new JButton("...");
        JButton but2 = new JButton("...");
        JButton but3 = new JButton("...");

        oneBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text1.setFont(fontVerdana);
            }
        });
        twoBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text1.setFont(fontArial);
            }
        });
        threeBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text1.setFont(fontLobster);
            }
        });
        fourBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text1.setFont(fontLobster2);
            }
        });
        fiveBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text1.setFont(fontLobster3);
            }
        });

        chooseFile.setFont(fontLobster);


        leftVerticBox.add(oneBut);
        leftVerticBox.add(twoBut);
        leftVerticBox.add(threeBut);
        leftVerticBox.add(fourBut);
        leftVerticBox.add(fiveBut);
        leftVerticBox.add(sixBut);
        text1.setFont(fontLobster);

        but1.setBackground(Color.CYAN);
        but2.setBackground(Color.CYAN);
        but3.setBackground(Color.CYAN);
        oneBut.setBackground(Color.WHITE); twoBut.setBackground(Color.WHITE); threeBut.setBackground(Color.WHITE);
        fourBut.setBackground(Color.WHITE); fiveBut.setBackground(Color.WHITE); sixBut.setBackground(Color.WHITE);
        chooseFile.setBackground(Color.WHITE);


        bh1.add(Box.createHorizontalStrut(10));
        bh1.add(but1);

        bh1.add(Box.createHorizontalStrut(5));
        bh1.add(but2);

        bh1.add(Box.createHorizontalStrut(7));
        bh1.add(but3);
        bh1.add(Box.createHorizontalGlue());
        bh1.add(chooseFile);
        bh1.add(Box.createHorizontalStrut(40));
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(bh1);
        mainBox.add(Box.createGlue());
        bh2.add(Box.createHorizontalStrut(30));
        bh2.add(Box.createHorizontalStrut(30));
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(bh2);

        bh3.add(Box.createHorizontalStrut(5));
        bh3.add(leftVerticBox);
        bh3.add(Box.createHorizontalStrut(10));
        bh3.add(text1);
        text1.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        bh3.add(Box.createHorizontalStrut(40));

        mainBox.add(bh3);
        mainBox.add(Box.createVerticalStrut(30));
        // getContentPane().add(bv2, BorderLayout.SOUTH);
        // getContentPane().add(mainBox, BorderLayout.CENTER);



        return mainBox;
    }

}

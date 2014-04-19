import components.WindowInitializer;
import components.ButtonsAndBoxes;
import components.WindowMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

//import WindowMenu;

public class Main extends JFrame {

    final static int fontSize=14;
    final static Font fontVerdana = new Font("Verdana", Font.PLAIN, fontSize);
    final static Font fontArial = new Font("Arial black",Font.PLAIN,fontSize);
    final static Font fontLobster = new Font("Lobster",Font.PLAIN,fontSize);
    final static Font fontLobster2 = new Font("Lobster",Font.PLAIN,fontSize+2);
    final static Font fontLobster3 = new Font("Lobster",Font.PLAIN,fontSize+4);


     public static void main(String[] args) {
        WindowInitializer.init();
    }
}

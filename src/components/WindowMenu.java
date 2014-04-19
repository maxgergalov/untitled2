package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Max on 20.03.14.
 */
public class WindowMenu {
    
    public static JMenuBar getMenu(Font font){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As...");
        JMenuItem cleanFile = new JMenuItem("Clean");
        JMenuItem informationAbout = new JMenuItem("About...");
        JMenuItem exit = new JMenuItem("Exit");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(cleanFile);
        fileMenu.add(exit);
        helpMenu.add(informationAbout);

        newFile.setFont(font);
        saveFile.setFont(font);
        saveAsFile.setFont(font);
        openFile.setFont(font);
        cleanFile.setFont(font);
        informationAbout.setFont(font);
        exit.setFont(font);
        fileMenu.setFont(font);
        helpMenu.setFont(font);


        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                }
            }
        });
        return menuBar;
    }

    /**
     * Created by Max on 20.03.14.
     */
    public static class BoxStructure {
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labsix;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.application.Application;
import javax.swing.filechooser.FileSystemView;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    JButton retainedModeBtn = new JButton("Retained mode");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //add all buttons
        add(saveBtn);
        add(exitBtn);
        add(resetBtn);
        add(loadBtn);
        add(retainedModeBtn);
        
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load) ;
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
        
    }
    
    
    private void reset(ActionEvent e)//buton reset
    {
       frame.canvas.graphics.setColor(Color.WHITE);
       frame.canvas.graphics.fill(new Rectangle(800,600));
       frame.canvas.repaint();



    }
    private void exit(ActionEvent e) {//exit
            System.exit(0);
    }

    //load method with file chooser
    private void load(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Specify a file to load");
        
        int returnValue = jfc.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String fullPath = jfc.getSelectedFile().getAbsolutePath().toString();
            System.out.println(fullPath);
        }
        
        try { 
            File selectedFile = jfc.getSelectedFile();
            BufferedImage image = ImageIO.read(selectedFile);
            frame.canvas.graphics.drawImage(image, 0, 0, null);
            frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }

    }

    private void save(ActionEvent e) {//la fel si aici
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Specify a file to save");
        
        int returnValue = jfc.showSaveDialog(null);
        
        
        try {
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String fullPath = new String(jfc.getSelectedFile().getAbsolutePath().toString());
                fullPath = fullPath + ".png";
                System.out.println(fullPath);
                ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream(fullPath);
            }
        } catch (IOException ex) { System.err.println(ex); }
    }

}



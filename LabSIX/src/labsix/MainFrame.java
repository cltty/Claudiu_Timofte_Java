/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labsix;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);


       //adaug componentele
        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        add(configPanel,BorderLayout.NORTH);



        pack();
    }
}
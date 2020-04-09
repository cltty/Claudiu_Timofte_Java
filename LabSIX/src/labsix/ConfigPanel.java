/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labsix;


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
        JLabel sidesLabel;
        JSpinner sidesField;
        JComboBox colorCombo;
        JComboBox shapesField;//optional
        

        public ConfigPanel(MainFrame frame) {
            this.frame = frame;
            init();
        }
        private void init() {
            sidesLabel = new JLabel("Number of sides:");
            sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            sidesField.setValue(6);
            String[] colors = {"Random","Black"};
            String[] shapes = {"RegularPolygon", "Square", "Rectangle"}; 
            colorCombo = new JComboBox(colors);
            shapesField = new  JComboBox(shapes);
            add(sidesLabel);
            add(sidesField);
            add(colorCombo);
            add(shapesField);
        }
    
}
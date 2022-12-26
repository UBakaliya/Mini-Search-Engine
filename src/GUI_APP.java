/**
 * @file GUI_APP.java 
 * @author Uvaish Bakaliya
 * @since 12-23-2022
 * @apiNote The creator has granted full access to the user who is utilizing it.
 * @copyright Copyright © 2022 UB
 */

package src;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI_APP extends JFrame {
    private Implementation DB;
    private JTextField inputField;
    private JLabel outputLabel;

    public GUI_APP(Implementation DB) {
        this.DB = DB;
        this.setLayout(new FlowLayout());

        inputField = new JTextField(20);
        this.add(inputField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputLabel.setText("");
                String input = inputField.getText();
                // String output = DB.search(input);
                // outputLabel.setText(output);
            }
        });
        this.add(searchButton);
        outputLabel = new JLabel();
        this.add(outputLabel);
    }

    public void RUN_GUI() {
        this.setSize(550, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

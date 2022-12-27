/**
 * @file GUI_APP.java 
 * @author Uvaish Bakaliya
 * @since 12-23-2022
 * @apiNote The creator has granted full access to the user who is utilizing it.
 * @copyright Copyright © 2022 UB
 */

package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GUI_APP extends JFrame implements ActionListener {

    // Declare and initialize a JTextField for user input
    JTextField inputField = new JTextField(35);

    // Declare and initialize a JButton for submits the input
    JButton searchButton = new JButton("search");

    // Declare and initialize a JTextArea for displaying the output
    JTextArea outputTextArea = new JTextArea();

    private Implementation database;

    private Set<String> result;

    public GUI_APP(Implementation database) {
        this.database = database;
        // Set the layout of the window to be a BorderLayout
        setLayout(new BorderLayout());

        // Create a panel to hold the input field and search button
        JPanel inputPanel = new JPanel(new FlowLayout());

        // Add the input field and search button to the input panel
        inputPanel.add(inputField);
        inputPanel.add(searchButton);

        // Set the preferred size of the output text area to allow word wrapping
        outputTextArea.setPreferredSize(new Dimension(400, 50));

        // Add the input panel and output text area to the window
        add(inputPanel, BorderLayout.NORTH);
        add(outputTextArea, BorderLayout.CENTER);

        // Declare and initialize a JScrollBar for the output text area
        JScrollBar outputVerticalScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 100);

        // Add the scroll bar and output text area to the window
        add(outputVerticalScrollBar, BorderLayout.EAST);
        add(outputTextArea, BorderLayout.CENTER);

        // Set the action command for the search button to "search"
        searchButton.setActionCommand("search");

        // Add an action listener to the search button
        searchButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        outputTextArea.setText("");
        // Get the action command of the button that was clicked
        String command = e.getActionCommand();
        if (command.equals("search")) {
            result = this.database.search(inputField.getText());
            outputTextArea.append("About " + result.size() + " result" + "\n");
            for (String i : result) {
                outputTextArea.append(i + "\n");
            }
            outputTextArea.setEditable(false);
        }

    }

    public void RUN_GUI(Implementation db) {
        // Create a new GUI_APP object and make it visible
        GUI_APP gui = new GUI_APP(db);
        gui.setSize(750, 750);
        gui.setTitle("Search Engine");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}

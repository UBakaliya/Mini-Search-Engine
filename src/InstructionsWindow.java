package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsWindow extends JFrame implements ActionListener {

    // text area to display the instructions
    private JTextArea instructionsArea;

    // button to close the instructions and start a new search
    private JButton closeButton;

    public InstructionsWindow(Color BGcolor, Color forGroundColor) {
        // set up the GUI
        setTitle("Instructions");
        setSize(550, 550);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // create the instructions text area
        instructionsArea = new JTextArea();
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setForeground(forGroundColor);
        instructionsArea.setBackground(BGcolor);
        instructionsArea.setFont(new Font("Courier New", Font.BOLD, 20));
        instructionsArea.setText("* Welcome to the Search Engine! * \n\n" +
                "This program allows you to search the web for information on a particular topic. To use the program, follow these steps:\n\n"
                +
                "1. Enter your search query in the input field. You can include plus signs (+) to indicate that a certain term is required in the search results, minus signs (-) to indicate that a certain term should be excluded from the search results, and spaces to separate multiple terms.\n\n\n"
                +
                "2. Click the \"Search\" button to initiate the search.\n\n\n" +
                "3. The search results will be displayed in the form of URLs. These URLs represent web pages that are relevant to your search query.\n\n\n"
                +
                "4. Click on a URL to open the corresponding web page in your web browser.\n\n\n" +
                "5. You can use the scroll bar to view all of the search results.\n\n\n" +
                "6. To close the search results and start a new search, click the \"Exit\" button.\n\n\n\n");

        // create the close and help buttons
        closeButton = new JButton("Close");

        // add the close and help buttons to the bottom of the GUI
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(closeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // add the instructions text area to the center of the GUI
        add(new JScrollPane(instructionsArea), BorderLayout.CENTER);

        // register the action listeners for the buttons
        closeButton.addActionListener(this);
        instructionsArea.setEditable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            // close the instructions and start a new search
            dispose();
        }
    }
}

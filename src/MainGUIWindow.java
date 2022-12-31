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
import java.awt.Color;
import javax.swing.*;
import java.util.Set;
import java.io.*;
import java.io.IOException;

public class MainGUIWindow extends JFrame implements ActionListener, KeyListener {

    // Declare and initialize a JTextField for user input
    private JTextField inputField = new JTextField(20);
    // Declare and initialize a JButton for submits the input
    private JButton searchButton = new JButton("search");
    // Declare and initialize a JTextArea for displaying the output
    private JTextArea outputTextArea = new JTextArea();
    private Implementation database;
    private JMenu file, help, edit, changeInputBoxColor, changeOutputBoxColor;
    private JMenuItem fileSelectMenu, fileExitMenu, fileSaveMenu;
    private JMenuItem instructionFile;
    private JMenuItem changeInputColor, changeOutputColor, changeInputBGColor, changeOutputBGColor;
    private Set<String> result;

    public MainGUIWindow(Implementation database) {
        this.database = database;
        ImageIcon imageIcon = new ImageIcon("src/images/icon.png");
        setIconImage(imageIcon.getImage());
        // Set the layout of the window to be a BorderLayout
        setLayout(new BorderLayout());
        // Create a panel to hold the input field and search button
        JPanel inputPanel = new JPanel();

        inputField.setFont(new Font("Consolas", Font.PLAIN, 15));
        inputField.setCaretColor(Color.black);
        inputField.setText("Enter search query");

        JMenuBar menuBar = new JMenuBar();

        this.file = new JMenu("File");
        fileSelectMenu = new JMenuItem("Select File");
        fileSaveMenu = new JMenuItem("Save");
        fileExitMenu = new JMenuItem("Exit");
        this.file.add(fileSelectMenu);
        this.file.add(fileSaveMenu);
        this.file.add(fileExitMenu);
        fileSelectMenu.addActionListener(this);
        fileSaveMenu.addActionListener(this);
        fileExitMenu.addActionListener(this);
        menuBar.add(file);

        this.edit = new JMenu("Edit");
        changeInputColor = new JMenuItem("Font Color");
        changeInputBGColor = new JMenuItem("Background Color");
        changeOutputColor = new JMenuItem("Font Color");
        changeOutputBGColor = new JMenuItem("Background Color");
        changeInputColor.addActionListener(this);
        changeOutputColor.addActionListener(this);
        changeInputBGColor.addActionListener(this);
        changeOutputBGColor.addActionListener(this);
        changeInputBoxColor = new JMenu("Input Box Color");
        changeInputBoxColor.add(changeInputColor);
        changeInputBoxColor.add(changeInputBGColor);
        changeOutputBoxColor = new JMenu("Output Box Color");
        changeOutputBoxColor.add(changeOutputColor);
        changeOutputBoxColor.add(changeOutputBGColor);
        edit.add(changeInputBoxColor);
        edit.add(changeOutputBoxColor);
        menuBar.add(edit);

        this.help = new JMenu("Help");
        this.instructionFile = new JMenuItem("Instructions");
        help.add(instructionFile);
        instructionFile.addActionListener(this);
        menuBar.add(help);

        this.setJMenuBar(menuBar);
        inputPanel.add(inputField);
        inputPanel.add(searchButton);

        outputTextArea.setEditable(false);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        // Add the input panel and output text area to the window
        add(inputPanel, BorderLayout.NORTH);
        add(outputTextArea, BorderLayout.CENTER);
        // Add the scroll bar and output text area to the window
        add(outputTextArea, BorderLayout.CENTER);
        add(new JScrollPane(outputTextArea), BorderLayout.CENTER);
        // Add an action listener to the search button
        searchButton.addActionListener(this);
        searchButton.addKeyListener(this);
        inputField.addKeyListener(this);
        addKeyListener(this);
    }

    private void writeInFile(String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(outputTextArea.getText());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayQueryResult() {
        outputTextArea.setText("");
        result = this.database.search(inputField.getText());
        outputTextArea.append("About " + result.size() + " result" + "\n\n");
        for (final String i : result) {
            outputTextArea.append(i + "\n" + database.getBodyText(i) + "\n\n");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            displayQueryResult();
        }
        if (e.getSource() == fileSelectMenu) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == fileChooser.APPROVE_OPTION) {
                // dispose(); // NOTE: CHANGE THIS ONLY WHEN YOU DON'T WANT TO KEEP THE PREVIOUS
                // WINDOW
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                new Search(filePath);
            }
        }
        if (e.getSource() == fileSaveMenu) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == fileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                writeInFile(filePath);
            }
        }
        if (e.getSource() == fileExitMenu) {
            System.exit(0);
        }
        if (e.getSource() == instructionFile) {
            new InstructionsWindow(outputTextArea.getBackground(), outputTextArea.getForeground());
        }
        if (e.getSource() == changeInputColor) {
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.white);
            inputField.setForeground(color);
        }
        if (e.getSource() == changeOutputColor) {
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.white);
            outputTextArea.setForeground(color);
        }
        if (e.getSource() == changeInputBGColor) {
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.white);
            inputField.setBackground(color);
        }

        if (e.getSource() == changeOutputBGColor) {
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.white);
            outputTextArea.setBackground(color);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case 10:
                displayQueryResult();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public void RUN_GUI(Implementation db) {
        // Create a new GUI_APP object and make it visible
        MainGUIWindow gui = new MainGUIWindow(db);
        gui.setSize(550, 550);
        gui.setTitle("Search Engine");
        gui.setLocationRelativeTo(null);

        // gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}

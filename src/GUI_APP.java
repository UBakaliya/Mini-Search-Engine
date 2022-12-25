package src;

import javax.swing.JFrame;

public class GUI_APP extends Implementation {
    public GUI_APP() {

        JFrame frame = new JFrame();
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
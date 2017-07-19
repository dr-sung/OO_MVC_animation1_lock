package view;

import controller.Main;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame {

    public void initialize() {
        setSize(700, 500);
        setLocation(100, 100);
        setTitle("Simple Animation Demo");

        Container contentPane = getContentPane();
        contentPane.add(Main.canvas, "Center");

        JButton button = new JButton("Add a box");
        button.addActionListener(Main.listener);
        JPanel south = new JPanel();
        south.add(button);
        contentPane.add(south, "South");
    }

}

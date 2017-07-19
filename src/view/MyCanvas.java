package view;

import controller.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import model.Box;
import model.SharedData;

public class MyCanvas extends JPanel {

    // to enable faster access from other obects
    public int width = -1; // negative == not rendered yet
    public int height = -1;
    
    public void initialize() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        width = this.getWidth();  // size is determined once rendered
        height = this.getHeight();

        Graphics2D g2 = (Graphics2D) g;

        SharedData.sharedDataLock.lock();
        try {
            //long startTime = System.currentTimeMillis();
            for (Box b : Main.sharedData.data) {
                g2.setColor(b.getColor());
                g2.fill(b);
            }
            //long endTime = System.currentTimeMillis();
            //System.out.println(endTime - startTime);
        } finally {
            SharedData.sharedDataLock.unlock();
        }
    }

}

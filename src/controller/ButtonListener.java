package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import model.Box;
import model.SharedData;

public class ButtonListener implements ActionListener {
    
    private final int BOXES_TO_ADD = 50000;

    @Override
    public void actionPerformed(ActionEvent e) {
        Random random = new Random();

        SharedData.sharedDataLock.lock();
        try {
            for (int i = 0; i < BOXES_TO_ADD; i++) {
                int x = random.nextInt(680);
                int y = random.nextInt(480);
                Box b = new Box(x, y, 10, 30);
                b.setColor(Color.yellow);
                b.setDown(false);
                Main.sharedData.add(b);
            }
        } finally {
            SharedData.sharedDataLock.unlock();
        }
    }

}

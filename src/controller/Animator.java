package controller;

import java.util.concurrent.TimeUnit;
import model.Box;
import model.SharedData;

public class Animator implements Runnable {

    private final int DELTA = 4;
    private final int FRAMES_PER_SECOND = 20;

    @Override
    public void run() {
        for (;;) {

            long startTime = System.currentTimeMillis();

            SharedData.sharedDataLock.lock();
            try {
                for (Box box : Main.sharedData.data) {
                    float w = (float) box.getWidth();
                    float h = (float) box.getHeight();
                    float x = (float) box.getX();
                    float y = (float) box.getY();

                    if (box.isDown()) {
                        if (y + DELTA > Main.canvas.height - h) {
                            box.setDown(false);
                            box.setRect(x, y - DELTA, w, h);
                        } else {
                            box.setRect(x, y + DELTA, w, h);
                        }
                    } else { // moving up
                        if (y - DELTA < 0) {
                            box.setDown(true);
                            box.setRect(x, y + DELTA, w, h);
                        } else {
                            box.setRect(x, y - DELTA, w, h);
                        }
                    }

                }
            } finally {
                SharedData.sharedDataLock.unlock();
            }

            Main.canvas.repaint();

            long endTime = System.currentTimeMillis();

            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);
            
            System.out.println(sleepTime);

            if (sleepTime > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}

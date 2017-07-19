package model;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData {

    // to enable faster access
    public final List<Box> data;
    
    public static final Lock sharedDataLock = new ReentrantLock();

    public SharedData() {

        // thread safe shared data
        this.data = Collections.synchronizedList(new ArrayList<>());

        Box b1 = new Box(100, 20, 20, 20);
        b1.setColor(Color.red);
        b1.setDown(true);

        Box b2 = new Box(500, 300, 40, 40);
        b2.setColor(Color.blue);
        b2.setDown(false);

        Box b3 = new Box(300, 200, 30, 30);
        b3.setColor(Color.green);
        b3.setDown(false);

        data.add(b1);
        data.add(b2);
        data.add(b3);

    }

    public void add(Box box) {
        data.add(box);
    }

}

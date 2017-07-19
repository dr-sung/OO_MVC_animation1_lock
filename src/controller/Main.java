package controller;

import view.MyCanvas;
import view.MyWindow;
import model.SharedData;
import javax.swing.JFrame;

public class Main {

    public static SharedData sharedData;
    public static MyCanvas canvas;
    public static Animator animator;
    public static ButtonListener listener;

    public static void main(String[] args) {

        sharedData = new SharedData(); // model
        canvas = new MyCanvas(); // view
        canvas.initialize();
        animator = new Animator(); // controller
        listener = new ButtonListener(); // controller
        MyWindow frame = new MyWindow(); // view
        frame.initialize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // animation starts
        new Thread(animator).start();
    }

}

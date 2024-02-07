package kit.develop.java.lesson_2.canvas.bricks;

import kit.develop.java.lesson_2.canvas.circles.Background;
import kit.develop.java.lesson_2.canvas.circles.Ball;
import kit.develop.java.lesson_2.canvas.common.CanvasRepaintListener;
import kit.develop.java.lesson_2.canvas.common.Interactable;
import kit.develop.java.lesson_2.canvas.common.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 1000;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private final Interactable[] interactables = new Interactable[11];

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        interactables[0] = new Background();
        for (int i = 1; i < interactables.length; i++) {
            interactables[i] = new Brick();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}

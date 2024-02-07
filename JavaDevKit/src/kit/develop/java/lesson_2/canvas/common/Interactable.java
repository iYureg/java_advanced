package kit.develop.java.lesson_2.canvas.common;

import kit.develop.java.lesson_2.canvas.common.MainCanvas;

import java.awt.*;

public interface Interactable {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}

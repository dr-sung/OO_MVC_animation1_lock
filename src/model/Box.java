package model;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Box extends Rectangle2D.Float {

    private Color color;
    private boolean down;

    public Box(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

}

package Simulator;
import processing.core.PApplet;

public class Sprite {
    private int r,b,g;
    private Position pos;
    private int radius;
    public Sprite(int r, int b, int g, Position pos, int radius){
        this.r = r;
        this.b=b;
        this.g=g;
        this.pos = pos;
        this.radius = radius;
    }

    public void setSize(int r){
        this.radius = r;
    }

    public void draw(PApplet window) {
//        Field f = Field.getInstance();
        window.fill(r,g,b);
        window.ellipse(pos.getXPixel(), pos.getYPixel(), radius, radius);
    }
}

package Simulator;
import Constants.Constants;
import processing.core.PApplet;
import processing.core.PImage;

public class Sprite {
    private Position pos;
    private int sidelength;
    private PImage img;
    private String path;
    public Sprite(Position pos, int sidelength){
        this.pos = pos;
        this.sidelength=sidelength;
    }

    public void setPath(String path){
        this.path = path;
    }

    public void setSize(int r){
        this.sidelength = r;
    }

    public void draw(PApplet window) {
        if(img != null) {
            window.image(img, pos.getXPixel(), pos.getYPixel(), sidelength, sidelength);
        } else if(path != null){
            this.img = window.loadImage(path);
            window.image(img, pos.getXPixel(), pos.getYPixel(), sidelength, sidelength);
        } else {
            window.rect(pos.getXPixel()+ (int)(Constants.FIELD.BOXSIDELENGTH/2), pos.getYPixel()+(int)(Constants.FIELD.BOXSIDELENGTH/2), sidelength, sidelength);
        }
    }
}

package Entity.Bullet;

import Constants.Constants;
import Entity.Entity;
import Simulator.Position;
import Simulator.Sprite;

public class Bullet {
    protected Position position;
    protected double velocity;
    protected int damage;
    protected Sprite s;
    public Bullet(double x, int y, int damage, double v){
        this.position = new Position(x,y);
        this.velocity = v;
        this.damage = damage;
        s = new Sprite(102,102,102,position, 10);
        s.setSize(10);
    }

    public void move(){
        position.IncreaseX(velocity);
    }

    public int hasCollided(){
        return damage;
    }

    public Sprite getSprite() {
        return this.s;
    }

    public boolean hasGoneOffScreen(){
        if(position.getXPixel() > Constants.Field.WIDTH){
            return true;
        }
        return false;
    }

    public Position getPosition(){
        return this.position;
    }
}

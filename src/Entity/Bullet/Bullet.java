package Entity.Bullet;

import Constants.Constants;
import Entity.Entity;
import Simulator.Position;
import Simulator.Sprite;

public class Bullet extends BasicProjectile{
    protected Position position;
    protected double velocity;
    protected int damage;
    protected Sprite s;
    protected final double range;
//    public Bullet(double x, int y, int damage, double v){
//        this.position = new Position(x,y);
//        this.velocity = v;
//        this.damage = damage;
//        s = new Sprite(position, 10);
//        s.setSize(10);
//    }

    public Bullet(double x, int y, int damage, double v, double range){
        this.position = new Position(x,y);
        this.velocity = v;
        this.damage = damage;
        this.range=range;
        s = new Sprite(position, 10);
        s.setSize(10);
    }

    public Bullet(double x, int y, int damage, double v, double range,String filepath){
        this.position = new Position(x,y);
        this.velocity = v;
        this.damage = damage;
        this.range=range;
        s = new Sprite(position, 10);
        s.setPath(filepath);
        s.setSize(20);
    }

    public boolean move(){
        if(range == -1) {
            position.IncreaseX(velocity);
        } else {
            System.out.println(position.initx + " " + range + " " + position.getX());
            if (range + position.initx < position.getX()){
//                System.out.println("delete me");
                return true;
            } else {
                position.IncreaseX(velocity);
            }
        }
        return false;
    }

    public int hasCollided(){
        return damage;
    }

    public Sprite getSprite() {
        return this.s;
    }

    public boolean hasGoneOffScreen(){
        if(position.getXPixel() > Constants.FIELD.WIDTH){
            return true;
        }
        return false;
    }

    public Position getPosition(){
        return this.position;
    }

    public int getCash(){
        return -1;
    }
}

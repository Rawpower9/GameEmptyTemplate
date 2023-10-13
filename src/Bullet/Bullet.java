package Bullet;

import Simulator.Position;

public class Bullet {
    Position p;
    private double velocity;
    private int damage;
    public Bullet(double x, int y, int damage, double v){
        this.p = new Position(x,y);
        this.velocity = v;
        this.damage = damage;
    }

    public void move(){
        p.IncreaseX(velocity);
    }

    public int hasCollided(){
        return damage;
    }

}

package Entity.Plant;

import Entity.Bullet.Bullet;
import Entity.Entity;
import Simulator.Position;
import Simulator.Sprite;

import java.util.ArrayList;

public class Plant extends Entity {
    protected double bulletSpeed;
    protected double coolDown; //seconds
    protected double coolDownTime;
    protected Sprite s;

    public Plant(int x, int y){
        super(x,y,255,255,0, 100);
        coolDown = 5;
        coolDownTime = coolDown;
        this.bulletSpeed = 0.05;
    }

    public void shoot(ArrayList<Bullet> bullets){
        if(coolDownTime <= 0) {
            Bullet b = new Bullet(position.getX(), position.getY(), this.damage, this.bulletSpeed);
            bullets.add(b);
            coolDownTime = coolDown;
        } else {
            coolDownTime--;
        }
    }
}

package Entity.Plant;

import Constants.Constants;
import Entity.Bullet.Bullet;
import Entity.Entity;
import Simulator.Position;
import Simulator.Sprite;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Plant extends Entity {
    protected double bulletSpeed;
    protected double range;
    protected double coolDown; //seconds
    protected double coolDownTime;
//    protected Sprite s;
    protected Constants.PLANT.TYPE t;

    public Plant(int x, int y, Constants.PLANT.TYPE type){
        super(x,y, 100);
        coolDown = 5;
        coolDownTime = coolDown;
        this.bulletSpeed = 0.05;
        this.t = type;
        this.range=Constants.PLANT.RANGE;
        s.setPath("Images/Plants/"+t.toString().toLowerCase()+".png");
    }

    public void shoot(ArrayList<Bullet> bullets){
        if(coolDownTime <= 0) {
            Bullet b = new Bullet(position.getX(), position.getY(), this.damage, this.bulletSpeed, range);
            bullets.add(b);
            coolDownTime = coolDown;
        } else {
            coolDownTime--;
        }
    }

    public Constants.PLANT.TYPE getType(){
        return this.t;
    }
}

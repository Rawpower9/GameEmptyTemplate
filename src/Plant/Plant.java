package Plant;

import Bullet.Bullet;
import Simulator.Position;
import Zombie.Zombie;

import java.util.ArrayList;

public class Plant {
    protected Position pos;
    protected int damage;
    protected int bulletSpeed;
    protected double coolDown; //seconds
    public Plant(int x, int y){
        pos = new Position((double)x,y);
    }

    public void shoot(ArrayList<Bullet> bullets){
        Bullet b = new Bullet(pos.getX(), pos.getY(), this.damage, this.bulletSpeed);
        bullets.add(b);
    }
}

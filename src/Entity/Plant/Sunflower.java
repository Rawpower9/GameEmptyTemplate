package Entity.Plant;

import Constants.Constants;
import Entity.Bullet.BasicProjectile;
import Entity.Bullet.Bullet;
import Entity.Bullet.Star;

import java.util.ArrayList;

public class Sunflower extends Plant{
    public Sunflower(int x, int y, Constants.PLANT.TYPE type) {
        super(x, y, type);
        this.coolDownTime = Constants.PLANT.SUNFLOWER.COOLDOWN;
        this.coolDown = this.coolDownTime;
    }

    public void shoot(ArrayList<BasicProjectile> stars){
        if(coolDownTime <= 0) {
            Star s = new Star(100,position.getX(), position.getY());
            stars.add(s);
            coolDownTime = coolDown;
        } else {
            coolDownTime--;
        }
    }
}

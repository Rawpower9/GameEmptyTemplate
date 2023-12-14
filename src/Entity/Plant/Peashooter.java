package Entity.Plant;
import Constants.Constants;
import Entity.Bullet.BasicProjectile;
import Entity.Bullet.Bullet;

import java.util.ArrayList;


public class Peashooter extends Plant{
    public Peashooter(int x, int y, Constants.PLANT.TYPE type){
        super(x, y, type);
        this.health = Constants.PLANT.PEASHOOTER.HEALTH;
        this.damage=Constants.PLANT.PEASHOOTER.DAMAGE;
        this.range=Constants.PLANT.PEASHOOTER.RANGE;
        this.coolDown = Constants.PLANT.PEASHOOTER.COOLDOWN;
    }

    public void shoot(ArrayList<BasicProjectile> bullets){
        if(coolDownTime <= 0) {
            Bullet b = new Bullet(position.getX(), position.getY(), this.damage, this.bulletSpeed,Constants.PLANT.PEASHOOTER.RANGE,"Images/Bullets/"+t.toString().toLowerCase()+".png");
            bullets.add(b);
            coolDownTime = coolDown;
        } else {
            coolDownTime--;
        }
    }

}

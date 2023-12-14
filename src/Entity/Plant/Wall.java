package Entity.Plant;

import Constants.Constants;
import Entity.Bullet.BasicProjectile;
import Entity.Bullet.Bullet;
import java.util.ArrayList;

public class Wall extends Plant{

    public Wall(int x, int y, Constants.PLANT.TYPE type) {
        super(x, y, type);
        this.health = Constants.PLANT.WALL.HEALTH;
    }

    public void shoot(ArrayList<BasicProjectile> bullets){
        //This plant does not shoot
    }


}

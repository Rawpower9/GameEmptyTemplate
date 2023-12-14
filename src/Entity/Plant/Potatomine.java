package Entity.Plant;

import Constants.Constants;
import Entity.Bullet.BasicProjectile;

import java.util.ArrayList;

public class Potatomine extends Plant {

    public Potatomine(int x, int y, Constants.PLANT.TYPE type) {
        super(x, y, type);
    }

    public void shoot(ArrayList<BasicProjectile> bullets){
        //This plant does not shoot
    }
}

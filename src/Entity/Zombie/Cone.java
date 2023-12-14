package Entity.Zombie;

import Constants.Constants;

public class Cone extends Zombie {

    public Cone(int y, Constants.ZOMBIE.TYPE t) {
        super(y,t);
        this.health = Constants.ZOMBIE.CONE.HEALTH;
        this.velocity = Constants.ZOMBIE.CONE.VELOCITY;
        this.damage = Constants.ZOMBIE.CONE.DAMAGE;
    }

}

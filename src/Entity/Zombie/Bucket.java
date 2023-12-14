package Entity.Zombie;

import Constants.Constants;

public class Bucket extends Zombie{
    public Bucket(int y, Constants.ZOMBIE.TYPE t) {
        super(y,t);
        this.health = Constants.ZOMBIE.BUCKET.HEALTH;
        this.velocity = Constants.ZOMBIE.BUCKET.VELOCITY;
        this.damage = Constants.ZOMBIE.BUCKET.DAMAGE;
    }
}

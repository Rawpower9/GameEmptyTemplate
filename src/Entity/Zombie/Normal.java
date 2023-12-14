package Entity.Zombie;

import Constants.Constants;

public class Normal extends Zombie{

    public Normal(int y, Constants.ZOMBIE.TYPE t) {
        super(y,t);
        this.health = Constants.ZOMBIE.NORMAL.HEALTH;
        this.velocity = Constants.ZOMBIE.NORMAL.VELOCITY;
        this.damage = Constants.ZOMBIE.NORMAL.DAMAGE;
    }
}

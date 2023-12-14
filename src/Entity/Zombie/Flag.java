package Entity.Zombie;

import Constants.Constants;

public class Flag extends Zombie{

    public Flag(int y, Constants.ZOMBIE.TYPE t) {
        super(y,t);
        this.health = Constants.ZOMBIE.FLAG.HEALTH;
        this.velocity = Constants.ZOMBIE.FLAG.VELOCITY;
        this.damage = Constants.ZOMBIE.FLAG.DAMAGE;
    }
}

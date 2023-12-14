package Entity.Zombie;

import Constants.Constants;

public class Dance extends Zombie{

    public Dance(int y, Constants.ZOMBIE.TYPE t) {
        super(y,t);
        this.health = Constants.ZOMBIE.DANCE.HEALTH;
        this.velocity = Constants.ZOMBIE.DANCE.VELOCITY;
        this.damage = Constants.ZOMBIE.DANCE.DAMAGE;
    }
}

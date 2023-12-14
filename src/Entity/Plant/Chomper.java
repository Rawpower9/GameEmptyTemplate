package Entity.Plant;
import Constants.Constants;

public class Chomper extends Plant{
    public Chomper(int x, int y, Constants.PLANT.TYPE type){
        super(x, y, type);
        this.health = Constants.PLANT.CHOMPER.HEALTH;
        this.damage=Constants.PLANT.CHOMPER.DAMAGE;
        this.range=Constants.PLANT.CHOMPER.RANGE;
    }

}

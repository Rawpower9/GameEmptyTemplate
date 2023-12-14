package Entity.Zombie;

import Constants.Constants;
import Entity.Plant.*;

public class ZombieType {

    public static Zombie getRandom(int c) throws ClassNotFoundException {
        int random = (int)(Math.random()*5);
        if(random == 0){
            return new Normal(c,Constants.ZOMBIE.TYPE.NORMAL);
        } else if (random == 1){
            return new Normal(c,Constants.ZOMBIE.TYPE.BUCKET);
        } else if (random == 2){
            return new Normal(c,Constants.ZOMBIE.TYPE.CONE);
        } else if (random == 3){
            return new Normal(c,Constants.ZOMBIE.TYPE.FLAG);
        } else {
            return new Normal(c,Constants.ZOMBIE.TYPE.DANCE);
        }

    }
    public static Zombie getInstance(int c, Constants.ZOMBIE.TYPE t) throws ClassNotFoundException {
        if(t.equals(Constants.ZOMBIE.TYPE.NORMAL)){
            return new Normal(c,t);
        } else if (t.equals(Constants.ZOMBIE.TYPE.BUCKET)){
            return new Normal(c,t);
//            return new Chomper(w,c,t);
        } else if (t.equals(Constants.ZOMBIE.TYPE.CONE)){
            return new Normal(c,t);
//            return new Peashooter(w,c,t);
        } else if (t.equals(Constants.ZOMBIE.TYPE.FLAG)){
            return new Normal(c,t);
//            return new Snowpea(w,c,t);
        } else if (t.equals(Constants.ZOMBIE.TYPE.DANCE)){
            return new Normal(c,t);
//            return new Potatomine(w,c,t);
        } else{
            throw new ClassNotFoundException("This Plant does not exists");
        }
//        return new Normal(c,t);
    }
}

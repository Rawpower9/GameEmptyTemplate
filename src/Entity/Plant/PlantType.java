package Entity.Plant;

import Constants.Constants;

public class PlantType {
    public static Plant getInstance(int w,int c,Constants.PLANT.TYPE t) throws ClassNotFoundException {

        if(t.equals(Constants.PLANT.TYPE.WALL)){
            return new Wall(w,c,t);
        } else if (t.equals(Constants.PLANT.TYPE.CHOMPER)){
            return new Chomper(w,c,t);
        } else if (t.equals(Constants.PLANT.TYPE.PEASHOOTER)){
            return new Peashooter(w,c,t);
        } else if (t.equals(Constants.PLANT.TYPE.SNOWPEA)){
            return new Snowpea(w,c,t);
        } else if (t.equals(Constants.PLANT.TYPE.POTATOMINE)){
            return new Potatomine(w,c,t);
        } else if (t.equals(Constants.PLANT.TYPE.REPEATER)){
            return new Repeater(w,c,t);
        }  else if (t.equals(Constants.PLANT.TYPE.SUNFLOWER)){
            return new Sunflower(w,c,t);
        } else{
            throw new ClassNotFoundException("This Plant does not exists");
        }
    }
}

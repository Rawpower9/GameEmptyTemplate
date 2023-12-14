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

    public static Plant getInstance(int w,int c,String t) throws ClassNotFoundException {
        if(t.equals("WALL")){
            return new Wall(w,c,Constants.PLANT.TYPE.WALL);
        } else if (t.equals("CHOMPER")){
            return new Chomper(w,c,Constants.PLANT.TYPE.CHOMPER);
        } else if (t.equals("PEASHOOTER")){
            return new Peashooter(w,c,Constants.PLANT.TYPE.PEASHOOTER);
        } else if (t.equals("SNOWPEA")){
            return new Snowpea(w,c,Constants.PLANT.TYPE.SNOWPEA);
        } else if (t.equals("POTATOMINE")){
            return new Potatomine(w,c,Constants.PLANT.TYPE.POTATOMINE);
        } else if (t.equals("REPEATER")){
            return new Repeater(w,c,Constants.PLANT.TYPE.REPEATER);
        }  else if (t.equals("SUNFLOWER")){
            return new Sunflower(w,c,Constants.PLANT.TYPE.SUNFLOWER);
        } else{
            return null;
        }
    }
}

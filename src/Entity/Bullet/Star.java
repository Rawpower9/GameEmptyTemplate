package Entity.Bullet;

import Constants.Constants;
import Simulator.Position;
import Simulator.Sprite;

public class Star extends BasicProjectile{

    private int cash;
    private int timeSinceSpawn;
    private Position p;
    private Sprite s;
    public Star(int cash, double x, int y) {
        this.cash=cash;
        this.p = new Position(x,y);
        this.s=new Sprite(p, Constants.FIELD.BOXSIDELENGTH);
        s.setPath("Images/Bullets/sunflower.png");
        this.timeSinceSpawn=0;
    }

    public int getCash(){
        return cash;
    }

    public double moveStar(int x){
        if (x > 50) {
            return 0.05;
        } else {
            return -0.05;
        }
    }

    public boolean move(){
        if(timeSinceSpawn < 100) {
            p.IncreaseX((double) 1 / 100);
            p.IncreaseDoubleY((double) moveStar(timeSinceSpawn));
            timeSinceSpawn++;
        }
        return false;
    }
    public boolean hasGoneOffScreen(){
        if(p.getXPixel() > Constants.FIELD.WIDTH){
            return true;
        }
        return false;
    }
    public Sprite getSprite() {
        return this.s;
    }
    public int hasCollided(){
        return 0;
    }

    public Position getPosition(){
        return this.p;
    }



}

package Entity;

import Simulator.Field;
import Simulator.Position;
import Simulator.Sprite;

public class Entity {
    protected Position position;
    protected int health;
    protected int damage;
    protected boolean alive;
    protected int radius;
    protected Sprite s;


    public Entity(int x,int y, int r, int g, int b, int radius){
        position = new Position(x,y);
        this.radius = radius;
        s = new Sprite(r,g,b, position, this.radius);
        this.damage = 1;
        this.health = 100;
        this.alive = true;
    }

    public void takeDamage(int d){
        health -= d;
        if(health <= 0){
            this.alive = false;
        }
    }

    public boolean isAlive(){
        return this.alive;
    }

    public Position getPosition(){
        return this.position;
    }

    public Sprite getSprite() {
        return this.s;
    }
}

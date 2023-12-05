package Entity.Zombie;

import Entity.Bullet.Bullet;
import Entity.Entity;

import java.util.ArrayList;

public class Zombie extends Entity{
    protected double velocity;

    public Zombie(int y){
        super(8,y,100);
        this.velocity = 0.001;
        this.sidelength = 100;
    }

    public void move(){
        position.IncreaseX(-this.velocity);
    }

    public int eat(){ // how much damage the zombie deals
       return damage;
    }

    public void hit(ArrayList<Bullet> bullets){
        for(int i = 0; i < bullets.size(); i++){
//            System.out.println(bullets.get(i).getPosition().getXPixel() - this.getPosition().getXPixel());
            if (Math.sqrt(Math.pow(bullets.get(i).getPosition().getXPixel() - this.getPosition().getXPixel(),2)+Math.pow(bullets.get(i).getPosition().getYPixel() - this.getPosition().getYPixel(),2)) <= this.sidelength/2) {
                this.takeDamage(bullets.get(i).hasCollided());
                bullets.remove(i);
                i++;
//                System.out.println(this.health);
            }
        }
    }
}


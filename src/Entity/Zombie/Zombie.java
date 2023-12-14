package Entity.Zombie;

import Constants.Constants;
import Entity.Bullet.BasicProjectile;
import Entity.Entity;
import Entity.Plant.Plant;

import java.util.ArrayList;

public class Zombie extends Entity{
    protected double velocity;

    public Zombie(int y, Constants.ZOMBIE.TYPE t){
        super(8,y,100);
        this.velocity = 0.001;
        this.sidelength = 100;
        s.setPath("Images/Zombies/"+t.toString().toLowerCase()+".png");
        System.out.println("Images/Zombies/"+t.toString().toLowerCase()+".png");
    }

    public void move(Plant[][] plants){
        boolean attacking = false;
        for (int w = 0; w < plants.length; w++) {
            for(int c = 0; c < plants[w].length; c++) {
                if (plants[w][c] != null) {
                    if (Math.sqrt(Math.pow(plants[w][c].getPosition().getXPixel() - this.getPosition().getXPixel(), 2) + Math.pow(plants[w][c].getPosition().getYPixel() - this.getPosition().getYPixel(), 2)) <= this.sidelength / 2) {
                        plants[w][c].takeDamage(this.damage);
                        attacking = true;
                        if (plants[w][c].isAlive() == false) {
                            plants[w][c] = null;
                        }
                    }
                }
            }
        }

        if(!attacking){
            position.IncreaseX(-this.velocity);
        }
    }

    public int eat(){ // how much damage the zombie deals
       return damage;
    }

    public void hit(ArrayList<BasicProjectile> bullets){
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

    public void kill(ArrayList<Plant> plants) {

    }
}


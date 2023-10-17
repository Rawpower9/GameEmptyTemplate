package Simulator;

import Entity.Bullet.Bullet;
import Entity.Plant.Plant;
import Entity.Zombie.Zombie;
import processing.core.PApplet;

import java.util.ArrayList;
import Entity.Zombie.ZombieQueue;

public class Field {
    int numRows, numColms, sideLength, x,y;
    private ArrayList<Plant> plants;
    private ArrayList<Zombie> zombies;
    private ArrayList<Bullet> bullets;
    private ZombieQueue q;
    private static Field f;

    public static Field getInstance(int numRows, int numColms, int sideLength, int startX, int startY){
        if(f == null){
            f = new Field(numRows,numColms,sideLength,startX,startY);
        }
        return f;
    }

    public static Field getInstance() {
        if(f == null){
            System.err.println("Field has not been initialized");
        }
        return f;
    }

    private Field(int numRows, int numColms, int sideLength, int startX, int startY){
        this.numRows=numRows;
        this.numColms=numColms;
        this.sideLength = sideLength;
        this.x=startX;
        this.y=startY;
        plants = new ArrayList<Plant>();
        zombies = new ArrayList<Zombie>();
        bullets = new ArrayList<Bullet>();
        q = new ZombieQueue(5,500);
        init();
    }

    private void init(){
//        plants.add(new Plant(0,0));
        for(int i = 0; i < 5; i++){
            plants.add(new Plant(0,i));
        }
        for(int i = 0; i < 10; i++){
            q.addToQueue(new Zombie((int)(Math.random()*5)));
        }
//        zombies.add(new Zombie(1));
    }

    public void draw(PApplet window){
        window.fill(255,255,255);
        for(int w = 0; w< numRows; w++){
            for(int c = 0; c< numColms; c++){
                window.rect(x + w*sideLength, y + c*sideLength, sideLength,sideLength);
            }
        }
        q.draw(zombies);

        this.move();
        for(Plant plant: plants){
            plant.getSprite().draw(window);
        }

        for(int i = 0; i < zombies.size(); i++){
            zombies.get(i).getSprite().draw(window);
            zombies.get(i).hit(bullets);
            if(zombies.get(i).isAlive() == false){
                zombies.remove(i);
                i++;
            }
        }

        for(int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).hasGoneOffScreen()){
                bullets.remove(i);
                i++;
            } else {
                bullets.get(i).getSprite().draw(window);
            }
        }
    }

    public void move(){
        for(Zombie zombie : zombies){
            zombie.move();
        }

        for(Plant plant: plants){
            plant.shoot(bullets);
        }

        for(Bullet bullet: bullets){
            bullet.move();
        }
    }
}

package Simulator;

import Entity.Bullet.Bullet;
import Entity.Plant.Plant;
import Entity.Plant.PlantType;
import Entity.Zombie.Zombie;
import Simulator.SideBar.Card;
import processing.core.PApplet;

import java.util.ArrayList;
import Entity.Zombie.ZombieQueue;
import processing.core.PImage;

public class Field {
    int numRows, numColms, sideLength, x,y;
    private ArrayList<Zombie> zombies;
    private ArrayList<Bullet> bullets;
    private ZombieQueue q;
    private static Field f;
    private Plant [][] plants;
    private PImage tile;
    public static Field getInstance(int numRows, int numColms, int sideLength, int startX, int startY,PApplet window){
        if(f == null){
            f = new Field(numRows,numColms,sideLength,startX,startY, window);
        }
        return f;
    }

    public static Field getInstance() {
        if(f == null){
            System.err.println("Field has not been initialized");
        }
        return f;
    }

    private Field(int numRows, int numColms, int sideLength, int startX, int startY, PApplet window){
        this.numRows=numRows;
        this.numColms=numColms;
        this.sideLength = sideLength;
        this.x=startX;
        this.y=startY;
//        plants = new ArrayList<Plant>();
        zombies = new ArrayList<Zombie>();
        bullets = new ArrayList<Bullet>();
        q = new ZombieQueue(5,500);
        this.plants = new Plant[numRows][numColms];
        tile = window.loadImage("src/Images/ground.jpg");
//        init();
    }

    private void init(){
//        plants.add(new Plant(0,0));
//        for(int i = 0; i < 5; i++){
//            plants.add(new Plant(0,i));
//        }
        for(int i = 0; i < 10; i++){
            q.addToQueue(new Zombie((int)(Math.random()*5)));
        }
//        zombies.add(new Zombie(1));
    }

    public void draw(PApplet window){
        window.fill(255,255,255);
        for(int w = 0; w< numRows; w++){
            for(int c = 0; c< numColms; c++){
                window.image(tile,x + w*sideLength, y + c*sideLength, sideLength,sideLength);
                if(plants[w][c] != null) {
//                    System.out.println(w + " " + c);
                    plants[w][c].getSprite().draw(window);
                }
//                window.rect(x + w*sideLength, y + c*sideLength, sideLength,sideLength);
            }
        }
        q.draw(zombies);

        this.move();

        for(int r = 0; r<plants.length; r++){
            for(int c = 0; c < plants[0].length; c++){
                if(plants[r][c] != null) {
                    plants[r][c].getSprite().draw(window);
                }
            }
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

        for(int r = 0; r<plants.length; r++){
            for(int c = 0; c < plants[0].length; c++){
                if(plants[r][c] != null) {
                    plants[r][c].shoot(bullets);
                }
            }
        }

        for(int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).move()){
                bullets.remove(i);
                i--;
            }
        }
    }

    public void mousePressed(int mouseX, int mouseY, Card card) throws ClassNotFoundException {
        if(card != null) {
            for (int w = 0; w < numRows; w++) {
                for (int c = 0; c < numColms; c++) {
                    if (inRegion(x + w * sideLength, y + c * sideLength, sideLength, sideLength, mouseX, mouseY)) {
                        plants[w][c] = PlantType.getInstance(w,c,card.getType());
                    }
                }
            }
        }
    }

    public boolean inRegion(int x, int y, int w, int h, int mouseX, int mouseY){
        if(mouseX >= x && mouseX <= x+w){
            if(mouseY >= y && mouseY <= y+h){
                return true;
            }
        }
        return false;
    }
}

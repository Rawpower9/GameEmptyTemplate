package Simulator;

import Constants.Constants;
import Entity.Bullet.BasicProjectile;
import Entity.Bullet.Bullet;
import Entity.Plant.Plant;
import Entity.Plant.PlantType;
import Entity.Zombie.Normal;
import Entity.Zombie.Zombie;
import Entity.Zombie.ZombieType;
import Simulator.SideBar.Card;
import processing.core.PApplet;

import java.util.ArrayList;
import Entity.Zombie.ZombieQueue;
import processing.core.PImage;

public class Field {
    int numRows, numColms, sideLength, x,y;
    private ArrayList<Zombie> zombies;
    private ArrayList<BasicProjectile> bullets;
    private ZombieQueue q;
    private static Field f;
    private Plant [][] plants;
    private PImage tile;
    public static Field getInstance(int numRows, int numColms, int sideLength, int startX, int startY,PApplet window) throws ClassNotFoundException {
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

    private Field(int numRows, int numColms, int sideLength, int startX, int startY, PApplet window) throws ClassNotFoundException {
        this.numRows=numRows;
        this.numColms=numColms;
        this.sideLength = sideLength;
        this.x=startX;
        this.y=startY;
//        plants = new ArrayList<Plant>();
        zombies = new ArrayList<Zombie>();
        bullets = new ArrayList<BasicProjectile>();
        q = new ZombieQueue(5,500);
        this.plants = new Plant[numRows][numColms];
        tile = window.loadImage("src/Images/ground.jpg");
        init();
    }

    private void init() throws ClassNotFoundException {
        for(int i = 0; i < 10; i++){
            q.addToQueue(ZombieType.getInstance(i % 5, Constants.ZOMBIE.TYPE.NORMAL));
        }

        for(int i = 0; i < 10; i++){
            q.addToQueue(ZombieType.getInstance(i % 5, Constants.ZOMBIE.TYPE.BUCKET));
        }

        for(int i = 0; i < 35; i++){
            q.addToQueue(ZombieType.getRandom((int)(Math.random() * 5)));
        }
    }

    public void draw(PApplet window){
        window.fill(255,255,255);
        for(int w = 0; w< numRows; w++){
            for(int c = 0; c< numColms; c++){
                window.image(tile,x + w*sideLength, y + c*sideLength, sideLength,sideLength);
                if(plants[w][c] != null) {
                    plants[w][c].getSprite().draw(window);
                }
            }
        }

        q.draw(zombies);

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
                i--;
            }
        }


        for(int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).hasGoneOffScreen()){
                bullets.remove(i);
                i++;
            } else {
                bullets.get(i).getSprite().bulletDraw(window);
            }
        }

        this.move();
    }

    public void move(){
        for(Zombie zombie : zombies){
            zombie.move(plants);
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

    public boolean loseCheck(){
        for(Zombie z:zombies){
            if (z.getPosition().getXPixel() <= Constants.FIELD.STARTX){
                return true;
            }
        }
        return false;
    }


    public boolean winCheck(){
        if(zombies.size() == 0 && q.ZombiesInQueue() == 0){
            return true;
        }
        return false;
    }
    public int mousePressed(int mouseX, int mouseY, Card card, int money) throws ClassNotFoundException {
        if(card != null) {
            for (int w = 0; w < numRows; w++) {
                for (int c = 0; c < numColms; c++) {
                    if (inRegion(x + w * sideLength, y + c * sideLength, sideLength, sideLength, mouseX, mouseY)) {
                        if(card.getType().COST() <= money && plants[w][c] == null){
                            money -= card.getType().COST();
                            plants[w][c] = PlantType.getInstance(w,c,card.getType());
                        }
                    }
                }
            }
        }
        return money;
    }

    public int bulletPressed(int mouseX, int mouseY){
        int totalCash = 0;
        for(int i = 0; i < bullets.size(); i++){

            if(mouseX > bullets.get(i).getPosition().getXPixel()+75f && mouseX < bullets.get(i).getPosition().getXPixel()+175f){
                if(mouseY > bullets.get(i).getPosition().getYPixel()+75f && mouseY < bullets.get(i).getPosition().getYPixel()+175f){
                    if(bullets.get(i).getCash() == -1){

                    } else {
                        totalCash+=bullets.get(i).getCash();
                        bullets.remove(i);
                        i--;
                    }
                }
            }
        }
        return totalCash;
    }

    public Plant[][] getPlants(){
        return plants;
    }

    public void setPlants(Plant[][] plants){
        this.plants = plants;
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

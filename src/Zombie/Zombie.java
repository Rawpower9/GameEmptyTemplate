package Zombie;

import Simulator.Position;

public class Zombie {
    protected Position position;
    protected double velocity;
    protected int health;
    protected int damage;
    protected boolean alive;
    public Zombie(int y){
        position = new Position(9,(int)Math.random()*5+1);
    }

    public boolean isAlive(int h){
        h = this.health;
        if (this.health > 0){
            return true;
        }
        return false;
    }

    public void move(){
        position.IncreaseX(velocity);
    }

    public int attack(){ // how much damage the zombie deals
       return damage;
    }

    public void takeDamage(int d){
        health -= d;
        if(health >= 0){
            this.alive = false;
        }
    }

    public boolean isAlive(){
        return this.alive;
    }
}


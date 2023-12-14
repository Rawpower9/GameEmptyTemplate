package Entity.Zombie;

import Entity.Zombie.Zombie;

import java.util.ArrayList;

public class ZombieQueue {
    private int y,time;
    private ArrayList<ArrayList<Zombie>> zombies;
    private int [] timeLeft;
    public ZombieQueue(int y, int t){
        this.y=y;
        this.time=t;
        this.timeLeft=new int[y];
        zombies = new ArrayList<>();
        for(int i = 0; i < y; i++){
            zombies.add(new ArrayList<>());
        }
    }

    public int ZombiesInQueue(){
        int total = 0;
        for(int i = 0; i< zombies.size(); i++){
            total += zombies.get(i).size();
        }
        return total;
    }

    public void addToQueue(Zombie z){
        zombies.get((int)(z.getPosition().getY())).add(z);
    }

    public void draw(ArrayList<Zombie> zombies) { //TODO: Rename this
        for (int i = 0; i < timeLeft.length; i++) {
            if (timeLeft[i] <= 0) {
                if(this.zombies.get(i).isEmpty() == false) {
                    zombies.add(this.zombies.get(i).remove(0));
                }
                timeLeft[i] = time;
            } else {
                timeLeft[i]--;
            }
        }
    }
}

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

    public void addToQueue(Zombie z){
        zombies.get(z.getPosition().getY()).add(z);
        System.out.println(z.getPosition().getY());
    }

    public void draw(ArrayList<Zombie> zombies) { //TODO: Rename this
        for (int i = 0; i < timeLeft.length; i++) {
            System.out.println(timeLeft[i]);
            if (timeLeft[i] <= 0) {
                if(this.zombies.get(i).isEmpty() == false) {
//                    System.out.println(timeLeft[i]);
                    zombies.add(this.zombies.get(i).remove(0));
                }
                timeLeft[i] = time;
            } else {
                timeLeft[i]--;
            }
        }
    }
}
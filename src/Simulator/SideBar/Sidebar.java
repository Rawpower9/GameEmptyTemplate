package Simulator.SideBar;

import Constants.Constants.PLANT;
import Constants.Constants.SIDEBAR;
import processing.core.PApplet;

import java.util.ArrayList;

public class Sidebar {
    ArrayList<Card> cards = new ArrayList<>();
    int y;

    private Card onMouse;
    public Sidebar(PApplet window){
        y = 0;
        for(PLANT.TYPE t: PLANT.TYPE.values()) {
            cards.add(new Card(t, window));
        }
    }

    public void draw(PApplet window){
        window.fill(100,100,100);
        window.rect(SIDEBAR.STARTX,SIDEBAR.STARTY,SIDEBAR.WIDTH,SIDEBAR.HEIGHT);
        for(int i = 0; i < Math.min(cards.size(),SIDEBAR.MAXCARDS); i++){
            cards.get(i).draw(window,i);
        }
        window.fill(200,200,200);
        window.rect(SIDEBAR.STARTX+SIDEBAR.WIDTH-20,SIDEBAR.STARTY,20,20);
        window.fill(0,0,0);
        window.text('^',SIDEBAR.STARTX+SIDEBAR.WIDTH-13,SIDEBAR.STARTY+15);
        if(onMouse != null) {
            onMouse.drawImage(window, window.mouseX, window.mouseY);
        }
    }

    public void mousePressed(int mouseX, int mouseY){
        if(onMouse != null){
            onMouse = null;
        }
        if(inRegion(SIDEBAR.STARTX+SIDEBAR.WIDTH-20,SIDEBAR.STARTY,20,20,mouseX,mouseY)){
                cards.add(cards.remove(0));
        } else {
            for(int i = 0; i < Math.min(cards.size(),SIDEBAR.MAXCARDS); i++){
                if (cards.get(i).mousePressed(mouseX, mouseY,i)) {
                    onMouse = cards.get(i);
//                    System.out.println(cards.get(i).getType().toString());
//                    break;
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

    public Card getOnMouse(){
        return onMouse;
    }
}

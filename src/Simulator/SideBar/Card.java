package Simulator.SideBar;

import Entity.Plant.Plant;
import Constants.Constants.SIDEBAR;
import Constants.Constants.PLANT;
import processing.core.PApplet;
import processing.core.PImage;



public class Card {
    private PImage img;
    private PLANT.TYPE type;
    private String description = "";
    public Card(PLANT.TYPE type, PApplet papplet){
        img = papplet.loadImage("Images/Plants/"+type.toString().toLowerCase()+".png");
        this.type = type;
        this.description = type.DESC();
    }

    public void draw(PApplet window, int i){
        window.image(img, SIDEBAR.STARTX,SIDEBAR.STARTY + i*SIDEBAR.CARD.HEIGHT,SIDEBAR.CARD.WIDTH, SIDEBAR.CARD.HEIGHT);
        window.fill(0,255,0);
        window.text(description,
                SIDEBAR.STARTX+SIDEBAR.CARD.WIDTH+SIDEBAR.CARD.TEXTTOIMAGESPACE,
                SIDEBAR.STARTY + i*SIDEBAR.CARD.HEIGHT+20,
                SIDEBAR.CARD.TEXTWIDTH - SIDEBAR.CARD.TEXTTOIMAGESPACE,
                SIDEBAR.CARD.HEIGHT);
    }

    public boolean mousePressed(int mouseX, int mouseY, int i){
        if(inRegion(SIDEBAR.STARTX,SIDEBAR.STARTY + i*SIDEBAR.CARD.HEIGHT,SIDEBAR.CARD.TEXTWIDTH+SIDEBAR.CARD.WIDTH,SIDEBAR.CARD.HEIGHT,mouseX,mouseY)){
//            System.out.println(this.type.toString());
            return true;
        }
        return false;
    }

    public boolean inRegion(int x, int y, int w, int h, int mouseX, int mouseY){
        if(mouseX >= x && mouseX <= x+w){
            if (mouseY >= y && mouseY <= y+h){
                return true;
            }
        }
        return false;
    }

    public PLANT.TYPE getType(){
        return this.type;
    }

    public void drawImage(PApplet window, int x, int y){
        window.image(img, x-(int)(SIDEBAR.CARD.WIDTH/2),y-(int)(SIDEBAR.CARD.HEIGHT/2),SIDEBAR.CARD.WIDTH, SIDEBAR.CARD.HEIGHT);
    }
}

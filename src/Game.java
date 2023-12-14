import Constants.Constants;
import Constants.Constants.FIELD;
import Simulator.Field;
import Simulator.Save;
import Simulator.SideBar.Sidebar;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Game extends PApplet {
    // TODO: declare game variables
    Field f;
    Sidebar s;
    private boolean pause;
    private PImage img;

    private int money;
    boolean lose,win;

    public void settings() {
        size(FIELD.WIDTH, FIELD.HEIGHT);   // set the window size
    }

    public void setup() {
        frameRate(60);
        try {
            f = Field.getInstance(FIELD.NUMROW,FIELD.NUMCOL,FIELD.BOXSIDELENGTH,FIELD.STARTX,FIELD.STARTY, this);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            f.setPlants(Save.loadState());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        s = new Sidebar(this);
        pause = false;
        money = 500;
        this.lose = false;
        this.win = false;
        // TODO: initialize game variables
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
//        f.move();
        if(!pause && !lose && !win) {
            if(f.loseCheck()){
                lose = true;
            } else if(f.winCheck()){
                win = true;
            }
            background(255);    // paint screen white
            f.draw(this);
            s.draw(this);
//            rect(FIELD.STARTX+FIELD.BOXSIDELENGTH*FIELD.NUMROW, FIELD.STARTY,100,50);
            text("Money: " + money, FIELD.STARTX, FIELD.STARTY + FIELD.BOXSIDELENGTH*FIELD.NUMCOL+50);

        } else if (lose){
            textSize((float) FIELD.HEIGHT /2);
            text("LOST", 0, Constants.FIELD.HEIGHT);
        } else if (win){
            textSize((float) FIELD.HEIGHT /2);
            text("WIN", 0, Constants.FIELD.HEIGHT);
        }

//        fill(0,255,0);          // load green paint color
//        ellipse(mouseX, mouseY, 60, 60);  // draw circle at mouse loc
//        ellipse(mouseX - 80, mouseY, 60, 60);  // draw circle at mouse loc
//        ellipse(mouseX + 80, mouseY, 60, 60);  // draw circle at mouse loc
    }

    public void keyPressed() {
        if (key == 'p') {
            pause = !pause;
            if(pause == false){
                try {
                    Save.saveState(f.getPlants());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void mousePressed(){
        if(mousePressed){
            try {
                money = f.mousePressed(mouseX, mouseY,s.getOnMouse(),money);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            s.mousePressed(mouseX,mouseY);
            money += f.bulletPressed(mouseX,mouseY);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

import Constants.Constants;
import Simulator.Field;
import processing.core.PApplet;

public class Game extends PApplet {
    // TODO: declare game variables
    Field f;
    public void settings() {
        size(Constants.Field.WIDTH, Constants.Field.HEIGHT);   // set the window size

    }

    public void setup() {
        frameRate(60);
        f = Field.getInstance(9,5,100,200,25);
        // TODO: initialize game variables
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
//        f.move();
        background(255);    // paint screen white
        f.draw(this);
//        fill(0,255,0);          // load green paint color
//        ellipse(mouseX, mouseY, 60, 60);  // draw circle at mouse loc
//        ellipse(mouseX - 80, mouseY, 60, 60);  // draw circle at mouse loc
//        ellipse(mouseX + 80, mouseY, 60, 60);  // draw circle at mouse loc
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

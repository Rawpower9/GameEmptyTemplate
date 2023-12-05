import Constants.Constants.FIELD;
import Simulator.Field;
import Simulator.SideBar.Sidebar;
import processing.core.PApplet;
import processing.core.PImage;

public class Game extends PApplet {
    // TODO: declare game variables
    Field f;
    Sidebar s;
    private boolean pause;
    private PImage img;
    public void settings() {
        size(FIELD.WIDTH, FIELD.HEIGHT);   // set the window size
    }

    public void setup() {
        frameRate(60);
        f = Field.getInstance(FIELD.NUMROW,FIELD.NUMCOL,FIELD.BOXSIDELENGTH,FIELD.STARTX,FIELD.STARTY, this);
        s = new Sidebar(this);
        pause = false;
        // TODO: initialize game variables
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
//        f.move();
        if(!pause) {
            background(255);    // paint screen white
            f.draw(this);
            s.draw(this);
        }

//        fill(0,255,0);          // load green paint color
//        ellipse(mouseX, mouseY, 60, 60);  // draw circle at mouse loc
//        ellipse(mouseX - 80, mouseY, 60, 60);  // draw circle at mouse loc
//        ellipse(mouseX + 80, mouseY, 60, 60);  // draw circle at mouse loc
    }

    public void keyPressed() {
        if (key == 'p') {
            pause = !pause;
        }
//        if(key == 's'){
//            s.keyPressed();
//        }
    }

    public void mousePressed(){
        if(mousePressed){
            try {
                f.mousePressed(mouseX, mouseY,s.getOnMouse());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            s.mousePressed(mouseX,mouseY);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

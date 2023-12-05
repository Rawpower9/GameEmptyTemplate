package Simulator;

public class Position {
    private double x;
    private int y;
    final public double initx;
    final public int inity;

    private Field f;
    public Position(double x, int y){
        this.x = x;
        this.y = y;
        this.initx=x;
        this.inity=y;
    }


    public double getX() {
        return x;
    }

    public void IncreaseX(double x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void IncreaseY(int y) {
        this.y += y;
    }

    public float getXPixel(){
        f = Field.getInstance();
        return (float) (f.x + f.sideLength * (this.getX()));
    }

    public float getYPixel(){
        f = Field.getInstance();
        return (float) (f.y + f.sideLength * (this.getY()));
    }

    public float getXCenter(){
        return getXPixel() - f.sideLength/2;
    }

    public float getYCenter(){
        return getYPixel() - f.sideLength/2;
    }
}

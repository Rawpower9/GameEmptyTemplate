package Simulator;

public class Position {
    private double x;
    private double y;
    final public double initx;
    final public double inity;

    private Field f;
    public Position(double x, int y){
        this.x = x;
        this.y = y;
        this.initx=x;
        this.inity=y;
    }

    public Position(double x, double y){
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
        return (int)(y);
    }

    public double getDoubleY(){
        return y;
    }

    public void IncreaseY(double y) {
        this.y += y;
    }

    public void IncreaseDoubleY(double y){
        this.y+=y;
    }

    public float getXPixel(){
        f = Field.getInstance();
        return (float) (f.x + f.sideLength * (this.getX()));
    }

    public float getYPixel(){
        f = Field.getInstance();
        return (float) (f.y + f.sideLength * (this.getDoubleY()));
    }

    public float getXCenter(){
        return getXPixel() - f.sideLength/2;
    }

    public float getYCenter(){
        return getYPixel() - f.sideLength/2;
    }
}

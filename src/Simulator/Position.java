package Simulator;

public class Position {
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

    private double x;
    private int y;

    public Position(double x, int y){
        this.x = x;
        this.y = y;
    }
}

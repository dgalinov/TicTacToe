package model;

public class Position {
    private int x;
    private int y;

    public Position() {}

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() { return y; }
    public int getX() { return x; }
}

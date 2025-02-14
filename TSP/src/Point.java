import java.io.FileNotFoundException;
import java.util.Scanner;
public class Point
{
    private int x;
    private int y;


    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point other)
    {
        double nx=Math.pow(other.x-x,2);
        double ny= Math.pow(other.y-y,2);
        return Math.sqrt(nx+ny);
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public static void main(String[] args)
    {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-1, 6);
        System.out.println(p1.distance(p2));
        System.out.println(p1);
        System.out.println(p2.getX());
        System.out.println(p1.getY());
    }


}

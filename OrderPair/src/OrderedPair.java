/*
Accessors:
distance between 2 points
midpoint between 2 points
inverse of OP
isOnLine
slope between 2 points
toPolar
getQuadrant

Mutators:
reflect
translate
rotate
stretch
*/

public class OrderedPair
{
    private double x;
    private double y;

    public OrderedPair()
    {
        x = 0;
        y = 0;
    }

    public OrderedPair(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    //post: this OP is unchanged
//returns the distance between this OP and the origin
    public double getDistance()
    {
        return Math.sqrt(x*x+y*y);
    }

    //post: this OP is unchanged
//returns the slope between this OP and the origin
    public double getSlope()
    {
        return y/x;
    }

    //post: this OP is unchanged
//returns the distance between this OP and another point
    public double getDistance(OrderedPair point)
    {
        return Math.sqrt(Math.pow(this.x-point.x,2)+Math.pow(this.y-point.y,2));
    }

    //post: this OP is unchanged
//returns the slope between this OP and another point
    public double getSlope(OrderedPair point)
    {

        return (this.y-point.y)/(this.x-point.x);
    }

    //post: this OP is unchanged
//returns the midpoint between this OP and the origin
    public OrderedPair getMidpoint()
    {
        return new OrderedPair(x/2,y/2);
    }

    //post: this OP is unchanged
//returns the midpoint between this OP and the another point
    public OrderedPair getMidpoint(OrderedPair point)
    {
        return new OrderedPair((this.x-point.x)/2,(this.y-point.y)/2);
    }

    //post: same
//returns the inverse of this OP
    public OrderedPair getInverse()
    {
        return new OrderedPair(y,x);
    }

    //post: this OP, point1, and point2 are unchanged
//returns true if this OP is on the line defined by point1 and point2, false otherwise
    public boolean isOnLine(OrderedPair point1, OrderedPair point2)
    {
        return this.getSlope(point1)==this.getSlope(point2);
    }
    public double getAngle()
    {
        return Math.atan2(y , x);
    }
    public PolarCoordinate getPOlarCoordinate()
    {
        return  new PolarCoordinate(this.getDistance(),this.getAngle());
    }
    //post y=>-y
    public void reflectOverX()
    {
        y*=-1;
    }
    public void reflectOverY()
    {
        x*=-1;
    }
    public void reflectOverOrigin()
    {
        y*=-1;
        x*=-1;
    }
    public void translate(double xMove, double yMove)
    {
        x+=xMove;
        y+=yMove;
    }
    public void stretch (double multiplier)
    {
        x*=multiplier;
        y*=multiplier;
    }
    public  void rotate(double angle)
    {
        double theta=this.getAngle();
        theta+=angle;
        double r=this.getDistance();
        x=r*Math.cos(theta);
        y=r*Math.sin(theta);

    }
    public String toString()
    {
        return "("+x+","+y+")";

    }
    //pre o is an orderedPair
    @Override
    public boolean equals(Object o) {
        OrderedPair point=(OrderedPair)o;
        return this.x==point.x&&this.y==point.y;
    }
    public int compareTo(OrderedPair point)
    {
        double thisMag = this.getDistance();
        double pointMag=point.getDistance();
        if(thisMag>pointMag)
                return 1;
        else if (thisMag<pointMag) {

            return -1;

        }
        else return 0;
        //return Double.compare(thisMag,pointMag)
    }
}
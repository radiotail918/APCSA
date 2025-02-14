public class PolarCoordinate
{
    private double r;
    private double theta;

    public PolarCoordinate(double r, double theta)
    {
        this.r = r;
        this.theta = theta;
    }

    public PolarCoordinate(OrderedPair o)
    {
        r = o.getDistance();
        theta = o.getAngle();
    }

    //returns the OrderedPair that this PolarCoordinate represents
    public OrderedPair getOrderedPair()
    {
        double newX = r * Math.cos(theta);
        double newY = r * Math.sin(theta);
        return new OrderedPair(newX, newY);
    }

    public String toString()
    {
        return "(" + r + ", " + theta + ")";
    }
}







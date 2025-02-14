
public class RationalNumber implements Comparable<RationalNumber>
{
    private int p;
    private int q;

    //initializes instance data using parameters
    //throws IllegalArgumentException if @param q is 0
    //postcondition: if p/q represents a negative rational number, the - is stored in p
    //if p and q are both negative, this.p and this.q should be positie
    //p/q represents a reduced rational number
    public RationalNumber(int p, int q)
    {
        if(q == 0)
            throw new IllegalArgumentException();
        if(q < 0)
        {
            p *= -1;
            q *= -1;
        }
        this.p = p;
        this.q = q;
        this.reduce();
    }

    public int getP()
    {
        return p;
    }

    public int getQ()
    {
        return q;
    }

    //returns a RationalNumber that represents the sum of this RN and r
    //post: this RN and r are unchanged
    public RationalNumber add(RationalNumber r)
    {
        return new RationalNumber(this.q * r.p + this.p * r.q, this.q * r.q);
    }

    //returns a RationalNumber that represents the difference of this RN and r (this - r)
    //post: this RN is unchanged and r
    public RationalNumber subtract(RationalNumber r)
    {
        return new RationalNumber(this.p * r.q - this.q * r.p, this.q * r.q);
    }

    //returns a RationalNumber that represents the product of this RN and r
    //post: this RN is unchanged and r
    public RationalNumber multiply(RationalNumber r)
    {
        return new RationalNumber(r.p *this.p, this.q * r.q);
    }

    //returns a RationalNumber that represents the quotient of this RN and r (this / r)
    //post: this RN is unchanged
    public RationalNumber divide(RationalNumber r)
    {
        return this.multiply(r.getReciprocal());
    }

    //returns the quotient of p/q
    //post: this RN is unchanged
    public double toDecimal()
    {
        return (double)p / q;
    }

    //returns a RationalNumber that represents the reciprocal of this RN
    //post: this RN is unchanged
    public RationalNumber getReciprocal()
    {
        return new RationalNumber(q, p);
    }

    //pre: o is a RationalNumber
    //post: this RN is unchanged
    //returns true if the p's and q's are equal, false otherwise
    public boolean equals(Object o)
    {
        RationalNumber r = (RationalNumber)o;
        return this.p == r.p && this.q == r.q;
    }

    //post: this unchanged
    //returns a String that represents this RN
    //Examples: 0/7 --> 0
    //	6/1 --> 6
    // 2/3 --> 2/3
    public String toString()
    {
        if(p == 0)
            return 0 + "";
        if(q == 1)
            return p + "";
        return p + "/" + q;
    }


    //a function should be private if it is not intended for use by a client
    private void reduce()
    {
        int gcf = getGCF(Math.abs(p), q);
        p /= gcf;
        q /= gcf;
    }

    //precondition: num1 and num2 are non-negative
    public static int getGCF(int num1, int num2)
    {
        if(num1 == 0)
            return num2;
        while(num1 != num2)
        {
            if(num1 > num2)
                num1 -= num2;
            else	//num2 > num1
                num2 -= num1;
        }
        return num1;
    }

    //post: this and r are unchanged
    //returns - if this is less than r, + if this is greater than r, 0 if equal
    public int compareTo(RationalNumber r)
    {
        return Double.compare(this.toDecimal(), r.toDecimal());
    }

    //post: this unchanged
    //returns the absolute value of this RN
    public RationalNumber abs()
    {
        return new RationalNumber(Math.abs(p), q);
    }
}






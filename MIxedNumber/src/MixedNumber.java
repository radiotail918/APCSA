
public class MixedNumber implements Comparable<MixedNumber>
{
    //Composition: HAS-A - when one class has as its instance data an instance of another class
    private int whole;
    private RationalNumber frac;

    public MixedNumber(RationalNumber r)
    {
        whole = r.getP() / r.getQ();
        frac = new RationalNumber(r.getP() % r.getQ(), r.getQ());
    }

    public MixedNumber add(MixedNumber m)
    {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber sum = thisRat.add(mRat);
        return new MixedNumber(sum);

        //return new MixedNumber(this.toRational().add(m.toRational()));
    }

    public MixedNumber subtract(MixedNumber m)
    {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber diff = thisRat.subtract(mRat);
        return new MixedNumber(diff);
    }

    public MixedNumber multiply(MixedNumber m)
    {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber product = thisRat.multiply(mRat);
        return new MixedNumber(product);
    }

    public MixedNumber divide(MixedNumber m)
    {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber quotient = thisRat.divide(mRat);
        return new MixedNumber(quotient);
    }

    public double toDecimal()
    {
        return whole + frac.toDecimal();
    }

    public RationalNumber toRational()
    {
        int newP = frac.getQ() * whole + frac.getP();
        int newQ = frac.getQ();
        return new RationalNumber(newP, newQ);
    }

    public String toString()
    {
        if(whole == 0)
            return frac + "";
        if(frac.getP() == 0)
            return whole + "";

        return whole + " " + frac.abs();
    }

    public boolean equals(Object o)
    {
        MixedNumber m = (MixedNumber)o;
        return this.whole == m.whole && this.frac.equals(m.frac);
    }

    public int compareTo(MixedNumber m)
    {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        return thisRat.compareTo(mRat);
    }
}

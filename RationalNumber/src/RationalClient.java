import java.util.Arrays;

public class RationalClient
{
    public static void main(String[] args)
    {

        RationalNumber r1 = new RationalNumber(2, 8);
        RationalNumber r2 = new RationalNumber(9, -13);
        RationalNumber r3 = new RationalNumber(-4, -16);
        RationalNumber r4 = new RationalNumber(-25, 5);

        System.out.println(r1 + " " + r2 + " " + r3 + " " + r4);// 1/4 -9/13 1/4 -5
        System.out.println(r1.equals(r3));//true
        System.out.println(r1.equals(r4));//false
        System.out.println(r1.add(r4));//-19/4
        System.out.println(r3.divide(r4));//-1/20
        System.out.println(r3.multiply(r2)); //-9/52
        System.out.println(r2.subtract(r4)); //56/13
        System.out.println(r1.getReciprocal()); //4
        System.out.println(r1.toDecimal()); //.25

        RationalNumber[] rs = {r1, r2, r3, r4};
        System.out.println(Arrays.toString(rs));	//not sorted
        Arrays.sort(rs);
        System.out.println(Arrays.toString(rs));	//should be sorted (tests compareTo)
    }
}
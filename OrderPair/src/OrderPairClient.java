import java.security.spec.RSAOtherPrimeInfo;

public class OrderPairClient {
    public static void main(String[] args)
    {
        OrderedPair op1= new OrderedPair(1,1);
        OrderedPair op2=new OrderedPair(2,3);
        OrderedPair op3= new OrderedPair(3,5);
        System.out.println(op1.isOnLine(op2,op3));
        if(op1.equals(op2))
            System.out.println("equal");
        else
            System.out.println("not equal");
        op1.translate(1,2);
        if(op1.equals("hi"))

    }
}

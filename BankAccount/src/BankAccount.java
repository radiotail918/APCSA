import javax.print.attribute.standard.NumberOfDocuments;
import java.text.DecimalFormat;

public class BankAccount{
    private String accountNumber;
    private double balance;
    private double interestRate;
    private double recentTransaction;

    public static final double MAX_WITHDRAWAL=600;
    public static final double OVERDRAFT_FEE=35;

    public static int numberOfAccounts=0;
    public BankAccount()
    {
        numberOfAccounts++;
        balance=0;
        interestRate=0;
        recentTransaction=0;
        DecimalFormat account= new DecimalFormat("0000000000000000000");

    }
    public String toString()
    {
        DecimalFormat dollar = new DecimalFormat("$###,###.00");
        DecimalFormat percent= new DecimalFormat("0.00%");
        return "Account: "+accountNumber+"\nBalance"+dollar.format(balance)
                +"\nInterest Rate: "+percent.format(interestRate);
    }
}
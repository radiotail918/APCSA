import java.util.Scanner;

public class CellphoneInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input your cellphone storage (GB):");
        double storage = sc.nextDouble();

        System.out.println("Please input your cellphone's price ($):");
        double price = sc.nextDouble();

        System.out.println("Can your cellphone take pictures? (y/n):");
        String picture = sc.next();

        cellphone c = new cellphone(storage, picture.equals("y"), price);
        c.defineBrand();

        System.out.println(c);

        sc.close();
    }
}

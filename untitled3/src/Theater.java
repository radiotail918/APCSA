import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Theater
{
    boolean[][] seats=new boolean[15][30];
    double[] prices=new double[15];
    int seatTaken=0;
    double totalSale=0;
    public Theater(String fileName) throws FileNotFoundException
    {

        Scanner sc = new Scanner(new File(fileName));
        for(int i=0;i<15;i++)
        {
            prices[i]=sc.nextDouble();

        }
    }

    public int getSeatTaken() {
        return seatTaken;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void buySeat(int m, int n)
    {

        //Scanner sc= new Scanner(System.in);
        if(m>14||m<0||n<0||n>29)
        {
            System.out.println("Invalid, input again");
        } else if (seats[m][n]) {
            System.out.println("Seat already taken");

        } else
        {
            seats[m][n]=true;
            totalSale+=prices[m];
            seatTaken++;
        }

    }
    public double getTotalSold()
    {
        return totalSale;
    }
    public int getNumSeatsTaken() {
        return seatTaken;
    }
    public int getNumSeatsTakenInRow(int r)
    {
        int result=0;
        for(int i=0;i<30;i++)
        {
            if(seats[r][i])
            {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        Theater t = new Theater("C:\\Users\\zwei\\IdeaProjects\\untitled3\\src\\seats(1).txt");
        System.out.println(t);
        t.buySeat(0, 0);
        t.buySeat(14, 29);
        System.out.println(t);
        System.out.println(t.getNumSeatsTaken());
        System.out.println(t.getTotalSold());
        System.out.println(t.getNumSeatsTakenInRow(0));
        System.out.println(t.getNumSeatsTakenInRow(1));
    }

    public String toString() {
        String result=("\tA B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d \n");
        for(int i=0;i<seats.length;i++)
        {
            result+=i+1+"\t";
            for(int j=0;j<seats[0].length;j++)
            {

                if(!seats[i][j])
                {
                    result+="# ";
                }
                else
                {
                    result+="* ";

                }            }
            result+="\n";
        }

        return result;

    }
}

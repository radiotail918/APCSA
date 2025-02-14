import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheaterClient {
    public static void main(String[] args) throws FileNotFoundException {

        Theater t = new Theater("C:\\Users\\zwei\\IdeaProjects\\untitled3\\src\\seats(1).txt");
        Scanner sc = new Scanner(System.in);
        int menuSystem;

        while (true) {
            System.out.println("\n(1)\tPurchase tickets");
            System.out.println("(2)\tDisplay the total dollar value of all tickets sold");
            System.out.println("(3)\tDisplay the total number of tickets sold");
            System.out.println("(4)\tDisplay the number of seats available in each row");
            System.out.println("(5)\tDisplay the number of seats available in the entire auditorium");
            System.out.println("(6)\tDisplay the current seating chart");
            System.out.println("(7)\tExit the system");
            System.out.print("Enter your choice: ");

            menuSystem = sc.nextInt();
            String[] seats = new String[30];

            if (menuSystem == 1) {
{
                System.out.print("Input the row ");
                int r = sc.nextInt();
                while(true)
                    {
                        if(r==-1)
                        {
                            break;
                        }
                        else if(r<0||r>15)
                        {
                            System.out.println("invalid");
                            System.out.print("Input the row ");
                            r = sc.nextInt();
                        }
                        else{
                            break;
                        }
                    }

                while (r != -1) {
                    r--;

                    System.out.print("Input the column (letter)");
                    String chara = sc.next();
                    char ch = chara.charAt(0);
                    while (true) {
                        if (ch >= 65 && ch <= 90) {
                            int c = ch - 65;
                            t.buySeat(r, c);
                            break;
                        } else if (ch >= 97 && ch <= 100) {
                            int c = ch - 71;
                            t.buySeat(r, c);
                            break;
                        } else {
                            System.out.println("invalid");
                            System.out.print("Input the column (letter)");
                            chara = sc.next();
                            ch = chara.charAt(0);
                        }
                    }
                    System.out.print("Input the row ");
                    r = sc.nextInt();
                    while(true)
                    {
                        if(r==-1)
                        {
                            break;
                        }
                        else if(r<0||r>15)
                        {
                            System.out.println("invalid");
                            System.out.print("Input the row ");
                            r = sc.nextInt();
                        }
                        else{
                            break;
                        }
                    }

                }
    double temp = t.totalSale;
                System.out.println(temp+"$");
            }



            }
            else if (menuSystem == 2) {
                double totalSale=t.getTotalSale();
                System.out.println("Total sales" +totalSale);
            }
            else if (menuSystem == 3) {
                int seatsTaken = t.getNumSeatsTaken();
                System.out.println("Total tickets sold: " + seatsTaken);
            }
            else if (menuSystem == 4) {
                System.out.print("row number");
                int checkR = sc.nextInt();
                System.out.println("row: " + checkR + ": " + (int)(30-t.getNumSeatsTakenInRow(checkR-1)));
            }
            else if (menuSystem == 5) {
                System.out.println("total available" + (450 - t.getNumSeatsTaken()));
            }
            else if (menuSystem == 6) {
                System.out.println(t);
            }
            else if (menuSystem == 7) {
                System.out.println("exit");
                break;
            }
            else {
                System.out.println("Invalid");
            }
        }
    }
}




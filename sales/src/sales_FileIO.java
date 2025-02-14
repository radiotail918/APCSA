import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class sales_FileIO {
    public static void main (String[] args) throws FileNotFoundException
    {
// generateSales("sales","totalled");

        generateSales("C:\\Users\\zwei\\IdeaProjects\\sales\\src\\salesTest","totalled2");

        System.out.println("done");
    }

    public static void generateSales(String inFile, String outFile) throws FileNotFoundException
    {
        String month;
        double monthSales = 0;
        double maxMonthSales = 0;
        String maxMonth = "";
//connect a Scanner to inFile
        Scanner fileScan = new Scanner(new File(inFile));

//connect a printwriter to outFile
        PrintWriter pw = new PrintWriter(outFile);

        pw.println("Month          Total Sales");
        month = fileScan.next();
        while(fileScan.hasNextLine())
        {
            if(fileScan.hasNextDouble())
            {
                monthSales += fileScan.nextDouble();
            }
            else if (fileScan.hasNext())
            {

                String spaceCount="";
                for(int i =0;i<15-month.length();i++)
                {
                    spaceCount+=" ";
                }

                pw.printf( month + spaceCount + monthSales +"\n");
                if (monthSales>maxMonthSales)
                {
                    maxMonth = month;
                    maxMonthSales = monthSales;
                }
                monthSales = 0;
                month = fileScan.next();
            }
        }
        String spaceCount="";
        for(int i =0;i<15-month.length();i++)
        {
            spaceCount+=" ";
        }
        pw.printf( month +spaceCount+ monthSales +"\n");
        if (monthSales>maxMonthSales)
        {
            maxMonth = month;
            maxMonthSales = monthSales;
        }


        pw.print("\nThe month with the most sales was: " + maxMonth);
        pw.close();
    }
}
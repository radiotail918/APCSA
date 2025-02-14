import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Gradebook {
    private static Student[] students;
    private static int[] defaultGrades;

    public Gradebook(int numOfStudents, int numOfGrades, String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        students = new Student[numOfStudents];
        defaultGrades = new int[numOfGrades];

        String iniLine = sc.nextLine();
        int tabIndex = iniLine.indexOf("\t");
        String defaultGrade = iniLine.substring(tabIndex).trim();

        for (int x = 0; x < numOfGrades; x++) {
            int nextTab = defaultGrade.indexOf("\t");
            if (nextTab == -1) {
                defaultGrades[x] = Integer.parseInt(defaultGrade);
                defaultGrade = "";
            }
            else {
                defaultGrades[x] = Integer.parseInt(defaultGrade.substring(0, nextTab).trim());
                defaultGrade = defaultGrade.substring(nextTab).trim();
            }
        }

        for (int i = 0; i < numOfStudents; i++) {
            String line = sc.nextLine();
            int nameEndIndex = line.indexOf("\t");
            String studentName = line.substring(0, nameEndIndex).trim();
            String gradesData = line.substring(nameEndIndex).trim();

            double[] grades = new double[numOfGrades];
            for (int j = 0; j < numOfGrades; j++) {
                int nextTab = gradesData.indexOf("\t");
                if (nextTab == -1) {
                    grades[j] = Double.parseDouble(gradesData.trim());
                    gradesData = "";
                } else {
                    grades[j] = Double.parseDouble(gradesData.substring(0, nextTab).trim());
                    gradesData = gradesData.substring(nextTab).trim();
                }
            }
            students[i] = new Student(studentName, grades, Arrays.stream(defaultGrades).sum());
        }
    }
    public Student getStudent(int i)
    {
        return students[i];
    }
    public static double[] findAssignmentAverages()
    {
        double[] average= new double[defaultGrades.length];
        for(int i=0;i<defaultGrades.length;i++)
        {
            double sum=0;

            for(int x=0;x<students.length;x++)
            {
                sum+=students[x].getGrades()[i];
            }
            average[i]= (sum / defaultGrades[i]/ students.length) ;


        }
        return average;
    }
    public static double[] findStudentAverages()
    {
        double[] average = new double[students.length];
        for(int i=0;i< students.length;i++)
        {
            average[i]=students[i].getGrade();
        }
        return average;
    }
    public static Student findTopStudent()
    {
        Student topStudent=students[0];
        double highScore=findStudentAverages()[0];
        for(int i =1;i<students.length;i++)
        {
            double average = findStudentAverages()[i];
            if(average>highScore)
            {
                topStudent=students[i];
                highScore=average;
            }
        }
        return topStudent;

    }
    public static Student findStrugglingStudent()
    {
        Student strugglingStudent=students[0];
        double lowScore=findStudentAverages()[0];
        for(int i =1;i<students.length;i++)
        {
            double average = findStudentAverages()[i];
            if(average<lowScore)
            {
                strugglingStudent=students[i];
                lowScore=average;
            }
        }
        return strugglingStudent;

    }
    public static Student findTopStudentForAssignment(int assignmentNum)
    {
        Student topStudentForAssignment=students[0];
        double highScore=topStudentForAssignment.getGrades()[assignmentNum];
        for(int i=0;i<students.length;i++)
        {
            double score= students[i].getGrades()[assignmentNum];
            if(score>highScore)
            {
                topStudentForAssignment=students[i];
                highScore=score;
            }
        }
        return topStudentForAssignment;
    }
    public static Student findStrugglingStudentForAssignment(int assignmentNum)
    {
        Student lowStudentForAssignment=students[0];
        double lowScore=lowStudentForAssignment.getGrades()[assignmentNum];
        for(int i=0;i<students.length;i++)
        {
            double score= students[i].getGrades()[assignmentNum];
            if(score<lowScore)
            {
                lowStudentForAssignment=students[i];
                lowScore=score;
            }
        }
        return lowStudentForAssignment;

    }
    public String toString()
    {
        String result="";
        for(int i=0;i< students.length;i++)
        {
            result+=students[i].toString()+"\n";
        }
        return result;
    }


}  
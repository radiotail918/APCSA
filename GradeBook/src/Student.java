import java.util.Arrays;
public class Student
{
    private String name;
    private double[] scores;
    private double grade;
    public Student(String name, double[] assignmentScores, double totalPossiblePoint)
    {
        this.name=name;
        scores=new double[assignmentScores.length];
        for(int i=0;i<assignmentScores.length;i++)
        {
            scores[i]=assignmentScores[i];
        }
        double totalScore=0;
        for(double i:assignmentScores)
        {
            totalScore+=i;
        }
        grade=Math.round(totalScore/totalPossiblePoint*10000)/10000.0;
    }

    public double[] getGrades() {
        return scores;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return "Name "+ name+"\t\tGrade: "+(double)(grade*100)+"%";
    }

    public static void main(String[] args)
    {
        double[] grades = {10, 9.5, 10, 8};
        Student me = new Student("Prosser ", grades, 40);
        System.out.println(me);
        System.out.println(Arrays.toString(me.getGrades()));
        System.out.println(me.getGrade());
        System.out.println(me.getName());
    }
}
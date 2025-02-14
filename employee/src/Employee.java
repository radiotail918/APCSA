import javax.xml.crypto.Data;
import java.util.Date;
public class Employee
{
    private String name;
    private String position;
    private double salary;
    private Date birthdate;
    public Employee()
    {
        name = "";
        position ="";
        salary=0;
        birthdate = new Date();
    }
    public Employee(String n, double salary)
    {
        this.name=name;
        this.salary=salary;
        position="";
        birthdate=new Date();

    }
    public String getPosition()
    {
        return position;
    }
    public void setPosition(String position){
        this.position=position;
    }
    public String getName()
    {
        return name;

    }
    public void setName(String name)
    {
        this.name=name;

    }
    public double getSalary()
    {
        return salary;

    }
    public void setSalary(double salary)
    {
        this.salary=salary;

    }
    public Date getBirthdate()
    {
        return birthdate;
    }
    public void setBirthdate(int year,int month, int day)
    {
        birthdate= new Date(year,month,day);
    }
}

/*
class - a blueprint for how an Object of this type will work

1. attributes (characteristics/instance data)
2. constructor(s) - special methods that allow the user to instantiate (create)
	an object of this type
3. other functions - accessors (getters) and mutators (setters)

ATTRIBUTES
private - accessible directly (using the dot operator) only in this class
protected - accessible directly inside this class, in any direct subclasses of this class
	and in any class in the same package as this class
public - accessible directly from any class

instance data should be private (unless you have a good reason to make it protected)
instance data should never be public (only class constants should be public)

CONSTRUCTORS
the job of a constructor is to initialize instance data

if you don't define any constructors, the JRE will provide the default constructor
as soon as you define a constructor, the default is no longer provided

default constructor - empty parameter list - initializes instance data to default values

OTHER FUNCTIONS
accessors - functions that allow the client to access the value(s) of instance data
mutators - functions that allow the client to change the value(s) of instance data
	but on our terms
*/

import java.util.*;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();  //abstract method to calculate salary

    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+",salary="+calculateSalary()+"]";
    }

}

class FullTimeEmployee extends Employee{
    private double monthySalary;

    public FullTimeEmployee(String name, int id, double monthySalary){
        super(name,id); //super keyword to call the parent class constructor to use name,id var
        this.monthySalary=monthySalary;
    }

    @Override

    public double calculateSalary(){
        return monthySalary;
    }

}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override

    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee Remove=null;
        for(Employee employee: employeeList){
            if(employee.getId()==id){
                Remove=employee;
                break;
            }
        }
        if(Remove!=null){
            employeeList.remove(Remove);
        }
    }

    public void displayEmployee(){
        for(Employee emp: employeeList){
            System.out.println(emp);
        }
    }
}



public class Main{
    public static void main(String[] args) {
        System.out.print("Radhe Radhe");
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("ashish",77,28000);
        PartTimeEmployee emp2=new PartTimeEmployee("Selu", 55, 8, 132);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee details: ");
        payrollSystem.displayEmployee();

        System.out.println("Removing an Employee: ");
        payrollSystem.removeEmployee(55);
        
        System.out.println("Remaining Employee");
        payrollSystem.displayEmployee();
    }
}
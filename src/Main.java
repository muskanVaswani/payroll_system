import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calSal();

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+", salary="+calSal()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
public FullTimeEmployee(String name, int id, double monthlySalary){
    super(name,id);
    this.monthlySalary = monthlySalary;
}
    @Override
    public double calSal() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
        @Override
        public double calSal(){
            return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeelist;

    public PayrollSystem(){
        employeelist = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeelist.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeelist){
            if(employee.getId()==id){
//                employeeToRemove = employee;
//                break;
            }
            if(employeeToRemove!=null){
                employeelist.remove(employeeToRemove);
            }

        }

    }
    public void displayEmployees(){
        for(Employee employee: employeelist){
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas" , 1,70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("muskan",2,40,40);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("initial employee details: ");
        payrollSystem.displayEmployees();

        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);

        System.out.println("Remaining Employees Details: ");
        payrollSystem.displayEmployees();
            }
}
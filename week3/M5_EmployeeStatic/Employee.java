/**
 * M5. Instance vs Static: Splitting an Employee Class Correctly
 *
 * empName and salary are per-object (instance) state. companyName and
 * employeeCount belong to the class itself (static) - one shared copy for
 * every employee. printCompanyInfo() is static and touches only static fields.
 */
public class Employee {
    private String empName;
    private double salary;

    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    /** Prints only class-level information; cannot reference instance fields. */
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new Employee("Divya", 65000);
        new Employee("Arjun", 40000);
        new Employee("Priya", 52000);

        Employee.printCompanyInfo();
    }
}

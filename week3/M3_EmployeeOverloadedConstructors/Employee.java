/**
 * M3. Overloaded Constructors for an Employee
 *
 * The intern constructor chains into the permanent-employee constructor with
 * this(...), so the field-setup logic is written exactly once.
 */
public class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    /** Permanent employee: salary known from day one. */
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    /** Intern: no salary structure yet. Chains to the 3-arg constructor. */
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}

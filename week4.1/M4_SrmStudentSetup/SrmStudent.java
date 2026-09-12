/**
 * M4. One-Time College Setup, Many Students
 *
 * collegeName and academicYear are set exactly once through a static block,
 * no matter how many SrmStudent objects get created in the batch loop.
 */
public class SrmStudent {
    static String collegeName;
    static String academicYear;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2025-2026";
        System.out.println("College info loaded");
    }

    private String name;

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for (String name : names) {
            new SrmStudent(name);
        }
    }
}

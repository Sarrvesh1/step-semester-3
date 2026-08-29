/**
 * M4. Reference Copies and a Shared Exam Hall Ticket
 *
 * Shows that assigning one object variable to another copies the reference,
 * not the object: both names point at the same HallTicket, while a separately
 * constructed ticket with identical values is still a different object (==).
 */
public class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;          // same object, second name
        copy.seatNumber = 45;             // change seen through both names

        HallTicket separate = new HallTicket("Priya", 45); // identical values, new object

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}

/**
 * P1. Movie Ticket Field Visibility Checker (continued)
 *
 * Real access level chosen per field, based on who genuinely needs to reach
 * it: seatNumber is private (only this class ever touches the raw seat -
 * everyone else goes through getSeatNumber()); screenId is default/package-
 * private (only classes inside the booking package, like screen management,
 * need it); ticketPrice is protected so PremiumMovieTicket - a subclass in a
 * different package - can read it directly; movieTitle is public since it's
 * displayed everywhere.
 */
public class MovieTicket {
    private int seatNumber;
    int screenId;
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket(int seatNumber, int screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void printDetails() {
        System.out.println(movieTitle + " | Seat " + seatNumber + " | Screen " + screenId + " | Rs " + ticketPrice);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket(12, 3, 250.0, "Interstellar");
        ticket.printDetails();
    }
}

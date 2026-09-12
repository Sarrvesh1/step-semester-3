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

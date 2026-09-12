/**
 * P3. Book Copy Circulation Guard
 *
 * copiesTotal and copiesAvailable are private with no way to set
 * copiesAvailable directly from outside; checkOut() silently rejects a call
 * with nothing available, and checkIn() silently rejects a call once the
 * inventory is already back to full capacity - the count never leaves
 * [0, copiesTotal].
 */
public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {
        BookInventory b = new BookInventory(3);
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();
        System.out.println(b.getCopiesAvailable());

        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn();
        System.out.println(b.getCopiesAvailable());
    }
}

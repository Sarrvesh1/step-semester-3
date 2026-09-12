/**
 * A5. instanceof Inside a Loop - Canteen Closing-Time Payment Dispatch
 *
 * processTransaction() uses instanceof to tell a CardPayment apart from a
 * plain Payment, charging the 2% processing fee only where it applies, and
 * keeps a running total of everything actually collected.
 */
public class Payment {
    private double totalCollected = 0;

    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }

    void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            totalCollected += cardPayment.payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
            totalCollected += amount;
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(), new Payment(), new CardPayment(), new Payment(), new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        Payment processor = new Payment();
        for (int i = 0; i < payments.length; i++) {
            processor.processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + processor.totalCollected);
    }
}

class CardPayment extends Payment {
    double payWithProcessingFee(double amount) {
        double totalCharged = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + totalCharged);
        return totalCharged;
    }
}

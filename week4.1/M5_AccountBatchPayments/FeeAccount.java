/**
 * M5. Account Batch Payments
 *
 * processPayment() uses instanceof to dispatch between a plain FeeAccount and
 * a HostelFeeAccount, and keeps a running count of each type processed.
 */
public class FeeAccount {
    void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    private int hostelCount = 0;
    private int dayScholarCount = 0;

    void printSummary() {
        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        FeeAccount processor = new FeeAccount();
        for (FeeAccount account : accounts) {
            processor.processPayment(account, 60000);
        }
        processor.printSummary();
    }
}

class HostelFeeAccount extends FeeAccount {
}

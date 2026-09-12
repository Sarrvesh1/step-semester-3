/**
 * M3. Late Fees - Skip the On-Time Accounts
 *
 * calculateLateFee() and printSummary() are final so the fee formula can
 * never be quietly changed by a subclass. Accounts with daysLate <= 0 are
 * skipped entirely rather than charged a fee of Rs 0.
 */
public class LateFeeAccount {
    private String regNo;
    private double totalFee;

    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * daysLate * 0.01;
    }

    final void printSummary(int daysLate) {
        System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + calculateLateFee(daysLate));
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        LateFeeAccount[] accounts = new LateFeeAccount[regNos.length];
        for (int i = 0; i < regNos.length; i++) {
            accounts[i] = new LateFeeAccount(regNos[i], totalFees[i]);
        }

        for (int i = 0; i < accounts.length; i++) {
            if (daysLate[i] > 0) {
                accounts[i].printSummary(daysLate[i]);
            } else {
                System.out.println(regNos[i] + " - On time, no late fee");
            }
        }
    }
}

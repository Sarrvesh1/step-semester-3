/**
 * M2. Encapsulated Payroll Account
 *
 * basicSalary and bonus are private with no setters. The only way to change
 * them is through the validated methods creditBonus / deductTax, and the only
 * way to read the result is the read-only getNetSalary().
 */
public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: negative opening salary given, starting at 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    /** Adds a positive bonus; rejects amounts <= 0. */
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0.");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    /** Reduces basicSalary by the given percentage; rejects percent outside 0-100. */
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100.");
            return;
        }
        basicSalary -= basicSalary * (percent / 100.0);
        System.out.println("Tax deducted: " + formatPercent(percent) + "%");
    }

    /** Read-only access to the net salary. */
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    private static String formatPercent(double percent) {
        if (percent == Math.rint(percent)) {
            return Long.toString((long) percent);
        }
        return Double.toString(percent);
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}

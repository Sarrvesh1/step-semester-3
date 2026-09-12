/**
 * P4. MovieBookingProfile JavaBean & OTP Property
 *
 * A public no-arg constructor plus a name-only convenience constructor that
 * chains via this(...). Every ordinary field gets a JavaBean-compliant
 * getX()/setX() pair (isConfirmed(), not getConfirmed()). otp is settable via
 * setOtp() but has no getter anywhere on the class - a true write-only
 * property.
 */
public class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static void main(String[] args) {
        System.out.println(new MovieBookingProfile("Rahul Dev").getName());

        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());

        p.setOtp("4471");
    }
}

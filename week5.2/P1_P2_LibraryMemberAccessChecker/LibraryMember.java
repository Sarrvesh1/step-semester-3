public class LibraryMember {
    private String membershipPin;
    String branchCode;
    double finesOwed;
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public void printProfile() {
        System.out.println(displayName + " | Branch " + branchCode + " | Fines: Rs " + finesOwed);
    }

    public static void main(String[] args) {
        LibraryMember member = new LibraryMember("7719", "BR-04", 45.0, "Priya Nair");
        member.printProfile();
    }
}

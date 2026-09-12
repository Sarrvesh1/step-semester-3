/**
 * P4. LibraryMember JavaBean & Security Answer Property
 *
 * A public no-arg constructor plus JavaBean-compliant getX()/setX() pairs
 * (isPremiumMember(), not getPremiumMember()). membershipId is write-once:
 * setMembershipId() genuinely exists (the framework requires it) but only
 * the first call ever takes effect. securityAnswer is stored only as a
 * one-way transformed value, with no getter anywhere on the class.
 */
public class LibraryMember {
    private String membershipId;
    private boolean membershipIdSet;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    public LibraryMember() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (!membershipIdSet) {
            this.membershipId = id;
            this.membershipIdSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswerHash = oneWayHash(answer);
    }

    private static String oneWayHash(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            result = result * 31 + value.charAt(i);
        }
        return Integer.toHexString(result);
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());

        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());

        System.out.println(m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
    }
}

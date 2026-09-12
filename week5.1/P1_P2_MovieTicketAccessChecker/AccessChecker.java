/**
 * P1. Movie Ticket Field Visibility Checker
 * P2. Subclass Ticket Access
 *
 * classifyAccess() decides ALLOWED/DENIED purely from Java's real visibility
 * rules for all five accessorContext values: private only ever allows
 * SAME_CLASS; default additionally allows SAME_PACKAGE; protected further
 * allows a subclass in a different package - but only when reached through a
 * variable declared as the subclass's own type (SUBCLASS_DIFFERENT_PACKAGE_
 * OWN_TYPE), never through one declared as the parent type (Java resolves
 * protected access by the reference's compile-time type, not the object's
 * runtime type); public is always allowed.
 */
public class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "public":
                return "ALLOWED";
            case "protected":
                return (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                    ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            default:
                throw new IllegalArgumentException("Unknown fieldModifier: " + fieldModifier);
        }
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;
        for (String[] attempt : attempts) {
            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(new String[][]{
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        }));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}

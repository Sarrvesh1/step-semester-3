/**
 * P1. Membership Field Reach Checker
 * P2. Reference Desk Subclass Reach
 *
 * classifyAccess() applies the real Java visibility rules across all five
 * accessorContext values (same rule table as the mentor MovieTicket set):
 * private only allows SAME_CLASS; default adds SAME_PACKAGE; protected
 * further allows a subclass in a different package, but only through a
 * variable declared as the subclass's own type, never through one declared
 * as the parent type; public is always allowed.
 *
 * summarizeByModifier() groups a batch's results per modifier - including a
 * modifier with zero attempts - rather than producing one flat total.
 *
 * firstDeniedAttempt() scans strictly in order and stops at the first denial
 * it finds, instead of building a full result set and searching it after.
 */
public class AccessChecker {
    private static final String[] MODIFIERS = {"private", "default", "protected", "public"};

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

    static String summarizeByModifier(String[][] attempts) {
        StringBuilder result = new StringBuilder();
        for (String modifier : MODIFIERS) {
            int allowed = 0;
            int denied = 0;
            for (String[] attempt : attempts) {
                if (attempt[0].equals(modifier)) {
                    if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }
            if (result.length() > 0) {
                result.append(" | ");
            }
            result.append(modifier).append(": ").append(allowed).append(" allowed / ").append(denied).append(" denied");
        }
        return result.toString();
    }

    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            if (classifyAccess(modifier, context).equals("DENIED")) {
                return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeByModifier(new String[][]{
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        }));

        System.out.println(firstDeniedAttempt(new String[][]{
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        }));
        System.out.println(firstDeniedAttempt(new String[][]{
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        }));
    }
}

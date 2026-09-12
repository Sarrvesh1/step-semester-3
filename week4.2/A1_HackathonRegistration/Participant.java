/**
 * A1. Overloaded Constructors for Hackathon Registration
 *
 * A solo entrant gets a placeholder team name by chaining, via this(...),
 * into the constructor used for participants who already have a team.
 */
public class Participant {
    private String name;
    private String teamName;
    private boolean registered;

    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        for (int i = 0; i < names.length; i++) {
            Participant participant = teamNames[i].isEmpty()
                ? new Participant(names[i])
                : new Participant(names[i], teamNames[i]);
            participant.printStatus();
        }
    }
}

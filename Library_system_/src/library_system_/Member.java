package library_system_;

/**
 * Represents a library member.
 */
public class Member {

    protected int memberId;
    protected String name;

    /**
     * Constructor to create a Member.
     */
    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters and Setters

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Calculates late fee for the member.
     * This method can be overridden by subclasses.
     */
    public double calculateFee(int lateDays) {
        return lateDays * 2.0; // default fee per day
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId +
               ", Name: " + name;
    }
}

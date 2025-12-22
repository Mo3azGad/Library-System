package library_system_;

/**
 * Represents a student member in the library.
 * Students have discounted late fees.
 */
public class StudentMember extends Member {

    /**
     * Constructor to create a StudentMember.
     */
    public StudentMember(int memberId, String name) {
        super(memberId, name);
    }

    /**
     * Calculates late fee for student members.
     * Overrides the base Member fee calculation.
     */
    @Override
    public double calculateFee(int lateDays) {
        return lateDays * 1.0; // students pay less
    }

    @Override
    public String toString() {
        return "Student Member -> ID: " + memberId +
               ", Name: " + name;
    }
}

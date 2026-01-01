package library_system_;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Member and StudentMember classes.
 */
public class MemberTest {

    @Test
    public void testMemberFeeCalculation() {
        Member member = new Member(1, "Ahmed");

        double fee = member.calculateFee(3); // 3 late days
        assertEquals(6.0, fee);
    }

    @Test
    public void testStudentMemberFeeCalculation() {
        Member student = new StudentMember(2, "Sara");

        double fee = student.calculateFee(3); // polymorphism
        assertEquals(3.0, fee);
    }

    @Test
    public void testPolymorphismBehavior() {
        Member member = new StudentMember(3, "Omar");

        // even though reference is Member, method of StudentMember is called
        assertEquals(2.0, member.calculateFee(2));
    }
}

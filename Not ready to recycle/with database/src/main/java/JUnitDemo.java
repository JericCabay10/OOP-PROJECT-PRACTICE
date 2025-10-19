import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import studentmanagementystem.Student;

public class JUnitDemo {
	
	@Test
	void testId() {
		Student student = new Student("123456", "jhon", 26, "6");
		// Expected: valid, so _id should be set
        assertEquals("1234", student.getId(), "ID with length 6 should be accepted");
	}
}

package drill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.rice.autograder.annotations.Grade;
import edu.rice.autograder.annotations.GradeTopic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("tests for Bar")
@GradeTopic(project = "Drill Template", topic = "Things")
class BarTest {
  @Test
  @DisplayName("it works")
  @Grade(project = "Drill Template", topic = "Things", points = 1.0)
  void test() {
    assertEquals("foo", new Foo().ping(2));
  }
}

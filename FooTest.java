package drill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.rice.autograder.annotations.Grade;
import edu.rice.autograder.annotations.GradeTopic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("tests for Foo")
@GradeTopic(project = "Drill Template", topic = "Strings")
class FooTest {
  @Test
  @DisplayName("it works")
  @Grade(project = "Drill Template", topic = "Strings", points = 1.0)
  void test() {
    assertEquals("foo", new Foo().ping());
  }
}

package drill.proof.of.concept;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.rice.autograder.annotations.Grade;
import edu.rice.autograder.annotations.GradeTopic;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

@GradeTopic(project = "Solving The Problem", topic = "mandatory")
class AppTest {

  @Test
  @Grade(project = "Solving The Problem", topic = "mandatory", points = 1)
  void appHasAGreeting() {
    App classUnderTest = new App();
    assertEquals(classUnderTest.getGreeting(), "app should have a greeting");
  }

  @TestFactory
  @Grade(project = "Solving The Problem", topic = "mandatory", points = 1, maxPoints = 3)
  Stream<DynamicTest> dynamicTestsFromCollection() {
    List<String> greetings = Arrays.asList("foo", "bar", "baz");
    return greetings.stream()
        .map(
            greeting ->
                DynamicTest.dynamicTest(
                    "greeting " + greeting,
                    () -> {
                      assertEquals(greeting, new App(greeting).getGreeting());
                    }));
  }
}

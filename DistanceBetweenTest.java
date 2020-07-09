package drill;

import static org.assertj.core.api.Assertions.assertThat;

import edu.rice.autograder.annotations.Grade;
import edu.rice.autograder.annotations.GradeTopic;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

@GradeTopic(project = "Letter Gap Counter Drill", topic = "distanceBetween")
class DistanceBetweenTest {

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "distanceBetween", points = 1, maxPoints = 1)
  @DisplayName("distance between same letter")
  List<DynamicTest> same_letter() {
    final String EXPECTED_RESULT = "there are no letters";
    return List.of(
        testFor('a', 'a', EXPECTED_RESULT),
        testFor('F', 'F', EXPECTED_RESULT),
        testFor('z', 'z', EXPECTED_RESULT),
        testFor('*', '*', EXPECTED_RESULT));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "distanceBetween", points = 1, maxPoints = 1)
  @DisplayName("distance between adjacent letters")
  List<DynamicTest> adjacent_letters() {
    final String EXPECTED_RESULT = "there are no letters";
    return List.of(
        testFor('a', 'b', EXPECTED_RESULT),
        testFor('@', 'A', EXPECTED_RESULT),
        testFor('4', '3', EXPECTED_RESULT),
        testFor('t', 's', EXPECTED_RESULT));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "distanceBetween", points = 1, maxPoints = 1)
  @DisplayName("one letter between")
  List<DynamicTest> one_letter_between() {
    final String EXPECTED_RESULT = "there is 1 letter";
    return List.of(
        testFor('V', 'X', EXPECTED_RESULT),
        testFor(':', '<', EXPECTED_RESULT),
        testFor('3', '1', EXPECTED_RESULT),
        testFor('f', 'd', EXPECTED_RESULT));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "distanceBetween", points = 1, maxPoints = 1)
  @DisplayName("two or more letters between")
  List<DynamicTest> two_or_more_letters_between() {

    return List.of(
        testFor('D', 'G', "there are 2 letters"),
        testFor('m', 'e', "there are 7 letters"),
        testFor('0', '9', "there are 8 letters"),
        testFor(' ', '~', "there are 93 letters"));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "distanceBetween", points = 1, maxPoints = 1)
  @DisplayName("if both characters are alphabetic, then case is ignored")
  List<DynamicTest> if_alphabetic_case_ignored() {

    return List.of(
        testFor('a', 'A', "there are no letters"),
        testFor('d', 'B', "there is 1 letter"),
        testFor('F', 'g', "there are no letters"),
        testFor('a', 'Z', "there are 24 letters"));
  }

  @Test
  @DisplayName("hack for coverage on utility classes")
  void code_coverage_hack() {
    new DrillUtils();
  }

  DynamicTest testFor(char firstChar, char secondChar, String expected) {
    String display =
        String.format(
            "distanceBetween(%s, %s) should return \"%s\"", firstChar, secondChar, expected);
    return DynamicTest.dynamicTest(
        display,
        () -> {
          assertThat(DrillUtils.distanceBetween(firstChar, secondChar)).isEqualTo(expected);
        });
  }
}

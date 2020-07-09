package drill;

import static org.assertj.core.api.Assertions.assertThat;

import edu.rice.autograder.annotations.Grade;
import edu.rice.autograder.annotations.GradeTopic;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

@GradeTopic(project = "Letter Gap Counter Drill", topic = "orderedLetters")
class OrderedLettersTest {

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "orderedLetters", points = 1, maxPoints = 1)
  @DisplayName("already ordered")
  List<DynamicTest> already_ordered() {
    return List.of(
        testFor('a', 'a', "a and a"),
        testFor('F', 'X', "F and X"),
        testFor('2', '8', "2 and 8"),
        testFor('$', '(', "$ and ("));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "orderedLetters", points = 1, maxPoints = 1)
  @DisplayName("reverse ordered")
  List<DynamicTest> reverse_ordered() {
    return List.of(
        testFor('f', 'e', "e and f"),
        testFor(']', '[', "[ and ]"),
        testFor('9', '0', "0 and 9"),
        testFor('M', 'C', "C and M"));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "orderedLetters", points = 1, maxPoints = 1)
  @DisplayName("same letter")
  List<DynamicTest> same_letter() {
    return List.of(
        testFor('V', 'V', "V and V"),
        testFor('<', '<', "< and <"),
        testFor('8', '8', "8 and 8"),
        testFor('t', 't', "t and t"));
  }

  @TestFactory
  @Grade(project = "Letter Gap Counter Drill", topic = "orderedLetters", points = 1, maxPoints = 1)
  @DisplayName("case of letters remains untouched")
  List<DynamicTest> case_doesnt_change() {
    return List.of(
        testFor('b', 'X', "b and X"),
        testFor('X', 'b', "b and X"),
        testFor('r', 'E', "E and r"),
        testFor('E', 'r', "E and r"));
  }

  @Test
  @DisplayName("hack for coverage on utility classes")
  void code_coverage_hack() {
    new DrillUtils();
  }

  DynamicTest testFor(char firstChar, char secondChar, String expected) {
    String display =
        String.format(
            "orderedLetters(%s, %s) should return \"%s\"", firstChar, secondChar, expected);
    return DynamicTest.dynamicTest(
        display,
        () -> {
          assertThat(DrillUtils.orderedLetters(firstChar, secondChar)).isEqualTo(expected);
        });
  }
}

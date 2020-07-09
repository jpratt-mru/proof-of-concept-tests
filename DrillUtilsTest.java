package drill;

import static org.assertj.core.api.Assertions.assertThat;

import edu.rice.autograder.annotations.Grade;
import edu.rice.autograder.annotations.GradeTopic;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

@GradeTopic(project = "accent maker drill", topic = "substrings")
class DrillUtilsTest {

  @TestFactory
  @Grade(project = "accent maker drill", topic = "substrings", points = 1, maxPoints = 1)
  @DisplayName("accent on first syllable")
  List<DynamicTest> starts() {
    return List.of(
        testFor(1, 3, "refuse", "REFuse"),
        testFor(1, 2, "object", "OBject"),
        testFor(1, 5, "interchange", "INTERchange"));
  }

  @TestFactory
  @Grade(project = "accent maker drill", topic = "substrings", points = 1, maxPoints = 1)
  @DisplayName("accent on end syllable")
  List<DynamicTest> ends() {
    return List.of(
        testFor(3, 6, "refuse", "reFUSE"),
        testFor(3, 6, "object", "obJECT"),
        testFor(4, 6, "shazam", "shaZAM"));
  }

  @TestFactory
  @Grade(project = "accent maker drill", topic = "substrings", points = 1, maxPoints = 1)
  @DisplayName("accents somewhere in middle")
  List<DynamicTest> middle() {
    return List.of(
        testFor(3, 4, "invalid", "inVAlid"),
        testFor(3, 5, "attribute", "atTRIbute"),
        testFor(4, 6, "particular", "parTICular"));
  }

  @TestFactory
  @Grade(project = "accent maker drill", topic = "substrings", points = 1, maxPoints = 1)
  @DisplayName("one-letter accents")
  List<DynamicTest> one_letter_accents() {
    return List.of(
        testFor(1, 1, "abba", "Abba"),
        testFor(4, 4, "banality", "banAlity"),
        testFor(8, 8, "spottify", "spottifY"));
  }

  @TestFactory
  @Grade(project = "accent maker drill", topic = "substrings", points = 1, maxPoints = 1)
  @DisplayName("only accent should be uppercase")
  List<DynamicTest> watch_that_casing() {
    return List.of(
        testFor(1, 2, "inSULT", "INsult"),
        testFor(4, 7, "prESent", "preSENT"),
        testFor(4, 6, "SegmenteD", "segMENted"));
  }

  @Test
  @DisplayName("hack for coverage on utility classes")
  void code_coverage_hack() {
    new DrillUtils();
  }

  DynamicTest testFor(
      int positionOfFirstLetter, int positionOfSecondLetter, String startingWord, String expected) {
    String display =
        String.format(
            "accentedWord(%s, %d, %d) should be %s",
            startingWord, positionOfFirstLetter, positionOfSecondLetter, expected);
    return DynamicTest.dynamicTest(
        display,
        () -> {
          assertThat(
                  DrillUtils.accentedWord(
                      startingWord, positionOfFirstLetter, positionOfSecondLetter))
              .isEqualTo(expected);
        });
  }
}

package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalStudents.ALEX;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TutorialContainsKeywordsPredicateTest {
    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("TG01");
        List<String> secondPredicateKeywordList = Arrays.asList("TG01", "TG02");

        TutorialContainsKeywordsPredicate firstPredicate =
                new TutorialContainsKeywordsPredicate(firstPredicateKeywordList);
        TutorialContainsKeywordsPredicate secondPredicate =
                new TutorialContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        TutorialContainsKeywordsPredicate firstPredicateCopy =
                new TutorialContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different values -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_tutorialContainsKeywords_returnsTrue() {
        // One keyword
        TutorialContainsKeywordsPredicate predicate =
                new TutorialContainsKeywordsPredicate(Collections.singletonList("TG01"));
        assertTrue(predicate.test(ALEX));

        // Multiple keywords
        predicate = new TutorialContainsKeywordsPredicate(Arrays.asList("TG01", "T02"));
        assertTrue(predicate.test(ALEX));
    }

    @Test
    public void test_tutorialDoesNotContainKeywords_returnsFalse() {
        // No keyword
        TutorialContainsKeywordsPredicate predicate = new TutorialContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(ALEX));

        // One keyword that does not exist
        predicate = new TutorialContainsKeywordsPredicate(Collections.singletonList("A0123"));
        assertFalse(predicate.test(ALEX));
    }
}

package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalStudents.ALEX;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StudentIdContainsKeywordsPredicateTest {
    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("e0123456");
        List<String> secondPredicateKeywordList = Arrays.asList("e0123456", "e0321456");

        StudentIdContainsKeywordsPredicate firstPredicate =
                new StudentIdContainsKeywordsPredicate(firstPredicateKeywordList);
        StudentIdContainsKeywordsPredicate secondPredicate =
                new StudentIdContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        StudentIdContainsKeywordsPredicate firstPredicateCopy =
                new StudentIdContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different values -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_studentIdContainsKeywords_returnsTrue() {
        // One keyword
        StudentIdContainsKeywordsPredicate predicate =
                new StudentIdContainsKeywordsPredicate(Collections.singletonList("e0543216"));
        assertTrue(predicate.test(ALEX));

        // Multiple keywords
        predicate = new StudentIdContainsKeywordsPredicate(Arrays.asList("e0543", "e0123456"));
        assertTrue(predicate.test(ALEX));
    }

    @Test
    public void test_studentIdDoesNotContainKeywords_returnsFalse() {
        // No keyword
        StudentIdContainsKeywordsPredicate predicate = new StudentIdContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(ALEX));

        // One keyword that does not exist
        predicate = new StudentIdContainsKeywordsPredicate(Collections.singletonList("e11111"));
        assertFalse(predicate.test(ALEX));
    }
}

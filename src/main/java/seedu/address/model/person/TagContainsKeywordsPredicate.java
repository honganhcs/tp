package seedu.address.model.person;

import static seedu.address.model.tag.Tag.NULL_INPUT;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Tag} matches any of the keywords given.
 */
public class TagContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public TagContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        // check for NULL_INPUT
        if (keywords.size() == 1 && keywords.get(0).equals(NULL_INPUT)) {
            return false;
        }
        return keywords.stream()
                .anyMatch(keyword -> person.getTags()
                                            .stream()
                                            .anyMatch(tag -> StringUtil
                                                    .containsPartialWordIgnoreCase(tag.tagName, keyword)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((TagContainsKeywordsPredicate) other).keywords)); // state check
    }
}

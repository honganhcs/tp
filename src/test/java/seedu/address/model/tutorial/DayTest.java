package seedu.address.model.tutorial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DayTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Day(null));
    }

    @Test
    public void constructor_invalidDay_throwsIllegalArgumentException() {
        String invalidDay = "";
        assertThrows(IllegalArgumentException.class, () -> new Day(invalidDay));
    }

    @Test
    public void equals() {
        Day sunday = new Day("sun");
        Day sundayCopy = new Day("Sunday");
        Day saturday = new Day("Sat");

        // same object -> returns true
        assertTrue(sunday.equals(sunday));

        // same values -> returns true
        assertTrue(sunday.equals(sundayCopy));

        // different types -> returns false
        assertFalse(sunday.equals(1));

        // null -> returns false
        assertFalse(sunday.equals(null));

        // different day -> returns false
        assertFalse(sunday.equals(saturday));
    }

    @Test
    public void isValidDay() {
        // null days
        assertThrows(NullPointerException.class, () -> Day.isValidDay(null));

        // invalid days
        assertFalse(Day.isValidDay("")); // empty string
        assertFalse(Day.isValidDay(" ")); // spaces only
        assertFalse(Day.isValidDay("computer")); // random word

        // valid days
        assertTrue(Day.isValidDay("Mon")); // Three letters with first letter upper case
        assertTrue(Day.isValidDay("Wednesday")); // Full spelling with first letter upper case
        assertTrue(Day.isValidDay("FRI")); // Three uppercase letters
        assertTrue(Day.isValidDay("tue")); // Three lowercase letters
    }
}

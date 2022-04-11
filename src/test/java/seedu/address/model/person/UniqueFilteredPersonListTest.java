package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalStudents.ALEX;
import static seedu.address.testutil.TypicalStudents.BERNARD;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.exceptions.DuplicatePersonException;

public class UniqueFilteredPersonListTest {

    @Test
    public void equal() {
        UniqueFilteredPersonsList uniqueFilteredPersonsList = new UniqueFilteredPersonsList();
        UniqueFilteredPersonsList uniqueFilteredPersonsListCopy = new UniqueFilteredPersonsList();
        uniqueFilteredPersonsList.add(ALEX);
        uniqueFilteredPersonsListCopy.add(ALEX);

        // same object -> equal
        assertTrue(uniqueFilteredPersonsList.equals(uniqueFilteredPersonsList));

        // same values -> equal
        assertTrue(uniqueFilteredPersonsList.equals(uniqueFilteredPersonsListCopy));

        // different values -> not equal
        uniqueFilteredPersonsListCopy.add(BERNARD);
        assertFalse(uniqueFilteredPersonsList.equals(uniqueFilteredPersonsListCopy));

        // different object -> not equal
        assertFalse(uniqueFilteredPersonsList.equals(1));

        // null object -> not equal
        assertFalse(uniqueFilteredPersonsList.equals(null));

    }


    @Test
    public void hashcode() {
        UniqueFilteredPersonsList uniqueFilteredPersonsList = new UniqueFilteredPersonsList();
        UniqueFilteredPersonsList uniqueFilteredPersonsListCopy = new UniqueFilteredPersonsList();
        uniqueFilteredPersonsList.add(ALEX);
        uniqueFilteredPersonsListCopy.add(ALEX);

        // same object -> equal
        assertEquals(uniqueFilteredPersonsList.hashCode(), uniqueFilteredPersonsList.hashCode());

        // same values -> equal
        assertEquals(uniqueFilteredPersonsList.hashCode(), uniqueFilteredPersonsListCopy.hashCode());

        // different values -> not equal
        uniqueFilteredPersonsListCopy.add(BERNARD);
        assertNotEquals(uniqueFilteredPersonsList.hashCode(), uniqueFilteredPersonsListCopy.hashCode());

    }

    @Test
    public void contains() {
        UniqueFilteredPersonsList uniqueFilteredPersonsList = new UniqueFilteredPersonsList();
        uniqueFilteredPersonsList.add(ALEX);
        assertTrue(uniqueFilteredPersonsList.contains(ALEX));
    }

    @Test
    public void addDuplicateThrowsError() {
        UniqueFilteredPersonsList uniqueFilteredPersonsList = new UniqueFilteredPersonsList();
        uniqueFilteredPersonsList.add(ALEX);
        assertThrows(DuplicatePersonException.class, () -> uniqueFilteredPersonsList.add(ALEX));
    }

    @Test
    public void setDuplicateThrowsError() {
        UniqueFilteredPersonsList uniqueFilteredPersonsList = new UniqueFilteredPersonsList();
        ArrayList<Person> alexList = new ArrayList<>();
        alexList.add(ALEX);
        alexList.add(ALEX);
        assertThrows(DuplicatePersonException.class, () -> uniqueFilteredPersonsList.setPersons(alexList));
    }
}

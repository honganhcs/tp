package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIALNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VENUE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WEEK;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.assessment.Assessment;
import seedu.address.model.assessment.AssessmentNameIsEqualPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;
import seedu.address.model.tutorial.TutorialNameIsEqualPredicate;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";
    public static final String VALID_TUTORIALNAME_T01 = "T01";
    public static final String VALID_TUTORIALNAME_T02 = "T02";
    public static final String VALID_DAY_T01 = "Wed";
    public static final String VALID_DAY_T02 = "Thu";
    public static final String VALID_TIME_T01 = "10:00";
    public static final String VALID_TIME_T02 = "11:00";
    public static final String VALID_VENUE_T01 = "LT15";
    public static final String VALID_VENUE_T02 = "LT16";
    public static final int VALID_WEEK_T01 = 13;
    public static final int VALID_WEEK_T02 = 13;

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;
    public static final String VENUE_DESC_T01 = " " + PREFIX_VENUE + VALID_VENUE_T01;
    public static final String VENUE_DESC_T02 = " " + PREFIX_VENUE + VALID_VENUE_T02;
    public static final String TUTORIALNAME_DESC_T01 = " " + PREFIX_TUTORIALNAME + VALID_TUTORIALNAME_T01;
    public static final String TUTORIALNAME_DESC_T02 = " " + PREFIX_TUTORIALNAME + VALID_TUTORIALNAME_T02;
    public static final String DAY_DESC_T01 = " " + PREFIX_DAY + VALID_DAY_T01;
    public static final String DAY_DESC_T02 = " " + PREFIX_DAY + VALID_DAY_T02;
    public static final String WEEKS_DESC_T01 = " " + PREFIX_WEEK + VALID_WEEK_T01;
    public static final String WEEKS_DESC_T02 = " " + PREFIX_WEEK + VALID_WEEK_T02;
    public static final String TIME_DESC_T01 = " " + PREFIX_TIME + VALID_TIME_T01;
    public static final String TIME_DESC_T02 = " " + PREFIX_TIME + VALID_TIME_T02;



    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags
    public static final String INVALID_TUTORIAL_NAME = " " + PREFIX_TUTORIALNAME; // empty string not allowed
    public static final String INVALID_DAY_DESC = " " + PREFIX_DAY + "thur"; // four letters abbreviation not allowed
    public static final String INVALID_TIME_DESC = " " + PREFIX_TIME + "1300"; // missing ':' symbol
    public static final String INVALID_WEEK_DESC = " " + PREFIX_WEEK + "100"; // value exceeds limit

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0]), false));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the assessment at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showAssessmentAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredAssessmentList().size());

        Assessment assessment = model.getFilteredAssessmentList().get(targetIndex.getZeroBased());
        model.updateFilteredAssessmentList(new AssessmentNameIsEqualPredicate(assessment.getAssessmentName()));

        assertEquals(1, model.getFilteredAssessmentList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the tutorial at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showTutorialAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredTutorialList().size());

        Tutorial tutorial = model.getFilteredTutorialList().get(targetIndex.getZeroBased());
        model.updateFilteredTutorialList(new TutorialNameIsEqualPredicate(tutorial.getTutorialName()));

        assertEquals(1, model.getFilteredTutorialList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the tutorial with the given {@code targetTutorialName} in the
     * {@code model}'s address book.
     */
    public static void showTutorialWithName(Model model, TutorialName targetTutorialName) {
        List<Tutorial> filteredTutorialWithMatchingName = model.getFilteredTutorialList()
                .stream()
                .filter(t -> t.getTutorialName().equals(targetTutorialName))
                .collect(Collectors.toList());

        assertTrue(filteredTutorialWithMatchingName.size() > 0);

        Tutorial tutorial = model.getFilteredTutorialList().get(0);
        model.updateFilteredTutorialList(new TutorialNameIsEqualPredicate(tutorial.getTutorialName()));

        assertEquals(1, model.getFilteredTutorialList().size());
    }

}

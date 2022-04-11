package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.commons.core.Messages.MESSAGE_TUTORIAL_NOT_FOUND;
import static seedu.address.logic.commands.AddStudentCommand.MESSAGE_ADD_STUDENT_SUCCESS;
import static seedu.address.logic.commands.AddStudentCommand.MESSAGE_DUPLICATE_STUDENT;
import static seedu.address.logic.commands.AddStudentCommand.MESSAGE_DUPLICATE_STUDENT_ID;
import static seedu.address.logic.commands.AddStudentCommand.MESSAGE_PERSON_NOT_FOUND;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.StudentTestUtil.VALID_NAME_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_NAME_BILL;
import static seedu.address.logic.commands.StudentTestUtil.VALID_STUDENT_ID_AARON;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG1;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Name;
import seedu.address.model.person.NusNetId;
import seedu.address.model.person.Person;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TutorialBuilder;

public class AddStudentCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void constructor_nullName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddStudentCommand(null,
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1)));
    }

    @Test
    public void constructor_nullNusNetId_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddStudentCommand(new Name(VALID_NAME_AARON),
                null, new TutorialName(VALID_TUTORIAL_NAME_TG1)));
    }

    @Test
    public void constructor_nullTutorialName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddStudentCommand(new Name(VALID_NAME_AARON),
                new NusNetId(VALID_STUDENT_ID_AARON), null));
    }

    @Test
    public void execute_personDoesNotExist_failure() throws CommandException {
        AddStudentCommand command = new AddStudentCommand(new Name(VALID_NAME_AARON),
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1));
        assertCommandFailure(command, model, MESSAGE_PERSON_NOT_FOUND);
    }

    @Test
    public void execute_tutorialDoesNotExist_failure() {
        Person validPerson = new PersonBuilder().withName(VALID_NAME_AARON).build();

        model.addPerson(validPerson);

        AddStudentCommand command = new AddStudentCommand(new Name(VALID_NAME_AARON),
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1));

        assertCommandFailure(command, model, String.format(MESSAGE_TUTORIAL_NOT_FOUND, VALID_TUTORIAL_NAME_TG1));
    }

    @Test
    public void execute_personAlreadyAdded_failure() throws CommandException {

        Person validPerson = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addPerson(validPerson);
        model.addTutorial(validTutorial);

        AddStudentCommand command = new AddStudentCommand(new Name(VALID_NAME_AARON),
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1));

        command.execute(model);

        assertCommandFailure(command, model, MESSAGE_DUPLICATE_STUDENT);
    }

    @Test
    public void execute_duplicateNusNetId_throwsCommandException() throws CommandException {
        Person aaron = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Person bill = new PersonBuilder().withName(VALID_NAME_BILL).build();

        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addPerson(aaron);
        model.addPerson(bill);
        model.addTutorial(validTutorial);

        // initialise camNUS with one student
        AddStudentCommand addAaron = new AddStudentCommand(new Name(VALID_NAME_AARON),
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1));

        // add a student with the same NusNetId
        AddStudentCommand addBill = new AddStudentCommand(new Name(VALID_NAME_BILL),
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1));

        addAaron.execute(model);

        assertCommandFailure(addBill, model, String.format(MESSAGE_DUPLICATE_STUDENT_ID, VALID_STUDENT_ID_AARON));

    }

    @Test
    public void execute_validStudentAdded_addStudentSuccessful() throws CommandException {
        Person validPerson = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addPerson(validPerson);
        model.addTutorial(validTutorial);

        AddStudentCommand command = new AddStudentCommand(new Name(VALID_NAME_AARON),
                new NusNetId(VALID_STUDENT_ID_AARON), new TutorialName(VALID_TUTORIAL_NAME_TG1));

        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(MESSAGE_ADD_STUDENT_SUCCESS,
                model.getStudentWithId(new NusNetId(VALID_STUDENT_ID_AARON))), commandResult.getFeedbackToUser());
    }

}

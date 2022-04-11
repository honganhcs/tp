package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.RemoveStudentCommand.MESSAGE_NOT_A_STUDENT;
import static seedu.address.logic.commands.RemoveStudentCommand.MESSAGE_REMOVE_STUDENT_SUCCESS;
import static seedu.address.logic.commands.RemoveStudentCommand.MESSAGE_TUTORIAL_DOES_NOT_EXIST;
import static seedu.address.logic.commands.StudentTestUtil.VALID_NAME_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_STUDENT_ID_AARON;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG1;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG2;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.StudentBuilder.DEFAULT_NUSNETID;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.NusNetId;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.StudentBuilder;
import seedu.address.testutil.TutorialBuilder;


public class RemoveStudentCommandTest {

    private static final Index INDEX_ONE = Index.fromOneBased(1);
    private static final Index INDEX_TWO = Index.fromOneBased(2);

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void constructor_nullTutorialName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RemoveStudentCommand(INDEX_ONE,
                null));
    }

    @Test
    public void execute_tutorialDoesNotExist_failure() throws CommandException {
        RemoveStudentCommand commandIndex = new RemoveStudentCommand(INDEX_ONE,
                new TutorialName(VALID_TUTORIAL_NAME_TG1));
        RemoveStudentCommand commandId = new RemoveStudentCommand(new NusNetId(VALID_STUDENT_ID_AARON),
                new TutorialName(VALID_TUTORIAL_NAME_TG1));

        assertCommandFailure(commandIndex, model, String.format(MESSAGE_TUTORIAL_DOES_NOT_EXIST,
                VALID_TUTORIAL_NAME_TG1));
        assertCommandFailure(commandId, model, String.format(MESSAGE_TUTORIAL_DOES_NOT_EXIST,
                VALID_TUTORIAL_NAME_TG1));

    }

    @Test
    public void execute_indexOutOfBounds_failure() throws CommandException {
        Person aaron = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();
        Student studentAaron = new StudentBuilder(aaron).withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addTutorial(validTutorial);
        model.addPerson(aaron);
        AddStudentCommand addStudentCommand = new AddStudentCommand(studentAaron.getName(),
                studentAaron.getStudentId(), studentAaron.getTutorialName());
        addStudentCommand.execute(model);

        RemoveStudentCommand command = new RemoveStudentCommand(INDEX_TWO, new TutorialName(VALID_TUTORIAL_NAME_TG1));
        assertCommandFailure(command, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void execute_notStudent_failure() throws CommandException {
        Person aaron = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addTutorial(validTutorial);
        model.addPerson(aaron);

        RemoveStudentCommand command = new RemoveStudentCommand(INDEX_ONE, new TutorialName(VALID_TUTORIAL_NAME_TG1));
        assertCommandFailure(command, model, MESSAGE_NOT_A_STUDENT);
    }

    @Test
    public void execute_validIndexValidTutorial_success() throws CommandException {
        Person aaron = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();
        Student studentAaron = new StudentBuilder(aaron).withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addPerson(aaron);
        model.addTutorial(validTutorial);
        AddStudentCommand addStudentCommand = new AddStudentCommand(studentAaron.getName(),
                studentAaron.getStudentId(), studentAaron.getTutorialName());
        addStudentCommand.execute(model);

        RemoveStudentCommand command = new RemoveStudentCommand(INDEX_ONE, new TutorialName(VALID_TUTORIAL_NAME_TG1));
        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(MESSAGE_REMOVE_STUDENT_SUCCESS, VALID_NAME_AARON,
                VALID_TUTORIAL_NAME_TG1), commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_validIdValidTutorial_success() throws CommandException {
        Person aaron = new PersonBuilder().withName(VALID_NAME_AARON).build();
        Tutorial validTutorial = new TutorialBuilder().withTutorialName(VALID_TUTORIAL_NAME_TG1).build();
        Student studentAaron = new StudentBuilder(aaron).withTutorialName(VALID_TUTORIAL_NAME_TG1).build();

        model.addPerson(aaron);
        model.addTutorial(validTutorial);
        AddStudentCommand addStudentCommand = new AddStudentCommand(studentAaron.getName(),
                studentAaron.getStudentId(), studentAaron.getTutorialName());
        addStudentCommand.execute(model);

        RemoveStudentCommand command = new RemoveStudentCommand(new NusNetId(DEFAULT_NUSNETID),
                new TutorialName(VALID_TUTORIAL_NAME_TG1));
        CommandResult commandResult = command.execute(model);

        assertEquals(String.format(MESSAGE_REMOVE_STUDENT_SUCCESS, VALID_NAME_AARON,
                VALID_TUTORIAL_NAME_TG1), commandResult.getFeedbackToUser());
    }

    @Test
    public void equals() {
        RemoveStudentCommand commandIndex = new RemoveStudentCommand(INDEX_ONE,
                new TutorialName(VALID_TUTORIAL_NAME_TG1));
        RemoveStudentCommand commandIndex2 = new RemoveStudentCommand(INDEX_TWO,
                new TutorialName(VALID_TUTORIAL_NAME_TG1));
        RemoveStudentCommand commandIndex3 = new RemoveStudentCommand(INDEX_ONE,
                new TutorialName(VALID_TUTORIAL_NAME_TG2));
        RemoveStudentCommand commandId = new RemoveStudentCommand(new NusNetId(DEFAULT_NUSNETID),
                new TutorialName(VALID_TUTORIAL_NAME_TG1));
        RemoveStudentCommand commandId2 = new RemoveStudentCommand(new NusNetId(DEFAULT_NUSNETID),
                new TutorialName(VALID_TUTORIAL_NAME_TG2));

        assertFalse(commandId.equals(commandIndex));
        assertFalse(commandId.equals(commandId2));
        assertFalse(commandIndex.equals(commandIndex2));
        assertFalse(commandIndex.equals(commandIndex3));
        assertFalse(commandId.equals(new Object()));

        assertTrue(commandId.equals(commandId));
        assertTrue(commandIndex.equals(commandIndex));
    }

}

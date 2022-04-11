package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIALNAME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_STUDENTS;

import java.util.List;

import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Displayable;
import seedu.address.model.Model;
import seedu.address.model.person.NusNetId;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;



public class RemoveStudentCommand extends Command {

    public static final String COMMAND_WORD = "remove_student";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Removes a student from the tutorial. \n"
            + "Parameters: "
            + "INDEX "
            + PREFIX_TUTORIALNAME + "TUTORIAL_NAME\n"
            + "or\n"
            + PREFIX_STUDENTID + "STUDENT_ID "
            + PREFIX_TUTORIALNAME + "TUTORIAL_NAME\n"
            + "Example:\n"
            + COMMAND_WORD + " "
            + "1 "
            + PREFIX_TUTORIALNAME + "G04\n"
            + COMMAND_WORD + " "
            + PREFIX_STUDENTID + "e0123456 "
            + PREFIX_TUTORIALNAME + "G04\n";

    public static final String MESSAGE_REMOVE_STUDENT_SUCCESS = "Student %1$s has been removed from tutorial %2$s";
    public static final String MESSAGE_NOT_A_STUDENT = "This person is not a student!";
    public static final String MESSAGE_TUTORIAL_DOES_NOT_EXIST = "Tutorial %1$s does not exist!";
    public static final String MESSAGE_STUDENT_DOES_NOT_EXIST = "Student %1$s is not in tutorial %2$s";
    public static final String MESSAGE_INDEX_USAGE = "Try listing students e.g. list_student";

    private final Index toRemoveIndex;
    private final NusNetId toRemoveStudentId;
    private final TutorialName toRemoveFromTutorialName;

    /**
     * Creates a RemoveStudentCommand to remove a student with the specified {@code studentId}
     * from the specified tutorial with {@code tutorialName}.
     */
    public RemoveStudentCommand(NusNetId studentId, TutorialName tutorialName) {
        requireNonNull(studentId);
        requireNonNull(tutorialName);
        toRemoveIndex = null;
        toRemoveStudentId = studentId;
        toRemoveFromTutorialName = tutorialName;
    }

    /**
     * Creates a RemoveStudentCommand to remove a student with the specified {@code index}
     * from the specified tutorial with {@code tutorialName}.
     */
    public RemoveStudentCommand(Index index, TutorialName tutorialName) {
        requireNonNull(index);
        requireNonNull(tutorialName);
        toRemoveIndex = index;
        toRemoveStudentId = null;
        toRemoveFromTutorialName = tutorialName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (toRemoveStudentId != null) {
            Tutorial tutorial;
            Student studentToRemove;
            if (!model.hasTutorialWithName(toRemoveFromTutorialName)) {
                throw new CommandException(String.format(MESSAGE_TUTORIAL_DOES_NOT_EXIST, toRemoveFromTutorialName));
            }
            tutorial = model.getTutorialWithName(toRemoveFromTutorialName);

            if (!tutorial.containsStudentWithId(toRemoveStudentId)) {
                throw new CommandException(String.format(MESSAGE_STUDENT_DOES_NOT_EXIST, toRemoveStudentId,
                        toRemoveFromTutorialName));
            }
            studentToRemove = model.getStudentWithId(toRemoveStudentId);
            model.removeStudentResults(toRemoveStudentId, toRemoveFromTutorialName);
            tutorial.setStudentsList(new FilteredList<Person>(model.getAddressBook().getPersonList(),
                    PREDICATE_SHOW_ALL_STUDENTS));
            model.removeStudent(studentToRemove);

            return CommandResult
                    .createStudentCommandResult(String.format(MESSAGE_REMOVE_STUDENT_SUCCESS, studentToRemove.getName(),
                            toRemoveFromTutorialName));
        } else {
            List<Displayable> lastShownList = model.getLastShownList();
            if (toRemoveIndex.getZeroBased() >= lastShownList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }
            if (!model.hasTutorialWithName(toRemoveFromTutorialName)) {
                throw new CommandException(String.format(MESSAGE_TUTORIAL_DOES_NOT_EXIST, toRemoveFromTutorialName));
            }

            Displayable personToRemove = lastShownList.get(toRemoveIndex.getZeroBased());

            if (!(personToRemove instanceof Person)) {
                throw new CommandException(Messages.MESSAGE_INDEX_LIST_MISMATCH + MESSAGE_INDEX_USAGE);
            }

            if (!(personToRemove instanceof Student)) {
                throw new CommandException(MESSAGE_NOT_A_STUDENT);
            }

            Student studentToRemove = (Student) personToRemove;
            NusNetId id = studentToRemove.getStudentId();

            if (!model.tutorialHasStudentWithId(id, toRemoveFromTutorialName)) {
                throw new CommandException(String.format(MESSAGE_STUDENT_DOES_NOT_EXIST, id,
                        toRemoveFromTutorialName));
            }

            model.removeStudentResults(id, toRemoveFromTutorialName);
            Tutorial tutorial = model.getTutorialWithName(toRemoveFromTutorialName);
            tutorial.setStudentsList(new FilteredList<Person>(model.getAddressBook().getPersonList(),
                    PREDICATE_SHOW_ALL_STUDENTS));
            model.removeStudent(studentToRemove);

            return CommandResult
                    .createStudentCommandResult(String.format(MESSAGE_REMOVE_STUDENT_SUCCESS, studentToRemove.getName(),
                    toRemoveFromTutorialName));
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof RemoveStudentCommand) {
            RemoveStudentCommand command = (RemoveStudentCommand) other;
            if (command.toRemoveIndex != null && toRemoveIndex != null) {
                return toRemoveIndex.equals(command.toRemoveIndex)
                        && toRemoveFromTutorialName.equals(command.toRemoveFromTutorialName);
            } else if (command.toRemoveStudentId != null && toRemoveStudentId != null) {
                return toRemoveStudentId.equals(command.toRemoveStudentId)
                        && toRemoveFromTutorialName.equals(command.toRemoveFromTutorialName);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

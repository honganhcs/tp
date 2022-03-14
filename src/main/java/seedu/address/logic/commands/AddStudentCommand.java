package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIALNAME;

import java.util.Set;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.NusNetId;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Student;
import seedu.address.model.person.exceptions.DuplicateStudentException;
import seedu.address.model.tag.Tag;
import seedu.address.model.tutorial.TutorialName;


public class AddStudentCommand extends Command {

    public static final String COMMAND_WORD = "add_student";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a person in the address book as a student to a tutorial. "
            + "Parameters: "
            + PREFIX_NAME + "NAME"
            + PREFIX_STUDENTID + "STUDENT_ID"
            + PREFIX_TUTORIALNAME + "TUTORIAL_NAME\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "Bobby"
            + PREFIX_STUDENTID + "E0123456 "
            + PREFIX_TUTORIALNAME + "G04";

    public static final String MESSAGE_ADD_STUDENT_SUCCESS = "New student added: %1$s";
    public static final String MESSAGE_ADD_STUDENT_FAILURE = "Ensure correct STUDENT_ID and "
            + "TUTORIAL_NAME input.";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student already exists in "
            + "the specified tutorial.";
    public static final String MESSAGE_NOT_FOUND_IN_ADDRESS_BOOK = "This student should be added "
            + "to the address book first.";

    private final Name toAddName;
    private final NusNetId toAddStudentId;
    private final TutorialName toAddTutorialName;

    /**
     * Creates an AddStudentCommand to add a student with the
     * specified {@code name}, {@code studentId} and {@code tutorialName}
     */
    public AddStudentCommand(Name name, NusNetId studentId, TutorialName tutorialName) {
        requireNonNull(name);
        requireNonNull(studentId);
        requireNonNull(tutorialName);
        toAddName = name;
        toAddStudentId = studentId;
        toAddTutorialName = tutorialName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasPersonWithName(toAddName)) {
            throw new CommandException(MESSAGE_NOT_FOUND_IN_ADDRESS_BOOK);
        }

        Person personMatch = model.getPersonWithName(toAddName);
        Phone phone = personMatch.getPhone();
        Email email = personMatch.getEmail();
        Address address = personMatch.getAddress();
        Set<Tag> tags = personMatch.getTags();

        Student toAdd = new Student(toAddName, phone, email, address, tags, toAddStudentId, toAddTutorialName);

        if (model.hasStudent(toAdd)) {
            throw new DuplicateStudentException();
        }

        model.addStudent(toAdd);
        return new CommandResult(String.format(MESSAGE_ADD_STUDENT_SUCCESS, toAdd));
    }
}
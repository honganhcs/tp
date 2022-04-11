package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.StudentTestUtil.VALID_ADDRESS_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_ADDRESS_BILL;
import static seedu.address.logic.commands.StudentTestUtil.VALID_EMAIL_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_EMAIL_BILL;
import static seedu.address.logic.commands.StudentTestUtil.VALID_NAME_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_NAME_BILL;
import static seedu.address.logic.commands.StudentTestUtil.VALID_PHONE_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_PHONE_BILL;
import static seedu.address.logic.commands.StudentTestUtil.VALID_STUDENT_ID_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_STUDENT_ID_BILL;
import static seedu.address.logic.commands.StudentTestUtil.VALID_TAG_STUDENT;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG1;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Student;

public class TypicalStudents {

    public static final Student ALEX = new StudentBuilder().withName("Alex Lee")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alex@example.com")
            .withPhone("91234567").withTags("student").withStudentId("e0543216")
            .withTutorialName("TG01").build();
    public static final Student BERNARD = new StudentBuilder().withName("Bernard Toh")
            .withAddress("123, Wood East Ave 6, #08-123").withEmail("bernardt@gmail.com")
            .withPhone("81234567").withTags("student").withStudentId("e0523416")
            .withTutorialName("TG01").build();
    public static final Student CHARLIE = new StudentBuilder().withName("Charlie Johnson")
            .withAddress("321, Jurong North Ave 9, #10-123").withEmail("cjohnson@hotmail.com")
            .withPhone("83214567").withTags("student").withStudentId("e0523614")
            .withTutorialName("TG01").build();
    public static final Student DENSON = new StudentBuilder().withName("Denson Loh")
            .withAddress("321, Ang Mo Kio West Ave 9, #10-101").withEmail("dsnlh@hotmail.com")
            .withPhone("83214567").withTags("student").withStudentId("e0563214")
            .withTutorialName("TG01").build();
    public static final Student EVE = new StudentBuilder().withName("Eve Tan")
            .withAddress("123, Jurong West Ave 7, #08-111").withEmail("eve@example.com")
            .withPhone("91234566").withTags("student").withStudentId("e0543220")
            .withTutorialName("T01").build();

    public static final Student EVA = new StudentBuilder().withName("Eva Tan")
            .withAddress("123, Jurong West Ave 7, #18-111").withEmail("eva@example.com")
            .withPhone("91255566").withTags("student").withStudentId("e0543229")
            .withTutorialName("T01").build();

    public static final Student FIONA = new StudentBuilder().withName("Fiona Rin")
            .withAddress("123, Clementi North, #18-111").withEmail("fiona@example.com")
            .withPhone("81244556").withTags("student").withStudentId("e0129820")
            .withTutorialName("T01").build();

    public static final Student JOHN = new StudentBuilder().withName("John")
            .withAddress("123, Clementi North, #18-111").withEmail("john@example.com")
            .withPhone("81244556").withTags("student").withStudentId("e0123456")
            .withTutorialName("Test Class").build();
    public static final Student JACK = new StudentBuilder().withName("Jack")
            .withAddress("123, Clementi North, #18-111").withEmail("jack@example.com")
            .withPhone("81244556").withTags("student").withStudentId("e0123555")
            .withTutorialName("Test Class").build();


    // Manually added - Student's details found in {@code StudentTestUtil}
    public static final Student AARON = new StudentBuilder().withName(VALID_NAME_AARON).withPhone(VALID_PHONE_AARON)
            .withEmail(VALID_EMAIL_AARON).withAddress(VALID_ADDRESS_AARON).withTags(VALID_TAG_STUDENT)
            .withStudentId(VALID_STUDENT_ID_AARON).withTutorialName(VALID_TUTORIAL_NAME_TG1).build();
    public static final Student BILL = new StudentBuilder().withName(VALID_NAME_BILL).withPhone(VALID_PHONE_BILL)
            .withEmail(VALID_EMAIL_BILL).withAddress(VALID_ADDRESS_BILL).withTags(VALID_TAG_STUDENT, VALID_TAG_FRIEND)
            .withStudentId(VALID_STUDENT_ID_BILL).withTutorialName(VALID_TUTORIAL_NAME_TG2).build();

    private TypicalStudents() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical students.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Student student : getTypicalStudents()) {
            ab.addStudent(student);
            ab.addLastShownItem(student);
        }
        return ab;
    }

    public static List<Student> getTypicalStudents() {
        return new ArrayList<>(Arrays.asList(ALEX, BERNARD, CHARLIE, DENSON));
    }
}

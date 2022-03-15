package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.assessment.Assessment;
import seedu.address.model.assessment.AssessmentName;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
    Predicate<Tutorial> PREDICATE_SHOW_ALL_TUTORIALS = unused -> true;
    Predicate<Person> PREDICATE_SHOW_ALL_STUDENTS = Student::isStudent;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Returns true if a person with the same name as {@code name} exists in the address book.
     */
    boolean hasPersonWithName(Name name);

    /**
     * Returns a person with the same name as {@code name}
     */
    Person getPersonWithName(Name name);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Returns true if a tutorial with the same identity as {@code tutorial} exists in the address book.
     */
    boolean hasTutorial(Tutorial tutorial);

    /**
     * Deletes the given tutorial.
     * The tutorial must exist in the address book.
     */
    void deleteTutorial(Tutorial target);

    /**
     * Adds the given tutorial.
     * {@code tutorial} must not already exist in the address book.
     */
    void addTutorial(Tutorial tutorial);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another
     * existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Replaces the given tutorial {@code target} with {@code editedTutorial}.
     * {@code target} must exist in the address book.
     * The tutorial identity of {@code editedTutorial} must not be the same as another existing
     * tutorial in the address book.
     */
    void setTutorial(Tutorial target, Tutorial editedTutorial);

    /**
     * Returns an unmodifiable view of the filtered student list
     */
    FilteredList<Person> getFilteredStudentList();

    /**
     * Updates the predicate of the filtered student list to the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Person> predicate);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /** Returns an unmodifiable view of the filtered tutorial list */
    ObservableList<Tutorial> getFilteredTutorialList();

    /** Returns an unmodifiable view of the filtered tutorial list */
    ObservableList<Assessment> getAssessmentList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Returns an unmodifiable view of the filtered assessment list
     */
    ObservableList<Assessment> getFilteredAssessmentList();

    /**
     * Updates the predicate of the filtered assessment list to {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredAssessmentList(Predicate<Assessment> predicate);

    /**
     * Returns true if an assessment with the same identity as {@code assessment} exists in the address book.
     */
    boolean hasAssessment(Assessment assessment);

    /**
     * Adds the given assessment.
     * @param toAdd must not already exist in the address book.
     */
    void addAssessment(Assessment toAdd);

    boolean hasAssessmentByName(AssessmentName name);

    Assessment removeAssessmentByName(AssessmentName name);

    /**
    * Adds the given student to the tutorial.
     * Student must not already exist in the student list of the tutorial.
     */
    void addStudent(Student student);

    /**
     * Updates the filter of the filtered tutorial list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTutorialList(Predicate<Tutorial> predicate);

    /** Returns an unmodifiable view of the filtered student list */
    FilteredList<Person> getAllStudentsList();

    /**
     *  Returns true if a student with the same identity as {@code student}
     *  exists in the tutorial with the same tutorial name as {@code tutorialName}.
     */
    boolean hasStudentWithName(Name studentName);

    /**
     * Returns true if a tutorial with the given {@code tutorialName} exists in the address book.
     */
    boolean hasTutorialByName(TutorialName tutorialName);
}

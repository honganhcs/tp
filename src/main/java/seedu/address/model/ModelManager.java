package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.assessment.Assessment;
import seedu.address.model.assessment.AssessmentName;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;

/**
 * Represents the in-memory model of the address book data.
 * TODO: add methods for AddressBook to support command logic
 * The AddressBook contains the tutorial list and assessment list.
 * e.g. TutorialManager to provide higher-level methods.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;
    private final FilteredList<Tutorial> filteredTutorials;
    private final FilteredList<Assessment> filteredAssessments;

    /**
     * A list containing all Students in the address book.
     * DO NOT MODIFY (as it is the list that {@link seedu.address.model.person.UniqueStudentsInTutorialList}
     * listens to).
     */
    private final FilteredList<Person> allStudents;
    /**
     * Used for the GUI display.
     * Can modify if needed.
     */
    private final FilteredList<Person> filteredStudents;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
        filteredTutorials = new FilteredList<>(this.addressBook.getTutorialList());
        filteredAssessments = new FilteredList<>(this.addressBook.getAssessmentList());

        allStudents = new FilteredList<>(this.addressBook.getPersonList(), PREDICATE_SHOW_ALL_STUDENTS);
        filteredStudents = new FilteredList<>(allStudents);

    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return addressBook.hasPerson(person);
    }

    @Override
    public boolean hasPersonWithName(Name name) {
        requireNonNull(name);
        return addressBook.hasPersonWithName(name);
    }

    @Override
    public Person getPersonWithName(Name name) {
        requireNonNull(name);
        return addressBook.getPersonWithName(name);
    }

    @Override
    public void deletePerson(Person target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        addressBook.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);

        addressBook.setPerson(target, editedPerson);
    }

    //=========== Assessments =============================================================
    /**
     * Returns an unmodifiable view of the list of {@code Assessment} backed by the internal list of
     * {@code AddressBook}
     */
    @Override
    public ObservableList<Assessment> getAssessmentList() {
        return addressBook.getAssessmentList();
    }

    @Override
    public ObservableList<Assessment> getFilteredAssessmentList() {
        return filteredAssessments;
    }

    @Override
    public void updateFilteredAssessmentList(Predicate<Assessment> predicate) {
        requireNonNull(predicate);
        filteredAssessments.setPredicate(predicate);
    }

    @Override
    public boolean hasAssessment(Assessment assessment) {
        return addressBook.hasAssessment(assessment);
    }

    @Override
    public void addAssessment(Assessment toAdd) {
        addressBook.addAssessment(toAdd);
    }

    @Override
    public boolean hasAssessmentByName(AssessmentName name) {
        return addressBook.hasAssessmentByName(name);
    }

    @Override
    public Assessment removeAssessmentByName(AssessmentName name) {
        return addressBook.removeAssessmentByName(name);
    }

    //=========== Tutorials =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Tutorial} backed by the internal list of
     * {@code AddressBook}
     */
    @Override
    public ObservableList<Tutorial> getFilteredTutorialList() {
        return filteredTutorials;
    }

    @Override
    public boolean hasTutorial(Tutorial tutorial) {
        requireNonNull(tutorial);
        return addressBook.hasTutorial(tutorial);
    }

    @Override
    public boolean hasTutorialByName(TutorialName tutorialName) {
        return addressBook.hasTutorialByName(tutorialName);
    }

    @Override
    public void deleteTutorial(Tutorial target) {
        addressBook.removeTutorial(target);
    }

    @Override
    public void addTutorial(Tutorial tutorial) {
        addressBook.addTutorial(tutorial);
        updateFilteredTutorialList(PREDICATE_SHOW_ALL_TUTORIALS);
    }

    @Override
    public void setTutorial(Tutorial target, Tutorial editedTutorial) {
        requireAllNonNull(target, editedTutorial);

        addressBook.setTutorial(target, editedTutorial);
    }

    @Override
    public void updateFilteredTutorialList(Predicate<Tutorial> predicate) {
        requireNonNull(predicate);
        filteredTutorials.setPredicate(predicate);
    }

    //=========== Students =============================================================

    @Override
    public boolean hasStudentWithName(Name studentName) {
        requireNonNull(studentName);
        return allStudents.stream().anyMatch(x -> x.getName().equals(studentName));
    }

    @Override
    public void addStudent(Student student) {
        requireNonNull(student);
        addressBook.addStudent(student);
    }

    @Override
    public FilteredList<Person> getAllStudentsList() {
        return allStudents;
    }

    @Override
    public FilteredList<Person> getFilteredStudentList() {
        return filteredStudents;
    }

    @Override
    public void updateFilteredStudentList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredStudents.setPredicate(predicate);
    }
    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code AddressBook}
     */
    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredPersons.equals(other.filteredPersons);
    }

}


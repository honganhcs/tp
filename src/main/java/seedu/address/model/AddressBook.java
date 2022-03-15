package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.assessment.Assessment;
import seedu.address.model.assessment.AssessmentName;
import seedu.address.model.assessment.UniqueAssessmentList;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialName;
import seedu.address.model.tutorial.UniqueTutorialList;

/**
 * Wraps all data at the address-book level (persons, tutorials, assessments)
 * Duplicates are not allowed (by .isSamePerson comparison)
 * TODO: add methods for tutorial and assessment list which will be used by the ModelManager
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniquePersonList persons;
    private final UniqueTutorialList tutorials = new UniqueTutorialList();
    private final UniqueAssessmentList assessments = new UniqueAssessmentList();

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }

    /**
     * Replaces the contents of the tutorial list with {@code tutorials},
     * which does not contain duplicate tutorials.
     */
    public void setTutorials(List<Tutorial> tutorials) {
        this.tutorials.setTutorials(tutorials);
    }

    /**
     * Replaces the contents of the assessment list with {@code assessments},
     * which does not contain duplicate assessments.
     */
    public void setAssessments(List<Assessment> assessments) {
        this.assessments.setAssessments(assessments);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setPersons(newData.getPersonList());
        setTutorials(newData.getTutorialList());
        setAssessments(newData.getAssessmentList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Person key) {
        persons.remove(key);
    }

    /**
     * Returns true if a person with the same name as {@code name} exists in the address book.
     */
    public boolean hasPersonWithName(Name name) {
        requireNonNull(name);
        return persons.hasPersonWithName(name);
    }

    /**
     * Returns a person with the same name as {@code name}.
     * This function will only be called if passed the check that
     * a matching {@code Person} exists in the address book.
     */
    public Person getPersonWithName(Name name) {
        return persons.get(name);
    }

    //// assessment-level operations
    /**
     * Returns true if an assessment with the same identity as {@code assessment} exists in the address book.
     */
    public boolean hasAssessment(Assessment assessment) {
        return assessments.contains(assessment);
    }

    /**
     * Adds the given assessment and corresponding AssessmentResults to every tutorial in the address book.
     * @param toAdd must not already exist in the address book.
     */
    public void addAssessment(Assessment toAdd) {
        assessments.add(toAdd);
        tutorials.addAssessment(toAdd);
    }

    /**
     * Returns true if an assessment with the given name exists in the address book.
     */
    public boolean hasAssessmentByName(AssessmentName name) {
        return assessments.containsByName(name);
    }

    /**
     * Removes the assessment with the given name and corresponding AssessmentResults from every tutorial
     * in the address book.
     */
    public Assessment removeAssessmentByName(AssessmentName name) {
        Assessment toRemove = assessments.removeByName(name);
        tutorials.removeAssessmentByName(name);
        return toRemove;
    }

    //// util methods

    /**
     * Returns true if a tutorial with the same identity as {@code tutorial} exists in the address book.
     */
    public boolean hasTutorial(Tutorial tutorial) {
        requireNonNull(tutorial);
        return tutorials.contains(tutorial);
    }

    /**
     * Returns true if a tutorial with the given {@code tutorialName} exists in the address book.
     */
    public boolean hasTutorialByName(TutorialName tutorialName) {
        return tutorials.containsByName(tutorialName);
    }

    /**
     * Adds a tutorial to the address book.
     * The tutorial must not already exist in the address book.
     */
    public void addTutorial(Tutorial t) {
        tutorials.add(t);
    }

    /**
     * Replaces the given tutorial {@code target} in the list with {@code editedTutorial}.
     * {@code target} must exist in the address book.
     * The tutorial identity of {@code editedTutorial} must not be the same as another existing
     * tutorial in the address book.
     */
    public void setTutorial(Tutorial target, Tutorial editedTutorial) {
        requireNonNull(editedTutorial);

        tutorials.setTutorial(target, editedTutorial);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeTutorial(Tutorial key) {
        tutorials.remove(key);
    }

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Tutorial> getTutorialList() {
        return tutorials.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Assessment> getAssessmentList() {
        return assessments.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && persons.equals(((AddressBook) other).persons));
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
    }

    ///student-level methods

    /**
     * Adds a student to the address book in a specified tutorial with the
     * tutorial name {@code tutorialName}.
     * The student must exist in the address book as a person.
     * The student must not exist in the tutorial.
     */
    public void addStudent(Student student) {
        requireNonNull(student);
        Person personMatch = persons.get(student.getName());
        persons.setPerson(personMatch, student);
    }

}

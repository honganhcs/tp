package seedu.address.model.tutorial;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.assessment.Assessment;
import seedu.address.model.assessment.AssessmentName;
import seedu.address.model.assessment.AssessmentResults;
import seedu.address.model.tutorial.exceptions.DuplicateTutorialException;
import seedu.address.model.tutorial.exceptions.InvalidTutorialException;
import seedu.address.model.tutorial.exceptions.TutorialNotFoundException;

/**
 * A list of Tutorials that enforces the uniqueness between its elements and does not allow nulls.
 * A Tutorial is considered unique by comparing using {@code Tutorial#isSameTutorial}.
 * Adding and updating a Tutorial uses {@code Tutorial#isSameTutorial(Tutorial)} to ensure
 * that the Tutorial being added is unique in terms of identity.
 * However, the removal of a Tutorial uses {@code Tutorial#equals(Object)} to ensure that the
 * Tutorial with exactly the same fields is removed.
 * TODO: implement the remove and setter methods.
 *
 * @see Tutorial#isSameTutorial(Tutorial)
 */
public class UniqueTutorialList {
    private final ObservableList<Tutorial> internalList = FXCollections.observableArrayList();
    private final ObservableList<Tutorial> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent tutorial as the argument,
     * uses {@code Tutorial#isSameTutorial(Tutorial)}
     */
    public boolean contains(Tutorial toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameTutorial);
    }

    /**
     * Returns true if the list contains a tutorial with the given {@code tutorialName}.
     */
    public boolean containsByName(TutorialName tutorialName) {
        requireNonNull(tutorialName);
        return internalList.stream().anyMatch(x -> x.hasTutorialName(tutorialName));
    }

    /**
     * Adds a tutorial to the list.
     * The tutorial must not already exist in the list.
     */
    public void add(Tutorial toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateTutorialException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent tutorial from the list.
     * The tutorial must exist in the list.
     */
    public void remove(Tutorial toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new TutorialNotFoundException();
        }
    }

    /**
     * Replaces the tutorial {@code target} in the list with {@code editedTutorial}.
     * {@code target} must exist in the list.
     * The tutorial identity of {@code editedTutorial} must not be the same as another existing tutorial in the list.
     */
    public void setTutorial(Tutorial target, Tutorial editedTutorial) {
        requireAllNonNull(target, editedTutorial);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new TutorialNotFoundException();
        }

        if (!target.isSameTutorial(editedTutorial) && contains(editedTutorial)) {
            throw new DuplicateTutorialException();
        }

        internalList.set(index, editedTutorial);
    }

    /**
     * Returns the backing list as an unmodifiable list.
     */
    public ObservableList<Tutorial> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    /**
     * Replaces the contents of this list with {@code tutorials},
     * which must not contain duplicate tutorials.
     */
    public void setTutorials(List<Tutorial> tutorials) {
        requireAllNonNull(tutorials);
        if (!tutorialsAreUnique(tutorials)) {
            throw new DuplicateTutorialException();
        }
        internalList.setAll(tutorials);
    }

    private boolean tutorialsAreUnique(List<Tutorial> tutorials) {
        for (int i = 0; i < tutorials.size() - 1; i++) {
            for (int j = i + 1; j < tutorials.size(); j++) {
                if (tutorials.get(i).isSameTutorial(tutorials.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns true if the list contains tutorial with an equivalent tutorial name as the argument,
     * uses {@code Tutorial#isSameTutorialName(TutorialName)}
     */
    public boolean containsName(TutorialName toCheckName) {
        requireNonNull(toCheckName);
        return internalList.stream().anyMatch(x -> x.hasTutorialName(toCheckName));
    }

    /**
     * Runs through the contents of this list to find the tutorial with
     * tutorial name matching given {@code tutorialName}.
     */
    public Tutorial getTutorialMatch(TutorialName tutorialName) {
        Tutorial tutorialMatch = internalList.stream()
                .filter(tutorial -> tutorialName.equals(tutorial.getTutorialName()))
                .findAny()
                .orElse(null);

        if (tutorialMatch == null) {
            throw new InvalidTutorialException();
        }
        return tutorialMatch;
    }

    /**
     * Adds an AssessmentResult corresponding to {@code assessment} to every tutorial in the list.
     * Note: listeners to UniqueTutorialList will not know of this change.
     */
    public void addAssessment(Assessment assessment) {
        requireNonNull(assessment);
        AssessmentName name = assessment.getAssessmentName();
        for (int i = 0; i < internalList.size(); i++) {
            internalList.get(i).addAssessmentResults(new AssessmentResults(name));
        }
    }

    /**
     * Removes the AssessmentResult with the given name from every tutorial in the list.
     * Note: listeners to UniqueTutorialList will not know of this change.
     */
    public void removeAssessmentByName(AssessmentName name) {
        requireNonNull(name);
        for (int i = 0; i < internalList.size(); i++) {
            internalList.get(i).removeAssessmentResultsByName(name);
        }
    }

}

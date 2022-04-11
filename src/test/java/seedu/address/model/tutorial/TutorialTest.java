package seedu.address.model.tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_DAY_TG2;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TIME_TG2;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG1;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG2;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_VENUE_TG2;
import static seedu.address.testutil.TypicalAssessments.OP1;
import static seedu.address.testutil.TypicalAssessments.OP2;
import static seedu.address.testutil.TypicalStudentResults.E0123456;
import static seedu.address.testutil.TypicalStudents.ALEX;
import static seedu.address.testutil.TypicalStudents.JACK;
import static seedu.address.testutil.TypicalStudents.JOHN;
import static seedu.address.testutil.TypicalTutorials.T01;
import static seedu.address.testutil.TypicalTutorials.T02;
import static seedu.address.testutil.TypicalTutorials.TG2;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.model.assessment.AssessmentResults;
import seedu.address.model.attendance.Attendance;
import seedu.address.model.attendance.AttendanceList;
import seedu.address.model.attendance.Comment;
import seedu.address.model.person.Name;
import seedu.address.model.person.NusNetId;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.StudentNotFoundException;
import seedu.address.testutil.TutorialBuilder;
import seedu.address.testutil.TypicalStudents;

public class TutorialTest {

    @Test
    public void isSameTutorial() {
        // same object -> returns true
        assertTrue(T01.isSameTutorial(T01));

        // null -> returns false
        assertFalse(T01.isSameTutorial(null));

        // same tutorial name, all other attributes different -> returns true
        Tutorial editedT01 = new TutorialBuilder(T01).withDay(VALID_DAY_TG2).withTime(VALID_TIME_TG2)
                        .withVenue(VALID_VENUE_TG2).build();
        assertTrue(T01.isSameTutorial(editedT01));

        // different tutorial name, all other attributes same -> returns false
        editedT01 = new TutorialBuilder(T01).withTutorialName(VALID_TUTORIAL_NAME_TG1).build();
        assertFalse(T01.isSameTutorial(editedT01));

        // tutorial name differs in case, all other attributes same -> returns false
        Tutorial editedTG2 = new TutorialBuilder(TG2).withTutorialName(VALID_TUTORIAL_NAME_TG2.toLowerCase()).build();
        assertFalse(TG2.isSameTutorial(editedTG2));

        // tutorial name has trailing spaces, all other attributes same -> returns false
        String tutorialNameWithTrailingSpaces = VALID_TUTORIAL_NAME_TG2 + " ";
        editedTG2 = new TutorialBuilder(TG2).withTutorialName(tutorialNameWithTrailingSpaces).build();
        assertFalse(TG2.isSameTutorial(editedTG2));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Tutorial t01Copy = new TutorialBuilder(T01).build();
        assertTrue(T01.equals(t01Copy));

        // same object -> returns true
        assertTrue(T01.equals(T01));

        // null -> returns false
        assertFalse(T01.equals(null));

        // different type -> returns false
        assertFalse(T01.equals(5));

        // different tutorial -> returns false
        assertFalse(T01.equals(TG2));

        // different tutorial name -> returns false
        Tutorial editedT01 = new TutorialBuilder(T01).withTutorialName(VALID_TUTORIAL_NAME_TG2).build();
        assertFalse(T01.equals(editedT01));

        // different venue -> returns false
        editedT01 = new TutorialBuilder(T01).withVenue(VALID_VENUE_TG2).build();
        assertFalse(T01.equals(editedT01));

        // different day -> returns false
        editedT01 = new TutorialBuilder(T01).withDay(VALID_DAY_TG2).build();
        assertFalse(T01.equals(editedT01));

        // different time -> returns false
        editedT01 = new TutorialBuilder(T01).withTime(VALID_TIME_TG2).build();
        assertFalse(T01.equals(editedT01));
    }

    public Tutorial tutorialWithListTest() {
        ObservableList<Person> personList = FXCollections.observableArrayList();
        personList.addAll(
                TypicalStudents.DENSON,
                TypicalStudents.EVE,
                TypicalStudents.FIONA
        );
        FilteredList<Person> studentList = new FilteredList<Person>(personList, null);

        Tutorial testTutorial = new TutorialBuilder().withTutorialName("T01")
                .withDay("Wed").withTime("10:00").withVenue("LT15").withWeeks(13).buildWithStudentList(studentList);
        return testTutorial;
    }

    @Test
    public void isSameTutorialTest() {
        boolean tutorialNamesIsSame = T01.isSameTutorial(T01);
        assertTrue(tutorialNamesIsSame);

        boolean tutorialNamesIsDifferent = T01.isSameTutorial(T02);
        assertFalse(tutorialNamesIsDifferent);
    }

    @Test
    public void isSameTutorialNameTest() {
        boolean tutorialNamesIsSame = T01.isSameTutorialName(T01.getTutorialName());
        assertTrue(tutorialNamesIsSame);

        boolean tutorialNamesIsDifferent = T01.isSameTutorialName(T02.getTutorialName());
        assertFalse(tutorialNamesIsDifferent);
    }

    @Test
    public void tutorialContainsStudentTest() {
        Tutorial testTutorial = tutorialWithListTest();
        // EVE belongs in T01
        assertTrue(
                testTutorial.contains(TypicalStudents.EVE));
        // BERNARD belongs in TG01
        assertFalse(
                testTutorial.contains(TypicalStudents.BERNARD));
    }

    @Test
    public void tutorialGetStudentWithIdTest() {
        Tutorial testTutorial = tutorialWithListTest();
        // EVE belongs in T01
        assertEquals(TypicalStudents.EVE, testTutorial.getStudentWithId(
                TypicalStudents.EVE.getStudentId()));
        // BERNARD belongs in TG01
        assertNull(testTutorial.getStudentWithId(
                TypicalStudents.BERNARD.getStudentId()));
    }

    @Test
    public void tutorialContainsStudentWithIdTest() {
        Tutorial testTutorial = tutorialWithListTest();
        // EVE belongs in T01
        assertTrue(testTutorial.containsStudentWithId(
                TypicalStudents.EVE.getStudentId()));
        // BERNARD belongs in TG01
        assertFalse(testTutorial.containsStudentWithId(
                TypicalStudents.BERNARD.getStudentId()));
    }

    @Test
    public void tutorialMarkUnmarkAllAttendanceTest() {
        Tutorial testTutorial = tutorialWithListTest();

        testTutorial.markAllAttendance(1);
        testTutorial.markAllAttendance(2);
        testTutorial.markAllAttendance(3);

        AttendanceList attendanceList = testTutorial.getAttendanceList();
        Attendance eveAttendance = attendanceList
                .getAttendancesByStudentName(
                        TypicalStudents.EVE.getName()).get(0); //EVE's attendance

        // Marked attendance for first 3 weeks

        assertTrue(eveAttendance.getAttendanceList().get(0) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(1) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(2) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(3) == 0);

        Attendance fionaAttendance = attendanceList
                .getAttendancesByStudentName(
                        TypicalStudents.FIONA.getName()).get(0); //EVE's attendance
        assertTrue(fionaAttendance.getAttendanceList().get(0) == 1);
        assertTrue(fionaAttendance.getAttendanceList().get(1) == 1);
        assertTrue(fionaAttendance.getAttendanceList().get(2) == 1);
        assertTrue(fionaAttendance.getAttendanceList().get(3) == 0);

        // Unmarked attendance for second week

        testTutorial.unmarkAllAttendance(2);

        assertTrue(eveAttendance.getAttendanceList().get(0) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(1) == 0);
        assertTrue(eveAttendance.getAttendanceList().get(2) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(3) == 0);

        assertTrue(fionaAttendance.getAttendanceList().get(0) == 1);
        assertTrue(fionaAttendance.getAttendanceList().get(1) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(2) == 1);
        assertTrue(fionaAttendance.getAttendanceList().get(3) == 0);
    }

    @Test
    public void tutorialMarkAndUnmarkIndividualAttendanceTest() {
        Tutorial testTutorial = tutorialWithListTest();
        NusNetId eveId = TypicalStudents.EVE.getStudentId();
        Name eveName = TypicalStudents.EVE.getName();
        NusNetId fionaId = TypicalStudents.FIONA.getStudentId();
        Name fionaName = TypicalStudents.FIONA.getName();

        testTutorial.markStudentAttendance(eveId, 1);
        testTutorial.markStudentAttendance(eveId, 2);
        testTutorial.markStudentAttendance(eveId, 3);
        testTutorial.markStudentAttendance(fionaId, 4);

        AttendanceList attendanceList = testTutorial.getAttendanceList();
        Attendance eveAttendance = attendanceList
                .getAttendancesByStudentName(
                        eveName).get(0); //EVE's attendance
        Attendance fionaAttendance = attendanceList
                .getAttendancesByStudentName(
                        fionaName).get(0); //EVE's attendance

        // Marked EVE's attendance for first 3 weeks
        // Marked FIONA's attendance for 4th week

        assertTrue(eveAttendance.getAttendanceList().get(0) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(1) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(2) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(3) == 0);

        assertTrue(fionaAttendance.getAttendanceList().get(0) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(1) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(2) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(3) == 1);

        // Unmarked EVE's attendance for 2nd weeks
        // Unmarked FIONA's attendance for 4th week

        testTutorial.unmarkStudentAttendance(eveId, 2);
        testTutorial.unmarkStudentAttendance(fionaId, 4);

        assertTrue(eveAttendance.getAttendanceList().get(0) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(1) == 0);
        assertTrue(eveAttendance.getAttendanceList().get(2) == 1);
        assertTrue(eveAttendance.getAttendanceList().get(3) == 0);

        assertTrue(fionaAttendance.getAttendanceList().get(0) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(1) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(2) == 0);
        assertTrue(fionaAttendance.getAttendanceList().get(3) == 0);
    }

    @Test
    public void addAndViewAndRemoveCommentTest() {
        Tutorial testTutorial = tutorialWithListTest();
        NusNetId eveId = TypicalStudents.EVE.getStudentId();
        Name eveName = TypicalStudents.EVE.getName();
        NusNetId fionaId = TypicalStudents.FIONA.getStudentId();
        Name fionaName = TypicalStudents.FIONA.getName();

        // Add comment for EVE and FIONA
        testTutorial.addComment(eveName, new Comment("Hardworking!"));
        testTutorial.addComment(fionaName, new Comment("Diligent!!"));

        assertEquals("Hardworking!", testTutorial.getAttendanceList()
                .getAttendancesByStudentName(eveName).get(0)
                .getComment().getCommentString());
        assertEquals("Diligent!!", testTutorial.getAttendanceList()
                .getAttendancesByStudentName(fionaName).get(0)
                .getComment().getCommentString());

        // Remove comment for FIONA

        testTutorial.removeComment(fionaName);

        assertEquals("Hardworking!", testTutorial.getAttendanceList()
                .getAttendancesByStudentName(eveName).get(0)
                .getComment().getCommentString());
        assertEquals("", testTutorial.getAttendanceList()
                .getAttendancesByStudentName(fionaName).get(0)
                .getComment().getCommentString());

        // View comments
        assertEquals("Hardworking!", testTutorial.viewComment(eveName).getCommentString());
        assertEquals("", testTutorial.viewComment(fionaName).getCommentString());
    }

    @Test
    public void tutorialSetStudentList() {
        Tutorial testTutorial = tutorialWithListTest();

        NusNetId eveId = TypicalStudents.EVE.getStudentId();
        NusNetId fionaId = TypicalStudents.FIONA.getStudentId();

        ObservableList<Person> personList = FXCollections.observableArrayList();
        personList.addAll(
                TypicalStudents.FIONA
        );
        FilteredList<Person> studentList = new FilteredList<Person>(personList, null);

        testTutorial.setStudentsList(studentList);
        assertTrue(testTutorial.getStudentsList().getStudentsInClass().size() == 1);
        assertFalse(testTutorial.containsStudentWithId(eveId));
        assertTrue(testTutorial.containsStudentWithId(fionaId));

    }

    @Test
    public void testStudentResultInTutorial() {
        Tutorial tutorial = new TutorialBuilder().withTutorialName("Test Class").build();
        AssessmentResults op1 = new AssessmentResults(OP1.getAssessmentName());
        AssessmentResults op2 = new AssessmentResults(OP2.getAssessmentName());
        tutorial.addAssessmentResults(op1);
        tutorial.addAssessmentResults(op2);
        ObservableList<Person> personObservableList = FXCollections.observableArrayList();
        personObservableList.add(JACK);
        personObservableList.add(JOHN);
        FilteredList<Person> personList = new FilteredList<Person>(personObservableList);
        tutorial.setStudentsList(personList);
        tutorial.addStudentResult(OP1.getAssessmentName(), E0123456);

        // gets correct assessment result
        assertTrue(tutorial.getAssessmentResult(OP1.getAssessmentName()).equals(op1));

        // has the correct student result
        assertTrue(tutorial.hasStudentResult(OP1.getAssessmentName(), E0123456.getStudentId()));

        // does not have student result as they are not added
        assertFalse(tutorial.hasStudentResult(OP2.getAssessmentName(), E0123456.getStudentId()));
        assertFalse(tutorial.hasStudentResult(OP1.getAssessmentName(), JACK.getStudentId()));
        assertFalse(tutorial.hasStudentResult(OP2.getAssessmentName(), JACK.getStudentId()));

        // does not have student in the tutorial
        assertThrows(StudentNotFoundException.class, (
            ) -> tutorial.hasStudentResult(OP1.getAssessmentName(), ALEX.getStudentId()));

    }

    @Test
    public void tutorialToString() {
        assertEquals("T01; Venue: LT15; Day: Wednesday; Time: 10:00; Weeks: 13", T01.toString());
        assertEquals("T02; Venue: LT16; Day: Thursday; Time: 11:00; Weeks: 13", T02.toString());
    }

}

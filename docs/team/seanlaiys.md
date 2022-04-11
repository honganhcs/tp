---
layout: page
title: Lai Yuen Sheng's Project Portfolio Page
---

### Project: camNUS
camNUS is a desktop app for Teaching Assistants (TAs) to manage assessments and class participation among students based on their contacts. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **Code contributed**:
  * See [here](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=seanlaiys&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **New Feature**: Viewing list of classes [#74](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/74), [#90](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/90)
  * What it does: Allows the TAs to see a list of classes they have added to camNUS along with the details of each class.
  * Justification: This feature is necessary because TAs will need to be able to see a list of classes in the application as they could add and remove classes. The list will also help them keep track of when and where their classes are, as they can view the details of each class in the displayed list.
  * Highlight: Aside from listing all the classes added by the TAs, the highlight of this feature is the ability to filter the list of classes by day. The TA will just have to key in an extra day field in the command input and they can see the list of classes they have on a particular day. As such, should the TA wish to plan his/her schedule for the day, he/she will not need to scroll through a long list of irrelevant details.

* **New Feature**: Viewing list of students [#79](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/79), [#92](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/92) 
  * What it does: Allows the TAs to see a full list of students added in camNUS or belonging to a specific class.
  * Justification: This feature is necessary because TAs will need to be able to see a list of students in the application as they could add, edit and remove students. The list will also help them keep track of the students they have added to camNUS and the class they are added to.
  * Highlight: Aside from just listing all the students added, the highlight of this feature is the ability to filter students by the class they belong to. The TA will just have to key in an extra tutorial name field or the index of the class(when the class list is displayed in the application) in their command input. As such, they can check whether they have added their students to the correct class and make use of the list to obtain the student's contact or email to contact them, without going through a long list of all students.

* **New Feature**: Viewing list of assessments [#93](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/93)
  * What it does: Allows the TAs to see the assessment components they have added in for the module they are teaching.
  * Justification: This feature is necessary because it enables the TA to see the assessment component he/she has added, such that they can keep track of the weightage and the full mark of each assessment component.

* **New Feature**: Viewing comments [#119](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/119)
  * What it does: Allows the TAs to see the comment they have added in for their student.
  * Justification: This feature is necessary because it enables the TA to see the comment he/she has added for a student as reference for any post admin duties, such as updating participation marks.

* **New Feature**: Viewing list of attendance [#110](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/110)
  * What it does: Allows the TAs to see an attendance list for them to keep track of their student's attendance as they use the mark and unmark feature of camNUS.
  * Justification: This feature is necessary because it enables the TA to see the attendance list in camNUS and make any changes if necessary. This list can also act as a list available for them to keep track of who in the class is present or absent each week.
  * Highlight: TAs can choose whether they wish to list the attendance by a specific student (for the whole semester) or by a specific class and tutorial week. This can be done by entering the required fields for them to view the attendance list of interest. For instance, if the TA wishes to view Student A's attendance for the semester, he/she could just input the student's ID and view student A's attendance in camNUS.

* **Enhancements to existing features**: Enhanced existing features to complement with new features added [#74](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/74)
  * What it does: Allows the TAs to see not just contacts, but also classes, comments for students, assessment results, assessment components, student contacts etc.
  * Justification: This feature is necessary as the existing address book could only display person contacts. Thus, enhancements had to be made to incorporate showing beyond person contacts.
  * Highlight: Implementing a `Displayable` interface allowed for different types of items to be displayed in the application, which helped future developments as more items are added for display. For instance, `Student`, `Attendance` and `StudentResult` etc. implement the `Displayable` interface so that their details could be displayed in the application. The use of enumerations, `DisplayType` also aided the implmentation as each of these items represent a different display type.
* **Enhancements to existing features**: Enhanced the UI with changes to the theme [#83](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/83)
  * What it does: Changes the theme to adopt the colours that represent NUS well, since camNUS is an application for NUS TAs.

* **Documentation**:
    * User Guide:
      * Added new features for viewing list of score, classes, students, attendance, and assessments [#40](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/40), [#64](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/64), [#93](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/93), [#100](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/100), [#110](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/110)
      * Updated Command Summary with new features [#40](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/40), [#209](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/209)
      * Updated Quick Start [#40](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/40)
      * Improved Introduction [#40](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/40)
      * Added all of the UI screenshots to aid understanding for some commands [#209](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/209)
    * Developer Guide:
      * Added new feature on displaying student with Sequence Diagram (Display Students Feature) [#100](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/100)
      * Updated UI Section [#252](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/252)
      * Updated UI Class Diagram [#100](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/100)
      * Updated Storage Class Diagram [#232](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/232)

* **Team-based tasks**:
  * Created GitHub Pages for the team's documentation for viewing online
  * Updated Ui.png for User Interface to be viewable in the tp Team List [#36](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/36)
  * Updated all Web Documents to adapt product name [#55](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/55)
  * Designed the mock UI which inspired the actual UI design later on [#36](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/36)
  * Updated ReadMe and added CodeCov badge [#36](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/36)

* **Review/Mentoring**:
  * Reviewed PRs of groupmates (e.g. [#80](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/80), [#107](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/107), [#118](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/118))
  * Aided team members in various occasions of debugging and helped team members with any UI-related queries

* **Beyond the project team**:
  * Reported bugs and suggestions for other teams (see [here](https://github.com/seanlaiys/ped/issues))

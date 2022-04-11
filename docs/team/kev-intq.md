---
layout: page
title: Quek Wenjie Kevin's Project Portfolio Page
---

### Project: camNUS
camNUS is a desktop app for Teaching Assistants (TAs) to manage assessments and class participation among students based on their contacts. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **New Feature**: Added the ability to add classes
  * What it does: Allows the user to add classes that contain the essential information about students.
  * Justification: Teaching assistants (TAs) may have multiple different classes and thus the students under the TA would need to be grouped into their according classes. This facilitates other operations on students, such as mass marking attendance for a class.
* **New Feature**: Added the ability to keep track, mark and unmark attendances
  * What it does: Allows the user to declare whether a student has attended the class for a particular week.
  * Justification: The module that the TA is teaching may require them to keep track of student attendance, either for grading or book-keeping purposes. This feature allows for attendances to be easily managed and viewed.
  * Highlight: The `MarkAttendanceCommand` and `UnmarkAttendanceCommand` responsible for related to this feature provides support for handling operations on a specific student, or all the students present in the specified `Tutorial` as well. This facilitates attendance marking in scenarios where the entire class is present and the TA can just mass mark the attendances with one input.
* **New Feature**: Added the ability to add comments for students
  * What it does: Allows the user to write down personal comments for each student.
  * Justification: The user may want to write down reminders or notes about a student for a particular week. This feature allows the user to quickly jot down comments for them.
  
* **Code contributed**: 
  * [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=w13&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=kev-intq&tabRepo=AY2122S2-CS2103T-W13-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)
  
* **Enhancements to existing features**: Enhanced help window
  * What it has changed: Instead of a help window providing the user to the user guide link, it now contains the full list of commands.
  * Justification: Some users may not have internet connectivity and may be unable to view the user guide link. Thus, a fully local guide containing the list of commands within the app is needed.
  * Highlights: Users are able to search through the list of commands in the enhanced help window.

* **Documentation**:
    * User Guide:
      * Added new features for viewing of help, and management of classes.
    * Developer Guide:
      * Added the implementation details of `HelpWindow` [#99](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/99)

* **Team-based tasks**:
  * Initialize the repository and base project with suitable settings and workflows
  * Setup code coverage for project
  * Managed release `v1.2.1`

* **Review/Mentoring**:
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/AY2122S2-CS2103T-T11-1/tp/issues/198) [2](https://github.com/AY2122S2-CS2103T-T11-1/tp/issues/185) [3](https://github.com/AY2122S2-CS2103T-T11-1/tp/issues/180))

  

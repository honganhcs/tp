---
layout: page
title: Gareth Koh Sheng's Project Portfolio Page
---

### Project: camNUS

camNUS is a desktop app for Teaching Assistants (TAs) to manage assessments and class participation among students based on their contacts. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **New Feature**: Added the ability to remove a `student` from camNUS
    * What it does: Allows users to `remove_student` from camNUS. This Replaces the existing `Student` contact with a 
`Person` contact, in the process removing details that are only relevant to a `Student`.
    * Justification: This feature is necessary for TAs to correct any mistakes they make when adding a student, be it 
  their student ID or their tutorial group.
    * Highlights: This feature was adapted to accommodate new features implemented later on, such as assessments. 
  Removing a student also removes all their assessment records from a tutorial group. Students that are removed do not 
  get deleted from camNUS immediately. This is to allow TAs to make changes to the student's details or to simply keep 
  in contact with them after the semester has ended. In addition, `remove_student` removes `student` tags automatically.
    * Pull request: [#86](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/86)


* **Code contributed**:
  * [RespoSense](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=garethkoh&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=zoom&zA=garethkoh&zR=AY2122S2-CS2103T-W13-2%2Ftp%5Bmaster%5D&zACS=106.41666666666667&zS=2022-02-18&zFS=garethkoh&zU=2022-04-08&zMG=false&zFTF=commit&zFGS=groupByRepos&zFR=false)


* **Project management**:
    * Attended weekly team meetings to update on progress and divide work among ourselves.


* **Enhancements to existing features**:
    * `edit` command now works for both `Student` and `Person`, previously editing a `Student` would result in data 
  relevant student data being lost. (Pull request: [#112](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/112))
    * `edit` command also adds and removes `student` tags automatically where appropriate.
    * `add` command ensures that a new person added does not have a `student` tag.
    * Student id, email and phone numbers are now unique, in addition to the previously unique Name field. 
  (Pull request: [#112](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/112))
    * Wrote test cases to increase code coverage:
      * RemoveStudentCommandTest, RemoveStudentCommandParserTest, AddStudentCommandTest, AddStudentCommandParserTest.
      * Pull request: [#235](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/235) 
      [#247](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/247)


* **Documentation**:
    * User Guide:
        * Wrote clarifying instructions in the introduction as well as some command instructions.
          (Pull request: [#124](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/124) [#224](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/224))
    * Developer Guide:
      * Added in user stories table (Pull request: [#65](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/65))
      * Wrote introduction (Pull request: [#68](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/68)) 
      * Added in the `remove_student` section (Pull request: [#108](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/108))


* **Team-based tasks**:
    * Released [v1.3](https://github.com/AY2122S2-CS2103T-W13-2/tp/releases/tag/v1.3) 


* **Review/Mentoring**:
    * Reviewed [sean's code](https://github.com/AY2122S2-CS2103T-W13-2/tp/pulls?q=is%3Apr+is%3Aclosed+author%3Aseanlaiys) 
    * Pull requests: [#90](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/90) [#92](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/92) [#93](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/93)
    

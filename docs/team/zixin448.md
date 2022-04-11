---
layout: page
title: Yong Zi Xin's Project Portfolio Page
---

### Project: camNUS

camNUS is a desktop app for Teaching Assistants (TAs) to manage assessments and class participation among students based on their contacts. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **New Feature**: Added the ability to add `Student` to tutorial
  * What it does: Allows the user to `add` `Student` to an existing tutorial. Replaces the original `Person` contact with a `Student` contact.
  * Justification: This feature is necessary for the app to function because Teaching Assistants (Target Audience) will have to be able to add `Student` into their class.
  * Highlights: This enhancement affects commands to be added in later phase of the project. It required an in-depth analysis of design alternatives. We finalised on the 
  implementation where all `Student` contacts will have to be created from an existing person contact. This helps to ensure that all `Student` are valid and when a TA removes `Student` from a class
  (e.g After the academic year ends), the TA will not lose the contact in camNUS. Some interesting parts of creating this feature at the earlier phase of the project was exploring storage 
  of a new `Student` type and displaying optional fields in the `Person` card.
  * Pull request: [#76](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/76)
  

* **New Feature**: Added the ability to find a `Person`/`Student` by prefix and partial keyword matching
  * What it does: Allows the user to `find` a `Person` or a `Student` by prefixes. The `findByPrefix` implementation allows for partial keyword matching.
  * Justification: This feature improves the product functionalities and user experience because it gives user the flexibility of searching for a contact 
  by specifying the field that they want to search for. Partial keyword matching makes the adapted find command less stringent.
  * Highlights: The implementation of this feature matches the respective field from the first character of each word in the field value. This is a slightly more complicated
  implementation process to achieve the standard of the usual partial finding features in already existing applications.
  * Credits: Adapted from the original Find Command in AB3.
  * Pull request: [#103](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/103)
    

* **Code contributed**:
  * [RepoSense](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=zixin448&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=zixin448&tabRepo=AY2122S2-CS2103T-W13-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)

* **Project management**:
  * NIL

* **Enhancements implemented to existing and new features**:
  * Updated Person card to change between `Person` and `Student` UI (Pull request)
  * Implemented storage for new `Assessment` and `Student` type (Pull request: [#82](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/82))
  * Made small enhancements to different features across the project (Pull request: [#70](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/70))
  * Wrote additional test for existing and new features to increase coverage by 3.47% *[To be updated by project submission]*
    * Test includes: AddClassCommandTest, AddClassCommandParserTest, AttendanceTest, CommentTest, NusNetIdTest
    * Test that will be completed by submission: DeleteClassCommandTest, DeleteClassCommandParserTest, FindByPrefixCommandTest, FindCommandParserTest, AttendanceListTest
    * Pull request: [#208](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/208) [#210](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/210)

* **Documentation**:
  * User Guide:
    * Added documentation for the features `addStudent` and `findByPrefix` (Pull request: [#121](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/121))
    * Did cosmetic tweaks to overall documentation to increase accuracy in documentation
  * Developer Guide:
    * Added documentation for the features `addStudent` (Pull request: [#101](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/101))
    * Added UML diagram for `addStudent` feature

* **Team-based tasks**:
  * Fix bugs from PE-D (Pull request: [#203](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/203) [#205](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/205) )

* **Review/Mentoring**:
  * PRs reviewed (Examples with non-trivial review comments: [1](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/67) [2](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/86) [3](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/207))
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/AY2122S2-CS2103T-T13-1/tp/issues/138) [2](https://github.com/AY2122S2-CS2103T-T13-1/tp/issues/142) [3](https://github.com/AY2122S2-CS2103T-T13-1/tp/issues/131))

* **Beyond the project team**:
  * to be added soon

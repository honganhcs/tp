---
layout: page
title: Nguyen Hong Anh's Project Portfolio Page
---

### Project: camNUS

camNUS is a desktop app for Teaching Assistants (TAs) to manage assessments and class participation among students based on their contacts. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

* **New Feature**: Adding assessments, [#71](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/71)
  * What it does: Allows the TA to add an assessment component of the module they are teaching to camNUS.
  * Justification: This feature is central to the app, which aims to make it easier for TAs to track and monitor their students' performance. It allows TAs to store information about the module's assessment components and subsequently add information about their students' performance in these assessments.
  * Highlight: TAs can add the weightage and full mark information for the assessment for bookkeeping.
* **New Feature**: Removing assessments, [#71](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/71)
    * What it does: Allows the TA to remove an assessment component and information about their students' performance in this component from the app.
    * Justification: This feature is essential as it allows TAs to remove any assessments that they have mistakenly added or no longer need.
    * Highlight: Apart from removing information about the assessment component itself, the feature also ensures that all information about the students' performance in this component is removed from the app.
* **New Feature**: Grading students, [#96](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/96), [#98](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/98)
  * What it does: Allows the TA to assign a score to a student in an assessment component.
  * Justification: This features fulfills one of the main aims of the application by allowing TAs to record and track their students' performance in assessments.
  * Highlight: TAs can add or edit a student's score using this command, instead of having to remember two separate commands. After the command is executed, the results list of the student's class in the given assessment is displayed to the TA, for easy viewing and analysis.

* **Code contributed**:
  * Added Assessment, Tutorial and Student related classes to the model component to support student, class and assessment related commands.
  * Added support for saving student results to the storage file.
  * Added Assessment-related command classes to the logic component.
  * Added tests for Assessment-related data, command and parser classes.
  * [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=honganhcs&tabRepo=AY2122S2-CS2103T-W13-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false)

* **Documentation**:
    * User Guide:
        * Added instructions for adding assessments, deleting assessments, grading students.
        * Standardized examples across features.
        * Fixed bugs in the UG.
    * Developer Guide:
        * Added explanations and UML diagrams for adding assessment feature.
        * Updated the description and class diagram for the model component.

* **Team-based tasks**:
    * Set up shared drive and meeting document for team.
    * Submitted [draft UG](https://docs.google.com/document/d/16ERljcK3FVKZoYPjeeGGxhsATdZVy5Z_H8_WfbaiqJA/edit#).
    * Opened [issues](https://github.com/AY2122S2-CS2103T-W13-2/tp/issues?q=is%3Aissue+is%3Aclosed+author%3Ahonganhcs) for features to be implemented.
    * Opened and closed milestone v1.2.
    * Created [v1.2 release](https://github.com/AY2122S2-CS2103T-W13-2/tp/releases/tag/v1.2).
    * Opened milestone v1.4.
    * [Enabled assertions](https://github.com/AY2122S2-CS2103T-W13-2/tp/pull/106/files) in build.gradle.
    * Examined the bugs reported by testers during PE dry-run and closed duplicate or irrelevant bug reports.

* **Review/Mentoring**:
  * Reviewed PRs thoroughly and provided comments regarding code logic, code quality, etc.
  * Suggested a PR review cycle for increased efficiency.
  * Access PRs reviewed [here](https://github.com/AY2122S2-CS2103T-W13-2/tp/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3Ahonganhcs).
  * Participated actively in discussions on the design of the model and implementation of commands during team meetings and in group chat.

* **Beyond the project team**:
  * Initiated a [discussion](https://github.com/nus-cs2103-AY2122S2/forum/issues/193) in the module forum on the design decision to make data classes immutable.

# Project Portfolio Page (vishnuvk47)

## Overview

Helped create a CLI-based application that acts like a banking app. Users can create accounts, deposit money, withdraw money, set save goal, set withdrawal limit, and view previous transactions with this application.

## Summary of Contributions

[Link to code contributed](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=vishnu&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&tabAuthor=vishnuvk47&tabRepo=AY2223S2-CS2113-T13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements implemented

* Created a createAccount method when the save file is empty [#31](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/31)

* Added a view-account feature [#39](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/39)

* Add a very simple help command [#44](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/44)

* I have developed a 'Save Goal' feature that empowers users to adhere to a frugal lifestyle by setting a minimum balance they wish to maintain. The system sends alerts to users when a withdrawal would result in them falling below their set save goal. Although this is not a strict limit, users have the flexibility to override the system's suggestions.
The development of the 'Save Goal' feature involved integrating the use of LocalDate and closely interacting with the withdrawal feature. This relates to both front end and back end as it needs to parse the user data stored in the save file (back end) and also interact with users via the UI to receive the relevant inputs and process them(front end). [#72](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/72)

Note: Features, UG and DG also had several significant contributions from my team mates as the program grew and evolved. We largely adopted a BFS approach

### UG contributions

Created a User Guide for the BankWithUs software/application, which included a rough template and details on the various features and their use cases. While working on the guide, I received significant assistance from my teammate, Tyuyang and xiaoge26, who helped me improve the guide's consistency and format to align with recommended guidelines. [#76](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/76)

### DG contributions

Templated the layout, wrote documentation for functionalities of the program for the DG.[#73](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/73) 

### Team-based tasks

* Set up the GitHub team org/repo
* Updated user/developer docs that are not specific to a feature e.g. documenting the target user profile
* Handled a significant number of issues that were reported in the PE-D.[#109](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/109)
* refactored the floats into Big Decimal to resolve overflow and precision issues.[#155](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/155)


### Review/Mentoring contributions

#### Links to PR reviewed (Most relevant ones are listed below):
* [#160](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/160())
* [#159](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/159)
* [#157](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/157)
* [#156](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/156)
* [#154](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/154)
* [#143](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/143)

#### Contributions beyond the project team

* [reported 14 bugs during the PE-D](https://github.com/vishnuvk47/ped/issues)
* Review other colleagues and teams codes, UG and DG during tutorial sessions


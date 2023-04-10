# Project Portfolio Page (tyuyang)

## Overview

Helped create a CLI-based application that acts like a banking app. Users can create accounts, deposit money, withdraw money, set save goal, set withdrawal limit, and view previous transactions with this application.

## Summary of Contributions

[Link to code contributed](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=T13-3&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&tabAuthor=tyuyang&tabRepo=AY2223S2-CS2113-T13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements implemented

Created the withdrawal limit feature ([#67](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/67), [#70](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/70), and [#71](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/71)). Since this feature required the tracking of withdrawals in a month, a separate feature that tracks how much money has been withdrawn in the current month had to be created. In addition, the use of LocalDate also had to be integrated into the feature, which adds to the complexity of this feature. This feature also heavily interacts with the withdraw feature, which meant that bugs that arose from integration needed to be prevented. In conclusion, this feature does not really have any bugs and works as expected in all tested situations.

Did some of the infrastructural work, such as the first iteration of the product ([#8](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/8)), the skeleton code for the load() function ([#21](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/21)), and the skeleton code for the run() function ([#29](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/29)). This allowed my teammates to start on their assigned features without having to worry about how classes interact with each other.

### UG contributions

Authored the withdrawal limit section. Worked with [vishnuvk47](https://github.com/vishnuvk47) to add examples of expected program behaviour.

### DG contributions

Created the puml diagrams for [main architecture](../diagrams/main_architecture.puml), [example sequence diagram](../diagrams/example_sequence_diagram.puml), [withdraw command](../diagrams/withdraw_seq_diagram.puml), [exceed withdrawal limit case](../diagrams/exceed_wl_seq_diagram.puml), and [fail save goal case](../diagrams/fail_save_goal_case_seq_diagram.puml).


### Team-based tasks

Helped in creating issues for the team to work on, especially at the start of the project. 

Did extensive bug testing for version 2.0 with [manushridiv](https://github.com/manushridiv) and published them as issues. Almost all of the functionality bugs found by others in the PED were already found before the PED with the exception of [issue #123](https://github.com/AY2223S2-CS2113-T13-3/tp/issues/123), [issue #114](https://github.com/AY2223S2-CS2113-T13-3/tp/issues/114) and [issue #127](https://github.com/AY2223S2-CS2113-T13-3/tp/issues/127). 

Helped restructure and clean up the code in [this PR](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/48). 


Reviewed and approved a significant number of PRs not authored by myself. Examples below:

[#31](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/31), [#34](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/34), [#39](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/39), [#40](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/40), [#42](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/42), [#57](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/57), [#72](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/72), [#74](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/74), [#101](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/101).

The rest of the pull requests are just LGTM reviews, so those are not included.

### Contributions beyond the project team

[Reported 18 bugs during the PE-D](https://github.com/tyuyang/ped/issues).

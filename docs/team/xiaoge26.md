# Project Portfolio Page (xiaoge26)

## Overview

Helped create a CLI-based application that acts like a banking app. Users can create accounts, deposit money, withdraw money, set save goal, set withdrawal limit, and view previous transactions with this application.

## Summary of Contributions

### Code contributed
[Link to code contributed](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=xiaoge26&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2023-02-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Enhancements implemented

I developed the add account and add deposit methods at the very early stage, which allows users to add a new deposit to the current account. 
I would like to thank all my teammates who have modified and improved these feature later to suit the evolved needs of the application. <br />
* Add Account Feature [#26](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/26)
  * Allows the user to add a new account
* Add Deposit Feature [#42](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/42)
  * Allows the user to add a new deposit to the current account 


I have also developed the features related to the `Transaction` and `TransactionList` classes, including adding, 
deleting, listing, parsing, saving, and loading the transactions. <br />
* Add and View Transaction Feature [#74](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/74)
  * `Transaction` class and `TransactionList` class store the transactions of the user <br />
  * `TransactionEncoder` and `TransactionDecoder` Classes help save and load the transaction data
  * Allows the transaction data to be automatically added to the `TransactionList` when the user adds a new transaction
  * Allows the user to view the transaction history of all the accounts
  * Allows the user to delete a transaction from the transaction history
* Delete Transaction Feature [#159](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/159) [#163](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/163)
  * Allow the user to delete a transaction from the transaction history
  * Automatically delete all the transactions of a particular account when the user deletes the account
### Contributions to the UG

* Documented `view-current`, `show-save-goal` and the features related to `Transaction` and `TransactionList` components in the User Guide <br />
* Fixed typos and bugs in the other sections in UG as well <br />

### Contributions to the DG

* Added 'Acknowledgements' 'Setting Up, Getting Started', 'Non-Functional Requirements' and 'Instructions for Manual Testing' with reference to 
[AddressBoook-Level3](https://se-education.org/addressbook-level3/DeveloperGuide.html) <br />
* Further modified the DG template and fixed the typos and standardized the format (Uppercase/lowercase issues, no full stop at the end of a bullet point etc.)


### Contributions to team-based tasks

* Helped in creating issues for the team to work on
* Updated User/Developer Guides that are not specific to a feature e.g. Non-Functional Requirements and Instructions for Manual Testing)
* Released v2.0 of the application
* Reviewed and approved a significant number of PRs not authored by myself
* Refactored the code to different packages
* Created milestones and assigned issues to them

### Review/mentoring contributions
#### Links to PRs reviewed
[#175](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/175)
[#156](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/156)
[#166](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/166)
[#98](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/98)
[#100](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/100)
[#71](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/71)
[#67](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/67)
[#58](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/58)
[#24](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/24)
[#158](https://github.com/AY2223S2-CS2113-T13-3/tp/pull/158)


### Contributions beyond the project team
* [Reported 12 bugs during the PE-D](https://github.com/xiaoge26/ped/issues)
* Developer Guide reviewed: [[CS2113-T14-2] BagPacker #61](https://github.com/nus-cs2113-AY2223S2/tp/pull/61/files/bf0684974cef3c42639ecce53b4a5ff60dec3a7a)

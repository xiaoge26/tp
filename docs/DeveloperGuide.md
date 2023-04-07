# Developer Guide

* [Acknowledgements](#acknowledgements)
* [Setting up, getting started](#setting-up-getting-started)
* [Design](#design)
    * [Architecture](#architecture)
    * [UI Component](#UI-Component)
    * [Parser Component](#parser-component)
    * [BankWithUs Component](#bankwithus-component)
    * [Account Component](#account-component)
    * [AccountList Component](#accountlist-component)
    * [SaveGoal Component](#saveGoal-component)
    * [Storage Component](#storage-component)
    * [Withdrawal Limit Component](#withdraw limit checker-Component)
    * [Transaction Component](#transaction-Component)
    * [TransactionList Component](#transactionlist-component)
* [Implementation](#implementation)
    * [Account Related Feature](#Account-feature)
    * [SaveGoal Related Feature](#SaveGoal-feature)
    * [Transaction Related Feature](#transaction-feature)

* [Appendix: Requirements](#appendix-requirements)
    * [Product Scope](#product-scope)
    * [Target User Profile](#target-user-profile)
    * [Value Proposition](#value-proposition)
    * [User Stories](#user-stories)
    * [Non-Functional Requirements](#non-functional-requirements)
    * [Glossary](#glossary)

---



## Acknowledgements
We adapted the structure of this document from the 
[AddressBook-Level3](https://se-education.org/addressbook-level3/DeveloperGuide.html) 
project created by the [SE-EDU initiative](https://se-education.org/).
We used the content from the above project for
the "Setting up, getting started" and "Non-Functional Requirements" sections in 
this document as well.


## Setting up, getting started
First, **fork** this repo, and **clone** the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):

1. **Configuring the JDK** to to ensure Intellij is configured to use JDK 11
2. **Import the project as a Gradle project** <br />
**Note**: Importing a Gradle project is slightly different from importing 
a normal Java project <br />
3. **Verify the setup**: <br />
* Run the `seedu/bankwithus/BankWithUs.java` and try a few commands. 
You may want to refer to our User Guide for the list of commands <br />
* Run the tests to ensure they all pass
---

## Design & implementation


### Design

### Architecture
<img src="images/MainArchitecture.png" width="280" /> <br />
The  Architecture Diagram given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Interactions**

The sequence diagram below shows how components interact with each other when the user issues the command `deposit 100`.

<img src="images/deposit100SeqDiagram.png" width="280" />


### UI-Component
Class: `Ui.java`

*  contains all code that interfaces directly with the CLI

### Parser-Component
Class: `Parser.java`

* determines what the program would do with the input retrieved from the CLI

### Account-Component
Class: `Account.java`

The `Account` component:

* contains `name`, `balance`, `saveGoal`, `withdrawChecker` attribute
* stores and manages all the account details that pertains to one account

### AccountList-Component

Class: `AccountList.java`

The `AccountList` component:

* contains an `ArrayList<Accounts>` named `accountList` that contains the various different accounts that the user has.
* `accountList` is used to navigate between accounts for the switch-to feature
* when a new account is created it is appended to the `accountList` array

### BankWithUs-Component
Class: `BankWithUs.java`

The `BankWithUs` component:

* The Main Class
* the whole program executes through the `BankWithUs` class

### SaveGoal-Component
Class: `SaveGoal.java`

The `SaveGoal` component:

* Allows users to add a savings goal
* allows users to add a deadline to the savings goal

### Storage-Component
Class: `Storage.java`

The `Storage` component:

* Handles storing data in the save files and also loading data, if any, when program opens

### Withdraw-Limit-Checker-Component
Class: `WithdrawalChecker.java`
* Checks if the user has exceeded the withdrawal limit
* Shows the current withdrawal limit and the total amount of money withdrawn in the current month


### Transaction-Component
Class: `Transaction.java`

The `Transaction` component:

* Stores the details of a transaction

### TransactionList-Component
Class: `TransactionList.java`

The `TransactionList` component:
* Contains an ArrayList<Transaction> 
that contains the various different transactions that the user has
* Contains methods to add, delete and view transactions

---

## Implementation
* [Account related Feature](#account-feature)
* [SaveGoal related Feature](#savegoal-feature)
* [Transaction Related Feature](#transaction-feature)

---

## Non-Functional Requirements

1. The application should work on any mainstream OS as long as it has Java 11 installed.
2. A user with above average typing speed for regular English text
   should be able to accomplish most of the tasks faster using commands than using the mouse.

## Glossary

* *Mainstream OS*: Windows, Linux, Unix, OS-X

## Appendix: Requirements

### Product scope

BankWithUs is a powerful and user-friendly CLI-based banking system 
that provides users with an easy and quick way to manage their financial 
transactions and budget accordingly. With its wide range of features and 
easy-to-use command syntax, BankWithUs makes it simple for users to manage their finances on the go.


### Target user profile

The target audience for the command line-based Banking System is individuals who value 
efficiency and simplicity in their financial management. This group includes students, 
freelancers, and small business owners who are looking for a fast and straightforward way to manage their finances.


### Value proposition

Fast typers may benefit more from the CLI 
version of the banking system as it allows for 
quick navigation and interaction with the system using keyboard shortcuts. 
This can lead to a faster and more efficient workflow compared to using a graphical user interface (GUI), 
which may require more clicks and navigation. Additionally, fast typers may prefer the simplicity and 
minimalism of a CLI interface, as it provides only the essential information and features needed to manage their finances.


### User Stories

| Version | As a ... | I want to ...                         | So that I can ...                                                                       |
|---------|----------|---------------------------------------|-----------------------------------------------------------------------------------------|
| v1.0    | user     | Add deposits                          | so that I can check my financial status                                                 |
| v1.0    | user     | Withdraw money                        | so that i can see the effect of my spending on balance                                  |
| v1.0    | user     | view account                          | so that i can keep track of my minimum balance                                          |
| v2.0    | user     | add a withdrawal limit                | so that i can be forced to maintain a frugal habit                                      |
| v2.0    | user     | add a savings goal                    | so that i can keep track of my spending  in tandem with my savings goal                 |
| v2.0    | user     | add a new account                     | so that i can categorise my accounts and manage financial better                        |
| v2.0    | user     | switch account                        | so that i can navigate between the various accounts i have and keep track of financials |
| v2.0    | user     | list all the command that can be used | so that i can have a basic overview of the apps functionalities                         |
| v2.1    | user     | delete transaction records            | so that i can get rid of trivial transaction records                                    |




## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

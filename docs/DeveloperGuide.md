# Developer Guide

* [Acknowledgements](#acknowledgements)
* [Setting Up, Getting Started](#setting-up-getting-started)
* [Design & Implementation](#design-and-implementation)
    * [Architecture](#architecture)
    * [UI Component](#UI-Component)
    * [Parser Component](#parser-component)
    * [BankWithUs Component](#bankwithus-component)
    * [Account Component](#account-component)
    * [AccountList Component](#accountlist-component)
    * [SaveGoal Component](#saveGoal-component)
    * [Storage Component](#storage-component)
    * [Withdrawal Limit Component](#withdraw-limit-checker-Component)
    * [Transaction Component](#transaction-component)
    * [TransactionList Component](#transactionlist-component)

* [Appendix](#appendix)
    * [Product Scope](#product-scope)
    * [Target User Profile](#target-user-profile)
    * [Value Proposition](#value-proposition)
    * [User Stories](#user-stories)
    * [Non-Functional Requirements](#non-functional-requirements)
    * [Glossary](#glossary)
    * [Instructions for Manual Testing](#instructions-for-manual-testing)

---



## Acknowledgements
We adapted the structure of this document from the 
[AddressBook-Level3](https://se-education.org/addressbook-level3/DeveloperGuide.html) 
project created by the [SE-EDU initiative](https://se-education.org/). <br />
We used the content from the above project for
the "Setting Up, Getting Started" and "Non-Functional Requirements" sections in 
this document as well.


## Setting up, getting started
First, **fork** this repo, and **clone** the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):

1. **Configure the JDK**: Follow the guide 
[_[se-edu/guides] IDEA: Configuring the JDK_](https://se-education.org/guides/tutorials/intellijJdk.html) to ensure Intellij is configured to use JDK 11
2. **Import the project as a Gradle project**: 
Follow the guide [_[se-edu/guides] IDEA: Importing a Gradle project_](https://se-education.org/guides/tutorials/intellijImportGradleProject.html) 
to import the project into IDEA.  <br />
❗ Note: Importing a Gradle project is slightly different from importing 
a normal Java project <br />
3. **Verify the setup**:
* Run the `seedu/bankwithus/BankWithUs.java` and try a few commands. 
You may want to refer to our User Guide for the list of commands <br />
* Run the tests to ensure they all pass
---

## Design and Implementation

### Architecture
<img src="images/MainArchitecture.png" width="280" /> <br />
The  Architecture Diagram given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Interactions**

The sequence diagram below shows how components interact with each other when the user issues the command `deposit 100`.

<img src="images/deposit100SeqDiagram.png" width="280" />


### UI-Component
Class: `Ui.java`

*  Contains all code that interfaces directly with the CLI

### Parser-Component
Class: `Parser.java`

* Determines what the program would do with the input retrieved from the CLI

### Account-Component
Class: `Account.java`

The `Account` component:

* Contains `name`, `balance`, `saveGoal`, `withdrawChecker` attribute
* Stores and manages all the account details that pertains to one account

### AccountList-Component

Class: `AccountList.java`

The `AccountList` component:

* Contains an `ArrayList<Accounts>` named `accountList` that contains the various 
different accounts that the user has
* The `accountList` is used to navigate between accounts for the switch-to feature
* When a new account is created it is appended to `accountList` 

### BankWithUs-Component
Class: `BankWithUs.java`

The `BankWithUs` component:

* The Main Class
* The whole program executes through the `BankWithUs` class

### SaveGoal-Component
Class: `SaveGoal.java`

The `SaveGoal` component:

* Allows users to add a savings goal
* Allows users to add a deadline to the savings goal

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

# Implementation

## Command: `help`

* If a user command begins with help, it will call a method in the UI class to print the help screen.
* Feature with the most basic implementation

## Command: `view-account` :

**Step 1**:

--> Calls `getAllAccountDetails()` method from the AccountList class. 

--> The `getAllAccountDetails()` method parses the `ArrayList<Account>` from the AccountLits class

--> This builds a String where each Account is separated by a newline character and the attributes of an Account is separated by `;`

**Step 2**:

--> This string is then passed to the `viewAccount()` class in UI, where the string is decoded and print to screen

--> Identifies attributes that belong to a particular user by splitting the string based on a new line

--> The relevant attributes(Name, balance) of the account can ge identified by separating the string again by `;` and accessing index 0 and 1 respectively

## Command: `withdraw` :

**Step 1**:

--> Checks the args(AMOUNT to withdraw) for a negative sign in the `checkNegative()` method

**Step 2**:

--> Calls the `withdrawMoney` method in the AccountList class

--> Checks if the AMOUNT entered is empty, number of decimal places(accepts only 2 d.p) and checks if the AMOUNT to be withdrawn is less than or equal to the available balance

**Step 3**:

--> Checks if the AMOUNT to withdraw exceeds the set withdrawal limit, if any, in the `willExceedWithdrawalLimit` method of the withdrawalChecker class

**Step 4**:

--> Checks if the AMOUNT to withdraw will cause the user to default on their set savings goal; though, users can proceed at their own discretion

**Step 5**:

--> If it passes all the above checks or if the users decide to continue despite defaulting on save goal then it will call the `subtractBalance` method in the Account class

--> The `subtractBalance` will deduct the AMOUNT withdrawn from the users balance

Note: Withdrawal will be cancelled if it fails to meet withdrawal limit or if users choose to meet savings goal 

**Step 6**:

--> New balance is displayed to the user via the `showBal()` method from AccountList class that makes use of the UI class' method to print to screen

## Command: `add-account`:

**Step 1**:

--> Calls the `createNewAccount` method in AccountList class

**Step 2**:

--> The `createNewAccount` request from the user via the interface for their username(name) and password

--> The method will continuously prompt users to enter a unique name, if a unique one wasnt already provided

**Step 3**:

--> Based on the name and balance provided, a new account is created via the `addAccount` method

**Step 4**:

--> Add account creates a new instance of an Account class with the specified attributes and appends to the current ArrayList

## Command: `deposit`:

**Step 1**:

--> Checks the args(AMOUNT to deposit) for a negative sign in the `checkNegative()` method

**Step 2**:

--> Calls the `depositMoney` method in the AccountList class

--> Checks if the AMOUNT entered is empty, number of decimal places(accepts only 2 d.p) 

**Step 3**:

--> inside the `depositMoney` method, once it passes all the checks will call the `addBalance` method from the Account class to increment the balance as appropriate

## Command: `set-save-goal`:

**Step 1**:

--> Checks the args(minimum AMOUNT to save in balance) for a negative sign in the `checkNegative()` method

**Step 2**:

--> If the AMOUNT to save is not empty then it request the user to enter a deadline for their savings goal

--> The parser then calls the `handleSaveGoal` method from the AccountList class

**Step 3**:

--> Checks if the date format entered complies with the dd-MM-yyyy format in the `isDateFormatValid` method in AccountList class

--> If data entered matches the specified formats, then it will call the `setSaveGoal` method from the Account class which will set the relevant Save goal for the main account

## Command: `show-save-goal`:

**step 1**:

--> Calls the `showGoal` method in the AccountList class which then prints the Save Goal attributes to the UI, if save goal amount is greater than 0

## Command: `switch-to`

**step 1**:

--> Calls the `switchMainAccount` method from teh AccountList class with the NAME of the account to switch into.

--> If that account is found the method uses the `swap` method from `Collections` to swap the account that matches the NAME into index 0

## Command: `delete`

**step 1**:

--> Calls the `deleteAccount` method from AccountList

--> This find the index of the account that matches the NAME of the account to be deleted and removes it from the ArrayList

---


## Appendix

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

People who can type fast may benefit more from the CLI 
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


## Non-Functional Requirements

1. The application should work on any mainstream OS as long as it has Java 11 installed.
2. A user with above average typing speed for regular English text
   should be able to accomplish most of the tasks faster using commands than using the mouse.

## Glossary

* *Mainstream OS*: Windows, Linux, Unix, OS-X
*  *CLI*: Command Line Interface <br />
Some Operating Systems and their respective CLIs are listed below: <br />
Windows: Command Prompt <br />
   Linux: Linux Bash Shell <br />
   MacOs: Mac Terminal <br />

## Instructions for manual testing
### Launch
1. Ensure you have Java 11 installed in your Computer
2. Download the latest release `BankWithUs.jar` from here
3. Copy the file to the folder you want to use as the home folder for BankWithUs
4. Open a command terminal, cd into the folder you put the `BankWithUs.jar` file in, and use `java -jar BankWithUs.jar` 
command to run the application. A CLI should appear in a few seconds

### Sample Test Cases
Please refer to the Features section in our [UserGuide](UserGuide.md) for more details on the test cases
that you can try out.
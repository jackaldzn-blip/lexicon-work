# Simple Contact App — Manual Testing

No JUnit or extra libraries are needed. Run `ContactApp.java`, test the menu as a group, and mark each result only after it is observed.

## Before testing

From the project root in PowerShell:

```powershell
javac -d out src/main/java/se/lexicon/ContactApp.java
java -cp out se.lexicon.ContactApp
```

The contacts exist only while the application is running. Restart the app to get an empty contact list. (Saving to a file is not part of our chosen challenge.)

## Test checklist

| # | Action | Expected result | Pass / Fail | Tester |
|---|---|---|---|---|
| 1 | Option 1: add Anna / 0701111111 / anna@example.com | `Contact added!` | | |
| 2 | Option 2: view contacts | Anna, phone and email shown | | |
| 3 | Option 3: search for `ann` | Anna shown (partial, case-insensitive match) | | |
| 4 | Option 3: search for `999` | `No contacts found.` | | |
| 5 | Option 1: add a different contact using 0701111111 | `That phone number already exists.` | | |
| 6 | Option 1: leave name blank, provide a phone | `Name and phone are required.` | | |
| 7 | Option 4: update 0701111111, change name to Maria, press Enter for unchanged fields | `Contact updated!`; viewing shows Maria | | |
| 8 | Option 4: update an unknown phone | `Contact not found.` | | |
| 9 | Option 5: delete 0701111111 | `Contact deleted!`; Maria no longer appears | | |
| 10 | Option 5: delete same phone again | `Contact not found.` | | |
| 11 | Option 1: add Zara / 0702222222, anna / 0703333333, Omar / 0704444444, then option 6 | Displayed in order: anna, Omar, Zara | | |
| 12 | Option 2 after sorting (before any other changes) | Shows original insertion order, not sorted order | | |
| 13 | Enter `9` at the main menu | `Please choose a valid option.`; returns to menu | | |
| 14 | Option 0 | Prints `Goodbye!` and exits | | |

**Note:** If reusing the same application session, follow the above cases in order. For other experiments, restart to clear the list. Phone numbers are text; entering a zero at the start must preserve it.

## If a test fails

1. Record the test number and what happened.
2. Tell the teammate responsible for that method.
3. Fix only that method or its helper.
4. Rerun the failed test and any related tests.
5. In the final report, describe the real issue and correction.

## Group responsibilities

- Member 3: test add and duplicate-phone validation.
- Member 4: test view and search.
- Member 5: test update and delete.
- Member 6: lead the checklist and test sorting.
- Member 2: test contact fields and displayed output.
- Coordinator: run the full final demonstration and record overall outcomes.

## Final report sentence (complete only after real testing)

> We tested the application through the console using normal and invalid inputs. We checked adding, viewing, searching, updating, deleting, and alphabetical sorting. Our checklist recorded ___ passed tests and ___ failed tests. We fixed the following problems: ___.

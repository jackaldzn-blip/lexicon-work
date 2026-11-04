# Contact Management Workshop — Start Here

We are building **one small console application** in `src/main/java/se/lexicon/ContactApp.java`.

## Our first 5 minutes
1. Open `ContactApp.java` in IntelliJ.
2. Locate `main`, `showMenu`, and the `ArrayList`.
3. Run the program. Enter `0` to exit.
4. Run it again. Add one contact with `1`.
5. Display that contact with `2`.

Only after this works should we explain and try search (`3`), update (`4`), and delete (`5`).

## Roles — take turns at the keyboard
- Coordinator (Member 1): lead discussion, menu, GitHub, and actual final report.
- Member 2: explain/write the nested `Contact` class.
- Member 3: add contact and ensure phone numbers are unique.
- Member 4: view and search contacts.
- Member 5: update and delete contacts.
- Member 6: sorting challenge, test real inputs and report results.

## Required rules
Name and phone cannot be empty. Phone numbers must be unique. A missing contact should not crash the application. Email can be blank.

## Challenge 1 — sorting
Implement menu option `6` in a separate Git branch (`feature/sort-contacts`), as the trainer requests. The provided file contains the final example implementation. For a genuine workshop, complete and commit the core first, then have Member 6 implement sorting on the challenge branch and merge it after review.

## Run from the project root

```powershell
javac -d out src/main/java/se/lexicon/ContactApp.java
java -cp out se.lexicon.ContactApp
```

## Quick manual test
Add `Zara / 0701111111`, `anna / 0702222222`, `Omar / 0703333333`; view and search them. Try adding a duplicate phone; update and delete a contact. Finally, option `6` should display anna, Omar, Zara alphabetically.

## Report notes
Record what every person **actually** did: discussion decisions, code they wrote/explained, tests performed, issues and fixes, and relevant Git commits. Do not claim contributions before they happen.

## Testing
We use a manual test checklist, not JUnit. See `TESTING.md`. Test each feature after implementing it; mark passed or failed only after checking the real console result.

# Workshop: Algorithm and Flowchart

For each question in this workshop, you must complete **two** things:

1. **Write the pseudocode**
2. **Draw the flowchart** using either
   - **Option 1:** Draw.io (recommended)
   - **Option 2 (optional):** Mermaid flowchart directly in Markdown
   - **Option 3 (optional):** Any other valid method

---

## 1. Check Even or Odd Number

Design an algorithm and flowchart that take a number as input and determine whether it is even or odd.

### ✔ Pseudocode

```text
START
    INPUT number

    IF number % 2 == 0 THEN
        PRINT "Even"
    ELSE
        PRINT "Odd"
    ENDIF
END
```

### ✔ Flowchart

```mermaid
flowchart TD
    A([Start]) --> B[/Input number/]
    B --> C{number % 2 == 0?}
    C -->|Yes| D[/Display Even/]
    C -->|No| E[/Display Odd/]
    D --> F([End])
    E --> F
```

---

## 2. Calculate Total and Average Marks

Write the algorithm and draw the flowchart for a program that inputs marks for 3 subjects, calculates the total and average, and displays both.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT mark1
    INPUT mark2
    INPUT mark3

    total = mark1 + mark2 + mark3
    average = total / 3

    PRINT total
    PRINT average
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input mark1, mark2, mark3"/]
  n3["total = mark1 + mark2 + mark3"]
  n4["average = total / 3"]
  n5[/"Display total and average"/]
  n6(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n4 --> n5
  n5 --> n6

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#f8fafc,stroke:#94a3b8,color:#172033
  class n1,n6 ds1
  class n2,n5 ds2
  class n3,n4 ds3
```

---

## 3. Display Multiplication Table

Create an algorithm and flowchart that input a number and display its multiplication table from 1 to 10 using a loop.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT number

    FOR i = 1 TO 10
        result = number * i
        PRINT number × i = result
    ENDFOR
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input number"/]
  n3["i = 1"]
  n4{"i <= 10?"}
  n5["result = number * i"]
  n6[/"Display number × i = result"/]
  n7["i = i + 1"]
  n8(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n4 -->|Yes| n5
  n5 --> n6
  n6 --> n7
  n7 --> n4
  n4 -->|No| n8

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#f8fafc,stroke:#94a3b8,color:#172033
  classDef ds4 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  class n1,n8 ds1
  class n2,n6 ds2
  class n3,n5,n7 ds3
  class n4 ds4
```

---

## 4. Positive, Negative, or Zero Check

Write the algorithm and flowchart to input a number and display whether it is positive, negative, or zero.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT number

    IF number > 0 THEN
        PRINT "Positive"
    ELSE IF number < 0 THEN
        PRINT "Negative"
    ELSE
        PRINT "Zero"
    ENDIF
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input number"/]
  n3{"number > 0?"}
  n4[/"Display Positive"/]
  n5{"number < 0?"}
  n6[/"Display Negative"/]
  n7[/"Display Zero"/]
  n8(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n3 -->|No| n5
  n5 -->|Yes| n6
  n5 -->|No| n7
  n4 --> n8
  n6 --> n8
  n7 --> n8

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  class n1,n8 ds1
  class n2,n4,n6,n7 ds2
  class n3,n5 ds3
```

---

## 5. Simple Interest Calculator

Create an algorithm and flowchart for a program that calculates simple interest using the formula:

**SI = (P × R × T) / 100**

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT P
    INPUT R
    INPUT T

    SI = (P * R * T) / 100

    PRINT SI
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input P, R, T"/]
  n3["SI = P * R * T / 100"]
  n4[/"Display SI"/]
  n5(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n4 --> n5

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#f8fafc,stroke:#94a3b8,color:#172033
  class n1,n5 ds1
  class n2,n4 ds2
  class n3 ds3
```

---

## 6. Average Temperature Calculation

Write the algorithm and draw the flowchart for a program that takes the temperature of 7 days, finds the average temperature, and displays it.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    total = 0

    FOR day = 1 TO 7
        INPUT temperature
        total = total + temperature
    ENDFOR

    average = total / 7
    PRINT average
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2["total = 0"]
  n3["day = 1"]
  n4{"day <= 7?"}
  n5[/"Input temperature"/]
  n6["total = total + temperature"]
  n7["day = day + 1"]
  n8["average = total / 7"]
  n9[/"Display average"/]
  n10(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n4 -->|Yes| n5
  n5 --> n6
  n6 --> n7
  n7 --> n4
  n4 -->|No| n8
  n8 --> n9
  n9 --> n10

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#f8fafc,stroke:#94a3b8,color:#172033
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  classDef ds4 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  class n1,n10 ds1
  class n2,n3,n6,n7,n8 ds2
  class n4 ds3
  class n5,n9 ds4
```

---

## 7. Calculate Area of a Rectangle

Create an algorithm and flowchart to input length and width, calculate the area (**Area = Length × Width**), and display the result.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT length
    INPUT width

    area = length * width

    PRINT area
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"basis","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input length and width"/]
  n3["area = length * width"]
  n4[/"Display area"/]
  n5(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n4 --> n5

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d,stroke-width:1px,font-size:14px,font-weight:400
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c,stroke-width:1px,font-size:14px,font-weight:400
  classDef ds3 fill:#f8fafc,stroke:#94a3b8,color:#172033,stroke-width:1px,font-size:14px,font-weight:400
  class n1,n5 ds1
  class n2,n4 ds2
  class n3 ds3
```

---

## 8. Determine Pass or Fail

Write the algorithm and draw the flowchart for a program that takes a student's average marks and displays **"Pass"** if average ≥ 50, otherwise **"Fail"**.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT average

    IF average >= 50 THEN
        PRINT "Pass"
    ELSE
        PRINT "Fail"
    ENDIF
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input average"/]
  n3{"average >= 50?"}
  n4[/"Display Pass"/]
  n5[/"Display Fail"/]
  n6(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n3 -->|No| n5
  n4 --> n6
  n5 --> n6

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  class n1,n6 ds1
  class n2,n4,n5 ds2
  class n3 ds3
```

---

## 9. Calculate Factorial of a Number

Write the algorithm and draw the flowchart that input a number and calculate its factorial using a loop.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT number
    factorial = 1

    FOR i = 1 TO number
        factorial = factorial * i
    ENDFOR

    PRINT factorial
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input number"/]
  n3["factorial = 1"]
  n4["i = 1"]
  n5{"i <= number?"}
  n6["factorial = factorial * i"]
  n7["i = i + 1"]
  n8[/"Display factorial"/]
  n9(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n7 --> n5
  n4 --> n5
  n5 -->|Yes| n6
  n6 --> n7
  n5 -->|No| n8
  n8 --> n9

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#f8fafc,stroke:#94a3b8,color:#172033
  classDef ds4 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  class n1,n9 ds1
  class n2,n8 ds2
  class n3,n4,n6,n7 ds3
  class n5 ds4
```

---

## 10. Calculate Discount on Purchase

Write the algorithm and draw the flowchart for a program that inputs the purchase amount and gives a **10% discount** if the amount is greater than 1000.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT amount

    IF amount > 1000 THEN
        discount = amount * 0.10
    ELSE
        discount = 0
    ENDIF

    finalAmount = amount - discount

    PRINT discount
    PRINT finalAmount
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input purchase amount"/]
  n3{"amount > 1000?"}
  n4["discount = amount * 0.10"]
  n5["discount = 0"]
  n6["finalAmount = amount - discount"]
  n7[/"Display discount and final amount"/]
  n8(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n3 -->|No| n5
  n4 --> n6
  n5 --> n6
  n6 --> n7
  n7 --> n8

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  classDef ds4 fill:#f8fafc,stroke:#94a3b8,color:#172033
  class n1,n8 ds1
  class n2,n7 ds2
  class n3 ds3
  class n4,n5,n6 ds4
```

---

# Optional Exercises

## 11. Online Shopping Delivery Eligibility

Write the algorithm and draw the flowchart for a program that inputs a customer's purchase amount and displays **"Free Delivery"** if the amount is 500 SEK or more; otherwise display **"Delivery Charge Applies"**.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT amount

    IF amount >= 500 THEN
        PRINT "Free Delivery"
    ELSE
        PRINT "Delivery Charge Applies"
    ENDIF
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input purchase amount"/]
  n3{"amount >= 500?"}
  n4[/"Display Free Delivery"/]
  n5[/"Display Delivery Charge Applies"/]
  n6(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n3 -->|No| n5
  n4 --> n6
  n5 --> n6

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  class n1,n6 ds1
  class n2,n4,n5 ds2
  class n3 ds3
```

---

## 12. Employee Salary and Bonus Calculator

Write the algorithm and draw the flowchart for a program that inputs an employee's monthly salary and years of service, calculates a bonus of **10%** for employees with 5 or more years of service and **5%** for others, then displays the bonus and total salary.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT salary
    INPUT yearsOfService

    IF yearsOfService >= 5 THEN
        bonus = salary * 0.10
    ELSE
        bonus = salary * 0.05
    ENDIF

    totalSalary = salary + bonus

    PRINT bonus
    PRINT totalSalary
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input salary and years of service"/]
  n3{"years of service >= 5?"}
  n4["bonus = salary * 0.10"]
  n5["bonus = salary * 0.05"]
  n6["totalSalary = salary + bonus"]
  n7[/"Display bonus and total salary"/]
  n8(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n3 -->|No| n5
  n4 --> n6
  n5 --> n6
  n6 --> n7
  n7 --> n8

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  classDef ds4 fill:#f8fafc,stroke:#94a3b8,color:#172033
  class n1,n8 ds1
  class n2,n7 ds2
  class n3 ds3
  class n4,n5,n6 ds4
```

---

## 13. Mobile Data Usage Monitor

Write the algorithm and draw the flowchart for a program that inputs a user's monthly data limit and data usage, then displays whether the user has exceeded the limit or how much data remains.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT dataLimit
    INPUT dataUsage

    IF dataUsage > dataLimit THEN
        exceeded = dataUsage - dataLimit
        PRINT "Limit exceeded by", exceeded
    ELSE
        remaining = dataLimit - dataUsage
        PRINT "Data remaining", remaining
    ENDIF
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input data limit and data usage"/]
  n3{"data usage > data limit?"}
  n4["exceeded = data usage - data limit"]
  n5[/"Display limit exceeded and exceeded amount"/]
  n6["remaining = data limit - data usage"]
  n7[/"Display data remaining"/]
  n8(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n4 --> n5
  n3 -->|No| n6
  n6 --> n7
  n5 --> n8
  n7 --> n8

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  classDef ds4 fill:#f8fafc,stroke:#94a3b8,color:#172033
  class n1,n8 ds1
  class n2,n5,n7 ds2
  class n3 ds3
  class n4,n6 ds4
```

---

## 14. Login System (Maximum 3 Attempts)

Create an algorithm and flowchart for a login system that allows a user up to 3 attempts to enter the correct password. Display **"Access Granted"** if the password is correct; otherwise display **"Account Locked"** after 3 failed attempts.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    correctPassword = "1234"
    attempts = 0

    WHILE attempts < 3
        INPUT password

        IF password = correctPassword THEN
            PRINT "Access Granted"
            STOP
        ELSE
            attempts = attempts + 1
        ENDIF
    ENDWHILE

    PRINT "Account Locked"
END
```

### Mermaid Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2["correctPassword = 1234"]
  n3["attempts = 0"]
  n4{"attempts < 3?"}
  n5[/"Input password"/]
  n6{"password =<br/>correctPassword?"}
  n7[/"Display Access Granted"/]
  n8(["End"])
  n9["attempts = attempts + 1"]
  n10[/"Display Account Locked"/]
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n4 -->|Yes| n5
  n5 --> n6
  n6 -->|Yes| n7
  n7 --> n8
  n6 -->|No| n9
  n9 --> n4
  n4 -->|No| n10
  n10 --> n8

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#f8fafc,stroke:#94a3b8,color:#172033
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  classDef ds4 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  class n1,n8 ds1
  class n2,n3,n9 ds2
  class n4,n6 ds3
  class n5,n7,n10 ds4
```

---

## 15. Store Checkout with Multiple Items

Write the algorithm and draw the flowchart for a program that inputs the number of items purchased, calculates the total purchase amount using a loop, and applies a **15% discount** if the total exceeds 5000 SEK.

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT numberOfItems
    total = 0

    FOR i = 1 TO numberOfItems
        INPUT price
        total = total + price
    ENDFOR

    IF total > 5000 THEN
        discount = total * 0.15
        total = total - discount
    ENDIF

    PRINT total
END
```

### <span style="color: #22c55e;">✔</span> Mermaid Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input number of items"/]
  n3["total = 0"]
  n4["i = 1"]
  n5{"i <= number of items?"}
  n6[/"Input item price"/]
  n7["total = total + price"]
  n8["i = i + 1"]
  n9{"total > 5000?"}
  n10["discount = total * 0.15"]
  n11["total = total - discount"]
  n12[/"Display total"/]
  n13(["End"])
  n1 --> n2
  n2 --> n3
  n3 --> n4
  n8 --> n5
  n4 --> n5
  n5 -->|Yes| n6
  n6 --> n7
  n7 --> n8
  n5 -->|No| n9
  n9 -->|Yes| n10
  n10 --> n11
  n11 --> n12
  n9 -->|No| n12
  n12 --> n13

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#f8fafc,stroke:#94a3b8,color:#172033
  classDef ds4 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  class n1,n13 ds1
  class n2,n6,n12 ds2
  class n3,n4,n7,n8,n10,n11 ds3
  class n5,n9 ds4
```

---

## 16. Electricity Bill Calculator

Write the algorithm and draw the flowchart for a program that inputs the number of electricity units consumed and calculates the total bill using the following rates:

- First 100 units: **1.5 SEK per unit**
- Next 200 units: **2.0 SEK per unit**
- Remaining units: **3.0 SEK per unit**

### <span style="color: #22c55e;">✔</span> Pseudocode

```text
START
    INPUT units

    IF units <= 100 THEN
        bill = units * 1.5

    ELSE IF units <= 300 THEN
        bill = 100 * 1.5
        bill = bill + (units - 100) * 2.0

    ELSE
        bill = 100 * 1.5
        bill = bill + 200 * 2.0
        bill = bill + (units - 300) * 3.0
    ENDIF

    PRINT bill
END
```

### <span style="color: #22c55e;">✔</span> Flowchart

```mermaid
%%{init: {"theme":"base","flowchart":{"curve":"rounded","padding":12}}}%%
flowchart TB
  n1(["Start"])
  n2[/"Input electricity units"/]
  n3{"units <= 100?"}
  n4["bill = units * 1.5"]
  n5{"units <= 300?"}
  n6[" bill = bill + (units - 100) * 2.0"]
  n7["bill = bill + (units - 300) * 3.0"]
  n8[/"Display bill"/]
  n9(["End"])
  n1 --> n2
  n2 --> n3
  n3 -->|Yes| n4
  n3 -->|No| n5
  n5 -->|Yes| n6
  n5 -->|No| n7
  n4 --> n8
  n6 --> n8
  n7 --> n8
  n8 --> n9

  classDef ds1 fill:#f0fdf4,stroke:#4ade80,color:#14532d
  classDef ds2 fill:#eff6ff,stroke:#60a5fa,color:#17325c
  classDef ds3 fill:#fffbeb,stroke:#fbbf24,color:#78350f
  classDef ds4 fill:#f8fafc,stroke:#94a3b8,color:#172033
  class n1,n9 ds1
  class n2,n8 ds2
  class n3,n5 ds3
  class n4,n6,n7 ds4
```

---
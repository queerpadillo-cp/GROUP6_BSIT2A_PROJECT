# Jeepney Operations & Fare Management System

An executable Java console prototype designed to manage distance-based fare collection with passenger registration, real-time seating capacity tracking, daily fuel expense logging, and driver financial summaries.

---

## Technical Features & Implementation
* **Language & Runtime:** Java (JDK 17 or higher)
* **User Input / Output:** Basic console I/O using `java.util.Scanner`
* **Data Storage:** In-Memory Object Repositories (`ArrayList`)
* **Programming Constructs Demonstrated:**
    * **Variables & Data Types:** `double`, `int`, `boolean`, `String`
    * **Operators:** Arithmetic (`+`, `-`, `*`), Relational (`<=`, `>=`, `==`), Logical (`||`), Increment (`++`)
    * **Control Structures:** `if-else` conditionals, `switch-case` statements, ternary expressions (`condition ? true : false`)
    * **Main Loop:** Continuous menu loop handled in `Main.java`

---

## Project Structure
```text
src/
└── main/
    └── java/
        └── com/
            └── scc/
                ├── model/
                │   ├── Passenger.java
                │   └── Expense.java
                ├── dao/
                │   ├── PassengerDao.java
                │   └── ExpenseDao.java
                └── Main.java
```markdown
# Jeepney Operations & Fare Management System

An executable Java console prototype designed to manage distance-based fare collection with passenger registration, real-time seating capacity tracking, daily fuel expense logging, and driver financial summaries.

---

## Technical Features & Implementation
* **Language & Runtime:** Java (JDK 17 or higher)
* **User Input / Output:** Basic console I/O using `java.util.Scanner`
* **Data Storage:** In-Memory Object Repositories (`ArrayList`)
* **Programming Constructs Demonstrated:**
  * **Variables & Data Types:** `double`, `int`, `boolean`, `String`
  * **Operators:** Arithmetic (`+`, `-`, `*`), Relational (`<=`, `>=`, `==`), Logical (`||`), Increment (`++`)
  * **Control Structures:** `if-else` conditionals, `switch-case` statements, ternary expressions (`condition ? true : false`)
  * **Main Loop:** Continuous menu loop handled in `Main.java`

---

## Project Structure
```text
src/
└── main/
    └── java/
        └── com/
            └── scc/
                ├── model/
                │   ├── Passenger.java
                │   └── Expense.java
                ├── dao/
                │   ├── PassengerDao.java
                │   └── ExpenseDao.java
                └── Main.java

```

---

## How to Run

### Running via IntelliJ IDEA

1. Open IntelliJ IDEA and choose **File > Open**.
2. Select the root project directory.
3. Open `src/main/java/com/scc/Main.java`.
4. Click **Run** or press `Shift` + `F10`.

### Running via Terminal / Command Line

1. Open terminal in the project root directory.
2. Compile source files:
```bash
javac -d bin src/main/java/com/scc/*.java src/main/java/com/scc/*/*.java

```


3. Run the compiled application:
```bash
java -cp bin com.scc.Main

```



---

## Operational Workflows

### 1. Passenger Fare Calculation & Registration

* Conductor selects **`1. Add Passenger & Collect Fare`**.
* Inputs passenger details:
* Passenger Name (e.g., *Juan Dela Cruz*)
* Drop-off Destination (e.g., *Mambaling*)
* Distance in km (e.g., *6.5*)
* Category (*Regular*, *Student*, *Senior Citizen*, *PWD*)


* System calculates distance-based fare (₱13.00 base for first 4.0 km + ₱1.80/extra km), applies 20% discount if eligible, logs record, and increments seat occupancy (+1).

### 2. Seating Capacity Tracking

* Main menu dynamically displays active seating occupancy (e.g., `[1 / 18 Occupied]`).
* Prevents adding passengers when 18-seat capacity is reached.
* Select **`3. Reset Trip Seats (New Pasada)`** to reset seating counter to `0 / 18` for new trip loops.

### 3. Expense Accounting & Net Pay Summary

* Driver selects **`4. Log Fuel Expense`** to record fuel expenses with driver/conductor name.
* Driver selects **`5. View Financial Summary`** to evaluate:

$$\text{Net Take-Home Pay} = \text{Total Gross Revenue} - \text{Total Fuel Expenses}$$



---

## Team Members & Project Information

* **Institution:** St. Cecilia's College - Cebu Inc.
* **Course & Section:** BSIT 2A
* **Group:** 6
* **Instructor:** Sir Michael John A. Bustamante

**Members:**

* Queer S. Padillo
* Jayrrd Degumbes
* John Vincent Omambac
* Nelle Getuaban


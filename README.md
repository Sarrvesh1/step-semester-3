# STEP Semester 3

Coursework for STEP SEM-3 (CodInClub / BridgeLabz).

## Branch layout

| Branch | Purpose |
|--------|---------|
| `main` | Stable / release branch |
| `dev` | Integration branch — all completed solutions land here |
| `feature/weekN` | Work for a given week, branched off `dev`, merged back into `dev` |

## Week 3 — OOP: Classes and Objects (Category B)

| # | Problem | File |
|---|---------|------|
| M1 | From Parallel Arrays to a Class — Library Inventory | `week3/M1_LibraryInventory/BookInventory.java` |
| M2 | Encapsulated Payroll Account | `week3/M2_PayrollAccount/PayrollAccount.java` |
| M3 | Overloaded Constructors for an Employee | `week3/M3_EmployeeOverloadedConstructors/Employee.java` |
| M4 | Reference Copies and a Shared Exam Hall Ticket | `week3/M4_HallTicket/HallTicket.java` |
| M5 | Instance vs Static: Splitting an Employee Class Correctly | `week3/M5_EmployeeStatic/Employee.java` |

### Running

Each file is self-contained with its own `main`:

```bash
cd week3/M1_LibraryInventory
javac BookInventory.java
java BookInventory
```

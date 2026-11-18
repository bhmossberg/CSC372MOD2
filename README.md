# CSC372MOD2 – Graphical User Interfaces in Java (Swing)

A Swing bank-balance GUI built for the module, plus zyBooks Chapter 16 Swing examples that cover frames, labels, text fields, buttons, sliders, spinners, tables, file choosers and custom painting.

## Overview

This is **CSU Global CSC372 (Programming II), Module 2: Graphical User Interfaces in Java**. It is an Eclipse Java project with two packages:
- `module2`: the bank-balance GUI written for this module
- `textbook`: worked examples that follow *Programming in Java with ZyLabs*, Chapter 16

Everything uses only the JDK's built-in `javax.swing` and `java.awt` libraries, so you don't need any external dependencies.

## `module2` – Bank Balance GUI

### `BankAccount.java`
A small model class: a private `balance` field, a constructor that sets the starting balance, `deposit(amount)` (positive amounts only), `withdraw(amount)` (only when `0 < amount ≤ balance`, so no overdraft), and `getBalance()`.

### `BankBalanceFrame.java` (`main`)
A `JFrame` that also `implements ActionListener`. It lays out its components with a **`GridBagLayout`**:

| Row | Components |
|---|---|
| 0 | "Initial Balance:" label, a currency `JFormattedTextField` (default `$500.00`), and the **Set Initial Balance** button |
| 1 | "Amount:" label and a currency `JFormattedTextField` |
| 2 | **Deposit**, **Withdraw** and **Show Balance** buttons |
| 3 | A `JPanel` with a "Current Balance:" label that is updated in place |
| 4 | **Quit** button |

A single `actionPerformed(ActionEvent)` method checks `event.getSource()` to see which button was pressed:
- **Set Initial Balance** creates the `BankAccount` from the field value.
- **Deposit** and **Withdraw** check that an account exists and the amount is positive. Withdraw also blocks overdrafts with an "Insufficient funds!" dialog. Results are confirmed with `JOptionPane` dialogs.
- **Show Balance** writes the balance, formatted with `NumberFormat.getCurrencyInstance()`, into the panel.
- **Quit** shows the remaining balance in a dialog and then calls `dispose()`.

## `textbook` – Chapter 16 examples

| File | Demonstrates |
|---|---|
| `GUI.java` | The smallest program that shows a window: an empty 400×250 `JFrame` |
| `SalaryGUI.java` | A non-editable `JTextField` used to display output |
| `SalaryLabelGUI.java` / `SalaryLabelFrame.java` | `JLabel`s and `JTextField`s positioned with `GridBagLayout`. The first builds the window inside `main`; the second subclasses `JFrame` |
| `SalaryCalcFrame.java` | Event handling: pressing Enter in the wage field calculates salary (wage × 40 × 50) |
| `SalaryCalcButtonFrame.java` | The same calculation triggered by a `JButton` |
| `FlyDriveFrame.java` | `JFormattedTextField` for numeric input. It computes flight time (miles ÷ 500) and driving time (miles ÷ 60), with an error dialog for negative input |
| `DogYearsFrame.java` | A `JSpinner` with a `SpinnerNumberModel` and a `ChangeListener` that converts a dog's age to human years from a lookup table |
| `HeightConverterFrame.java` | Two `JSlider`s (feet and inches) that update their fields live through `ChangeListener`, and a button that converts to centimeters (total inches × 2.54) |
| `SavingsInterestCalcFrame.java` | Currency, percent and integer `JFormattedTextField`s. It prints year-by-year compound savings into a `JTextArea` inside a `JScrollPane` |
| `ArrayMaxFrame.java` | An editable `JTable` of values and a "Find max" button that loops over the table to find the maximum |
| `FileReadFrame.java` | `JFileChooser` to pick a file, with its contents read into a scrolling `JTextArea` |
| `SeatInfo.java` + `SeatReservationFrame.java` | A 5-seat reservation system. An `ArrayList<SeatInfo>` stays in sync with a `JTable`, and there are **Reserve** and **Delete** buttons (Delete is marked `// NEW`, an addition to the textbook version), with validation dialogs |
| `MyCustomJComponent.java` | A template for a custom `JComponent` that overrides `paintComponent` |
| `HistogramComponent.java` + `HistogramViewer.java` | Custom 2D drawing: `paintComponent(Graphics)` with `Graphics2D` draws three colored rectangles as a histogram inside a frame |

## Build and run

JDK 8 or newer, on a machine with a display (Swing opens desktop windows).

```bash
mkdir -p bin
javac -d bin src/module2/*.java src/textbook/*.java
java -cp bin module2.BankBalanceFrame          # module program
java -cp bin textbook.SeatReservationFrame     # any textbook example
```

From Eclipse, open the project and run `BankBalanceFrame` (or any class with `main`) as a Java Application.

## Concepts demonstrated
- `JFrame` subclassing, `pack()`, `setDefaultCloseOperation`, `dispose()`
- Layout with `GridBagLayout`/`GridBagConstraints` (grid position, insets, `gridwidth`)
- Event-driven programming: `ActionListener`, `ChangeListener`, `event.getSource()`
- Input widgets: `JTextField`, `JFormattedTextField` with `NumberFormat`, `JSpinner`, `JSlider`, `JFileChooser`
- Output widgets: `JLabel`, `JTextArea` + `JScrollPane`, `JTable`, `JOptionPane` dialogs
- Separating the model class (`BankAccount`, `SeatInfo`) from the GUI
- Custom painting with `JComponent.paintComponent` and `Graphics2D`

## Module readings

Required
- [ ] Chapter 16 in Programming in Java with ZyLabs
- [ ] Chapter 2 ProGit eBook

Recommended
- [ ] Forber, B. (2023, February 23). Push your code with Git [Video]. LinkedIn Learning.
- [ ] Oracle. (2024). Using top-level containers.
- [ ] Oracle. (2024). The JComponent class.

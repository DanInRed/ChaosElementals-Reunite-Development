# Elemental Masters - TURN BASED simple JAVA PROJECT using Java Ant in Apache Net Beans (version 28 and above)
A Java-based battle engine for our FINAL PROJECT

## Getting Started

Before contributing, please read our [Development Workflow](WORKFLOW.md) .

### ⚠️ MANDATORY: All team members must follow the protocols defined in WORKFLOW.md to ensure code stability and prevent merge conflicts. Please review the "DO NOTs" section before submitting any Pull Requests.



## How to Run
1. Open this project in **NetBeans**.
2. Right-click the project and select **Run**.
3. The main entry point is `SimulateBattle.java` in the `battle.simulator` package.

## Project Structure
- `src/character`: Contains BaseCharacter and subclasses.
- `src/elements`: Handles the elemental advantage logic (Fire, Water, etc.).
- `src/battle`: The core simulation and coordinate-based mechanics.
- `src/core/TestingElementalMaster.java`: This is the Main Class make sure to run this one!
- `src/elements`: This contains all the 8 elements 
- `src/engine`: This is where the DamageCalculator.java resides
- `src/interfaces`: This is where ElementAction.java resides
- `src/types`: This contains AttackType and ElementType in enums


## BackEnd File
- location `src.game.01_BackEnd_Docs`
- Base Stats [BaseStats] (01_BackEnd_Docs/BaseStats.md)

## Contributing
- Do not push directly to `main`.
- Create a new branch for your GUI features.
- Open a Pull Request for review.

## 📝 TO-DO List (Task Board)
- [x] Core Battle Logic (`DamageCalculator.java`)
- [x] Elemental Advantage System (8 Elements)
- [ ] Special Attributes of each Elements 
- [ ] **GUI Implementation** (Main priority for contributors!)
- [ ] Save/Load System for Player Progress
- [ ] Sprite Integration for Characters
- [ ] Sound Effects & Background Music (OPTIONAL)

### 1. Atomic Commits
* **Rule:** One commit = One specific change.
* **Bad:** `git commit -m "fixed stuff and added gui"`
* **Good:** `git commit -m "feat: added Fire element damage multiplier"`
* **Why:** If a bug appears, it is much easier to find exactly which line of code caused it.

### 2. The "Compile First" Rule
* **Rule:** Never push code that doesn't run.
* **Action:** Before you commit, right-click the project in **NetBeans** and select **Clean and Build**. If it fails, do not push!

### 3. Package Integrity
* **Rule:** Respect the folder structure.
* **src/gui**: Only for Figma-to-Java swing/FX classes.
* **src/engine**: Only for calculation logic.
* **Why:** Misplaced files lead to `ClassNotFound` errors and broken imports.

### 4. Meaningful Naming
* **Rule:** No single-letter variables (except in loops).
* **Bad:** `int d = 50;`
* **Good:** `int baseDamage = 50;`
* **Why:** Code should be readable like a book so we don't have to call each other at 3 AM to ask "What is `d`?"

---

## WARNING!!!!
- Do not tamper with the .gitignore without any prior notice!!!
- If .gitignore is tampered, your merge request is DENIED!
- This is crucial to keep our devices safe from unwanted 10 HOURS DEBUG SESSION ;)
- MAKE SURE to create a new branch when editing in your NETBEANS or VSCODE!
- Direct tampering with main Branch is STRICTLY PROHIBITED!!!
- All these info are essential to avoid the 10 HOURS DEBUG SESSION
- If reading all these are tiring, then 10 HOURS DEBUG SESSION with ZERO PROGRESS is a THOUSAND TIMES more FRUSTRATING and it may attract unwanted attention.

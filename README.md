### Chaos Elementals: Reunite 
A Java-based battle engine for our FINAL PROJECT
- Status: currently in development
- Tech Stack: Java(JDK25), Swing, Graphics2D, Ant and Netbeans version 28;

---
## Quick Start
1. Clone the repo
2. Open in Netbeans or vsCode
3. Run the ChaosElementalsMain.java for Battle Simulation or ChaosElementalsGridExperiment.java for the 2d Top down "Overworld" 
- main classes are located at `src.game.core.main`

- DanInRed(Dash) acting Project Manager

--- 

## Getting Started
Before contributing, please read our [Development Workflow](WORKFLOW.md) .

---

## Project Structure
- `src/game/entity`: Contains all entity related methods and classes.
- `src/game/resources` : Contains all the "Sprites" and the "Icons".
- `src/game/elements`: Contains all the elemental types the game has to offer (Fire, Water, etc.).
- `src/game/battle`: The core simulation serves as backend calculations and dialogues for BattlePanel.java.
- `src/game/core/main`: This is where the Main Class resides.
- `src/game/core/validator`: This handles the input sanitation.  
- `src/engine`: This currently holds the logic for settings of main menu.
- `src/game/ui`: This contains the placeholder UI. (Currently under construction.)
- `src/game/types`: This contains AttackType and ElementType in enums.


## BackEnd File
- location `src.game.01_BackEnd_Docs`
- Base Stats [BaseStats](src/game/01_BackEnd_Docs/BaseStats.md)

## Contributing
- Do not push directly to `main`.
- Create a new branch for your features.
- Open a Pull Request for review.

## 📝 TO-DO List (Task Board)
- [x] Core Battle Logic (`DamageCalculator.java`)
- [x] Elemental Advantage System (8 Elements)
- [ ] Special Attributes of each Elements 
- [ ] **GUI Implementation** (Main priority for contributors!)
- [ ] Save/Load System for Player Progress
- [ ] Sprite Integration for Characters
- [ ] Sound Effects & Background Music

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
* **src/game/resources**: This should only contain images and Icons.
* **src/game/battle**: Only for battle related backend files like calculations and battle dialogues.
* **Why:** Misplaced files lead to `ClassNotFound` errors and broken imports.

### 4. Meaningful Naming
* **Rule:** No single-letter variables (except in loops).
* **Bad:** `int d = 50;`
* **Good:** `int baseDamage = 50;`
* **Why:** Code should be readable like a book so we don't have to call each other at 3 AM to ask "What is `d`?"

---

## WARNING!!!!
- Do not tamper with the .gitignore without any prior notice!
- MAKE SURE to create a new branch when editing in your NETBEANS or VSCODE!
- Direct tampering with main Branch is STRICTLY PROHIBITED!
- This is crucial to keep our devices safe from unwanted 10 HOURS DEBUG SESSION.
- All these info are essential to avoid the 10 HOURS DEBUG SESSION.


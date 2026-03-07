# Elemental Masters - Battle Simulator
A Java-based battle engine for our mobile game prototype.

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


## Contributing
- Do not push directly to `main`.
- Create a new branch for your GUI features.
- Open a Pull Request for review.

## 📝 TO-DO List (Task Board)
- [x] Core Battle Logic (`DamageCalculator.java`)
- [x] Elemental Advantage System (8 Elements)
- [ ] **GUI Implementation** (Main priority for contributors!)
- [ ] Save/Load System for Player Progress
- [ ] Sprite Integration for Characters
- [ ] Sound Effects & Background Music (OPTIONAL)

## WARNING!!!!
- Do not tamper with the .gitignore without any prior notice!!!
- If .gitignore is tampered, your merge request is DENIED!
- This is crucial to keep our devices safe from unwanted 10 HOURS DEBUG SESSION ;)
- MAKE SURE to create a new branch when editing in your NETBEANS or VSCODE!
- Direct tampering with main Branch is STRICTLY PROHIBITED!!!
- All these info are essential to avoid the 10 HOURS DEBUG SESSION
- If reading all these are tiring, then 10 HOURS DEBUG SESSION with ZERO PROGRESS is a THOUSAND TIMES more FRUSTRATING and it may attract unwanted attention.

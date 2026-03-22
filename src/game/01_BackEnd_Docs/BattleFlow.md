### Battle Flow and Logic
- This is where the battle calculation and battle dialogues happen.

## Navigation
- Back to README.md [README.md](../../../README.md)
- Back to BaseStats.md [BaseStats.md](BaseStats.md) 
---
## Battle Simulator 
- Located at `src/game/battle/simulator` 

1. SimulateBattle.java
- Handles all the player turn and enemy turn. 
- Utilizes TurnResult class 
- Calls DamageCalculator.java located at `src/game/engine`
- Reach out to DanInRed(Dash) before changing any methods

2. SimulateManaCost.java
- Acts as the mana validator to stop the player and enemy from performing attacks outside their mana range
- requirement: Occurs if and only if (currMana >= manaCost)
- Must call the constructor before the attempt to subtract mana from the mana bar ui of the BattlePanel
- Essential for updating UI JLabels and JProgressBar.

3. TurnResult.java
- Regulates SimulateBattle.java 
- Also serves as helper for BattlePanel.java (JPanel)
- Helper of txtAreaBattlePanel (JTextArea) to mitigate hardcoding terminalLog

---

## Engine Calculations 
- Located at `src/game/engine`

1. DamageCalculator.java
- Handles the damage output by accepting the attacker, receiver and the AttackType as parameter.
- Used by SimulateBattle.java
- Handles the Interactions between Player and Enemy including the Elements interactions
- Formula: TotalDamage = (baseDamage * AttackMultiplier * ElementalMultiplier)
- AttackMultiplier represents the base multiplier for Skill usage
- ElementalMultiplier represents the positioning of Element
- Let X = position of elemen in enums 
- if position is X+1 or X+2 = ElementalMultiplier returns 1.5x 
- else if position is X-1 or X-2 = ElementalMultiplier return 0.5x (except AttackType.ULTIMATE returns 1.0) 

2. ManaCostCalculator 
- Contains the base mana cost of AttackType 
- Utilized by SimulateManaCost.java (manaValidation occurs at SimulateManaCost)
- ManaCostCalculator must contain only the calculations and nothing else.
- Should we update the mana cost this is the entry point

3. GameUtils.java
- Currently acts as the Thread sleeper for terminal debug purpose.
- Heavily used by ChaosElementalsMain.java (for debug purposes).
- Don't delete anything from ChaosElementalsMain without prior notice.
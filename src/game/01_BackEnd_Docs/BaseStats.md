### Base Stats for Character entity (for Elementals stats only)
- This is where to edit incase we decide to add a special entities like BOSSes
- Currently calls the default constructors for character stats 

## Navigation
- Back to README.md [README.md](../../../README.md)
- Next -> BattleFlow.md [BattleFlow.md](BattleFlow.md)


## Health Points
This is located at | src.game.character.stats |

# Attributes
 - private double currentHP
 - private double maxHP
 
# Methods
- constructor: public HealthPoints()
- void takeDamage(double amount)
- void setCurrentHP(double amount)
- double getCurrentHP()
- double getMaxHP()
- boolean isFainted()

---

## Technical Implementation Notes
* **Data Type:** We use `double` for precision during calculation, but cast to `int` for the UI.
* **Constraints:** Health cannot drop below **0**.

---

## Base Damage 
This is located at | src.game.character.stats | 

# Attributes
-private double baseDamage

# Methods
- constructor: public baseDamage()
- constructor: public baseDamage(double baseDamage)
- public double getBaseDamage()

---

## Mana Points
This is located at | src.game.character.stats |

# Attributes
- private double currentMana
- private double maxMana
- private double regenRate

# Methods
- constructor: public ManaPoints()
- constructor: public ManaPoints(double maxMana, double regenRate)
- public void manaCost(double amount)
- public void regenerate()
- public void manaCost(double amount)
- public double getCurrentMana()
- public double getMaxMana()
- public double getRegenRate() 

---
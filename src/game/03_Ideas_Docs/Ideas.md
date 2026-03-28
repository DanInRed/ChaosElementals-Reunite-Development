## IDEAS for a better game
- Cave of Equilibrium

---
## Cave Maps 
- There are 3 maps
- Cave lvl 1 has three Elementals (weak, weak, neutral)
- Cave lvl 2 has another three Elementals (neutral, strong, strong)
- Cave lvl 3 last Elemental = Skip battle and trigger switcheroo (Secret Ending)
---
## ENTITIES INSIDE THE CAVE
- Enemy Elementals
- Player
- Lantern is now considered a subclass of Player

---
## LANTERN LOGIC

Object-to-State Transition:
"The 'Grandfather’s Lantern' undergoes a type-conversion during the gameplay lifecycle. 
Initially instantiated as a SuperObject for world-placement, upon collection, it is refactored into a Player state-flag. This prevents coordinate-desync and allows the LightingEngine to bind the 260px radial-gradient mask directly to the player's screen-space coordinates."

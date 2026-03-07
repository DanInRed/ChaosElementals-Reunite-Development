
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.types;

public enum AttackType {
    NORMAL(1.0),
    SKILL_1(1.0),
    SKILL_2(1.5),
    ULTIMATE(2.0);

    private final double power;

    AttackType(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }
}
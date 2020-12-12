package abstractclass.gamecharacter;

import java.util.Arrays;
import java.util.Random;

public class BattleField {

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
            attacker.secondaryAttack(defender);
        }
        return attacker.isAlive() && defender.isAlive();
    }

    public Character fight(Character one, Character other) {
        //while (one.isAlive() && other.isAlive()) {
        //oneHit(one, other);
        //oneHit(other, one);
        while (oneHit(one, other) && oneHit(other, one)) {
            round++;
        }
        return one.isAlive() ? one : other;
    }
}

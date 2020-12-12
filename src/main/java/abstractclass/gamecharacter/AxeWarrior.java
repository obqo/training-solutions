package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {

    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    private int getActualSecondaryDamage() {
        return getRandom().nextInt(getActualPrimaryDamage() * 2) +1;
    }

    public void secondaryAttack(Character enemy) {
        if (enemy.getPosition().distance(getPosition()) < 2) {
            hit(enemy, getActualSecondaryDamage());
        }
    }
}

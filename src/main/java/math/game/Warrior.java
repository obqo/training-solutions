package math.game;

import java.util.Random;

public class Warrior {

    private String name;
    private int stamina;
    private double skill;
    private Point position;

    private final Random rnd = new Random();

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        //this.stamina = new Random().nextInt(81) + 20;
        this.stamina = rnd.nextInt(81) + 20;
        //this.skill = new Random().nextDouble();
        this.skill = rnd.nextDouble();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior forward) {
        int newX = position.getX();
        int newY = position.getY();
        if (forward.getPosition().getX() - position.getX() > 0) {
            newX++;
        } else if (forward.getPosition().getX() - position.getX() < 0) {
            newX--;
        }
        if (forward.getPosition().getY() - position.getY() > 0) {
            newY++;
        } else if (forward.getPosition().getY() - position.getY() < 0) {
            newY--;
        }
        position = new Point(newX, newY);
    }

    public double distance(Warrior other) {
        return position.distance(other.position);
    }

    public void attack(Warrior warrior) {
        if (new Random().nextDouble() < skill) {
            //warrior.stamina -= new Random().nextInt(3) + 1;
            warrior.stamina -= rnd.nextInt(3) + 1;
        }
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public String toString() {
        return name + ": (" + position.getX() + "," + position.getY() + ") " + stamina;
    }
}

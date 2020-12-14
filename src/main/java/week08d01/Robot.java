/*
A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot az origóban van. A robot négy irányba képes mozogni fel,
le, balra és jobbra. A week08d01.Robot osztályban írj egy move() metódust ami egy karaktersorozatot vár.  pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal,
J=jobb. A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója. A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés,
hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét, akkor dobjunk IllegalArgumentExceptiont!
 */
package week08d01;

import inheritanceconstructor.classroom.Room;

public class Robot {

    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(String steps) {
        for (int i = 0; i < steps.length(); i++) {
            switch (steps.charAt(i)) {
                case 'F':
                    y++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'B':
                    x--;
                    break;
                case 'J':
                    x++;
                    break;
                default:
                    throw new IllegalArgumentException("Wrong instruction!");
            }
        }
    }
}

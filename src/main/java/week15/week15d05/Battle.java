package week15.week15d05;

public class Battle {

    private final String house;
    private final int nr;

    public Battle(String house, int nr) {
        this.house = house;
        this.nr = nr;
    }

    public String getHouse() {
        return house;
    }

    public int getNr() {
        return nr;
    }

    @Override
    public String toString() {
        return house + " " + nr;
    }
}

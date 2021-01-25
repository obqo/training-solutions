package week13.week13d01;

public class Settlement {

    private String name;
    private int postcode;

    public Settlement(String name, int postcode) {
        this.name = name;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "name='" + name + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}

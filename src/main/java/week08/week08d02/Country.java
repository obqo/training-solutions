package week08.week08d02;

public class Country {

    private String name;
    private int population;
    private int coloursOfFlag;
    private int numberOfNeighbours;

    public Country(String name, int population, int colorsOfFlag, int numberOfNeighbours) {
        this.name = name;
        this.population = population;
        this.coloursOfFlag = colorsOfFlag;
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getColorsOfFlag() {
        return coloursOfFlag;
    }

    public int getNumberOfNeighbours() {
        return numberOfNeighbours;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", coloursOfFlag=" + coloursOfFlag +
                ", numberOfNeighbours=" + numberOfNeighbours +
                '}';
    }
}

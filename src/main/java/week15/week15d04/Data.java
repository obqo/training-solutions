package week15.week15d04;

public class Data {

    private final int cases_weekly;
    private final String year_week;

    public Data(int cases_weekly, String year_week) {
        this.cases_weekly = cases_weekly;
        this.year_week = year_week;
    }

    public int getCases_weekly() {
        return cases_weekly;
    }

    public String getYear_week() {
        return year_week;
    }

    @Override
    public String toString() {
        return cases_weekly + " " + year_week;
    }
}

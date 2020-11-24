package controlselection.month;

public class DayInMonth {

    public int monthsDay(int year, String month) {
        switch (month.toUpperCase()) {
            case "JANUÁR":
            case "MÁRCIUS":
            case "MÁJUS":
            case "JÚLIUS":
            case "AUGUSZTUS":
            case "OKTÓBER":
            case "DECEMBER":
                return 31;
            case "ÁPRILIS":
            case "JÚNIUS":
            case "SZEPTEMBER":
            case "NOVEMBER":
                return 30;
            case "FEBRUÁR":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                }
                else {
                    return 28;
                }
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    public static void main(String[] args) {
        System.out.println(new DayInMonth().monthsDay(2020, "február"));
        System.out.println(new DayInMonth().monthsDay(2020, "március"));
        System.out.println(new DayInMonth().monthsDay(2020, "november"));
        System.out.println(new DayInMonth().monthsDay(2000, "február"));
        System.out.println(new DayInMonth().monthsDay(2100, "február"));
        System.out.println(new DayInMonth().monthsDay(2021, "február"));
        System.out.println(new DayInMonth().monthsDay(2021, "febr"));
    }
}

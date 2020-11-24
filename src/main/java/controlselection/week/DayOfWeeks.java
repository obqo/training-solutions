package controlselection.week;

public class DayOfWeeks {

    public String getTypeOfDayWithSwitchStatement(String day){
        switch(day.toLowerCase()) {
            case "hétfő":
                return "hét eleje";
            case "kedd":
            case "szerda":
            case "csütörtök":
                return "hét közepe";
            case "péntek":
                return "majdnem hétvége";
            case "szombat":
            case "vasárnap":
                return "hét vége";
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public static void main(String[] args) {
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("hétfő"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("Kedd"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("sZERDA"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("CsüTöRtÖk"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("PÉNTEK"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("szombat"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("Vasárnap"));
        System.out.println(new DayOfWeeks().getTypeOfDayWithSwitchStatement("monday"));
    }

}

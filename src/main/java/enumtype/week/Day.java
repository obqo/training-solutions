package enumtype.week;

public enum Day {

    MONDAY(DayType.WORKDAY), TUESDAY(DayType.WORKDAY), WEDNESDAY(DayType.WORKDAY), THURSDAY(DayType.WORKDAY), FRIDAY(DayType.WORKDAY), SATURDAY(DayType.HOLIDAY), SUNDAY(DayType.HOLIDAY);

    private final DayType value;

    Day(DayType value) {
        this.value = value;
    }

    public DayType getValue() {
        return value;
    }
}

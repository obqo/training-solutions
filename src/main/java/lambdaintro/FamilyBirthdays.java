/*
Írj egy FamilyBirthdays osztályt, mely konstruktor paraméterül kap születésnapokat.
Implementáld benne az isFamilyBirthday és nextFamilyBirthDay metódusokat, a tesztben szereplő method reference-ek alapján.
A isFamilyBirthday visszaadja, hogy a paraméterként átadott dátum születésnap-e.
A nextFamilyBirthDay metódus visszaadja, hány nap van a legközelebbi születésnapig.
Implementációs javaslat
Nézd meg LocalDate query() metódusát, hogy mit kap paraméterül.
Használd a ChronoUnit osztályt annak meghatározására, hogy két dátum között hány nap telt el.
 */
package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class FamilyBirthdays {

    private final List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = List.of(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        for (LocalDate birthday : birthdays) {
            if (birthday.getMonthValue() == month && birthday.getDayOfMonth() == day) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        LocalDate base = LocalDate.of(year, month, day);
        int min = Integer.MAX_VALUE;
        for (LocalDate birthday : birthdays) {
            LocalDate nextBirthday = birthday.withYear(year);
            if (nextBirthday.isBefore(base)) {
                nextBirthday = birthday.withYear(year + 1);
            }
                int diff = (int) ChronoUnit.DAYS.between(base, nextBirthday);
                if (min > diff) {
                    min = diff;
                }

        }
        return min;
    }
}

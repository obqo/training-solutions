/*
Gyűjtsd ki az ugyanahhoz az IP-címhez tartozó napló bejegyzéseket egy szöveges naplóból. A napló sorokban tárolja az adatokat,
egy sor egy Entry objektumnak felel meg, IP cím, dátum és login mezőkből áll. Írj egy log feldolgozást implementáló osztályt,
LogParser néven, amely elvégzi a dátum String konvertálását, a sor feldolgozását, és Map-be szortírozását. A fő tevékenységet a
(parseLog(String log)) metódus végzi, amely egy (Map<String, List<Entry>>) értéket ad vissza.
Hibakezelés
Ha a dátum String nem dolgozható fel, a metódus dobjon egy IllegalArgumentException kivételt.
Ha a parseLog(String log) metódus bemenete olyan String, amely nem dolgozható fel, mint Entry objektum, szintén
IllegalArgumentException kivételt dobjon.
Megvalósítás
A sorfeldolgozáshoz szükséges adatok - elemek száma, pozíciója, mező szeparátor, dátum String formátuma - statikus final
változóként kerüljenek be a LogParser osztályba.
Tippek
Ha a sor nem dolgozható fel, vagy a dátum nem konvertálható, az egész feldolgozást töröljük és kivételt dobunk a probléma
megjelölésével.
 */
package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final int POSITION_OF_IP = 0;
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_LOGIN = 2;
    public static final int NUMBER_OF_FIELDS = 3;
    public static final String LOG_SEPARATOR = ":";

    public Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> result = new HashMap<>();
        try (Scanner scanner = new Scanner(log)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] splitLine = line.split(LOG_SEPARATOR);
                if (splitLine.length != NUMBER_OF_FIELDS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                String ipAddress = splitLine[POSITION_OF_IP];
                LocalDate entryDate = parseDate(splitLine[POSITION_OF_DATE]);
                String login = splitLine[POSITION_OF_LOGIN];
                Entry entry = new Entry(ipAddress, entryDate, login);
                if (!result.containsKey(ipAddress)) {
                    result.put(ipAddress, new ArrayList<>());
                }
                result.get(ipAddress).add(entry);
            }
        }
        return result;
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);
        }
        catch (DateTimeParseException pe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }
}

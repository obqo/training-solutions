/*
Implementáld az IntegerOperations osztályban a következő metódusokat!
public List<Integer> createList(int... numbers)
public int sumIntegerList(List<Integer> integerList)
public int sumIntegerObjects(Integer... integers)
Az egyes kollekciók esetében vizsgáljuk meg és értelmezzük a toString() metódus működését, a kiírás sorrendjének elemzésével.
Megvalósítás
Használjunk varargs típusokat a paraméterek megadásához.
 */
package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> newList = new ArrayList<>();
        for (int number : numbers) {
            newList.add(number);
        }
        return newList;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (int integer : integerList) {
            sum += integer;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (int integer : integers) {
            sum += integer;
        }
        return sum;
    }

}

package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> numbers) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.subList(i + 1, numbers.size()).contains(numbers.get(i))) {
                duplicates.add(numbers.get(i));
            }
        }
        return duplicates;
    }
}

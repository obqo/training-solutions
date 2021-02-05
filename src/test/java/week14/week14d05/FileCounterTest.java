package week14.week14d05;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileCounterTest {

    @Test
    void countWords() {
        FileCounter fc = new FileCounter();
        String fileName = "src/main/java/week14/week14d05/hachiko.srt";
        Map<String, Integer> countMap = new HashMap<>(fc.countWords(fileName, "Hachiko", "haza", "pályaudvar", "jó"));
        assertEquals("{haza=15, jó=15, pályaudvar=5, Hachiko=4}", countMap.toString());
    }
}
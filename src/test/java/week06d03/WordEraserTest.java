package week06d03;

import org.junit.jupiter.api.Test;
import week06d01.ListSelector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordEraserTest {

    @Test
    public void testWordEraser() {
        //eraseWordChar
        assertEquals("körte dió szilva", new WordEraser().eraseWordChar("alma  körte dió alma szilva", "alma"));
        assertEquals("", new WordEraser().eraseWordChar("alma", "alma"));
        assertEquals("körte dió", new WordEraser().eraseWordChar("körte dió alma", "alma"));
        assertEquals("körte", new WordEraser().eraseWordChar("körte", "alma"));
        assertEquals("", new WordEraser().eraseWordChar("", "alma"));
        assertEquals("alma körte dió alma szilva", new WordEraser().eraseWordChar("alma körte dió alma szilva", ""));
        //eraseWordSubstring
        assertEquals("körte dió szilva", new WordEraser().eraseWordSubstring("alma körte dió alma szilva", "alma"));
        assertEquals("", new WordEraser().eraseWordSubstring("alma", "alma"));
        assertEquals("körte dió", new WordEraser().eraseWordSubstring("körte dió alma", "alma"));
        assertEquals("körte", new WordEraser().eraseWordSubstring("körte", "alma"));
        assertEquals("", new WordEraser().eraseWordSubstring("", "alma"));
        assertEquals("alma körte dió alma szilva", new WordEraser().eraseWordSubstring("alma körte dió alma szilva", ""));
        //eraseWordSplit
        assertEquals("körte dió szilva", new WordEraser().eraseWordSplit("alma körte dió alma szilva", "alma"));
        assertEquals("", new WordEraser().eraseWordSplit("alma", "alma"));
        assertEquals("körte dió", new WordEraser().eraseWordSplit("körte dió alma", "alma"));
        assertEquals("körte", new WordEraser().eraseWordSplit("körte", "alma"));
        assertEquals("", new WordEraser().eraseWordSplit("", "alma"));
        assertEquals("alma körte dió alma szilva", new WordEraser().eraseWordSplit("alma körte dió alma szilva", ""));
        //eraseWordSplitList
        assertEquals("körte dió szilva", new WordEraser().eraseWordSplitList("alma körte dió alma szilva", "alma"));
        assertEquals("", new WordEraser().eraseWordSplitList("alma", "alma"));
        assertEquals("körte dió", new WordEraser().eraseWordSplitList("körte dió alma", "alma"));
        assertEquals("körte", new WordEraser().eraseWordSplitList("körte", "alma"));
        assertEquals("", new WordEraser().eraseWordSplitList("", "alma"));
        assertEquals("alma körte dió alma szilva", new WordEraser().eraseWordSplitList("alma körte dió alma szilva", ""));
    }

    @Test
    void testWordEraserNull() {
        //eraseWordChar
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordChar("alma körte dió alma szilva", null));
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordChar(null, "alma"));
        //eraseWordSubstring
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordSubstring("alma körte dió alma szilva", null));
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordSubstring(null, "alma"));
        //eraseWordSplit
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordSplit("alma körte dió alma szilva", null));
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordSplit(null, "alma"));
        //eraseWordSplitList
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordSplitList("alma körte dió alma szilva", null));
        assertThrows(IllegalArgumentException.class, () -> new WordEraser().eraseWordSplitList(null, "alma"));
    }
}

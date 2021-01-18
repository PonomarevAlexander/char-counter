package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatterTest {
    
    Formatter formatter;
    private Map<Character, Integer> incomingMap = new HashMap<>();
    private static final String EXPECTED = "\"e\" - 1\n"
            + "\"h\" - 1\n"
            + "\"l\" - 2\n"
            + "\"o\" - 1\n";

    @BeforeEach
    void init() {
        formatter = new Formatter();
        incomingMap.put('h', 1);
        incomingMap.put('e', 1);
        incomingMap.put('l', 2);
        incomingMap.put('o', 1);
    }
    
    @Test
    void testFormatToPrint() {
        String actual = formatter.formatToPrint(incomingMap).toString();
        assertEquals(EXPECTED, actual);
    }

}

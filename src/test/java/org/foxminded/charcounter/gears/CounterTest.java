package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {
    
    private Counter counter;
    private Map<Character, Integer> charData = new LinkedHashMap<>(); 
    private static final String FOUR_WORD = "hello world hello world";
    
    @BeforeEach
    void init() {
        counter = new Counter();
        charData.put('h', 2);
        charData.put('e', 2);
        charData.put('l', 6);
        charData.put('o', 4);
        charData.put(' ', 3);
        charData.put('w', 2);
        charData.put('r', 2);
        charData.put('d', 2);
    }

    @Test
    void testToCountCharacters() {
        Map<Character, Integer> actual = counter.toCountCharacters(FOUR_WORD);
        assertEquals(charData, actual);
        assertEquals(8, charData.size());
    }
}

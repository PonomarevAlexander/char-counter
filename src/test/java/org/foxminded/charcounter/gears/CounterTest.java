package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {
    
    private Counter counter;
    private Map<Character, Integer> expectedCharMap = new HashMap<>();
    private static final String HELLO_WORLD = "hello";
    private static final String EMPTY_STRING = "";
    
    @BeforeEach
    void init() {
        counter = new Counter();
        expectedCharMap.put('h', 1);
        expectedCharMap.put('e', 1);
        expectedCharMap.put('l', 2);
        expectedCharMap.put('o', 1);
    }

    @Test
    void testToCountCharacters() {
        Map<Character, Integer> actual = counter.toCountCharacters(HELLO_WORLD);
        assertEquals(expectedCharMap, actual);
        assertEquals(4, expectedCharMap.size());
    }
    
    @Test
    void testShouldThrowExceptionIfIncomingStringIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {counter.toCountCharacters(EMPTY_STRING);});
    }

}

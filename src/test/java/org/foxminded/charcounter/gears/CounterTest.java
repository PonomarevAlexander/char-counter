package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {
    
    private Counter counter;
    private Map<Character, Integer> expectedMap = new HashMap<>();
    private static final List<String> SPLITTED_HELLO_WORLD = Arrays.asList("hello", "world!");
    private static final String EMPTY_STRING_EXCEPTION_MESSAGE = "You are tryed to count characters in empty string";
    private static final List<String> EMPTY_LIST = new ArrayList<>();
    
    @BeforeEach
    void init() {
        counter = new Counter();
        expectedMap.put('h', 1);
        expectedMap.put('e', 1);
        expectedMap.put('l', 2);
        expectedMap.put('o', 1);
    }

    @Test
    void testToCountChars() {
        Map<Character, Integer> actual = counter.toCountCharacters(SPLITTED_HELLO_WORLD, 0);
        assertEquals(expectedMap, actual);

    }
    
    @Test
    void testShouldThrowExceptionIfIncomingStringIsEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, 
                () -> {counter.toCountCharacters(EMPTY_LIST, 0);});
        assertEquals(EMPTY_STRING_EXCEPTION_MESSAGE, exception.getMessage());
    }

}

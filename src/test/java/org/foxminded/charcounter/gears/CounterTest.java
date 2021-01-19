package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {
    
    private Counter counter;
    private Map<Character, Integer> charData = new LinkedHashMap<>();
    private Map<Character, Integer> specSymbolsData = new LinkedHashMap<>();
    
    private static final String ONE_WORD = "hello";
    private static final String FOUR_WORD = "hello world, hello world";
    
    @BeforeEach
    void init() {
        counter = new Counter();
        charData.put('h', 1);
        charData.put('e', 1);
        charData.put('l', 2);
        charData.put('o', 1);
        specSymbolsData.put(' ', 3);
        specSymbolsData.put(',', 1);
        
    }

    @Test
    void testToCountCharacters() {
        Map<Character, Integer> actual = counter.toCountCharacters(ONE_WORD);
        assertEquals(charData, actual);
        assertEquals(4, charData.size());
    }
    
    @Test
    void testCountSpecSymbols() {
        Map<Character, Integer> actual = counter.countSpecSymbols(FOUR_WORD);
        assertEquals(specSymbolsData, actual);
    }
}

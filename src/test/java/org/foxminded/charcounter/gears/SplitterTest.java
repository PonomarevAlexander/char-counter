package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class SplitterTest {
    
    Splitter splitter;
    private static final String HELLO_WORLD = "hello world!";
    private static final String[] SPLITTED_HELLO_WORLD = {"hello", "world!"};
    
    @BeforeEach
    void init() {
        splitter = new Splitter();
    }

    @Test
    void testSplitString() {
        String[] actual = splitter.splitString(HELLO_WORLD);
        assertEquals(Arrays.toString(SPLITTED_HELLO_WORLD), Arrays.toString(actual));
        
    }

    @Test
    void testGetCharsArrayOfWordByIndex() {
        char[] actual = splitter.getCharsArrayOfWordByIndex(SPLITTED_HELLO_WORLD, 0);
        char[] expected = {'h', 'e', 'l', 'l', 'o'};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}

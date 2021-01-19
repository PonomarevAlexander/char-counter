package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordStorageTest {
    
    WordStorage storage;
    private static final String KEY = "foxminded";
    private static final String KEY_NEW_WORD = "test";
    private static final LinkedHashMap<Character, Integer> CHARS_AMOUNTS = new LinkedHashMap<Character, Integer>() {{
        put('f', 1);
        put('o', 1);
        put('x', 1);
        put('m', 1);
        put('i', 1);
        put('n', 1);
        put('d', 2);
        put('e', 1);
    }};

    @BeforeEach
    void init() {
        storage = new WordStorage();
        storage.putToStorage(KEY, CHARS_AMOUNTS);
    }

    @Test
    void testCheckToContains() {
        assertTrue(storage.checkToContains(KEY));
        assertFalse(storage.checkToContains(KEY_NEW_WORD));
    }
    
    @Test
    void testGetWord() {
        assertEquals(CHARS_AMOUNTS, storage.getWord(KEY));
        assertEquals(8, storage.getWord(KEY).size());
    }
}

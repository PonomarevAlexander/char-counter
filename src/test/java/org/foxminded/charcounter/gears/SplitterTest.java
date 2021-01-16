package org.foxminded.charcounter.gears;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplitterTest {
    
    Splitter splitter;
    private static final String HELLO_WORLD = "hello world!";
    private static final List<String> SPLITTED_HELLO_WORLD = Arrays.asList("hello", "world!");
    
    @BeforeEach
    void init() {
        splitter = new Splitter();
    }

    @Test
    void testSplitString() {
        List<String> actual = new ArrayList<>();
        actual.addAll(Arrays.asList(HELLO_WORLD.split(" ")));
        assertEquals(SPLITTED_HELLO_WORLD, actual);
        
    }
}

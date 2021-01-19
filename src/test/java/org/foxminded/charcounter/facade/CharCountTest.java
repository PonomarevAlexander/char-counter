package org.foxminded.charcounter.facade;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;

import org.foxminded.charcounter.gears.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import java.util.Map;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CharCountTest {
    
    private static final String SOURCE_STRING = "there is facade test";
    private static final String EMPTY_STRING = "";
    private static final String EXPECTED = "\"t\" - 3\n"
            + "\"h\" - 1\n"
            + "\"e\" - 4\n"
            + "\"r\" - 1\n"
            + "\"i\" - 1\n"
            + "\"s\" - 2\n"
            + "\"f\" - 1\n"
            + "\"a\" - 2\n"
            + "\"c\" - 1\n"
            + "\"d\" - 1\n"
            + "\" \" - 3\n";
    private CharCount cc;

    @Mock
    private Splitter splitter;
    
    @Mock
    private Counter counter;
    
    @Mock
    private WordStorage storage;
    
    @Mock
    private Formatter formatter;
    
    @Mock
    private Map<Character, Integer> charsAmountStubb;
    
    @InjectMocks
    private CharCount charCount = new CharCount();
    
    
    @Test
    void testTimesInvokationMethodsWithoutLoop() {
        charCount.countCharacters(SOURCE_STRING);
        
        verify(splitter).splitString(SOURCE_STRING);
        verify(counter).countSpecSymbols(SOURCE_STRING);
        verify(formatter).formatToPrint(charsAmountStubb);
    }
    
    @Test
    void testOrderInvokeMethodsWhithoutLoop() {
        InOrder inOrder = inOrder(splitter, counter, formatter);
        charCount.countCharacters(SOURCE_STRING);
        
        inOrder.verify(splitter).splitString(SOURCE_STRING);
        inOrder.verify(counter).countSpecSymbols(SOURCE_STRING);
        inOrder.verify(formatter).formatToPrint(charsAmountStubb);
    }
    
    @BeforeEach
    void init() {
        cc = new CharCount();
    }
    
    @Test
    void testCountCharactersShouldReturnCorrectResult() {
        String actual = cc.countCharacters(SOURCE_STRING);
        assertEquals(EXPECTED, actual);
    }
    
    @Test
    void testShouldThrowExceptionIfStringIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {cc.countCharacters(EMPTY_STRING);});
    }
}









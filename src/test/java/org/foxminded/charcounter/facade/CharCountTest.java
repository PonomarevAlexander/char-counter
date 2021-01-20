package org.foxminded.charcounter.facade;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.foxminded.charcounter.gears.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;

import java.util.LinkedHashMap;
import java.util.Map;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CharCountTest {
    
    private static final String SOURCE_STRING = "there is facade test";
    private static final String EMPTY_STRING = "";
    private static Map<Character, Integer> map = new LinkedHashMap<>();
    private static final String EXPECTED = "\"t\" - 3\n"
            + "\"h\" - 1\n"
            + "\"e\" - 4\n"
            + "\"r\" - 1\n"
            + "\" \" - 3\n"
            + "\"i\" - 1\n"
            + "\"s\" - 2\n"
            + "\"f\" - 1\n"
            + "\"a\" - 2\n"
            + "\"c\" - 1\n"
            + "\"d\" - 1\n";
    private CharCount cc;
    
    
    @Mock
    private Counter counter;
    
    @Mock
    private WordStorage storage;
    
    @Mock
    private CharCountFormatter formatter;

    
    @InjectMocks
    private CharCount charCount = new CharCount();
    
    
    @Test
    void testTimesCallMethodsIfStringDoesntFindInStorage() {
        when(storage.checkToContains(SOURCE_STRING)).thenReturn(false);
        charCount.countCharacters(SOURCE_STRING);
        
        verify(storage).checkToContains(SOURCE_STRING);
        verify(counter).toCountCharacters(SOURCE_STRING);
        verify(storage).putToStorage(SOURCE_STRING, map);
        verify(formatter).formatToPrint(map);
    }
    
    @Test
    void testTimesCallMethodsIfStorageHaveAString() {
        when(storage.checkToContains(SOURCE_STRING)).thenReturn(true);
        charCount.countCharacters(SOURCE_STRING);
        
        verify(storage).checkToContains(SOURCE_STRING);
        verify(storage).get(SOURCE_STRING);
        verify(formatter).formatToPrint(map);
        
    }
    
    @Test
    void testOrderInvokationIfStringDoesNotFoundInStorage() {
        InOrder inOrder = inOrder(storage, counter, formatter);
        when(storage.checkToContains(SOURCE_STRING)).thenReturn(false);
        charCount.countCharacters(SOURCE_STRING);
        
        inOrder.verify(storage).checkToContains(SOURCE_STRING);
        inOrder.verify(counter).toCountCharacters(SOURCE_STRING);
        inOrder.verify(storage).putToStorage(SOURCE_STRING, map);
        inOrder.verify(formatter).formatToPrint(map);
    }
    
    @Test
    void testOrderInvokationIfStringWasFoundInStorage() {
        InOrder inOrder = inOrder(storage, formatter);
        when(storage.checkToContains(SOURCE_STRING)).thenReturn(true);
        charCount.countCharacters(SOURCE_STRING);
        
        inOrder.verify(storage).checkToContains(SOURCE_STRING);
        inOrder.verify(storage).get(SOURCE_STRING);
        inOrder.verify(formatter).formatToPrint(map);  
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









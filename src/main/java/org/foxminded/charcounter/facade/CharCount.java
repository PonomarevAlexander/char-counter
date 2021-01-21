package org.foxminded.charcounter.facade;

import java.util.Map;

import org.foxminded.charcounter.gears.*;

public class CharCount {

    private Counter counter = new Counter();
    private WordStorage storage = new WordStorage();
    private CharCountFormatter formatter = new CharCountFormatter();
    private static final String EMPTY_STRING_EXCEPTION_MESSAGE = "You are tryed count empty string";
    private static final String EMPTY_STRING = "";

    public String countCharacters(String sourceString) {
        Map<Character, Integer> result;
        if (sourceString.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException(EMPTY_STRING_EXCEPTION_MESSAGE);
        }
        
        if (storage.checkToContains(sourceString)) {
            result = storage.get(sourceString);
        } else {
            result = counter.toCountCharacters(sourceString);
            storage.putToStorage(sourceString, result);
        }
        return formatter.formatToPrint(result);
    }  
}

package org.foxminded.charcounter.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.foxminded.charcounter.gears.*;

public class CharCounter {

    private static CharCounter facadeInstance;
    private Splitter splitter = new Splitter();
    private Counter counter = new Counter();
    private WordStorage storage = new WordStorage();
    private Formatter formatter = new Formatter();
    private Map<Character, Integer> totalCharsAmount = new HashMap<>();

    private CharCounter() {
    }
    
    public static CharCounter getCharCounterInstance() {
        if (CharCounter.facadeInstance == null) {
            facadeInstance = new CharCounter();
        }
        return facadeInstance;
    }

    public String countCharacters(String sourceString) {
        List<String> subStringList = splitter.splitString(sourceString);
        
        for (String subString : subStringList) {
            if (storage.checkToContains(subString)) {
                mergeAmount(storage.getWord(subString));
            } else {
                mergeAmount(counter.toCountCharacters(subString));
                storage.putToStorage(subString, counter.toCountCharacters(subString));
            }
        }
        return formatter.formatToPrint(totalCharsAmount).toString();
    }
    
    private void mergeAmount(Map<Character, Integer> data) {
        data.forEach((letter, amount) -> totalCharsAmount.computeIfPresent(letter, (key, value) -> amount + value));
        data.forEach((letter, amount) -> totalCharsAmount.putIfAbsent(letter, amount));   
    }
}

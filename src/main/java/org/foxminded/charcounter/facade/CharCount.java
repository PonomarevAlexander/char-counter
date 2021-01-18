package org.foxminded.charcounter.facade;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.foxminded.charcounter.gears.*;

public class CharCount {

    private Splitter splitter = new Splitter();
    private Counter counter = new Counter();
    private WordStorage storage = new WordStorage();
    private Formatter formatter = new Formatter();
    private Map<Character, Integer> totalCharsAmount = new LinkedHashMap<>();

    public String countCharacters(String sourceString) {
        if (sourceString.equals("")) {
            throw new IllegalArgumentException();
        }
        
        List<String> subStringList = splitter.splitString(sourceString);
        
        for (String subString : subStringList) {
            if (storage.checkToContains(subString)) {
                mergeAmount(storage.getWord(subString));
            } else {
                mergeAmount(counter.toCountCharacters(subString));
                storage.putToStorage(subString, counter.toCountCharacters(subString));
            }
        }
        mergeAmount(counter.countSpecSymbols(sourceString));
        return formatter.formatToPrint(totalCharsAmount);
    }
    
    private void mergeAmount(Map<Character, Integer> incomingData) {
        incomingData.forEach((letter, amount) -> totalCharsAmount.computeIfPresent(letter, (key, value) -> amount + value));
        incomingData.forEach((letter, amount) -> totalCharsAmount.putIfAbsent(letter, amount));   
    }   
}

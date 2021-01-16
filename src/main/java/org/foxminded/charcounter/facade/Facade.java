package org.foxminded.charcounter.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.foxminded.charcounter.gears.*;


public class Facade {

    private static Facade facade;
    private Splitter splitter = new Splitter();
    private Counter counter = new Counter();
    private WordStorage storage = new WordStorage();
    private Formatter formatter = new Formatter();
    private Map<Character, Integer> resultData = new HashMap<>();

    private Facade() {
    }
    
    public static Facade getFacade() {
        if (Facade.facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public String countLetters(String source) {
        List<String> subStringList = splitter.splitString(source);
        
        for (String subString : subStringList) {
            if (storage.checkToContains(subString)) {
                facade.mergeData(storage.getWord(subString));
            } else {
                mergeData(counter.toCountCharacters(subString));
                storage.putToStorage(subString, counter.toCountCharacters(subString));
            }
        }
        return formatter.formatToPrint(resultData).toString();
    }
    
    private void mergeData(Map<Character, Integer> data) {
        data.forEach((letter, amount) -> resultData.computeIfPresent(letter, (key, value) -> amount + value));
        data.forEach((letter, amount) -> resultData.putIfAbsent(letter, amount));   
    }
}

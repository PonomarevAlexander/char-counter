package org.foxminded.charcounter.gears;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordStorage {
    
    private Map<String, LinkedHashMap<Character, Integer>> wordsStorage = new HashMap<>();
    
    public void putToStorage(String word, Map<Character, Integer> amount) {
        wordsStorage.putIfAbsent(word, (LinkedHashMap<Character, Integer>) amount);
    }
    
    public boolean checkToContains(String key) {
        boolean flag = false;
        if (wordsStorage.containsKey(key)) {
            flag = true;
        }
        return flag;
    }
    
    public Map<Character, Integer> getWord(String word) {
        return wordsStorage.get(word);
    }
}

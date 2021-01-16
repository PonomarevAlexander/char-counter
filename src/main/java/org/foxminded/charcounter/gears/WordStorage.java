package org.foxminded.charcounter.gears;

import java.util.HashMap;
import java.util.Map;

public class WordStorage {
    
    private Map<String, HashMap<Character, Integer>> wordsStorage;
    
    public WordStorage() {
        this.wordsStorage = new HashMap<>();
    }
    
    public void putToStorageIfAbscent(String word, Map<Character, Integer> letterCounts) {
        wordsStorage.putIfAbsent(word, (HashMap<Character, Integer>) letterCounts);
    }
}

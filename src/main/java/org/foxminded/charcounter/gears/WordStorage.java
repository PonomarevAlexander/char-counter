package org.foxminded.charcounter.gears;

import java.util.HashMap;
import java.util.Map;

public class WordStorage implements Storage {
    
    private Map<String, Map<Character, Integer>> wordsStorage = new HashMap<>();
    
    @Override
    public void putToStorage(String word, Map<Character, Integer> amount) {
        wordsStorage.putIfAbsent(word, amount);
    }
    
    @Override
    public boolean checkToContains(String key) {
        boolean flag = false;
        if (wordsStorage.containsKey(key)) {
            flag = true;
        }
        return flag;
    }
    
    @Override
    public Map<Character, Integer> get(String word) {
        return wordsStorage.get(word);
    }
}

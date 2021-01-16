package org.foxminded.charcounter.gears;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private int count;
    private Map<Character, Integer> countedChars;
    
    public Counter() {
        this.countedChars = new HashMap<>();
    }
    
    public Map<Character, Integer> toCountCharacters(String subString) {
        countedChars.clear();
        if (!subString.isEmpty()) {
            char[] letters = subString.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                for (int j = 0; j < letters.length; j++) {
                    if (letters[i] == letters[j]) {
                        count++;
                    }
                }
                countedChars.put(letters[i], count);
                count = 0;
            }
            return countedChars;
        } else {
            throw new IllegalArgumentException("You are tryed to count characters in empty string");
        }
    }
}

package org.foxminded.charcounter.gears;

import java.util.LinkedHashMap;
import java.util.Map;

public class Counter {
    private int count;
    private Map<Character, Integer> countedChars;
    
    public Counter() {
        this.countedChars = new LinkedHashMap<>();
    }
    
    public Map<Character, Integer> toCountCharacters(String subString) {
        countedChars.clear();
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
    }
    
    public Map<Character, Integer> countSpecSymbols(String sourceString) {
        Map<Character, Integer> specSymbolsAmount = new LinkedHashMap<>();
        char[] letters = sourceString.toCharArray();
        for (char character : letters) {
            if (!Character.isAlphabetic(character)) {
                count++;
                specSymbolsAmount.computeIfPresent(character, (key, value) -> value + 1);
                specSymbolsAmount.putIfAbsent(character, count);
                count = 0;
            }
        }
        return specSymbolsAmount;
    }
}

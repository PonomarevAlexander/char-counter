package org.foxminded.charcounter.gears;

import java.util.Map;

public class CharCountFormatter implements Formatter {
    
    private static final String QUOTE = "\"";
    private static final String NEW_LINE = "\n";
    private static final String SEPARATOR = " - ";
    private StringBuilder result = new StringBuilder();
    
    @Override
    public String formatToPrint(Map<Character, Integer> source) {
        source.forEach((key, value) -> result.append(QUOTE + key + QUOTE +  SEPARATOR + value + NEW_LINE));
        return result.toString();
    }
}

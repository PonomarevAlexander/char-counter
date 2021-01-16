package org.foxminded.charcounter.gears;

import java.util.Map;

public class Formatter {
    
    private StringBuilder result = new StringBuilder();
    
    public StringBuilder formatToPrint(Map<Character, Integer> source) {
        source.forEach((key, value) -> result.append("\"" + key + "\"" +  " - " + value + "\n"));
        return result;
    }
}

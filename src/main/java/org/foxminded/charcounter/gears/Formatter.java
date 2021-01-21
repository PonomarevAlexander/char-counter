package org.foxminded.charcounter.gears;

import java.util.Map;

public interface Formatter {

    public String formatToPrint(Map<Character, Integer> source);
}

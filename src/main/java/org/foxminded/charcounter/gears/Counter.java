package org.foxminded.charcounter.gears;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Counter {
    
    public Map<Character, Integer> toCountCharacters(String sourceString) {
        return sourceString.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.summingInt(ch -> 1)));
    }
}

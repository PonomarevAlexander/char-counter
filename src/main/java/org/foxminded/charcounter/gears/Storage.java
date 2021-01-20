package org.foxminded.charcounter.gears;

import java.util.Map;

public interface Storage {
    
    void putToStorage(String key, Map<Character, Integer> value);
    
    boolean checkToContains(String key);
    
    Map<Character, Integer> get(String key);

}

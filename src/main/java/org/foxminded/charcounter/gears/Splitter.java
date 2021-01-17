package org.foxminded.charcounter.gears;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    private static final String SPLIT_REGEX = "\\s*[^a-zA-Z]+\\s*";
    
    public List<String> splitString(String sourceString) {
        List<String> separatedString = new ArrayList<>();
        separatedString.addAll(Arrays.asList(sourceString.split(SPLIT_REGEX)));
        return separatedString;
    }   
}
    


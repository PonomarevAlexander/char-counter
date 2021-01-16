package org.foxminded.charcounter.gears;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> splitString(String actual) {
        List<String> separatedString = new ArrayList<>();
        separatedString.addAll(Arrays.asList(actual.split(",")));
        return separatedString;
    }   
}
    


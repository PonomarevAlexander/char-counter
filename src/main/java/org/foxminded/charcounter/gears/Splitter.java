package org.foxminded.charcounter.gears;

public class Splitter {

    public String[] splitString(String actual) {
        return actual.split(" ");
    }
    
    public char[] getCharsArrayOfWordByIndex(String[] words, int index) {
        return words[index].toCharArray(); 
    }
}

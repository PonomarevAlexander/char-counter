package org.foxminded.charcounter.facade;

import java.util.Scanner;

public class Main {
    
    private static final String INVITE = "Type some string for counting...";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        
        CharCount charCounter = new CharCount();
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(INVITE);
            String input = scanner.nextLine();
            String result = charCounter.countCharacters(input);
            System.out.println(NEW_LINE + input + NEW_LINE + result);
            scanner.close();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

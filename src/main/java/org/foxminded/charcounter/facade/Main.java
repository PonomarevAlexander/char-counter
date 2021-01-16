package org.foxminded.charcounter.facade;

public class Main {
    private static final String SENTENCE = "hello world";

    public static void main(String[] args) {
        
        Facade facade = Facade.getFacade();
        
        System.out.println(facade.countLetters(SENTENCE));
    }

}

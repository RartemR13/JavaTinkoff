package edu.project1;

import edu.project1.Dictionaries.Animals;

public final class Main {
    private Main() {
    }

    private final static int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        ConsoleHungman consoleHungman = new ConsoleHungman(new Animals(), MAX_ATTEMPTS);
        consoleHungman.run();
    }
}

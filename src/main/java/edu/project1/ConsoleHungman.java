package edu.project1;

import edu.project1.Results.Defeat;
import edu.project1.Results.Win;
import java.util.NoSuchElementException;
import java.util.Scanner;

@SuppressWarnings("RegexpSingleLineJava")
public final class ConsoleHungman {
    public ConsoleHungman(Dictionary dictionary, int maxAttempts) {
        Session.createSession(dictionary.randomWord(), maxAttempts);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("> Guess a letter:");
            System.out.print("< ");

            String input;
            try {
                input = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println(">" + Session.getSession().giveUp().message());
                break;
            }

            Result result;
            try {
                result = tryGuess(input);
            } catch (IncorrectInput e) {
                System.out.println("> Incorrect\n>");
                continue;
            }

            System.out.println(result.message());

            if (result instanceof Defeat
                || result instanceof Win) {
                break;
            }
        }
    }

    private Result tryGuess(String input) throws IncorrectInput {
        if (input.length() > 1) {
            throw new IncorrectInput();
        }

        if (String.valueOf(Session.getSession().getUserAnswer()).indexOf(input.charAt(0)) != -1) {
            throw new IncorrectInput();
        }

        return Session.getSession().guess(input.charAt(0));
    }

    private static final class IncorrectInput extends Exception {}
}

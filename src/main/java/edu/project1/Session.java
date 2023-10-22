package edu.project1;

import edu.project1.Results.CommonResult;
import edu.project1.Results.Defeat;
import edu.project1.Results.FailedGuess;
import edu.project1.Results.SuccessfulGuess;
import edu.project1.Results.Win;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class Session {
    private Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        userAnswer = new char[maxAttempts + answer.length()];
    }

    public static Session session;

    public static void createSession(String answer, int maxAttempts) {
        if (session != null) {
            throw new RuntimeException("Can't create Session twice");
        }

        session = new Session(answer, maxAttempts);
    }

    public static Session getSession() {
        if (session == null) {
            throw new RuntimeException("Session is not created");
        }

        return session;
    }

    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;
    private int guessCount;

    public char[] getUserAnswer() {
        return Arrays.copyOf(userAnswer, userAnswer.length);
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getAnswer() {
        return answer;
    }

    @NotNull Result guess(char guess) {
        userAnswer[guessCount++] = guess;
        Result currentResult;

        for (int i = 0; i < answer.length(); ++i) {
            if (answer.charAt(i) == guess) {
                currentResult = new SuccessfulGuess();

                if (String.valueOf(currentResult.state()).indexOf('*') == -1) {
                    currentResult = new Win();
                }

                return currentResult;
            }
        }

        currentResult = new FailedGuess();
        if (++attempts == maxAttempts) {
            currentResult = new Defeat();
        }

        return currentResult;
    }

    @NotNull Result giveUp() {
        return new Defeat();
    }
}

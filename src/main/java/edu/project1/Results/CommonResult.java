package edu.project1.Results;

import edu.project1.Result;
import edu.project1.Session;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;


public abstract class CommonResult implements Result {
    @Override
    public char[] state() {
        String answer = Session.getSession().getAnswer();

        char[] state = new char[answer.length()];
        Arrays.fill(state, '*');

        char[] userAnswers = Session.getSession().getUserAnswer();

        for (int i = 0; i < answer.length(); ++i) {
            for (char userAnswer : userAnswers) {
                if (userAnswer == answer.charAt(i)) {
                    state[i] = userAnswer;
                    break;
                }
            }
        }

        return state;
    }

    @Override
    public int attempt() {
        return Session.getSession().getAttempts();
    }

    @Override
    public int maxAttempts() {
        return Session.getSession().getMaxAttempts();
    }

    @Override
    @NotNull public abstract String message();
}

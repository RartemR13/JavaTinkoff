package edu.project1.Results;

import org.jetbrains.annotations.NotNull;

public final class Defeat extends FailedGuess {
    @Override
    @NotNull public String message() {
        String message = "\n> You lost!\n";
        if (attempt() == maxAttempts()) {
            message = super.message() + message;
        }
        return message;
    }
}

package edu.project1.Results;

import org.jetbrains.annotations.NotNull;

public final class Win extends SuccessfulGuess {
    @Override
    @NotNull public String message() {
        return super.message() + "\n> You win!\n";
    }
}

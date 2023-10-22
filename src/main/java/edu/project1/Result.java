package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface Result {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();
}

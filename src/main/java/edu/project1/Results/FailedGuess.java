package edu.project1.Results;

import org.jetbrains.annotations.NotNull;

public class FailedGuess extends CommonResult {
    @Override
    @NotNull public String message() {
        return "> Missed, mistake "
                    + attempt()
                    + " out of "
                    + maxAttempts()
                    + ".\n"
               + ">\n"
               + "> The word: "
                    + String.valueOf(state())
                    + "\n>";
    }
}

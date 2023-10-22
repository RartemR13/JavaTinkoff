package edu.project1.Results;

import org.jetbrains.annotations.NotNull;

public class SuccessfulGuess extends CommonResult {
    @Override
    @NotNull public String message() {
        return "> Hit!\n"
               + ">\n"
               + "> The word: "
               + String.valueOf(state())
               + "\n>";
    }
}

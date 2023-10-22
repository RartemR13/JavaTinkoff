package edu.project1.Dictionaries;

import edu.project1.Dictionary;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public final class Animals implements Dictionary {
    @Override
    @NotNull public String randomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private final String[] words = {
        "tiger",
        "lian",
        "monkey",
        "shark"
    };
}

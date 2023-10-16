package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task5Test {
    @Test
    @DisplayName("Не палиндром, без потомка")
    void checkOddNoPalindrome() {
        // given
        int number = 123;

        // when
        boolean isPalindromeDescedant = Task5.isPalindromeDescendant(number);

        // then
        assertThat(isPalindromeDescedant).isEqualTo(false);
    }

    @Test
    @DisplayName("Примерные тесты")
    void checkSample() {
        // given
        int[] array = {11211230, 13001120, 23336014, 11};
        boolean[] correctAnswers = {true, true, true, true};

        // then
        boolean[] answers = new boolean[correctAnswers.length];
        for (int i = 0; i < answers.length; ++i) {
            answers[i] = Task5.isPalindromeDescendant(array[i]);
        }

        // when
        assertThat(answers).isEqualTo(correctAnswers);
    }
}

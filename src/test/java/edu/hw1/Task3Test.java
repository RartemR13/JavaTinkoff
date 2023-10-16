package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task3Test {
    @Test
    @DisplayName("Первый массив пуст")
    void checkFirstEmpty() {
        // given
        int[] array1 = {};
        int[] array2 = {1, 2, 3, 4};

        // when
        boolean isNestable = Task3.isNestable(array1, array2);

        // then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("Второй массив пуст")
    void checkSecondEmpty() {
        // given
        int[][] arrays = {
            {1, 2}, {},
            {}, {},
        };

        boolean[] correctAnswers = {false, true};

        // then
        boolean[] answers = new boolean[correctAnswers.length];
        for (int i = 0; i < arrays.length; i += 2) {
            answers[i / 2] = Task3.isNestable(arrays[i], arrays[i+1]);
        }

        //when
        assertThat(answers).isEqualTo(correctAnswers);
    }

    @Test
    @DisplayName("Примерные тесты")
    void checkSample() {
        // given
        int[][] arrays = {
            {1, 2, 3, 4}, {0, 6},
            {3, 1}, {4, 0},
            {9, 9, 8}, {8, 9},
            {1, 2, 3, 4}, {2, 3}
        };

        boolean[] correctAnswers = {true, true, false, false};

        // then
        boolean[] answers = new boolean[correctAnswers.length];
        for (int i = 0; i < arrays.length; i += 2) {
            answers[i / 2] = Task3.isNestable(arrays[i], arrays[i+1]);
        }

        //when
        assertThat(answers).isEqualTo(correctAnswers);
    }
}

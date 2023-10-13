package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class Task7Test {
    @Test
    @DisplayName("Примерные тесты rotateLeft")
    void checkSampleRotateLeft() {
        // given
        int[][] coples = {
            {16, 1},
            {17, 2},
            {8, -1}
        };
        int[] correctAnswers = {1, 6, 4};

        // when
        int[] answers = new int[correctAnswers.length];
        for (int i = 0; i < answers.length; ++i) {
            answers[i] = Task7.rotateLeft(coples[i][0], coples[i][1]);
        }

        // then
        assertThat(answers).isEqualTo(correctAnswers);
    }

    @Test
    @DisplayName("Примерные тесты rotateRight")
    void checkSampleRotateRight() {
        // given
        int[][] coples = {
            {16, -1},
            {17, -2},
            {8, 1}
        };
        int[] correctAnswers = {1, 6, 4};

        // when
        int[] answers = new int[correctAnswers.length];
        for (int i = 0; i < answers.length; ++i) {
            answers[i] = Task7.rotateRight(coples[i][0], coples[i][1]);
        }

        // then
        assertThat(answers).isEqualTo(correctAnswers);
    }
}

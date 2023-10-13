package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task6Test {
    @Test
    @DisplayName("Некорректные входные данные")
    void checkIncorrect() {
        // given
        int[] array = {123, 1000, 9999};

        // then
        for (int number : array) {
            assertThatThrownBy(() -> Task6.countK(number)).isInstanceOf(Task6.IncorrectInputNumber.class);
        }
    }

    @Test
    @DisplayName("Примерные тесты")
    void checkSample() {
        // given
        int[] array = {6621, 6554, 1234};
        int[] correctAnswers = {5, 4, 3};

        // when
        int[] answers = new int[correctAnswers.length];
        for (int i = 0; i < answers.length; ++i) {
            try {
                answers[i] = Task6.countK(array[i]);
            } catch (Task6.IncorrectInputNumber e) {
                assertThat(false).isTrue();
            }
        }

        // then
        assertThat(answers).isEqualTo(correctAnswers);
    }
}

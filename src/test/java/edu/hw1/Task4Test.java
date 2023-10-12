package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task4Test {
    @Test
    @DisplayName("Пустая строка")
    void checkEmpty() {
        // given
        String str = "";

        // then
        String out = Task4.fixString(str);

        // when
        assertThat(out).isEqualTo("");
    }

    @Test
    @DisplayName("Примерные тесты")
    void checkSample() {
        // given
        String[] array = {
            "123456",
            "hTsii  s aimex dpus rtni.g",
            "badce"
        };

        String[] correctAnswers = {
            "214365",
            "This is a mixed up string.",
            "abcde"
        };

        // then
        String[] answers = new String[correctAnswers.length];
        for (int i = 0; i < answers.length; ++i) {
            answers[i] = Task4.fixString(array[i]);
        }

        // when
        assertThat(answers).isEqualTo(correctAnswers);
    }
}

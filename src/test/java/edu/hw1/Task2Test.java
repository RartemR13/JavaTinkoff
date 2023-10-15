package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task2Test {
    @Test
    @DisplayName("Проверка нуля")
    void checkZero() {
        // given
        int number = 0;

        // then
        int countDigits = Task2.countDigits(number);

        // when
        assertThat(countDigits).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("Натуральные числа")
    @CsvSource({
        "100, 3",
        "385848, 6",
        "183723712, 9"
    })
    void checkNatural(int number, int numberLength) {
        // then
        int countDigits = Task2.countDigits(number);

        // when
        assertThat(countDigits).isEqualTo(numberLength);
    }

    @ParameterizedTest
    @DisplayName("Отрицательные числа")
    @CsvSource({
        "-100, 3",
        "-385848, 6",
        "-183723712, 9"
    })
    void checkNegative(int number, int countLength) {
        // then
        int countDigits1 = Task2.countDigits(number);

        // when
        assertThat(countDigits1).isEqualTo(countLength);
    }
}

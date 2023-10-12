package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Натуральные числа")
    void checkNatural() {
        // given
        int number1 = 100;
        int number2 = 385848;
        int number3 = 183723712;

        // then
        int countDigits1 = Task2.countDigits(number1);
        int countDigits2 = Task2.countDigits(number2);
        int countDigits3 = Task2.countDigits(number3);

        // when
        assertThat(countDigits1).isEqualTo(3);
        assertThat(countDigits2).isEqualTo(6);
        assertThat(countDigits3).isEqualTo(9);
    }

    @Test
    @DisplayName("Отрицательные числа")
    void checkNegative() {
        // given
        int number1 = -100;
        int number2 = -385848;
        int number3 = -183723712;

        // then
        int countDigits1 = Task2.countDigits(number1);
        int countDigits2 = Task2.countDigits(number2);
        int countDigits3 = Task2.countDigits(number3);

        // when
        assertThat(countDigits1).isEqualTo(3);
        assertThat(countDigits2).isEqualTo(6);
        assertThat(countDigits3).isEqualTo(9);
    }
}

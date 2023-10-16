package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task1Test {
    @Test
    @DisplayName("Проверка формата (*:*)")
    void moreThanTwoColons() {
        // given
        String time = "13:14:10";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка формата (*!:!!)")
    void incorrectLengths() {
        // given
        String time1 = ":01";
        String time2 = "1:1";

        // when
        int seconds1 = Task1.minutesToSeconds(time1);
        int seconds2 = Task1.minutesToSeconds(time2);

        // then
        assertThat(seconds1).isEqualTo(-1);
        assertThat(seconds2).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка длины строки-минут")
    void greaterThan5() {
        // given
        String time = "1000000:0";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка ведущих нулей в минутах")
    void leadingZero() {
        // given
        String time = "003:0";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка формата (digit:digit)")
    void notTwoDigits() {
        // given
        String time = "1.3:23";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Проверка формата (natural:natural)")
    // Под natural подразумевается число из множества натуральных чисел с нулем
    void notTwoNaturals() {
        // given
        String time = "-10:15";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Количество секунд во входной записи не должно превышать 59")
    void greaterThen59() {
        // given
        String time = "10:60";

        // when
        int seconds = Task1.minutesToSeconds(time);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Корректный вариант")
    void correct() {
        // given
        String time1 = "1:10";
        String time2 = "1:01";
        String time3 = "0:00";

        // when
        int seconds1 = Task1.minutesToSeconds(time1);
        int seconds2 = Task1.minutesToSeconds(time2);
        int seconds3 = Task1.minutesToSeconds(time3);

        // then
        assertThat(seconds1).isEqualTo(70);
        assertThat(seconds2).isEqualTo(61);
        assertThat(seconds3).isEqualTo(0);
    }
}

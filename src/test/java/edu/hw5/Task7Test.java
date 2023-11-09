package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task7Test {
    @ParameterizedTest
    @DisplayName("Первый")
    @CsvSource({
        "10010101001011, true",
        "00, false",
        "001, false",
        "11011111, true",
        "11111111, false"
    })
    void first(String str, boolean ans) {
        assertThat(Task7.check1(str)).isEqualTo(ans);
    }

    @ParameterizedTest
    @DisplayName("Второй")
    @CsvSource({
        "01111111111111110, true",
        "0, true",
        "101, true",
        "0111111, false"
    })
    void second(String str, boolean ans) {
        assertThat(Task7.check2(str)).isEqualTo(ans);
    }

    @ParameterizedTest
    @DisplayName("Третий")
    @CsvSource({
        "0, true",
        "1111, false",
        "101, true",
        "011, true"
    })
    void third(String str, boolean ans) {
        assertThat(Task7.check3(str)).isEqualTo(ans);
    }
}



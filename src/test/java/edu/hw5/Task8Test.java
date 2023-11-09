package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task8Test {
    @ParameterizedTest
    @DisplayName("первый")
    @CsvSource({
        "01011, true",
        "00, false",
        "110, false"
    })
    void first(String str, boolean ans) {
        assertThat(Task8.check1(str)).isEqualTo(ans);
    }

    @ParameterizedTest
    @DisplayName("второй")
    @CsvSource({
        "010, true",
        "0000, false",
        "1000, true",
        "101, false"
    })
    void second(String str, boolean ans) {
        assertThat(Task8.check2(str)).isEqualTo(ans);
    }

    @ParameterizedTest
    @DisplayName("третий")
    @CsvSource({
        "000, true",
        "0100, true",
        "001111, false",
        "0111111101111101, true"
    })
    void third(String str, boolean ans) {
        assertThat(Task8.check3(str)).isEqualTo(ans);
    }

    @ParameterizedTest
    @DisplayName("пятый")
    @CsvSource({
        "1010, true",
        "0100, false",
        "001111, false",
        "11111111111111101, true"
    })
    void fifth(String str, boolean ans) {
        assertThat(Task8.check5(str)).isEqualTo(ans);
    }
}

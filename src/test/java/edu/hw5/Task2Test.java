package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {
    private static Stream<Arguments> provideSample() {
        return Stream.of(
            Arguments.of(1925, new String[] {
                "1925-02-13", "1925-03-13", "1925-11-13"
            }),

            Arguments.of(2024, new String[] {
                "2024-09-13", "2024-12-13"
            })
        );
    }
    @ParameterizedTest
    @DisplayName("Примерные тесты")
    @MethodSource("provideSample")
    void sampleTest(int year, String[] correctAns) {
        ArrayList<String> correctAnsAL = new ArrayList<>(Arrays.asList(correctAns));

        var ans = Task2.getAll13Fridays(year);
        assertThat(ans).isEqualTo(correctAnsAL);
    }
}

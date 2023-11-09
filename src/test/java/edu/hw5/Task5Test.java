package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {
    @ParameterizedTest
    @DisplayName("Примерные тесты")
    @CsvSource({
        "А123ВЕ777, true",
        "О777ОО177, true",
        "123АВЕ777, false",
        "А123ВГ77, false",
        "А123ВЕ7777, false"
    })
    void sampleTest(String number, boolean ans) {
        assertThat(Task5.checkCaRNumber(number)).isEqualTo(ans);
    }

}

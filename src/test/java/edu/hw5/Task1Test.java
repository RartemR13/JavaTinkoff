package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    @DisplayName("Примерный тест")
    void sampleTest() {
        String[] sequence = {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        };

        var res = Task1.averageTimeMinutes(sequence[0], sequence[1]);

        assertThat(res).isEqualTo(3*60 + 40);
    }
}

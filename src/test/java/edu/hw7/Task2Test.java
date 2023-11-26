package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task2Test {
    @Test
    @DisplayName("test")
    void test() {
        int value = Task2.getFactParal(5);

        assertThat(value).isEqualTo(120);
    }
}

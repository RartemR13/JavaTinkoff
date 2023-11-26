package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class Task1Test {
    @Test
    @DisplayName("test")
    void test() throws InterruptedException {
        int value = Task1.concGet();

        assertThat(value).isEqualTo(10000);
    }
}

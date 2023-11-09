package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Примерный тест")
    void sampleTest() {
        String little = "abc";
        String big = "achfdbaabgabcaabg";

        assertTrue(Task6.isSubstring(big, little));
    }
}

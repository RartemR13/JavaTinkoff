package edu.hw5;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task4Test {
    @Test
    @DisplayName("Со спец знаком")
    void specialTest() {
        String specials = "~!@#$%^&*!|";

        for (int i = 0; i < specials.length(); ++i) {
            assertTrue(Task4.pswHaveSpecial("ddsfdsf"
                + specials.charAt(i)
                + "sdfsdfsdfsdf"));
        }
    }

}

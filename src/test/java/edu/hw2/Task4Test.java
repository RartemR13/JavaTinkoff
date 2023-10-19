package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Task4Test {
    private static final class CallChecker {
        public static Task4.CallingInfo getCallingInfo() {
            return Task4.callingInfo();
        }
    }
    @Test
    void checkSample() {
        var correctCallingInfo = new Task4.CallingInfo("CallChecker", "getCallingInfo");

        var callingInfo = CallChecker.getCallingInfo();

        assertThat(callingInfo).isEqualTo(correctCallingInfo);
    }
}

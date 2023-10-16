package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    void checkDefault() {
        var commandExecuter = new Task3.PopularCommandExecutor(new Task3.DefaultConnectionManager(), 100);

        assertDoesNotThrow(commandExecuter::updatePackages);
    }

    @Test
    void checkException() {
        var commandExecuter = new Task3.PopularCommandExecutor(new Task3.FaultyConnectionManager(), 1);

        try {
            for (int i = 0; i < 100; ++i) {
                commandExecuter.updatePackages();
            }
        } catch (Task3.ConnectionException e) {
            assertThat(e).isInstanceOf(Task3.ConnectionException.class);
            assertThat(e.getCause()).isInstanceOf(Task3.ConnectionException.class);
        }
    }
}

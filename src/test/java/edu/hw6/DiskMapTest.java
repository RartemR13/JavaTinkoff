package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiskMapTest {
    @Test
    @DisplayName("Тест на мапу")
    void mapTest() {
        Map<String, String> m = null;

        try {
            m = new DiskMap(Path.of("foo"));
        } catch (IOException any) {
            fail();
        }

        m.put("яблоко", "apple");

        assertThat(m.get("яблоко")).isEqualTo("apple");
        assertNull(m.get("тыблоко"));
    }

    @Test
    @DisplayName("Дописываение")
    void addTest() throws IOException {
        DiskMap toWrite = new DiskMap(Path.of("foo"));
        toWrite.put("C", "D");

        DiskMap toCheck = new DiskMap(Path.of("foo"));
        assertThat(toCheck.get("C")).isEqualTo("D");
    }
}
